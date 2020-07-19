package com.deepak.graph.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CycleInDirectedGraphDFS {

	private List<List<Integer>> graph;
	private boolean[] visited;
	
	public void addDirectedEdge(int n1, int n2) {
		graph.get(n1).add(n2);
	}
	
	public void createGraph() {
		
		graph = new ArrayList<>();
		visited = new boolean[7];
		
		for(int i=0; i<=visited.length; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		addDirectedEdge(0, 1);
		addDirectedEdge(2, 0);
		addDirectedEdge(1, 3);
		addDirectedEdge(3, 4);
		addDirectedEdge(4, 2);
		addDirectedEdge(4, 5);
	
		//  0 - 1 - 2 - 3 - 4- 5 - 6
		/*addEdge(0, 1);
		addEdge(1, 2);
		addEdge(2, 3);
		addEdge(3, 4);
		addEdge(4, 5);
		addEdge(5, 6);
*/
		
	}
	
	public boolean isCycleDetected() {
		
		boolean[] recStack = new boolean[visited.length];
		
		for(int i=0; i<visited.length; i++) {
			if(visited[i] == false) {
				if(dfs(i, recStack)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean dfs(int vertex, boolean[] recStack) {
		
		visited[vertex] = true;
		recStack[vertex] = true;
		
		for(Integer v : graph.get(vertex)) {
			if(visited[v] == false && dfs(v, recStack)) {
				return true;
			} else if(recStack[v] == true) {
				return true;
			}
		}
		
		recStack[vertex] = false;
		return false;
	}
}
