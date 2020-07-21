package com.deepak.graph.sssp;

public class TestBellmanFordAlgorithm {

	public static void main(String[] args) {
		BellmanFordAlgorithm dj = new BellmanFordAlgorithm();
		
		dj.createGraph();
		dj.bellmanFord(4);
		dj.print();

	}

}
