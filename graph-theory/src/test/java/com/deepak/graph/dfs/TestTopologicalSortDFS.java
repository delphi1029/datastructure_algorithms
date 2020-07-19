package com.deepak.graph.dfs;

import java.util.List;

public class TestTopologicalSortDFS {

	public static void main(String[] args) {
		TopologicalSortDFS ts = new TopologicalSortDFS();
		
		ts.createGraph();
		
		List<Integer> result = ts.topologicalSort();
		
		for(Integer in :result)
			System.out.print(in+" ");

	}

}
