# Algorithms
 ## Graph Theory - 
 
 #### Applications of BFS - 
 
 1) Shortest path in un weighted graph.
 2) Crawler in search engine.
 3) Peer to Peer networks
 4) Social networking search
 5) In garbage collection (Cheney's algo)
 6) Cycle detection
 7) Ford fulkerson algorithm (The Ford–Fulkerson method or Ford–Fulkerson algorithm is a greedy algorithm that computes the maximum flow in a flow network).
 8) Broadcasting

#### Applications of DFS -

1) Cycle detection
2) Topological sort.
3) Strongly connected components.
4) Solving maze and similar problems
5) Path finding.


#### Shortest Path (Unweighted Graph) - BFS

We can use simple BFS to find shorted distance in un-weighted and undirected graph. The time complexity of the solution is O(V + E) and space complexity is O(V).

#### Topological Sort - 

Many real world situations canbe modelled as graph with directed edges where some events must occur before others

- School class prerequisites
- Program dependencies
- Event scheduling
- Assemble instructions.

Topological ordering is an odering of the nodes in a directed graph where from each directed edge from node A to node B, node A appears beofre node B in the ordering.

Topological sort algorithm can find a topological ordering in O(V+E) time.

**Not every graph can have a topological ordering. A graph which contains cycle cannot have a valid ordering. The only type of graph which is a valid topological ordering is a directed acyclic grapg (DAG). These are graph with directed edges and no cycle.**
