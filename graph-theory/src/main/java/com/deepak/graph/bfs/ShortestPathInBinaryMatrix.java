package com.deepak.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * In an N by N square grid, each cell is either empty (0) or blocked (1).
 * A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:
 *  - Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
 *	- C_1 is at location (0, 0) (ie. has value grid[0][0])
 *	- C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
 *	- If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
 * 
 * Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.
 *  Example  - 
 *  
 *  	 | 0  0  0 |
 *   	 | 1  1  0 |
 *   	 | 1  1  0 |
 *   
 *   output : 4
 */
public class ShortestPathInBinaryMatrix {
	
	private int direction[][] = new int[][] {{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};

	public int shortestPathBinaryMatrix(int[][] grid) {
        
	    int m = grid.length;
        int n = grid[0].length;
        
        //if start and end point are blocked
        if(grid[0][0]==1 || grid[m-1][n-1]==1) {
            return -1;
        }
        
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true; //start with left most node
        
        queue.add(new Pair(0,0));
		
        int ans = 0;
		
        while(!queue.isEmpty()) {
        	int size = queue.size();
        	
        	//explore neighbours
        	for(int i=0; i<size; i++) {
        		Pair ver = queue.poll();
        		
        		if(ver.X == m-1 && ver.Y == n-1) {
        			ans++;
        			return ans;
        		}
        		
        		for(int k=0; k<direction.length; k++) {
        			int nextX = direction[k][0] + ver.X;
        			int nextY = direction[k][1] + ver.Y;
        			
        			//validate is coordinates are valid or not
        			if(nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextX][nextY] && grid[nextX][nextY] == 0) {
        				queue.add(new Pair(nextX,nextY));
        				visited[nextX][nextY] = true;
        			}
        		}
        		
        	}
        	
        	ans++;
        	
        }
        
        
		return -1;
    }
	
	public int[][] createMatrix() {
		int[][] matrix = new int[3][3];
		
		matrix[0][0] = 0; 
		matrix[0][1] = 0;
		matrix[0][2] = 0;
		matrix[1][0] = 1;
		matrix[1][1] = 1;
		matrix[1][2] = 0;
		matrix[2][0] = 1;
		matrix[2][1] = 1;
		matrix[2][2] = 0;
		
		return matrix;
	}
}

class Pair {
	int X;
	int Y;
	
	public Pair(int X, int Y) {
		this.X = X;
		this.Y = Y;
	}
}