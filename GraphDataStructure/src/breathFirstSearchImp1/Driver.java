package breathFirstSearchImp1;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Vector;



public class Driver {

	public static void main(String[] args) {
		
		Vertex A = new Vertex("A");
		Vertex B = new Vertex("B");
		Vertex C = new Vertex("C");
		Vertex D = new Vertex("D");
		Vertex E = new Vertex("E");
		Vertex F = new Vertex("F");
		Vertex G = new Vertex("G");
		
		Edge[] edges = new Edge[7];
		edges[0] = new Edge(A,B);
		edges[1] = new Edge(A,D);
		edges[2] = new Edge(A,F);
		edges[3] = new Edge(F,D);
		edges[4] = new Edge(D,C);
		edges[5] = new Edge(D,E);
		edges[6] = new Edge(E,G);
		
		Graph graph = new Graph(edges);
		System.out.println("The shortest path length from 'A' to 'G' is :"+graph.shortestPathLength(A, G));
		System.out.println("the rooted spanning tree of the Graph with root 'A' is: "+graph.getSpanningTree());
		System.out.println("The Shortest path from 'A' to 'G' is :"+graph.shortestPath(A, G));
		
		//comment the above three lines before executing the below,  spanning tree by DFS.
		//System.out.println(" Spanning Tree computed by DFS : " + graph.dfs(A));

	}

}