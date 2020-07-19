package com.deepak.graph.bfs;

public class TestCycleInDirectedGraphUsingKahnAlgo {
	
	public static void main(String[] args) {
		CycleInDirectedGraphUsingKahnAlgo algo = new CycleInDirectedGraphUsingKahnAlgo();
		
		algo.createGraph();
		
		System.out.print(algo.isCycleDetected());
	}

}
