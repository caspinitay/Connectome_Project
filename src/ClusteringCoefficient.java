package nets150.cis.upenn.edu;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ClusteringCoefficient {
	
	public static double computeClusteringCoefficient(Connectome c, int node) {
		List<Integer> neighborhood = new LinkedList<Integer>();
		for (int i = 0; i < 264; i++) {
			if (c.getConnectivity()[node][i] > 0) {
				neighborhood.add(i);
			}
		}
		
		double numConnections = 0.0;
		double possConnections = 0.0;
		for (int i = 0; i < neighborhood.size(); i++) {
			for (int j = i + 1; j < neighborhood.size(); j++) {
				if (c.getConnectivity()[neighborhood.get(i)][neighborhood.get(j)] > 0) {
					numConnections++;
				}
				possConnections++;
			}
		}
		
		return numConnections / possConnections;
	}
	
	public static double computeAverageClusteringCoefficient(Connectome c) {
		double total = 0.0;
		for (int i = 0; i < 264; i++) {
			total += computeClusteringCoefficient(c, i);
		}
		return total / 264;
	}
	
	public static double groupAverageClusteringCoefficient(Set<Connectome> group) {
		double total = 0.0;
		for (Connectome c : group) {
			total += computeAverageClusteringCoefficient(c);
		}
		return total / group.size();
	}

}
