package com.deepak.graph.connectedcomponents;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArticulationPoint {
	
	private List<List<Integer>> graph;
	private boolean[] visited;
	int time = 0;
	
	public void addEdge(int n1, int n2) {
		graph.get(n1).add(n2);
		graph.get(n2).add(n1);
	}
	
	public void createGraph() {
		
		graph = new ArrayList<>();
		visited = new boolean[7];
		
		for(int i=0; i<visited.length; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
	/*	addEdge(0, 1);
		addEdge(0, 3);
		addEdge(0, 2);
		addEdge(1, 2);
		addEdge(3, 4); */
		
		addEdge(0, 1); 
        addEdge(1, 2); 
        addEdge(2, 0); 
        addEdge(1, 3); 
        addEdge(1, 4); 
        addEdge(1, 6); 
        addEdge(3, 5); 
        addEdge(4, 5); 
	}
	
	// The function to do DFS traversal
	public void articulationPoint() {
		int len = visited.length;
		int disc[] = new int[len]; 
        int low[] = new int[len]; 
        int parent[] = new int[len];
        Arrays.fill(parent,  -1);
        boolean ap[] = new boolean[len]; // To store articulation points 
        
     // Call the recursive helper function to find articulation 
        // points in DFS tree rooted with vertex 'i' 
        for (int i = 0; i < len; i++)  {
            if (visited[i] == false) 
                dfs(i, disc, low, parent, ap); 
        }
        
        
     // Now ap[] contains articulation points, print them 
        for (int i = 0; i < len; i++) 
            if (ap[i] == true) 
                System.out.print(i+" "); 
	}
	
	// A recursive function that find articulation points using DFS 
    // u --> The vertex to be visited next 
    // visited[] --> keeps tract of visited vertices 
    // disc[] --> Stores discovery times of visited vertices 
    // parent[] --> Stores parent vertices in DFS tree 
    // ap[] --> Store articulation points 
	public void dfs(int ver, int[] disc, int[] low, int[] parent, boolean[] ap) {
		
		// Count of children in DFS Tree 
        int children = 0; 
  
        // Mark the current node as visited 
        visited[ver] = true; 
        
     // Initialize discovery time and low value 
        disc[ver] = time+1; 
        low[ver] = time+1; 
        
     // Go through all vertices aadjacent to this 
        for(Integer v : graph.get(ver)) {
        	// If v is not visited yet, then make it a child of u 
            // in DFS tree and recur for it 
            if (visited[v] == false)  {
            	children++;
            	parent[v] = ver;
            	dfs(v, disc, low, parent, ap);
            	
            	// Check if the subtree rooted with v has a connection to 
                // one of the ancestors of u 
                low[ver]  = Math.min(low[ver], low[v]); 
                
                // ver is an articulation point in following cases 
                
                // (1) ver is root of DFS tree and has two or more chilren. 
                if (parent[ver] == -1 && children > 1) 
                    ap[ver] = true; 
                
                // (2) If u is not root and low value of one of its child 
                // is more than discovery value of u. 
                if (parent[ver] != -1 && low[v] >= disc[ver]) 
                    ap[ver] = true; 
            }
            
         // Update low value of u for parent function calls. 
            else if (v != parent[ver]) 
                low[ver]  = Math.min(low[ver], disc[v]); 
            
        }
	}

}
