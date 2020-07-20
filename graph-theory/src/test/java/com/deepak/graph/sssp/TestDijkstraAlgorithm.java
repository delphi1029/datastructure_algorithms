package com.deepak.graph.sssp;

public class TestDijkstraAlgorithm {

	public static void main(String[] args) {
		DijkstraAlgorithm dj = new DijkstraAlgorithm();
		
		dj.createGraph();
		dj.dijkstra(4);
		dj.print();

	}

}
