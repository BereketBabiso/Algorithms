package implementation1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Graph {
	List<Vertex> listVerts = new ArrayList<>();
	List<Edge> listEdges = new ArrayList<>();
	HashMap<Vertex,List<Vertex>> adjList = new HashMap<>();
	HashMap<Vertex,Integer> listOfVisitedVerts = new HashMap<>();
	
	List<Edge> spanningTree = new ArrayList<>();
	List<Graph> spanningForest = new ArrayList<>();
	
	public Graph(Edge[] givenEdges) {
		HashMap<Vertex,Vertex> dupverts = new HashMap<>();//controls duplicate vertices
		for(int i=0;i<givenEdges.length;i++) {
			Vertex v1 = givenEdges[i].getU();
			Vertex v2 = givenEdges[i].getV();
			listEdges.add(givenEdges[i]);
			
			if(dupverts.get(v1)==null) {
				dupverts.put(v1,v1);
				listVerts.add(v1);
			}
			if(dupverts.get(v2)==null) {
				dupverts.put(v2, v2);
				listVerts.add(v2);
			}
			
			List<Vertex> adjv1 = adjList.get(v1);
			if(adjv1==null) {
				adjv1 = new ArrayList<Vertex>();
			}
			adjv1.add(v2);
			adjList.put(v1,adjv1);
			List<Vertex> adjv2 = adjList.get(v2);
			if(adjv2==null) {
				adjv2 = new ArrayList<>();
			}
			adjv2.add(v1);
			adjList.put(v2,adjv2);
			
		}
	}

	public List<Vertex> getListVerts() {
		List<Vertex> copyVerts = new ArrayList<>();
		this.listVerts.forEach(x->copyVerts.add(x));
			
		return copyVerts;
	}

	public List<Edge> getListEdges() {
		List<Edge> copyEdges = new ArrayList<>();
		this.listEdges.forEach(e->copyEdges.add(e));
		
		return copyEdges;
	}

	public HashMap<Vertex, List<Vertex>> getAdjList() {
		return adjList;
	}
	
	public boolean areAdjacent(Vertex v1, Vertex v2) {
		if(this.adjList.get(v1).contains(v2)) return true;
		return false;
	}
	
	public void DFS() {
		List<Vertex> verts = this.getListVerts();
		int counter=0;
		while(!verts.isEmpty()) {
			//System.out.println(verts.size());
			Stack<Vertex> stack = new Stack<>();
			Vertex s = verts.remove(0);
			listOfVisitedVerts.put(s,1);
			List<Edge> tempSpanningTree = new ArrayList<>(); //temporary spanning tree for each components
			stack.push(s);
			while(!stack.isEmpty()) {
				Vertex v = stack.peek();
				List<Vertex> adjVerts = adjList.get(v);
				List<Vertex> adjVertsNotVistedYet = new ArrayList<>();
				
				adjVerts.forEach(vert -> {if(listOfVisitedVerts.get(vert)==null) adjVertsNotVistedYet.add(vert);});
				
				
				if(!adjVertsNotVistedYet.isEmpty()) {
					//System.out.println(adjVertsNotVistedYet);
					Vertex w = adjVertsNotVistedYet.get(0);
					listOfVisitedVerts.put(w,1);
					stack.push(w);
					this.spanningTree.add(new Edge(v,w));
					tempSpanningTree.add(new Edge(v,w));
					verts.remove(w);
				}
				else {
					stack.pop();
				}			
			}
			Edge[] edgesForConnectedComponnent = new Edge[tempSpanningTree.size()];
			int i=0;
			for(Edge e : tempSpanningTree) {
				edgesForConnectedComponnent[i]=e;
				i++;
			}
			Graph Gconnected = new Graph(edgesForConnectedComponnent);
			this.spanningForest.add(Gconnected);
			
		}
	}
	
	public boolean isConnected() {
		DFS();
		boolean flag = true;
		for(Vertex v : this.listVerts) {
			if(this.listOfVisitedVerts.get(v)==null) {
				flag=false;
				break;
			}
		}
		return flag;
	}
	
	public List<Edge> getSpanningTree(){
		DFS();
		return this.spanningTree;
	}
	
	public int connectedComponentsSize() {
		DFS();
		return this.spanningForest.size();
	}
	
	public void printSpanningForest() {
		DFS();
		this.spanningForest.forEach(System.out::print);
	}
	
	public String toString() {
		return this.listVerts.toString();
	}
	

}
