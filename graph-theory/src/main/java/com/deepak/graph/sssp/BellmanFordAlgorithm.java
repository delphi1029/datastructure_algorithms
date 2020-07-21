package com.deepak.graph.sssp;

import java.util.ArrayList;
import java.util.List;

public class BellmanFordAlgorithm {

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
		addDirectedEdge(0, 3, -6);
		addDirectedEdge(1, 0, 3);
		addDirectedEdge(2, 3, 2);
		addDirectedEdge(3, 1, 1);
		addDirectedEdge(3, 2, 1);
		addDirectedEdge(4, 1, 4);
		addDirectedEdge(4, 3, 2);
	
	}
	
	void bellmanFord(int start) {
		WeightedNode src =  nodeList.get(start);
		src.distance = 0;
		
		for(int i=1; i<nodeList.size(); i++) { //run V-1 times
			
			for(WeightedNode vertex : nodeList) { // for each Vertex
				for(WeightedNode neighbour : vertex.neighbours) {  // for each Neighbor
					// if distance of neighbor is greater than tentative new path then
					// update distance of neighbor with new parent as presentNode
					if(neighbour.distance > (vertex.distance + vertex.weightMap.get(neighbour))) {
						neighbour.distance = vertex.distance + vertex.weightMap.get(neighbour);
						neighbour.parent = vertex;
					}
				}
			}
		}
		
		//for each edge check if update possible, if true then negative cycle is there report error
		for(WeightedNode vertex: nodeList) {
			for(WeightedNode neighbour: vertex.neighbours) {
				// if distance of neighbor is greater than tentative new path then we have a negative cycle, return from here.. 
				if(neighbour.distance > (vertex.distance + vertex.weightMap.get(neighbour))) {
					System.out.println("Negative cycle found: \n");
					System.out.println("Vertex Name: " + neighbour.name);
					System.out.println("Old Distance: " + neighbour.distance);
					int newDistance = vertex.distance + vertex.weightMap.get(neighbour);
					System.out.println("New distance: " + newDistance);
					return;
				}
			}
		}
		System.out.println("Negative cycle not found: \n");
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
