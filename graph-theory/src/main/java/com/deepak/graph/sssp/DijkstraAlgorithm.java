package com.deepak.graph.sssp;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
	
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
	
	void dijkstra(int start) {
		
		WeightedNode node = nodeList.get(start); //start node
		
		PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
		
		node.distance = 0;
		queue.addAll(nodeList);
		
		while(!queue.isEmpty()) {
			WeightedNode presentNode = queue.poll();//remove node with minimum distance from queue
			
			for(WeightedNode neighbour : presentNode.neighbours) {
				if(queue.contains(neighbour)) { //if neighbor is not visited
					// if 'known distance' of neighbor is greater than new path then, 
					// update 'distance' of neighbor 
					// and also new parent as presentNode
					if(neighbour.distance > (presentNode.distance + presentNode.weightMap.get(neighbour))) {
						neighbour.distance = presentNode.distance + presentNode.weightMap.get(neighbour);
						neighbour.parent = presentNode;
						//Refresh the Priority Queue 
						queue.remove(neighbour);
						queue.add(neighbour);
					}
				}
			}
		}
	}
	
	
	public void print() {
		//print table of node with minimum distance and shortest path from source
		for(WeightedNode nodeToCheck: nodeList) {
			System.out.print("Node "+nodeToCheck+", distance: "+nodeToCheck.distance+", Path: ");
			pathPrint(nodeToCheck);
			System.out.println();
		}
	}
	
	private static void pathPrint(WeightedNode node) {
		if(node.parent !=null) {
			pathPrint(node.parent);
			System.out.print("->"+node);
		}
		else 
			System.out.print(node);
	}//end of method

}
