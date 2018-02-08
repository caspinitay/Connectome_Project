package nets150.cis.upenn.edu;


public class Betweenness implements Comparable {
	
	private int node;
	private double betweenness;
	
	public Betweenness(int node, double betweenness) {
		this.node = node;
		this.betweenness = betweenness;
	}
	
	public int getNode() {
		return node;
	}
	
	public double getBetweenness() {
		return betweenness;
	}

	@Override
	public int compareTo(Object o) {
		if (!Betweenness.class.isAssignableFrom(o.getClass())) {
	        return -1;
	 } 
	  Betweenness other = (Betweenness) o;
	  if (betweenness < other.getBetweenness()) {
		  return 1;
	  } else if (betweenness == other.getBetweenness()) {
		  return 0;
	  } else {
		  return -1;
	  }
	}

}
