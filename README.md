# Shortest Path

## Dijkstra's Algorithm for single source shortest path (weighted)

The goal for this program is to utilize basic graph data structure to solve important graph problems. This program implements Dijkstra's single source shortest path algorithm which takes an input of two things:
* a connected directed graph with weights on the edges (it may have cycles) 
* a single vertex, the start vertex.

For each vertex V in the graph, Dijkstra's algorithm finds the shortest path from the start vertex to V (including start vertex to itself, with path length 0). 

This program utilizes hashmaps to affiliate Nodes to Vertices, obtain, remove, and get nodes or vertices in O(1) time complexity. It also utilizes a Priority Queue towards finding the corresponding shortest path from one node to another during the execution of dijkstra's algorithm.
