package question2_graphDijkstraModified;

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
	
	List<Edge> alreadyConsideredEdgesList = new ArrayList<Edge>();
	boolean flag = true;
	
	HashMap<Vertex,Integer> A = new HashMap<>();
	HashMap<Vertex,List<Edge>> B = new HashMap<>();
	List<Vertex> Pool = new ArrayList<>();
	
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
	public Edge getEdgeFromVerts(Vertex v1, Vertex v2) {
		Edge ee = null;
		for(Edge e : this.listEdges) {
			if(v1.equals(e.getU()) && v2.equals(e.getV()))
				return e;
			if(v2.equals(e.getU()) && v1.equals(e.getV()))
				return e;
		}
		return ee;
	}
	
	public void dijkstra(Vertex s) {
		handleInitialProcess(s);
		process(this.Pool);
		System.out.println(this.A);
	}
	
	public void handleInitialProcess(Vertex s){
		if(s==null) throw new IllegalArgumentException("Starting vertex can not be null");
		A.put(s, 0);
		List<Edge> list = new ArrayList<>();
		B.put(s, list);
		this.Pool.add(s);
		
	}
	
	public void process(List<Vertex> X) {
		
		while(!X.equals(this.listVerts)) {
			List<Vertex> nextVerts = new ArrayList<>();// all adjacent verts to be processed but not in the pool X
			X.forEach(vert ->{
				List<Vertex> temp = this.adjList.get(vert); //all adjacent vertices to vert
				temp.forEach(v ->{
					if(!X.contains(v)) nextVerts.add(v);
				});
			});
			
			HashMap<Edge,Integer> pathLengthMap = new HashMap<>();
			X.forEach(v1 ->{
				
				nextVerts.forEach(v2 ->{
					Edge e = getEdgeFromVerts(v1,v2);
					if(e!=null) {
						int distance = A.get(v1) + e.getWeight();
						pathLengthMap.put(e, distance);
					}
				});
			});
			//Find the min of the above operation
			if(!pathLengthMap.isEmpty()) {
			Edge edge = findMin(pathLengthMap);
			if(flag) this.alreadyConsideredEdgesList.add(edge);
			Vertex w = edge.getV();
			int value = pathLengthMap.get(edge);
			this.A.put(w, value);
			X.add(w);
			}
			else {
				
				break;
			}
		}
		flag=false;
	}
	
	public Edge findMin(HashMap<Edge,Integer> pathLengthMap) {
		//System.out.println(pathLengthMap.isEmpty());
		Edge ret = (Edge) pathLengthMap.keySet().toArray()[0];
		int min = pathLengthMap.get(ret);
		
		for(Edge e :pathLengthMap.keySet()){
			if(min>pathLengthMap.get(e)) {
				min = pathLengthMap.get(e);
				ret = e;
			}
		}
		return ret;
	}
	

}
