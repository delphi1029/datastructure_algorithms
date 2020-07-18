package com.deepak.graph.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

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
	
	public void bfs(int vertex) {
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(vertex);
		visited[vertex] = true;
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node+" ");
			
			for(Integer in : graph.get(node)) {
				if(visited[in] == false) {
					queue.add(in);
					visited[in] = true;
				}
			}
		}
	}
	
	public void bfsStart() {
		for(int i=0; i<visited.length; i++) {
			if(visited[i] == false) {
				bfs(i);
			}
		}
	}
}
