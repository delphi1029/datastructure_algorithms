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

By distance between two nodes u,v we mean the number of edges on the shortest path between u and v . Now:
Start at the start vertex s . It is at distance 0 from itself, and there are no other nodes at distance 0
Consider all the nodes adjacent to s . These all are at distance at most 1 from s (maybe less than 1, if s has an edge to itself; but then we would have found a shorter path already) and there are no other nodes at distance 1
Consider all the nodes adjacent to the nodes adjacent to s . These are all at distance at most 2 from s (maybe less than 2; but then we would have found a shorter path already) and there are no other nodes at distance 2
... and so on. In this breadth-first search, as soon as we visit a node in the graph, we know the shortest path from s to it; and so by the time we have visited all the nodes in the graph, we know the shortest path from s to each of them
