package com.deepak.graph.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathUnWeightedGraphBFS {
	
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
		
	}
	
	public int[] shortestPath(int startVertex) {
		int[] distance = new int[visited.length];
		
		for(int i=0; i<distance.length; i++) {
			distance[i] = -1;
		}
		for(int i=0; i<visited.length; i++) {
			if(visited[i] == false) {
				bfs(i, distance);
			}
		}
		
		return distance;
	}
	
	public void bfs(int vertex, int[] distance) {
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(vertex);
		visited[vertex] = true;
		distance[vertex] = 0;
		
		while(!queue.isEmpty()) {
			int ver = queue.poll();
			
			for(int neighbour : graph.get(ver)) {
				if(visited[neighbour] == false) {
					visited[neighbour] = true;
					distance[neighbour] = distance[ver]+1;
					queue.add(neighbour);
				}
			}
		}
	}
	
	public void print(int[] distance) {
		
		for(int i=0; i<distance.length; i++) {
			System.out.println(i+" - "+distance[i]);
		}
	}
	
	public void traceShortesPath(int startId, int endId) {
		
	}

}
