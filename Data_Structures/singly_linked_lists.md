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
## Unshifting
- Unshifting involves adding a node onto the beginning of a linked list.
- To add a node to the beginning of the list, you set the next property of the new node to be the current head, then you reassign the current head to be the new node. Finally, you return the new node.
## Unshifting Pseudocode
- The function should accept a value and create a new node using that value.
- If there is no head, set the head and tail to be the new node.
- Otherwise, set the next property of the new node to be the head of list, then reassign the head of the list to be the new node.
- Finally, increment the length of the list by one and return the new node.
## Get
- Get is a method that allows you to treat a linked list like an array. You pass it a number, starting from 0, and it returns the node at that position in the linked list by starting at the head and accessing that node’s next property an appropriate number of times.
## Get Pseudocode
- The function should accept an index and return the node at that index.
- If the index is negative or greater than or equal to the length, return null or undefined.
- Loop through the list until you reach the node at that index.
## Set
- sSet is like get, except you’re changing the value of a node at a specific position instead of just retrieving the node.
## Set Pseudocode
- The function should accept an index and a value. The function should change the value of the node at that index and return true if successful. If the node is not found, return false. The get method can be used as a helper to write this method.
## Insert
- The insert method should be able to add a node to a singly linked list at a specific location. The method should accept an index and a value, just like the set method. If the index is negative or greater than the length, return false. Otherwise, create and insert a new node at the specified index and return true.
## Insert Pseudocode
- If the index is the same as the length, use the push method to push the new node onto the list.
- If the index is zero, use the unshift method to add the new node to the beginning of the list.
- If the index is valid, reference the nodes before and at the node at the argument index. Update the next property of the before node to be the new node and set the next property of the new node to be the node previously at the argument index. Finally, return true.
## Remove
- The remove method should be able to remove a node from a singly linked list at a specific location. The method should accept an index and remove the node at that index.
## Remove Pseudocode
- If the index is less than zero or greater than or equal to the length, return undefined.
- If the index is length – 1, pop the node off the end of the list. If the index is zero, unshift the node off the beginning of the list. Otherwise, reference the nodes before and after the one to be deleted. Set the next property of the before node to be the after node.
- Finally, decrement the length and return the value of the node removed.
## Reverse
- Reversing a linked list means reversing the order of the nodes so that the head becomes the tail and the tail becomes the head. Additionally, all nodes in between have their order reversed, so that the next property of the head becomes the node that previously came before the tail, and so on.
## Reverse Pseudocode
- When reversing the list, you need to keep track of three things: The previous node, the current node, and the next node.
- Initially the previous pointer will be set to null (because you’re at the head), the current node will be set to the head, and the next node will be set to null.
- Before looping, set the head to be the tail of the list, then set the tail of the list to be the current node.
- While the current pointer is not null:
    - Update the next node to be current.next. You do this first because it is the only way to access the node after the current node. In the next step, we reassign current.next, which erases the reference, so we save the reference first.
    - Update current.next to be the previous node. This reverses the order of the two nodes. For the first iteration of the loop, this makes the head the tail by setting its next property to null.
    - Update the previous node to be the current node.
    - Update the current node to be the next node. You can’t update current node to be next before updated previous node to be current node because then the previous and current node would be set to the next node.
