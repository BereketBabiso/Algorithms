package breathFirstSearchImp1;

public class Edge {
	Vertex u;
	Vertex v;
	
	Edge(Vertex u, Vertex v){
		this.u = u;
		this.v = v;
	}

	public Vertex getU() {
		return u;
	}

	public void setU(Vertex u) {
		this.u = u;
	}

	public Vertex getV() {
		return v;
	}

	public void setV(Vertex v) {
		this.v = v;
	}
	
	public boolean equals(Edge ob) {
		if(ob==null) return false;
		if(this.getClass()!=ob.getClass()) return false;
		Edge e = (Edge) ob;
		return this.u.equals(e.getU()) && this.v.equals(e.getV());
	}

	@Override
	public String toString() {
		return "("+this.u.toString()+", "+this.v.toString()+")";
	}
	
	

}
