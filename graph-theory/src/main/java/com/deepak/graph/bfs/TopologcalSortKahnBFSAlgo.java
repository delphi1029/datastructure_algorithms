package com.deepak.graph.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologcalSortKahnBFSAlgo {
	
	private List<List<Integer>> graph;
	private int vertices;
	
	public void addDirectedEdge(int n1, int n2) {
		graph.get(n1).add(n2);
	}
	
	public void createGraph() {
		
		vertices = 5;
		
		graph = new ArrayList<>();
		
		for(int i=0; i<=vertices; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		addDirectedEdge(5, 0);
		addDirectedEdge(5, 2);
		addDirectedEdge(4, 0);
		addDirectedEdge(4, 1);
		addDirectedEdge(2, 3);
		addDirectedEdge(3, 1);
		
	}
	
	
	public List<Integer> topologicalSort() {
		
		List<Integer> result = new ArrayList<>();
		int[] inDegrees = new int[vertices+1];
		
		//fill indegree array
		for(int i=0; i<=vertices; i++) {
			for(Integer v : graph.get(i)) {
				inDegrees[v]++;
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=0; i<inDegrees.length; i++) {
			if(inDegrees[i] == 0)
				queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			int ver = queue.poll();
			result.add(ver);
			
			for(Integer in : graph.get(ver)) {
				inDegrees[in]--;
				if(inDegrees[in] == 0)
					queue.add(in);
			}
		}
		
		return result;
	}
}
