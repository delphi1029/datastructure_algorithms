package com.deepak.graph.mst;

import java.util.List;

public class TestPrimsAlgoForMST {

	public static void main(String[] args) {
		PrimsAlgoForMST pr = new PrimsAlgoForMST();
		pr.createGraph();
		
		List<Edge> result = pr.prims();
		
		for(Edge e : result)
			System.out.println(e);
		
	}
}
