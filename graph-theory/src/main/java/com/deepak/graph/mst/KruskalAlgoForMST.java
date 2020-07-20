package com.deepak.graph.mst;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KruskalAlgoForMST {
	
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
		
		addDirectedEdge(0, 1, 28);
		addDirectedEdge(0, 5, 10);
		addDirectedEdge(1, 2, 16);
		addDirectedEdge(1, 6, 14);
		addDirectedEdge(2, 3, 12);
		addDirectedEdge(6, 3, 18);
		addDirectedEdge(6, 4, 24);
		addDirectedEdge(4, 3, 22);
		addDirectedEdge(5, 4, 25);
		
		
	}
	
	public List<Edge> kruskal() {
		List<Edge> mst = new ArrayList<Edge>();
		
		Queue<Edge> queue = new PriorityQueue<>();
		
		for(int i=0; i<graph.size(); i++) {
			for(Edge e : graph.get(i)) {
				queue.add(e);
			}
		}
		
		int noOfVertices = 6;
		
		int x = 0;
		while(x < noOfVertices-1) {
			Edge e = queue.poll();
			System.out.println(e.from+" : "+e.to+" : "+e.weight);
			if(visited[e.to] && visited[e.from]) {
				continue;
			}
			
			mst.add(e);
			
			visited[e.from] = true;
			visited[e.to] = true;
			x++;
		}
		
		return mst;
	}
}


