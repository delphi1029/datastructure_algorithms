package com.deepak.graph.sssp;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	
	int val;
	int weight;
	List<Vertex> neighbours;
	
	public Vertex(int val, int weight) {
		this.val = val;
		this.weight = weight;
		this.neighbours = new ArrayList<>();
	}
	
	public void addNeighbour(Vertex neighbour) {
		neighbours.add(neighbour);
	}

}
