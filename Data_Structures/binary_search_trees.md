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
## Binary Trees
- Like the many different types of trees in nature, there are many different types of trees used in programming. All these types of trees follow the same general patterns of a tree data structure but have their own unique properties.
    - Some trees are much faster at searching while others are faster at insertion and deletion. There are also trees specifically suited to storing data that is structured in a certain way, such as data that contains either unique values or a lot of duplicates.
- One type of tree commonly used in programming is the Binary Search tree which is a special kind of Binary Tree (a family of trees) that excels at searching.
- Binary Search Trees store **sorted** data in a particular way that makes the data easier to retrieve.
- In a tree structure, there is no limit on the number of children a node can have. In Binary trees, any given node can only have up to two children.
- Binary Search Trees are Binary trees in which the data is sorted in a particular way. They store data that is sortable or comparable in some way. The nodes of a Binary Search Tree (BST) must follow the following rule:
    - All children of a node that are lower in value are located to the left of the node. All children of a node that are greater in value are located to the right of the node.
    - This pattern must be followed for **all** nodes, not just the root node.
    - Another way of putting is that the left subtree of a node must contain values less than that node and the right subtree must contain values greater than that node. This means **all** nodes below a given node (a subtree) must abide by this rule, not just the immediate children.
    - Each subtree in a BST must also be a BST.
- Recap:
    - A BST is a type of tree in which every parent node has at most two children.
    - Every child node lower in value than the parent node is located to the left of the parent while nodes greater in value than the parent are located to the right.
    - All values in a BST must be unique because of the way they are structured and the way the searching algorithms work. The position of a node in BST is strictly defined by its value, meaning that two nodes of the same value would occupy the same position on the tree. Further, searching algorithms would skip duplicated values once the first match was found.
## Searching
- The manner in which BSTs are structured makes it very easy to search for, insert, and delete nodes.
- To search through a binary tree, you compare the value you’re looking for to the parent node. If the value is greater than that of the node, you only search through the nodes to its right. You do this for every node as you move through each level of the tree.
    - For an evenly weighted tree, this cuts the number of comparisons in half when compared to an un-sorted tree.
## Inserting
- When inserting a node into a BST, its position is strictly defined by its value. The insert function should take in a value, create a new node, and insert the node into the tree based on that value.
- The first thing the function should check is the root of the tree. If the root does not exist, insert the new node at the root of the tree.
- If the root does exist, define a variable called ‘current’ and assign it to the root of the tree.
- Perform the following comparisons in an indefinite loop:
    - If the current node’s value is equal to the new node’s value, return undefined (there should not be duplicates in a BST).
    - If the new node’s value is less than the current node’s value and there is no node to the left of that node, assign the current node’s left node to be the new node and return the new tree to break out of the loop.
    - If the current node already has a left node, update the current node to be that left node.
    - If the new node’s value is greater than the current node’s value and there is no node to the right of that node, assign the current node’s right node to be the new node and return the new tree to break out of the loop.
    - If the current node already has a right node, update the current node to be that right node.
## Finding
- The find method should take in a value and return true if the tree contains a node with that value and false otherwise.
- Starting at the root, the first thing the function should is the existence of a root. If the root does not exist (the tree is empty), return false.
- If there is a root, compare the root’s value to the value passed to the function. If the values are equal, return true. If the value is greater, move to the right and perform the same comparison. If the value is lesser, move to the left and perform the same comparison.
- If you reach the end of the tree without finding the value, return false.
## Time and Space Complexity
- Insertion has a time complexity of O(log(n)) and a space complexity of O(1).
- Searching has a time complexity of O(log(n)) and a space complexity of O(1).
- O(log(n)) is the time complexity for insertion and searching **in the best and average case**, where log is log of base 2.
- The best and average cases involve a BST that is perfectly balanced and fairly balanced, respectively.
- In the worst case (completely lopsided BST). The time complexity increases to O(n).
## Method Benefits and Drawbacks
- DFS and BFS have the same time complexity because you visit every node once in both algorithms. However, BFS can have a greater space complexity than DFS because of the queue that is created. This queue can grow to be quite large in “fully flashed out trees”, “wide” trees with a lot of siblings and children.
- For trees that are very lopsided (have all or most nodes to one side), BFS would be better to use because the queue would only grow to store one node (in the case of a BST where each node only has a node to one side). With DFS, each of these nodes would need to be added to the call stack, so it would grow to be very large and take up more space than the queue in BFS.
- For wide trees, the queue in BFS could end up using more space than the call stack in DFS.
- For long (deep) trees, the call stack in DFS could end up using more space than the queue in BFS.
- As far as the different variants of DFS are concerned, there’s no concrete guidance on which variant is better for a given situation. However, there are some examples in which one variant prevails over another.
- For example, using In-Order search on a BST containing numbers will cause the nodes to be visited in numerical order.
- Using Pre-Order Search on a BST allows you to “flatten” the tree, potentially store it in a database, and then recreate it from that flattened form.
    - This is possible because performing Pre-Order Search on a BST ensures that the root is the first element visited and added to the flattened clone of the tree. Then the first child is visited, then the first grandchild and so on.
    - Traversing the tree in this order to create a “flattened copy” ensures that when this copy is used to recreate the tree using the insert function, the insert function places the nodes in the correct position.
- The DFS variants are very similar, so it’s not as big of a decision as choosing between DFS and BFS.
## Recap
- Trees are a non-linear data structure consisting of a root node and child nodes. Trees can store any data type.
- Binary Trees are a special type of tree where each node can have a maximum of two children, one to the left and the other to the right.
- Binary Search tree are a special type of Binary Tree in which all nodes to the left of a parent are smaller in value than the parent and all nodes to the right of the parent are greater in value. They are only used with data that is comparable.
- You search through the nodes of a tree using Breadth-First Search or Depth-First Search (In-Order, Post-Order, and Pre-Order),