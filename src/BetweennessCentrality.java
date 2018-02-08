package nets150.cis.upenn.edu;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

public class BetweennessCentrality {
	private static int numNodes = 264;
	
	public static Dijkstra[] dijkstra(Connectome c, int startNode) {
		Dijkstra[] shortestPath = new Dijkstra[numNodes];
		PriorityQueue<Dijkstra> queue = new PriorityQueue<Dijkstra>();
		shortestPath[startNode] = new Dijkstra(startNode, startNode,0);
		queue.add(shortestPath[startNode]);
		while (!queue.isEmpty()) {
			Dijkstra curr = queue.remove();
			for (int i = 0; i < numNodes; i++) {
				int node = curr.getNode();
				if (c.getConnectivity()[node][i] > 0) {
					float newLength = curr.getLength() + c.getConnectivity()[node][i];
					if (shortestPath[i] == null) {
						shortestPath[i] = new Dijkstra(i, node, newLength);
						queue.add(shortestPath[i]);
					} else {
						if (shortestPath[i].getLength() > newLength) {
							shortestPath[i].setFromNode(node);
							shortestPath[i].setLength(newLength);
						}
					}
				}
			}
		}
		
		
		return shortestPath;
	}
	
	public static Map<Integer, Dijkstra[]> connectomeDijkstra(Connectome c) {
		Map<Integer, Dijkstra[]> allPaths = new TreeMap<Integer, Dijkstra[]>();
		for (int i = 0; i < numNodes; i++) {
			allPaths.put(i, dijkstra(c, i));
		}
		return allPaths;
	}
	
	public static Set<List<Integer>> pathFromDijkstra(Dijkstra[] shortestPaths, int startNode) {
		Set<List<Integer>> paths = new HashSet<List<Integer>>();
		for (int i = 0; i < numNodes; i++) {
			if (i != startNode && shortestPaths[i] != null) {
				LinkedList<Integer> nodePath = new LinkedList<Integer>();
				Dijkstra curr = shortestPaths[i];
				while (curr.getNode() != startNode) {
					nodePath.add(curr.getNode());
					curr = shortestPaths[curr.getFromNode()];
				}
				nodePath.add(startNode);
				paths.add(nodePath);
			}
		}
		return paths;
	}
	
	public static Set<List<Integer>> allShortestPaths(Map<Integer, Dijkstra[]> dijkstras) {
		Set<List<Integer>> allPaths = new HashSet<List<Integer>>();
		for (Integer node : dijkstras.keySet()) {
			allPaths.addAll(pathFromDijkstra(dijkstras.get(node), node));
		}
		return allPaths;
	}
	 
	public static int[] betweennessCentrality(Connectome c) {
		Set<List<Integer>> shortestPaths = allShortestPaths(connectomeDijkstra(c));
		int[] betweenness = new int[numNodes];
		for (List<Integer> l : shortestPaths) {
			for (Integer i : l) {
				betweenness[i]++;
			}
		}
		
		for (int i = 0; i < numNodes; i++) {
			betweenness[i] = betweenness[i]/2;
		}
		return betweenness;
	}
	
	public static PriorityQueue<Betweenness> avgBetweennessCentrality(Set<Connectome> cs) {
		PriorityQueue<Betweenness> hubs = new PriorityQueue<Betweenness>(20);
		int[] avgBetweenness = new int[numNodes];
		for (Connectome c : cs) {
			int[] betweenness = betweennessCentrality(c);
			for (int i = 0; i < numNodes; i++) {
				avgBetweenness[i] += betweenness[i];
			}
		}
		for (int i = 0; i < numNodes; i++) {
			double avg = (double) avgBetweenness[i] / cs.size();
			hubs.add(new Betweenness(i, avg));
		}
		
		return hubs;
	}
	

	
}
