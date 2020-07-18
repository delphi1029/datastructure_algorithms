package com.deepak.graph.bfs;

public class TestShortestPathInBinaryMatrix {

	public static void main(String[] args) {
		ShortestPathInBinaryMatrix path = new ShortestPathInBinaryMatrix();
		
		int[][] grid = path.createMatrix();
		
		int num = path.shortestPathBinaryMatrix(grid);
		
		System.out.print(num);

	}

}
