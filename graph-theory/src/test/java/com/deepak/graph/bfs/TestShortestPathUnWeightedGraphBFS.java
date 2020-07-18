package com.deepak.graph.bfs;

public class TestShortestPathUnWeightedGraphBFS {

	public static void main(String[] args) {
		ShortestPathUnWeightedGraphBFS path = new ShortestPathUnWeightedGraphBFS();
		
		path.createGraph();
		path.print(path.shortestPath(0));

	}

}
