package com.deepak.graph.mst;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgoForMST {
	
	private List<List<Edge>> graph;
	private boolean[] visited;
	
	public void addDirectedEdge(int n1, int n2, int weight) {
		graph.get(n1).add(new Edge(n1, n2, weight));
		graph.get(n2).add(new Edge(n2,n1, weight));
	}
	
	public void createGraph() {
		
		int noOfVertices = 7;
		visited = new boolean[noOfVertices];
		
		graph = new ArrayList<>();
	
		for(int i=0; i<=noOfVertices; i++) {
			graph.add(new ArrayList<>());
		}
		
		addDirectedEdge(0, 1, 5);
		addDirectedEdge(0, 6, 2);
		addDirectedEdge(1, 2, 3);
		addDirectedEdge(2, 3, 6);
		addDirectedEdge(4, 2, 2);
		addDirectedEdge(4, 5, 4);
		addDirectedEdge(5, 3, 1);
		
	}
	
	public List<Edge> prims() {
		
		List<Edge> mst = new ArrayList<>();
		
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		
		//start with node 0
		for(Edge e : graph.get(0)) {
			queue.add(e);
		}
		visited[0] = true;
		
		while(!queue.isEmpty()) {
			Edge edge = queue.poll();
			
			if(visited[edge.to] && visited[edge.from]) {
				continue;
			}
			
			visited[edge.from] = true;
			
			for(Edge e : graph.get(edge.to)) {
				if(visited[e.to] == false) {
					queue.add(e);
				}
			}
			
			visited[edge.to] = true;
			mst.add(edge);
		}
		
		return mst;
	}
}