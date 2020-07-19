package com.deepak.graph.sssp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SSSPUsingTopologicalSortDAG {
	
	private List<List<Vertex>> graph;
	private boolean[] visited;
	private int[] distance;
	
	public void addDirectedEdge(int n1, int n2, int weight) {
		graph.get(n1).add(new Vertex(n2, weight));
	}
	
	public void createGraph() {
		
		int noOfVertices = 5;
		visited = new boolean[noOfVertices+1];
		
		graph = new ArrayList<>();
		
		for(int i=0; i<=noOfVertices; i++) {
			graph.add(new ArrayList<>());
		}
		
		addDirectedEdge(0, 1, 2);
		addDirectedEdge(0, 4, 1);
		addDirectedEdge(1, 2, 3);
		addDirectedEdge(2, 3, 6);
		addDirectedEdge(4, 2, 2);
		addDirectedEdge(4, 5, 4);
		addDirectedEdge(5, 3, 1);
		
	}
	
	
	public int[] SSSP() {
		
		int sourceVertex = 0;
		distance = new int[visited.length];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[sourceVertex] = 0;
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<visited.length; i++) {
			if(visited[i] == false) {
				dfs(i, stack);
			}
		}
		
		while(!stack.isEmpty()) {
			int vertex = stack.pop();
			for(Vertex v : graph.get(vertex)) {
				distance[v.val] =  Math.min(distance[vertex]+v.weight, distance[v.val]);
			}
		}
		
		return distance;
	}
	
	public void dfs(int ver, Stack<Integer> stack) {
		visited[ver] = true;
		
		for(Vertex v : graph.get(ver)) {
			if(visited[v.val] == false) {
				dfs(v.val, stack);
			}
		}
		stack.push(ver);
	}

}
