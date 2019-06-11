package implementation1;

public class Vertex {
	String vert;
	
	Vertex(String s){
		this.vert = s;
	}

	public String getVert() {
		return vert;
	}

	public void setVert(String vert) {
		this.vert = vert;
	}
	
	public boolean equals(Object ob) {
		if(ob==null) return false;
		if(this.getClass()!=ob.getClass()) return false;
		Vertex v = (Vertex) ob;
		return this.vert.equalsIgnoreCase(v.vert);
	}
	
	public String toString() {
		return this.vert;
	}
	

}
