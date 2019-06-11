package dijkstraAlgorithmImpl1;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Vertex S = new Vertex("S");
//		Vertex V = new Vertex("V");
//		Vertex W = new Vertex("W");
//		Vertex X = new Vertex("X");
//		
//		Edge[] edges = new Edge[5];
//		edges[0] = new Edge(S,V,1);
//		edges[1] = new Edge(S,W,4);
//		edges[2] = new Edge(V,W,2);
//		edges[3] = new Edge(V,X,6);
//		edges[4] = new Edge(W,X,3);
//		
//		Graph G = new Graph(edges);
//		G.dijkstra(S);
		
		//Double d = Double.POSITIVE_INFINITY;
		
		Vertex V = new Vertex("V");
		Vertex X = new Vertex("X");
		Vertex W = new Vertex("W");
		Vertex U = new Vertex("U");
		Vertex Y = new Vertex("Y");
		
		Edge[] edges = new Edge[7];
		edges[0] = new Edge(V,W,3);
		edges[1] = new Edge(V,U,1);
		edges[2] = new Edge(V,X,2);
		edges[3] = new Edge(U,X,3);
		edges[4] = new Edge(U,W,4);
		edges[5] = new Edge(U,Y,2);
		edges[6] = new Edge(X,Y,2);
		
		Graph G = new Graph(edges);
		G.dijkstra(V);

	}

}
