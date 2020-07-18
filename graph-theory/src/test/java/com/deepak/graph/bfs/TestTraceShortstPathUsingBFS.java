package com.deepak.graph.bfs;

public class TestTraceShortstPathUsingBFS {

	public static void main(String[] args) {
		TraceShortstPathUsingBFS path = new TraceShortstPathUsingBFS();
		
		path.createGraph();
		path.printShortestDistance(0, 6);

	}

}
