# Algorithms
 ## Graph Theory - 
 
 * #### Applications of BFS [link](https://github.com/delphi1029/datastructure_algorithms/blob/master/graph-theory/src/main/java/com/deepak/graph/bfs/BFS.java) - 
 
 1) Shortest path in un weighted graph.
 2) Crawler in search engine.
 3) Peer to Peer networks
 4) Social networking search
 5) In garbage collection (Cheney's algo)
 6) Cycle detection
 7) Ford fulkerson algorithm (The Ford–Fulkerson method or Ford–Fulkerson algorithm is a greedy algorithm that computes the maximum flow in a flow network).
 8) Broadcasting

* #### Applications of DFS [link](https://github.com/delphi1029/datastructure_algorithms/blob/master/graph-theory/src/main/java/com/deepak/graph/dfs/DFS.java) -

1) Cycle detection
2) Topological sort.
3) Strongly connected components.
4) Solving maze and similar problems
5) Path finding.


* #### Shortest Path (Unweighted Graph) - [BFS](https://github.com/delphi1029/datastructure_algorithms/blob/master/graph-theory/src/main/java/com/deepak/graph/bfs/ShortestPathUnWeightedGraphBFS.java)

We can use simple BFS to find shortest distance in un-weighted and undirected graph. The time complexity of the solution is O(V + E) and space complexity is O(V).

We can also trace the shortest path if required. [link](https://github.com/delphi1029/datastructure_algorithms/blob/master/graph-theory/src/main/java/com/deepak/graph/bfs/TraceShortstPathUsingBFS.java)

* #### Detect cycle in undirected graph [link](https://github.com/delphi1029/datastructure_algorithms/blob/master/graph-theory/src/main/java/com/deepak/graph/dfs/CycleInUndirectedGraph.java) 

We can use DFS to detect cycle in graph.For every visited vertex v, when we have found any adjacent vertex u, such that u is already visited, and u is not the parent of vertex v. Then cycle is detected.

* #### Detect cycle in directed graph
    * DFS can be used to detect cycle in the directed graph. [link](https://github.com/delphi1029/datastructure_algorithms/blob/master/graph-theory/src/main/java/com/deepak/graph/dfs/CycleInDirectedGraphDFS.java)
    * We can also use BFS to detect cycle in a graph. The algorithm used for this purpose is Kahn's topological sort algorithm. [link](https://github.com/delphi1029/datastructure_algorithms/blob/master/graph-theory/src/main/java/com/deepak/graph/bfs/CycleInDirectedGraphUsingKahnAlgo.java)

* #### Finding shortest path in a grid using [BFS](https://github.com/delphi1029/datastructure_algorithms/blob/master/graph-theory/src/main/java/com/deepak/graph/bfs/ShortestPathInBinaryMatrix.java)

* #### Topological Sort - 

Many real world situations canbe modelled as graph with directed edges where some events must occur before others

- School class prerequisites
- Program dependencies
- Event scheduling
- Assemble instructions.

Topological ordering is an odering of the nodes in a directed graph where from each directed edge from node A to node B, node A appears beofre node B in the ordering.

Topological sort algorithm can find a topological ordering in O(V+E) time.

**Not every graph can have a topological ordering. A graph which contains cycle cannot have a valid ordering. The only type of graph which is a valid topological ordering is a directed acyclic grapg (DAG). These are graph with directed edges and no cycle.**

- Topological sort algorithm - 

  1) Kahn's BFS based algorithm [link](https://github.com/delphi1029/datastructure_algorithms/blob/master/graph-theory/src/main/java/com/deepak/graph/bfs/TopologcalSortKahnBFSAlgo.java) 
     * Store Indegrees of every vertes. Loop through the graph and fill indegree array. 
     * Create a queue.
     * Add all 0 indegree nodes vertices to queue.
     * Run a look while queue is not empty
     * Remove a vertex from the queue (Dequeue operation) and then.
         * Increment count of visited nodes by 1.
         * Decrease in-degree by 1 for all its neighboring nodes.
         * If in-degree of a neighboring nodes is reduced to zero, then add it to the queue.
     * Time complexity is O(V+E) and space complexity is O(V).
     
  2) DFS algorithm for topological sort. [link](https://github.com/delphi1029/datastructure_algorithms/blob/master/graph-theory/src/main/java/com/deepak/graph/dfs/TopologicalSortDFS.java)
     * Create an empty stack.
     * for every vertex u, do following
             * if (u is not visited)
                   DFS(u, stack)
      * While stack is not empty, pop an element from the stack and print it.
      * DFS(u, stack)
           - mark u as visited
           - For every adjacent v of u
                     if(v is not visited)
                        DFS(v,stack)
           - push u to stack
 
 * #### Shortest path in DAG (Directed acyclic graph)
   * For a general weighted graph, we can calculate single source shortest distances in O(VE) time using Bellman–Ford Algorithm. 
   * For a graph with no negative weights, we can do  better and calculate single source shortest distances in O(E + VLogV) time using Dijkstra’s algorithm. 
   * **Can we do even better for Directed Acyclic Graph (DAG)? We can calculate single source shortest distances in O(V+E) time for DAGs. The idea is to use Topological Sorting.** [link](https://github.com/delphi1029/datastructure_algorithms/blob/master/graph-theory/src/main/java/com/deepak/graph/sssp/SSSPUsingTopologicalSortDAG.java)
   
 * #### Single Source Shortest Path (SSSP) problem -
      * SSSP problem is about finding a path between a given vertex (called source) to all other vertices in a graph such that the total distance between them (source and destination) is minimum. 
      * Algorithms for SSSP are -
        * BFS [link](https://github.com/delphi1029/datastructure_algorithms/blob/master/graph-theory/src/main/java/com/deepak/graph/bfs/ShortestPathUnWeightedGraphBFS.java)
          * Can be used to find SSSP in case of unWeighted-undirected and unWeighted-directed graph.
          * Cannot be used in case of weighted graph.
        * Dijkstra's
        * Bellman Ford
      
#### Spanning Tree and Minimum Spanning Tree
* A spanning tree T of an undirected graph G is a subgraph that is a tree which includes all of the vertices of G, with a minimum possible number of edges (min edges = V-1).
* Please note A tree is a connected undirected graph with no cycles.
* **A minimum spanning tree (MST)** or minimum weight spanning tree is a subset of the edges of a connected, edge-weighted undirected graph that connects all the vertices together, without any cycles and with the minimum possible total edge weight. That is, it is a spanning tree whose sum of edge weights is as small as possible. 
