package com.deepak.graph.mst;

import java.util.List;

public class TestKruskalAlgoForMST {

	public static void main(String[] args) {
		KruskalAlgoForMST pr = new KruskalAlgoForMST();
		pr.createGraph();
		
		List<Edge> result = pr.kruskal();
		
		for(Edge e : result)
			System.out.println(e);
		
	}

}
