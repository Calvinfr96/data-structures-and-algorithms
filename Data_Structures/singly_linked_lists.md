# Singly Linked Lists

## Introduction
- A linked list is a data structure like an array where the data it holds has a particular order. Unlike an array, the elements don’t have indices. Instead, a linked list contains a head (beginning), tail (end), and length property.
- Linked lists consist of nodes. Each node has a value and a pointer that either points to null or the next node. This pointer is how linked lists maintain the order of the data they hold without the use of indices.
    - Instead of accessing the nth node in a linked list directly (as you would with an element’s index in an array), You must access each node before it until you reach that node.
    - Every node except the tail points to another node.
    - A singly linked lists is named so because each node only points unidirectionally to the node after it, not the one after it and the one before it (doubly linked list).
- Singly Linked lists must have a head, but they don’t need to have a tail.
## Comparison With Arrays
- Singly Linked Lists:
    - Don’t have Indices.
    - Connect via nodes with the next pointer.
    - Random access not allowed.
- Arrays:
    - Indexed in order.
    - Insertion and Deletion can be expensive.
    - Can be quickly accessed at a specific index (random access).
- Linked Lists are a better choice than arrays when if insertion and deletion are more important than random access.
## Pushing
- The singly linked list constructor defines an instance with a length of 0 and the head and tail set to null. This would be the equivalent of an empty array.
- When pushing the first item (node) onto a singly linked list, that node should be assigned as both the head and tail of the list and the length of the list should be incremented by one. 
- When pushing a second node onto the end of the list. The tail of the list should be updated to be that node and the pointer of the head should be updated to point to the second node. To add a third item, you have the current tail point to that item and update the tail to be that item.
## Pushing Pseudocode
- The function should accept a value, create a new node based on that value, and add it to the singly linked list.
- If the list is empty (no head), the head and tail of the list should be set as the node being pushed.
- If the list is not empty, the pointer of the tail should be updated from null to the node being pushed and the tail of the list should be updated to be that node. 
- Finally, increment the length by one and return the linked list.
## Popping
- When popping an item off the end of a singly linked list, you have to remove the current tail and set the new tail as the node before it.
- To set the previous node as the tail, you must traverse through the list until you find the node before the tail being removed, then set the tail as the previous node.
- After popping the last node off the list, you return that node.
- To traverse a list, you start at the head, then keep moving to the next node as long as the node has a next property
## Popping Pseudocode
- If there are no nodes in the list, return undefined.
- Loop through the list until you reach the tail.
- Set the next property of the second to last item to null.
- Set the tail property to be the second to last node.
- Decrement the length by one.
- Return the node that was removed.
## Shifting
- Shifting involves removing a node from the beginning of a linked list.
- To remove the head, you can simply set its next property to be the head of the linked list.
## Shifting Pseudocode
- If the list is empty, return undefined
- Otherwise, save the current head in a variable to be returned at the end of the method. Then, set the head to be the next property of the current head. Afterwards, decrement the length by one and return the head that was removed.

