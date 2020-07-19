package com.deepak.graph.sssp;

public class TestSSSPUsingTopologicalSortDAG {

	public static void main(String[] args) {
		SSSPUsingTopologicalSortDAG ts = new SSSPUsingTopologicalSortDAG();
		
		ts.createGraph();
		
		int[] result = ts.SSSP();
		
		for(Integer in :result)
			System.out.print(in+" ");

	}

}
