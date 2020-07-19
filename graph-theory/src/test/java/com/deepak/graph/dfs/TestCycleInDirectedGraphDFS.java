package com.deepak.graph.dfs;

public class TestCycleInDirectedGraphDFS {

	public static void main(String[] args) {
		CycleInDirectedGraphDFS cycle = new CycleInDirectedGraphDFS();
		cycle.createGraph();
		
		boolean flag = cycle.isCycleDetected();

		System.out.print(flag);

	}

}
