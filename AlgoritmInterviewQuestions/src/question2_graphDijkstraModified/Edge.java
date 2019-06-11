package question2_graphDijkstraModified;

public class Edge {
	Vertex u;
	Vertex v;
	int weight;
	
	Edge(Vertex u, Vertex v, int weight){
		this.u = u;
		this.v = v;
		this.weight = weight;
		
	}

	public Vertex getU() {
		return u;
	}

	public Vertex getV() {
		return v;
	}

	public int getWeight() {
		return weight;
	}
	
	
	
	public boolean equals(Object ob) {
		if(ob==null) return false;
		if(this.getClass()!=ob.getClass()) return false;
		Edge e = (Edge) ob;
		return this.u.equals(e.getU()) && this.equals(e.getV()) && this.weight==e.getWeight();
	}

}
