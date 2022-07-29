# Tree Traversal

## Introduction
- Tree traversal is the process of visiting any node in a tree. Tree traversal can apply to any type of tree, whether it’s a plain binary tree or a binary search tree.
    - One example of tree traversal involves searching for a node a binary tree (unsorted). Searching for a node in an unsorted tree would potentially require searching through every node in the tree to determine if the node exists.
- Tree traversal algorithms take advantage of recursion. There are two main algorithms used to traverse a tree. One is called Breadth-First Search (BFS) and the other is called Depth-First Search (DFS).
- BFS involves traversing a traversing a tree beginning at the root, then visiting its children, then its grandchildren etc. You basically traverse the tree one “generation” or “level” at a time.
- DFS is more complicated than BFS and involves three main approaches: In-Order, Pre-Order, and Post-Order.
- There are many traversal algorithms for a tree because there are many ways data in a tree can be distributed. Each algorithm excels at traversing a particular distribution scheme.
## Breadth-First Search
- Breath-First Search (BFS) involves traversing a tree by visiting each sibling node in each level of a tree, starting at the root, and ending at the leaves. 
- BFS involves creating a queue (list or array) and a variable to store the values of nodes visited (list or array).
- The first node added (push) to the queue is the root, while there are items in the queue, perform these operations in a loop (using a BST as an example tree):
    - Dequeue (shift) a node from the queue and add its value to the ‘visited’ array.
    - If there is a left property on the node dequeued, add (push) it to the queue.
    - If there is a right property on the node dequeued, add (push) it to the queue.
- When the loop finishes, return the ‘visited’ array. 
## Depth-First Pre-Order Search
- DFS involves traversing nodes in a tree vertically, from the root of the tree to a leaf, before visiting sibling nodes.
- DFS can be broken down into three steps:
    - For any node, you need to visit the node and it to the list of nodes visited.
    - You then need to explore the entire left side of the node, then the entire right side (for a BST).
    - The different DFS approaches differ in how they perform this exploration.
- Pre-Order search involves visiting the node and adding it to the list of visited nodes first, then traversing its entire left side, then its entire right side.
- For each node, once you have traversed its entire left side, you then move to traverse its entire right side. This means that starting at the root, you keep moving left until you reach the level above a leaf. When you reach this level, you traverse the left leaf then the right leaf of the node.
- After that, you move back up to the right side of side of the root and perform the same traversal moving right instead of left.
- Recommended algorithm:
    - Create a variable called ‘visited’ (array) to store the list of nodes visited.
    - Store the root of the BST in a variable called ‘current.’
    - Write a helper function that accepts a node as an argument:
        - Push the value of the node into ‘visited.’
        - If the node has a left node, call the function on that node.
        - If the node has right property, call the function on that node.
    - Invoke the helper function with ‘current.’
    - Return ‘visited.’
## Depth-First Post-Order Search
- Post-Order search is like Pre-Order search in that both use the DFS algorithm but differ in the order in which nodes are visited.
- In Pre-Order Search, you visit a node first, then visit its entire left side, then its entire right side. In Post-Order Search, you visit a node’s entire left side, then a node’s entire right side, then you visit the node itself.
    - In Pre-Order, the root is the first node visited (added to the ‘visited’ array). In Post-Oder, the root is the last node visited.
    - Before visiting a node, you explore all of its children first.
- Recommended algorithm:
    - Create a variable called ‘visited’ (array) to store the list of nodes visited.
    - Store the root of the BST in a variable called ‘current.’
    - Write a helper function that accepts a node as an argument:
        - If the node has a left node, call the function on that node.
        - If the node has right property, call the function on that node.
        - Push the value of the node into ‘visited.’
    - Invoke the helper function with ‘current.’
    - Return ‘visited.’
## Depth-First In-Order Search
- In-Order search is like Post-Oder Search, except you visit a node after visiting its entire left side, then you visit the node’s entire right side.
- Recommended algorithm:
    - Create a variable called ‘visited’ (array) to store the list of nodes visited.
    - Store the root of the BST in a variable called ‘current.’
    - Write a helper function that accepts a node as an argument:
        - If the node has a left node, call the function on that node.
        - Push the value of the node into ‘visited.’
        - If the node has right property, call the function on that node.
    - Invoke the helper function with ‘current.’
    - Return ‘visited.’