 # Graphs

 ## Introduction
- A graph is a data structure that consists of vertices, nodes, or points together with a set of unordered pairs of these vertices (undirected graph) or a set of ordered pairs (directed graph).
- In simpler terms a graph, like a tree, is a collection of nodes and connections between said nodes. One difference between a tree and a graph is that there is no parent node in a graph; all nodes are treated equally.
- Graphs are used commonly in the following applications:
    - Social Networks: In a social network, people are nodes and their relationships (friendships) act as connections between nodes.
    - Location / Mapping: On a map, locations are modeled as nodes and roads are modeled as the connections between nodes
    - Routing Algorithms: These algorithms aim to find the quickest path to a location by finding the shortest path between two nodes.
    - Recommendation Algorithms: Using video games as an example, these algorithms work by modeling a video game as a central node and the genres it falls under as nodes that radiate out from it. When you do this for multiple games, certain games will be related to one another through their genre (has-many-through relationship). This information can be used to recommend similar games to users.
    - Visual Hierarchy
    - File System Optimizations
## Graph Terminology
- Vertex – A node. In graphs, the nodes act as a point where two or more edges meet. Unlike in trees, where edges must point from a parent to a child, the edges in graphs can point in any direction because nodes aren’t classified as parents or children. This means graphs can form a line, tree, or closed shape or loop.
- Edge – A connection between nodes.
- Weighted / Unweighted – Values are assigned to distances between vertices.
- Directed / Undirected – Directions are assigned to distances between vertices.
- A tree (in graph theory) is an example of an undirected graph in which any two vertices are connected by exactly one path. The tree data structure would technically be a directed graph because nodes must point from parent to child.
- Example Graph:
    <img src="Example_Graph.JPG" />
## Types of Graphs
- Weighted / Unweighted – In a weighted graph, values are assigned to each edge. In an unweighted graph, edges have no assigned value.
- Directed / Undirected – In an undirected graph, the edges have no specific direction; they act as two-way connections. In a directed graph, edges have a specific direction and are often represented with arrows.
