# Doubly Linked Lists

## Introduction
- Doubly Linked Lists are like Singly Linked lists in that they are a collection of nodes. However, Doubly Linked Lists contain two pointers instead of one. One pointer points to the previous node and the other points to the next node.
- The head of a Doubly Linked List has a previous pointer that is null and the tail a Doubly Linked List has a next pointer that is null.
- Doubly Linked Lists are more flexible than Singly Linked Lists, but this comes at the expense of greater memory usage because of the extra pointer in each node.
## Push
- The push method accepts a value, creates a new node using that value, and adds the node to the Doubly Linked List.
- When pushing the first node onto an empty Doubly Linked List, that node becomes the head and the tail. When pushing a node onto the end of a Doubly Linked List that has one or more nodes, the new node becomes the tail.
- When connecting the new tail, the next property of the previous tail needs to be set to the new tail and the previous property of the new tail needs to be set to the previous tail.
## Push Pseudocode
- Create a new node with the value passed to the function.
- If the list is empty, the new node should be set as the head and tail of the list.
- If the list is not empty, set the next property on the current tail to be the new node. Then set the previous property of the new node to be the current tail.
- Set the tail of the list to be the new node and increment the length of the list by one.
- Return the updated list.
## Pop
- The pop method removes the current tail of the Doubly Linked List and makes the previous node the new tail. This method returns the node that was removed.
- If the list is empty, the method should return undefined. If the list only has one node, the method should set the head and tail to be null.
## Pop Pseudocode
- If the list doesn’t have a tail, return undefined.
- If the length of the list is one, set the head and tail to be null and return the tail of the list.
- Otherwise, store the current tail in a variable that will be returned at the end of the method. 
- Set the current tail’s previous node to be the new tail. Then set the current tail’s previous node to be null.
- Set the new tail’s next node to be null. Then decrement the length and return the tail that was removed.
## Shift
- The shift method removes a node from the beginning of a Doubly Linked List.
- With a Doubly Linked List, you must make sure to set the next of the old head and the previous of the new head to null, then return the old head.
## Shift Pseudocode
- If the length is zero, return undefined. Otherwise store the old head in a variable to be returned at the end of the method.
- If the length is one, set the head and tail to be null and decrement the length by one.
- Otherwise, update the head of the list to be the next pointer of the old head. Set the next pointer of the old head to be null and set the previous pointer of the new head to be null.
- Decrement the length by one and return the old head.
## Unshift
- The unshift method accepts a value, creates a new node with that value, and updates the head of the Doubly Linked List to be the new node.
- If the list is empty, the new node becomes the head and tail of the list.
## Unshift Pseudocode
- Create a new node with the value passed to the function.
- If the length is zero, set the head and tail of the list to be the new node and increment the length by one.
- Otherwise, set the next pointer of the new node to be the current head, then set the previous pointer of the current head to be the new node. Finally, update the head of the list to be the new node, increment the length by one, and return the list.
