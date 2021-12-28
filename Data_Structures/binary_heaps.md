# Binary Heaps

## Introduction
- Heaps are a type of tree, so everything that applies to trees in general (consists of nodes with a parent/child relationship) also applies to heaps.
- A Binary Heap is very similar to a BST, but with some different rules. In a Max Binary Heap, parent nodes are always larger than child nodes. In a Min Binary Heap, parent nodes are always smaller than child nodes.
    - Unlike in BSTs, where the children on the left side are smaller than children on the right side, there is no guaranteed relationship among siblings in a Binary Heap.
- Like BSTs, the nodes of a Binary Heap can only have two children. Unlike BSTs, the data in Binary Heaps is not sorted so that nodes less than parent on the left and nodes greater than the parent on the right.
- Binary Heaps differ from BSTs in that they are as compact as possible, meaning all of the children of each node are optimally occupied, with the left children being filled first. This differs from BSTs, which can be very skewed to one side.
- Binary Heaps are commonly used to implement Priority Queues, which are very commonly used data structures. Binary Heaps are also commonly used in graph traversal algorithms.
## Representing Heaps
- Binary Heaps can easily be stored using arrays or lists. This can be done by storing the nodes of the tree in the array so that the root comes first, then moving down level by level, you add nodes moving from left to right.
- When represented this way, where x is the index of the parent, its children are at indices 2x + 1 and 2x + 2. Working backwards, where x is the index of a child, its parent is located at the truncated (floor) value of (x – 1) / 2. These two relationships are important for adding nodes to the array representation of a Max Binary Heap.
- To insert nodes into a Max Binary Heap, you add the node to the bottom of the tree, then compare its value to that of its parent, if the node is larger, you swap it with its parent. You continue to compare and swap until the node is less than its parent and all of its children are less than it.
## Inserting Nodes
- The insert method for a Binary Heap should accept a value, push the value into the end of the values array, then swap it with its parent node (if necessary) until it is in the correct position.
- To swap the parent and child nodes, you first need the indices of the parent and child. To start, the index of the child is [length – 1] because it’s at the end of the array. The index of the parent will always be the floor of (x – 1) / 2 where x is the child index.
- While the child element is greater than the parent element, swap them and update the child element.
