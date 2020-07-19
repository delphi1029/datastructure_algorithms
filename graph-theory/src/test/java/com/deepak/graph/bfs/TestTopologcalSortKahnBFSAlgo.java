package com.deepak.graph.bfs;

import java.util.List;

public class TestTopologcalSortKahnBFSAlgo {

	public static void main(String[] args) {
		TopologcalSortKahnBFSAlgo ts = new TopologcalSortKahnBFSAlgo();
		
		ts.createGraph();
		
		List<Integer> result = ts.topologicalSort();
		
		for(Integer in :result)
			System.out.print(in+" ");

	}

}
