# Stacks

## Introduction
- A stack is an abstract data structure that is a collection of data which abides by the Last In Fist Out (LIFO) principle. This means the last element added to a stack must be the first element removed from a stack.
    - This makes sense logically. If you stack plates in a cabinet after cleaning them, the last plate put on the stack (the one on top) will be the first one removed when you want to use it.
- A stack can be implemented using a linked list or an array.
- An example of a stack is the Call Stack, the last (most recent) function call added to the stack must be the first one to be removed.
    - With recursive calls, the first call to be resolved (base case) is the last one added to the stack and the first one removed from the stack. The first call (final result) is the last one to be remove from the stack
- Stacks have many practical applications in programming, including:
    - Managing function invocations (Call Stack).
    - Undo / Redo functionality in photoshop.
    - History objects in the browser. The history object in React is also modeled using a stack.
    - Algorithms used to manipulate graphs also incorporate stacks.
- Stacks are abstract concepts. This means we can implement a stack using existing data structures like linked lists and arrays. With linked lists, we had to define our own class the node and the list itself.
## Array Implementation
- A stack is an abstract concept. Any data structure that abides by the LIFO principle. The easiest way of implementing this principle is by using an array.
- To implement a stack using an array, you simply add elements to the array using the push method and remove elements from the array using the pop method. Alternatively, you can use unshift to add elements to the array and shift to remove elements from the array.
    - Comparing these two implementations, the push/pop implementation is more efficient when using an array.
- When you consider that the primary implementation of stack is adding data, then removing data based on when it was added, an array isn’t very efficient because you don’t need indices to perform these operations.
    - The order of a stack needs to be preserved, but you never need to access information based on an index.
    - Therefore, a linked list would be a more efficient implementation of a stack.
- When using stacks in algorithms as a means of storing data, it’s easier and quicker to implement using an array even though it is less efficient.
## Linked List Implementation
- When consiPdering whether to use a Singly Linked List or a Doubly Linked List, you need to decide whether you want to add and remove from the beginning or end.
    - If you want to add from the end, a Doubly Linked List would be more efficient because you can remove items from the end more efficiently (O(1) versus O(n) for a Singly Linked List).
    - If you want to add and remove from the beginning, Singly and Doubly Linked List have the same time complexity of O(1) for both operations. However, a Singly Linked List is better because it doesn’t have the unnecessary ‘previous’ pointer.
- When creating a Stack class, you only need to right two methods, one for pushing data onto the stack and one for popping data off the stack. The push method should return the updated size (length) of the stack and the pop method should return the data that was removed.
- The Stack Class will look almost identical to the Singly Linked List class. However, because pushing and popping in a Stack are supposed to be O(1) time, we need to use the shift and unshift methods from the Singly Linked List class to push and pop.
## Push Pseudocode
- The function should accept a value and create a new node with that value.
- If the stack is empty, the first and last properties should be set as the new node.
- If the stack is not empty, create a variable called ‘first’ to store the current first property of the stack. Then reset the first property of the stack to be the new node.
- Set the next property of the node to be ‘first’ and increment the length.
## Pop Pseudocode
- If the stack is empty, return null.
- Otherwise, save the head in a variable called ‘head’ to be returned at the end of the method.
- If the stack only has one node. Set the head and tail to null and return ‘head.’
- If the stack has more than one item, set the head of the stack to be the next property of the current head.
- Decrement the size of the list and return ‘head.’
## Time and Space Complexity
- Insertion and Removal for a stack should have a time and space complexity of O(1).
- Searching and Accessing data in stack has a time complexity of O(n) and a space complexity of O(1).
- Stacks prioritize insertion and removal.
## Recap
- Stacks are a LIFO abstract data structure where the last item added is always the first one removed.
- They’re used to manage function invocations, operations like undo and redo, for routing and browser history, and a lot more.
- They’re not a built-in data structure in JS, but are relatively simple to implement.
