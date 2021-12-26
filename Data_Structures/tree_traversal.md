# Tree Traversal

## Introduction
- Tree traversal is the process of visiting any node in a tree. Tree traversal can apply to any type of tree, whether it’s a plain binary tree or a binary search tree.
    - One example of tree traversal involves searching for a node a binary tree (unsorted). Searching for a node in an unsorted tree would potentially require searching through every node in the tree to determine if the node exists.
- Tree traversal algorithms take advantage of recursion. There are two main algorithms used to traverse a tree. One is called Breadth-First Search (BFS) and the other is called Depth-First Search (DFS).
- BFS involves traversing a traversing a tree beginning at the root, then visiting its children, then its grandchildren etc. You basically traverse the tree one “generation” or “level” at a time.
- DFS is more complicated than BFS and involves three main approaches: In-Order, Pre-Order, and Post-Order.
- There are many traversal algorithms for a tree because there are many ways data in a tree can be distributed. Each algorithm excels at traversing a particular distribution scheme.
## Breadth First Search
- Breath-First Search (BFS) involves traversing a tree by visiting each sibling node in each level of a tree, starting at the root, and ending at the leaves. 
- BFS involves creating a queue (list or array) and a variable to store the values of nodes visited (list or array).
- The first node added (push) to the queue is the root, while there are items in the queue, perform these operations in a loop (using a BST as an example tree):
    - Dequeue (shift) a node from the queue and add its value to the ‘visited’ array.
    - If there is a left property on the node dequeued, add (push) it to the queue.
    - If there is a right property on the node dequeued, add (push) it to the queue.
- When the loop finishes, return the ‘visited’ array. 
