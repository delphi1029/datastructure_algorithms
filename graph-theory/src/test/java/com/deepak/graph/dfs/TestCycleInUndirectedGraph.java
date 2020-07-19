package com.deepak.graph.dfs;

public class TestCycleInUndirectedGraph {

	public static void main(String[] args) {
		CycleInUndirectedGraph cycle = new CycleInUndirectedGraph();
		cycle.createGraph();
		
		boolean flag = cycle.isCycleDetected();

		System.out.print(flag);
	}

}
