package com.deepak.graph.mst;

public class Edge implements Comparable<Edge>{
	int to;
	int from;
	Integer weight;

	public Edge(int from, int to, int weight) {
		this.to = to;
		this.from = from;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return this.weight.compareTo(o.weight);
	}

	@Override
	public String toString() {
		return "from : " + from + ", to : " + to + ", weight : " + weight;
	}
}
