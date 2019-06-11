package implementation1;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vertex A = new Vertex("A");
		Vertex B = new Vertex("B");
		Vertex C = new Vertex("C");
		Vertex D = new Vertex("D");
		Vertex E = new Vertex("E");
		Vertex F = new Vertex("F");
		
		Edge[] edges = new Edge[6];
		edges[0] = new Edge(A,B);
		edges[1] = new Edge(B,C);
		edges[2] = new Edge(A,D);
		edges[3] = new Edge(D,E);
		edges[4] = new Edge(B,E);
		edges[5] = new Edge(E,F);
		
		Graph G = new Graph(edges);
		Vertex testAjacency = new Vertex("Z");
		
		System.out.println("Is adjacent : "+G.areAdjacent(A, B));
		System.out.println("Is adjacent : "+G.areAdjacent(A, testAjacency));
		
		Vertex X = new Vertex("X");
		Vertex Y = new Vertex("Y");
		Vertex Z = new Vertex("Z");
		Vertex P = new Vertex("P");
		Edge[] edgesForDisconnectedGraph = new Edge[8];
		edgesForDisconnectedGraph[0] = new Edge(A,B);
		edgesForDisconnectedGraph[1] = new Edge(B,C);
		edgesForDisconnectedGraph[2] = new Edge(A,D);
		edgesForDisconnectedGraph[3] = new Edge(D,E);
		edgesForDisconnectedGraph[4] = new Edge(B,E);
		edgesForDisconnectedGraph[5] = new Edge(E,F);
		edgesForDisconnectedGraph[6] = new Edge(X,Y);
		edgesForDisconnectedGraph[7] = new Edge(Z,P);
		
		Graph G2 = new Graph(edgesForDisconnectedGraph);
//		
//		System.out.println("Is  G connected graph? : "+G.isConnected());
//		System.out.println("Is  G2 connected graph? : "+G2.isConnected());
//		System.out.println("Spanning-tree of graph G is : "+G.getSpanningTree());
		
		//System.out.println("The number of connected components in G2: "+G2.connectedComponentsSize());
		G2.printSpanningForest();

	}

}
