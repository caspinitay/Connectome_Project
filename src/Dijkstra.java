package nets150.cis.upenn.edu;

import java.util.Comparator;

public class Dijkstra implements Comparable {
	public int node;
	public int fromNode;
	public float length;
	
	public Dijkstra(int node, int fromNode, float f) {
		this.node = node;
		this.fromNode = fromNode;
		this.length = f;
	}
	
	public int getNode() {
		return node;
	}
	
	public float getLength() {
		return length;
	}
	
	public int getFromNode() {
		return fromNode;
	}
	
	public void setLength(float newLength) {
		length = newLength;
	}
	
	public void setFromNode(int newNode) {
		fromNode = newNode;
	}
	

	@Override
	public int compareTo(Object arg0) {
	  if (!Dijkstra.class.isAssignableFrom(arg0.getClass())) {
	        return -1;
	 } 
	  Dijkstra other = (Dijkstra) arg0;
	  if (length < other.getLength()) {
		  return -1;
	  } else if (length == other.getLength()) {
		  return 0;
	  } else {
		  return 1;
	  }
	  
	}

}
