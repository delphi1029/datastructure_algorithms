package com.deepak.graph.dfs;

import java.util.ArrayList;
import java.util.List;

public class DFS {

	private List<List<Integer>> graph;
	
	private boolean[] visited;
	
	
	
	public void addEdge(int n1, int n2) {
		graph.get(n1).add(n2);
		graph.get(n2).add(n1);
	}
	
	public void createGraph() {
		
		graph = new ArrayList<>();
		visited = new boolean[7];
		
		for(int i=0; i<=visited.length; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		addEdge(0, 1);
		addEdge(0, 2);
		addEdge(1, 3);
		addEdge(1, 4);
		addEdge(2, 3);
		addEdge(3, 4);
		addEdge(5,6);
		
	}
	
	public void dfs() {
		for(int i=0; i<visited.length; i++) {
			if(visited[i] == false) {
				dfsRec(i);
			}
		}
	}
	
	public void dfsRec(int vertex) {
		visited[vertex] = true;
		
		System.out.print(vertex+" ");
		
		for(Integer node: graph.get(vertex)) {
			if(visited[node] == false) {
				dfsRec(node);
			}
		}
	}
	
}
