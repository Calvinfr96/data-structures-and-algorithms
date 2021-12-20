# Doubly Linked Lists

## Introduction
- Doubly Linked Lists are like Singly Linked lists in that they are a collection of nodes. However, Doubly Linked Lists contain two pointers instead of one. One pointer points to the previous node and the other points to the next node.
- The head of a Doubly Linked List has a previous pointer that is null and the tail a Doubly Linked List has a next pointer that is null.
- Doubly Linked Lists are more flexible than Singly Linked Lists, but this comes at the expense of greater memory usage because of the extra pointer in each node.
## Push
- The push method accepts a value, creates a new node using that value, and adds the node to the Doubly Linked List.
- When pushing the first node onto an empty Doubly Linked List, that node becomes the head and the tail. When pushing a node onto the end of a Doubly Linked List that has one or more nodes, the new node becomes the tail.
- When connecting the new tail, the next property of the previous tail needs to be set to the new tail and the previous property of the new tail needs to be set t the previous tail.
## Push Pseudocode
- Create a new node with the value passed to the function.
- If the list is empty, the new node should be set as the head and tail of the list.
- If the list is not empty, set the next property on the current tail to be the new node. Then set the previous property of the new node to be the current tail.
- Set the tail of the list to be the new node and increment the length of the list by one.
- Return the updated list.
