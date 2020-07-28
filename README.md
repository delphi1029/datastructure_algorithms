# Algorithms

Contents - 
 * [Big O](#big-o) 
 * [Arrays](#arrays)
 * [Graph Theory](#graph-theory)


 ## Big O
 
 * O(1) < O(loglog n) < O(log n) < O(sqt(n)) < O(n) < O(n* log n) < O(n^2) < O(n^3) < O(2^n) < O(n!)
 
 Handy formulas - 
  * c + c + c + c + c +.........+c = cn
  
  * 1 + 2 + 3 + 4 + 5 + 6 +........+n = n(n+1)/2;
  
  * 1^2 + 2^2 + 3^2 + 4^2 +.......+n^2 = n(n+1)(2n+1)/6;
  
  * r^0 + r^1 + r^2 + r^3 +.......+r^n = ((r^n+1) - 1)/(r-1)
  * 2^0 + 2^1 + 2^2+ ......+2^n = 2^(n+1) -1
  
  Common complexity Scenarios - 
  
  * for(int i=0; i<n; i++) -  O(n)
  
  * for(inti=0; i<n; i=+k) - O(n)
  
  * for(int i=0; i<n; i++) </br>
       for(int j=0; j<m; j++) - O(m*n)
       
  *  for(int i=0; i<n; i++) - O(n^2) </br>
       for(int j=0; j<i; j++)
   
  *  for(int i=0; i<n; i++) - **O(n)** </br>
        i*=2 </br>
        for(intj=0; j<i; j++)
        
  * for(inti =0; i<n; i = i*2) - O(log n)
  
  * for(int i=0; i<n; i = i/2) - O(log n)
  
  * for(int i=0; i*i<n; i++) - O(sqrt(n))
  
  
  
 Note - String concatination operation is O(n^2) where n is length of string. Instead of string use string builder for string concatination operation.


 ## Arrays
 
 * Remove duplicates from sorted array. [link](https://github.com/delphi1029/datastructure_algorithms/blob/master/arrays/src/main/java/com/deepak/algo/arrays/RemoveDuplicate.java)
 
 * Rotate Array [link](https://github.com/delphi1029/datastructure_algorithms/blob/master/arrays/src/main/java/com/deepak/algo/arrays/RotateTheArray.java)
 
 * Buy Sell Stock (only one trasaction allowed). [link](https://github.com/delphi1029/datastructure_algorithms/blob/master/arrays/src/main/java/com/deepak/algo/arrays/BuySellStock_1.java)
 
 * Buy and Sell Stock II (multiple transactions allowed). [link](https://github.com/delphi1029/datastructure_algorithms/blob/master/arrays/src/main/java/com/deepak/algo/arrays/BuySellStock_2.java)
 
 * Plus One [link](https://github.com/delphi1029/datastructure_algorithms/blob/master/arrays/src/main/java/com/deepak/algo/arrays/PlusOne.java)
 
 *  Remove Element. [link](https://github.com/delphi1029/datastructure_algorithms/blob/master/arrays/src/main/java/com/deepak/algo/arrays/RemoveElement.java)
 
 
 
 
 ## Graph Theory
 
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
   * For a graph with no negative weights, we can do  better and calculate single source shortest distances in O(E * Log(V)) time using Dijkstra’s algorithm. 
   * **Can we do even better for Directed Acyclic Graph (DAG)? We can calculate single source shortest distances in O(V+E) time for DAGs. The idea is to use Topological Sorting.** [link](https://github.com/delphi1029/datastructure_algorithms/blob/master/graph-theory/src/main/java/com/deepak/graph/sssp/SSSPUsingTopologicalSortDAG.java)
   
 * #### Single Source Shortest Path (SSSP) problem -
      * SSSP problem is about finding a path between a given vertex (called source) to all other vertices in a graph such that the total distance between them (source and destination) is minimum. 
      * Algorithms for SSSP are -
        * BFS [link](https://github.com/delphi1029/datastructure_algorithms/blob/master/graph-theory/src/main/java/com/deepak/graph/bfs/ShortestPathUnWeightedGraphBFS.java)
          * Can be used to find SSSP in case of unWeighted-undirected and unWeighted-directed graph.
          * Cannot be used in case of weighted graph.
          * Time complexity O(V+E).
        * Dijkstra's [link](https://github.com/delphi1029/datastructure_algorithms/blob/master/graph-theory/src/main/java/com/deepak/graph/sssp/DijkstraAlgorithm.java)
          * Time complexity is O(E * log(V)).
          * Dijkstra alorithm will only work for graphs having non negative edge weights, **it will not work for negative edge weights.**
          * This is a greedy algorithm.
        * Bellman Ford [link](https://github.com/delphi1029/datastructure_algorithms/blob/master/graph-theory/src/main/java/com/deepak/graph/sssp/BellmanFordAlgorithm.java)
          * when you have negative edge weight then this algo can detect negative cycles in a graph.
          * The only difference between the two is that Bellman-Ford is also capable of handling negative weights whereas Dijkstra Algorithm can only handle positives.
          * Time complexity is O(V * E)
   
 * #### All source shortest Path (ASSP) problem - 
      * This problem is ablout finding a path between every vertex to all other vertices in a graph such that, the total distance between then (source and destination) in minimum.
      * Algorithm for ASSP - 
          * Floyd Warshall [link](https://github.com/delphi1029/datastructure_algorithms/blob/master/graph-theory/src/main/java/com/deepak/graph/assp/FloydWarshallAlgorithm.java)
            * This algorithm does not work for negative cycles.
            * Time complexity is O(V^3).
            * Space complexity is O(V^2).
      
#### Spanning Tree and Minimum Spanning Tree
* A spanning tree T of an undirected graph G is a subgraph that is a tree which includes all of the vertices of G, with a minimum possible number of edges (min edges = V-1).
* Please note A tree is a connected undirected graph with no cycles.
* Given an undirected graph with weighted edges, a Minimum Spanning Tree (MST) is a subset of the edges in the graph which connects all vertices together (without creating any cycle) while minimizing the total edge cost.
* **A minimum spanning tree (MST)** or minimum weight spanning tree is a subset of the edges of a connected, edge-weighted undirected graph that connects all the vertices together, without any cycles and with the minimum possible total edge weight. That is, it is a spanning tree whose sum of edge weights is as small as possible. 
* If there are n vertices in the graph, then each spanning tree has n − 1 edges.
* There may be several minimum spanning trees of the same weight; in particular, if all the edge weights of a given graph are the same, then every spanning tree of that graph is minimum.
* Minimum spanning trees have direct applications in the design of networks, including computer networks, telecommunications networks, transportation networks, water supply networks, and electrical grids.
* Removing one edge from spanning tree will make it disconnected.
* Adding one edge in spanning tree will make a loop.
* If each edge has distinct weight then there will be only one Minimum spanning tree.
* A complete undirected graph can have n ^ n-2 no of spanning trees (n - number of vertices).
* From a complete graphby removing max (e-n+1) edges we can create a spanning tree. (e - edges, n- vertices)

##### Algorithms to find cost of minimum spanning tree - 
* Prim's algorithm. [link](https://github.com/delphi1029/datastructure_algorithms/blob/master/graph-theory/src/main/java/com/deepak/graph/mst/PrimsAlgoForMST.java)
* Kruskal algorithm - **Pending**

* Both prim's and Krushal algorithms cannot be used for Directed graphs.

#### Connected Components - 
   *  A component is called connected if every vertex is reachable from every other vertex.
   *  In case of **undirected graph** we can find connected components simply by using either 
      * BFS
      * DFS
   *  In case of **directed graph** we can find connected components by using following algorithms - 
      * Kosaraju Algorithm [link](https://github.com/delphi1029/datastructure_algorithms/blob/master/graph-theory/src/main/java/com/deepak/graph/connectedcomponents/KosarajuAlgorithm.java)
         * Steps - 
           1) Create an empty stack ‘S’ and do DFS traversal of a graph. In DFS traversal, after calling recursive DFS for adjacent vertices of a vertex, push the vertex to stack.
           2) Reverse directions of all arcs to obtain the transpose graph.
           3) One by one pop a vertex from S while S is not empty. Let the popped vertex be ‘v’. Take v as source and do DFS (call DFSUtil(v)). The DFS starting from v prints  strongly connected component of v.
         * Time complexity is O(V + E) - The algo perform 2 DFS and 1 transpose. All the 3 operations take O(V + E) time therefore total is 3 * O(V+E).
         
*  ##### Articulation Points (or Cut Vertices) in a Graph
   * An articulation point is a point in a graph, which when removed from the graph results in disjoint graph components.
   * A practical example of articulation points would be critical points in a network graph, whose removal might create a whole system shutdown.
*    ##### How to find all articulation points in a given graph?
   * A simple approach is to one by one remove all vertices and see if removal of a vertex causes disconnected graph. Following are steps of simple approach for connected  graph.
        1) For every vertex v, do following
           * a) Remove v from graph
           * b) See if the graph remains connected (We can either use BFS or DFS)
           * c) Add v back to the graph
       * Time complexity of above method is O(V*(V+E)) for a graph represented using adjacency list.
       
       *  A O(V+E) algorithm to find all Articulation Points (APs) [link](https://github.com/delphi1029/datastructure_algorithms/blob/master/graph-theory/src/main/java/com/deepak/graph/connectedcomponents/ArticulationPoint.java)
           *  The idea is to use DFS (Depth First Search). In DFS, we follow vertices in tree form called DFS tree. In DFS tree, a vertex u is parent of another vertex v, if v is discovered by u (obviously v is an adjacent of u in graph). In DFS tree, a vertex u is articulation point if one of the following two conditions is true.
           *  1) u is root of DFS tree and it has at least two children.
           *  2) u is not root of DFS tree and it has a child v such that no vertex in subtree rooted with v has a back edge to one of the ancestors (in DFS tree) of u.
