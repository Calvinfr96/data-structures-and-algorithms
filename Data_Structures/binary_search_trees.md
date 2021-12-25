# Binary Search Trees

## Introduction
- A tree is a data structure consisting of nodes that have a parent/child relationship. Think of a family tree, each node represents a person, and each person can a parent, a child, or both. A connection between nodes is called an edge; each node can have zero, one, or many edges that connect it to (an)other node(s).
- Trees are typically diagramed in a top-down nature, where the central parent node (root) is at the top, then its edges extend below it to its children, then each child potentially has edges extending below it to its children (the parent’s grandchildren) and so on until you reach the bottom of the tree.
    - At the bottom of the tree, no nodes will have branches extending from them. These bottom nodes are called leaves.
- Like Linked Lists, the nodes of a tree can store any data type. Typically, they are used to store strings and/or numbers.
- Lists are a linear data structure, meaning one thing comes after the next. Trees are considered a non-linear data structure because they can branch, creating multiple pathways from the parent node (root) to an end node (leaf).
    - A Singly Linked List can technically be considered a special case of a tree.
- Constraints:
    - To be considered a tree, each node must point to a child node, nodes cannot point to siblings or parents. Additionally, each node should move away from the root.
    - A tree can only have one root node.
- Terminology:
    - Root – The top node in a tree.
    - Child – A node directly connected to another node when moving away from the root.
    - Parent – A node directly connected to another node when moving toward the root. The edge should be pointing away from the root.
    - Siblings – A group of nodes with the same parent.
    - Leaf – A node with no children.
    - Edge – The connection between one node and another.
## Applications
- The HTML DOM is an example of a tree. There is a parent-child relationship between the different HTML elements that make up a webpage.
- Network routing also implements trees to transmit messages between nodes.
- Abstract syntax keys are a way of describing the syntax of a programming language using a tree structure. This can be used to write a program that parses through code to ensure its syntax is valid for the language it is written in.
- They are used in AI and machine learning. You can break down the logic of a task using a decision tree and use that to train the algorithm.
- Folders in an OS, as well as computer filing systems, are modeled using a tree structure.
- JSON from an HTML response is parsed from a string into an object by traversing a tree-like structure.
