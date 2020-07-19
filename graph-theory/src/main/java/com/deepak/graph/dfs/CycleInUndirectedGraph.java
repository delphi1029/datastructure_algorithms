package com.deepak.graph.dfs;

import java.util.ArrayList;
import java.util.List;

public class CycleInUndirectedGraph {

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
		addEdge(4,5);
		addEdge(5,6);
	
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
		
		for(int i=0; i<visited.length; i++) {
			if(visited[i] == false) {
				if(dfs(i,-1)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean dfs(int index, int parent) {
		visited[index] = true;
		
		for(Integer in : graph.get(index)) {
			if(visited[in] == false) {
				if(dfs(in,index) == true) {
					return true;
				} 
			} else if(in != parent) {
				return true;
			}
		}
		return false;
	}
}
