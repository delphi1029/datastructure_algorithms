package com.deepak.graph.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Given a unweighted graph, a source and a destination, we need to find shortest path from source to destination in the graph in most optimal way.
 * We need to print the whole path
 * 
 *  - One solution is to solve in O(VE) time using Bellman–Ford. 
 *  - If there are no negative weight cycles, then we can solve in O(E + VLogV) time using Dijkstra’s algorithm.
 *  - Since the graph is unweighted, we can solve this problem in O(V + E) time using simple BFS
 */
public class TraceShortstPathUsingBFS {

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
	
	public void printShortestDistance(int src, int dest) {
		//we need tow arrays for keeping track of distance of a vertes from start vertex and keeping track of predicessor of the vertex
		int[] distance = new int[visited.length];
		int[] pred = new int[visited.length];
		
		//pre fill distance with -1
		Arrays.fill(distance, -1);
		Arrays.fill(pred, -1);
		
		boolean isPathFound = bfs(src, dest, pred, distance);
		
		if(!isPathFound) {
			System.out.print("Path not fount between "+src+" dest");
			return;
		}
		
		// LinkedList to store path 
        List<Integer> path = new ArrayList<Integer>(); 
        int crawl = dest; 
        path.add(crawl); 
        while (pred[crawl] != -1) { 
            path.add(pred[crawl]); 
            crawl = pred[crawl]; 
        } 
        
        // Print distance 
        System.out.println("Shortest path length is: " + distance[dest]); 
  
        // Print path 
        System.out.println("Path is ::"); 
        for (int i = path.size() - 1; i >= 0; i--) { 
            System.out.print(path.get(i) + " "); 
        } 
		
	}
	
	// a modified version of BFS that stores predecessor 
    // of each vertex in array pred 
    // and its distance from source in array dist 
    public boolean bfs(int src,int dest, int[] pred, int[] dist) {
    	
    	Queue<Integer> queue = new LinkedList<>();
    	queue.add(src);
    	dist[src] = 0;
    	visited[src] = true;
    	
    	while(!queue.isEmpty()) {
    		int vertex = queue.poll();
    		
    		for(Integer node : graph.get(vertex)) {
    			if(visited[node] == false) {
    				visited[node] = true;
    				dist[node] = dist[vertex]+1;
    				pred[node] = vertex;
    				
    				queue.add(node);
    				
    				if(node == dest) {
    					return true;
    				}
    			}
    		}
    	}
    	
    	return false;
    }
    
    
    
    
    
    
    
    
    
}
