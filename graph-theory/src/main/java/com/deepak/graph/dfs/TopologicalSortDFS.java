package com.deepak.graph.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSortDFS {
	private List<List<Integer>> graph;
	private boolean[] visited;
	
	public void addDirectedEdge(int n1, int n2) {
		graph.get(n1).add(n2);
	}
	
	public void createGraph() {
		
		//vertices = 5;
		
		graph = new ArrayList<>();
		visited = new boolean[5];
		
		for(int i=0; i<=visited.length; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		addDirectedEdge(0, 1);
		addDirectedEdge(1, 3);
		addDirectedEdge(2, 3);
		addDirectedEdge(3, 4);
		addDirectedEdge(2, 4);
		
	}
	
	public List<Integer> topologicalSort() {
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<visited.length; i++) {
			if(visited[i] == false) {
				dfs(i, stack);
			}
		}
		
		List<Integer> result = new ArrayList<>();
		
		while(!stack.isEmpty()) {
			result.add(stack.pop());
		}
		
		return result;
	}
	
	public void dfs(int vertex, Stack<Integer> stack) {
		visited[vertex] = true;
		
		for(Integer in : graph.get(vertex)) {
			if(visited[in] == false) {
				dfs(in, stack);
			}
		}
		
		stack.push(vertex);
	}
}
