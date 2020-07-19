package com.deepak.graph.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleInDirectedGraphUsingKahnAlgo {
	
	private List<List<Integer>> graph;
	int vertices;
	
	public void addDirectedEdge(int n1, int n2) {
		graph.get(n1).add(n2);
	}
	
	public void createGraph() {
		
		graph = new ArrayList<>();
		vertices = 6;
		
		for(int i=0; i<=vertices; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		addDirectedEdge(0, 1);
		addDirectedEdge(2, 0);
		addDirectedEdge(1, 3);
		addDirectedEdge(3, 4);
		addDirectedEdge(4, 2);
		addDirectedEdge(4, 5);
		addDirectedEdge(5, 6);
		
	
		//  0 - 1 - 2 - 3 - 4- 5 - 6
		/*addDirectedEdge(0, 1);
		addDirectedEdge(1, 2);
		addDirectedEdge(2, 3);
		addDirectedEdge(3, 4);
		addDirectedEdge(4, 5);
		addDirectedEdge(5, 6);*/

		
	}
	
	public boolean isCycleDetected() {
		int[] inDegrees = new int[vertices+1];
		
		for(int i=0; i<=vertices; i++) {
			for(Integer in : graph.get(i)) {
				inDegrees[in]++;
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=0; i<inDegrees.length; i++) {
			if(inDegrees[i] == 0)
				queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			int ver = queue.poll();
			
			for(Integer in : graph.get(ver)) {
				inDegrees[in]--;
				if(inDegrees[in] == 0)
					queue.add(in);
			}
		}
		
		for(int x=0; x<inDegrees.length; x++) {
			if(inDegrees[x] != 0)
				return true;
		}
		
		return false;
	}
}
