package com.deepak.graph.sssp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedNode implements Comparable<WeightedNode>{
	
	int name;
	List<WeightedNode> neighbours;
	Map<WeightedNode, Integer> weightMap;
	boolean isVisited = false;
	WeightedNode parent;
	int distance;
	
	public WeightedNode(int name) {
		this.name = name;
		this.distance = Integer.MAX_VALUE;
		neighbours = new ArrayList<>();
		this.weightMap = new HashMap<>();
	}
	
	@Override
	public String toString() {
		return ""+name;
	}
	
	public int compareTo(WeightedNode node) {
		return this.distance - node.distance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + name;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeightedNode other = (WeightedNode) obj;
		if (name != other.name)
			return false;
		return true;
	}
	
	
}
