package com.deepak.graph.connectedcomponents;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KosarajuAlgorithm {

	private List<List<Integer>> graph;
	private boolean[] visited;
	
	public void addDirectedEdge(int n1, int n2) {
		graph.get(n1).add(n2);
	}
	
	public void createGraph() {
		
		graph = new ArrayList<>();
		visited = new boolean[5];
		
		for(int i=0; i<visited.length; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		addDirectedEdge(0, 2);
		addDirectedEdge(0, 3);
		addDirectedEdge(1, 0);
		addDirectedEdge(2, 1);
		addDirectedEdge(3, 4);
	}
	
	
	public void kosaraju() {
		//steps - 
		//1) DFS 
		//2) Reverse
		//3) DFS
		
		
		//1) DFS and fill order
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<graph.size(); i++) {
			if(visited[i] == false) {
				dfs(i,stack);
			}
		}
		
		//2) Reverse the graph
		List<List<Integer>> transposedGraph = getTranspose();
		
		// Mark all the vertices as not visited (For second DFS) 
        for (int i = 0; i < visited.length; i++) 
            visited[i] = false; 
		
        while(!stack.isEmpty()) {
        	Integer ver = stack.pop();
        	if(visited[ver] == false) {
        		System.out.println();
        		dfs(ver,transposedGraph);
        	}
        }
	}
	
	public List<List<Integer>> getTranspose() {
		
		List<List<Integer>> transposeGraph = new ArrayList<>();
		
		for(int i=0; i<visited.length; i++) {
			transposeGraph.add(new ArrayList<Integer>());
		}
		
		
		for(int i=0; i<visited.length; i++) {
			for(Integer neighbour : graph.get(i)) {
				transposeGraph.get(neighbour).add(i);
			}
		}
		
		return transposeGraph;
	}
	
	public void dfs(int ver, List<List<Integer>> transposedGraph) {
		visited[ver] = true;
		
		for(Integer v : transposedGraph.get(ver)) {
			if(visited[v] == false) {
				visited[v] = true;
				dfs(v, transposedGraph);
			}
		}
		
		System.out.print(ver+" ");
	}
	
	public void dfs(int ver, Stack<Integer> stack) {
		visited[ver] = true;
		
		for(Integer v : graph.get(ver)) {
			if(visited[v] == false)
				dfs(v,stack);
		}
		
		stack.push(ver);
	}
}
