package com.deepak.graph.assp;

import java.util.ArrayList;
import java.util.List;


public class FloydWarshallAlgorithm {
	
	private List<WeightedNode> nodeList;
	
	public void addDirectedEdge(int n1, int n2, int weight) {
		WeightedNode from = nodeList.get(n1);
		WeightedNode to = nodeList.get(n2);
		
		from.neighbours.add(to);
		from.weightMap.put(to, weight);
	}
	
	public void createGraph() {
		
		int noOfVertices = 5;
		nodeList = new ArrayList<>();
		
		for(int i=0; i<noOfVertices; i++) {
			nodeList.add(new WeightedNode(i));
		}
		
		addDirectedEdge(0, 2, 6);
		addDirectedEdge(0, 3, 6);
		addDirectedEdge(1, 0, 3);
		addDirectedEdge(2, 3, 2);
		addDirectedEdge(3, 1, 1);
		addDirectedEdge(3, 2, 1);
		addDirectedEdge(4, 1, 4);
		addDirectedEdge(4, 3, 2);
	
	}
	
	public void floydWarshall() {
		int size = nodeList.size();
		int[][] V = new int[size][size]; //distance array
		
		// Initializing Distance table from adjacency list
		for(int i=0; i<size ; i++) {
			WeightedNode first = nodeList.get(i);
			for(int j=0; j<size; j++) {
				WeightedNode second = nodeList.get(j);
				if(i==j) {
					V[i][j] = 0;
				} else if(first.weightMap.containsKey(second)) {
					V[i][j] = first.weightMap.get(second);
				} else {
					V[i][j] = Integer.MAX_VALUE/10; // no direct edge between i & j, so mark it as infinity [divided by 10 to avoid arithmetic overflow]
				}
			}
		}
		
		// Floyd Warshall's Algorithm
		for(int k=0; k<size; k++) {
			for(int i=0; i<size; i++) {
				for(int j=0; j<size; j++) {
					if(V[i][j] > V[i][k] + V[k][j]) {
						V[i][j] = V[i][k] + V[k][j];
					}
					
				}
			}
		}
		
		// Print table of node with minimum distance and shortest path from each source
			for (int i = 0; i < size; i++) {
					System.out.print("Printing distance list for node "+nodeList.get(i)+": ");
					for (int j = 0; j < size; j++) {
						System.out.print(V[i][j]+" ");
					}
					System.out.println();
				}
	}

}
