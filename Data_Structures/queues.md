# Queues

## Introduction
- A queue is like stack in that it is an abstract data structure in which data is either added or removed. Unlike a stack, a queue is a collection of data that abides by the First In First Out (FIFO) principle.
    - Think of any line, such as that at a grocery store. The first person to enter the line is the first person to leave the line.
- In programming, queues are used in many places. For example, in an online game, there is a waiting room where players are added into the game based on how long they’ve been waiting. The first person added to the waiting room is the first person admitted to the game.
    - Background tasks on your computer are also managed using a queue.
    - Uploading and downloading resources on your computer is managed using a queue. If you download two files of the same size, the file downloaded first will be the first one processed.
    - A printer also manages the jobs sent to it using a Queue.
- Like stacks, queues are abstract, meaning they can be implemented using a variety of data structures, such as arrays and linked lists. While the array implementation is less efficient it is easier to use when implementing a queue into other algorithms. 
## Array Implementation
- There are two ways of implementing a queue using an array. Data can be added to the array using push and removed from the array using shift. Data can also be added to the array using unshift and removed from the array using pop.
- With stacks, the push/pop implementation was more efficient because it avoided the need for re-indexing. With queues, neither implementation avoids re-indexing, so there is no better implementation. In push/shift, shift requires re-indexing. In the unshift/pop method, unshift requires re-indexing.
## Linked List Implementation
- A queue can also be implemented using a Singly Linked List. In this implementation, you add nodes using a method like push (called enqueue) and you remove nodes using a method like shift (called dequeue).
- When adding nodes to the list, you update the tail of the list to be the last item removed. When removing nodes, you remove the head of list and update the next node to be the new head.
## Enqueue Pseudocode
- The enqueue method should accept a value and create a new node with that value.
- If the list is empty, update the first and last properties of the queue to be the new node.
- If the list is not empty, update the next property of the last to be the new node, then update the last property of the queue to be the new node.
- Finally, increment the size of the queue and return the updated size.
## Dequeue Pseudocode
- If the list is empty, return undefined.
- If the list is not empty, save the first property of the queue in a variable called ‘first’ to be returned at the end of the method.
- Update the first property of the queue to be the next property of first, then decrement the size and return the value of ‘first.’
## Time and Space Complexity
- Adding and removing data from a queue should have a time and space complexity of O(1).
- Searching for and Accessing data within a queue should have a time complexity of O(n) and a space complexity of O(1).
## Recap
- Queues are an abstract data structure that follow the FIFO principle, this means the first piece of data added to the queue should be the first item removed from a queue.
- Queues are useful for processing tasks, such as a printer queue. They are also foundational for more complex data structures.
- Insertion and removal needs to be O(1).