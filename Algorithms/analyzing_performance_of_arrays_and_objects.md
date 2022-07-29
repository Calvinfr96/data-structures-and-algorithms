# Analyzing Peformance of Arrays and Objects

### Objectives
- Analyze how arrays and objects work through the lens of Big O.
- Explain why adding elements to the beginning of an array is costly.
- Compare and contrast the runtimes of arrays and objects, as well as their built-in methods.


## The Big O of Objects
- Objects are unordered data structures of key-value pairs. Objects are ideal when you don’t need to store data in an ordered fashion and fast access, insertion, and removal.
- The Big O of basic object operations are as follows:
    - Insertion – O(1)
    - Removal – O(1)
    - Searching – O(n). Searching an object means looking through all of the keys of an object for a particular value.
    - Access – O(1)
- When you don’t need any ordering, objects are a great choice!
- The Big O of common object methos are as follows:
    - Object.keys – O(N)
    - Object.values – O(N)
    - Object.entries – O(N). Object.entries returns a 2D array where each inner array is a key-value pair.
    - hasOwnProperty – O(N). hasOwnProperty returns a true if the string passed to it as an argument is a key within the object, and false otherwise.

The Big O of Arrays
- Unlike objects, arrays are ordered lists of data. Arrays should only be used when order is necessary. This is because the ordered nature of arrays makes accessing, inserting, and deleting data more costly. Arrays aren’t the only ordered data structure; singly and doubly linked lists are also ordered.
- The Big O of basic array operations is as follows:
    - Insertion – depends on where in the array the data is being inserted (beginning, middle, end).
        - Inserting at the end of an array is like inserting into an object. Therefore, it is O(1).
        - Inserting at the beginning of an array is more costly because you have to re-index every element in the array. This means it is O(n).
    - Removal - depends on where in the array the data is being removed (beginning, middle, end).
        - Removal from the end of an array is live removal from an object and is O(1).
        - Removal from the beginning of an array is O(n) for the same reason adding to the beginning of an array is O(n).
    - Searching – O(n). Searching means looking for a specific piece of data in an array.
    - Access – O(1)
- The Big O of common array methods are as follows:
    - Push – O(1)
    - Pop – O(1)
    - Shift – O(n)
    - Unshift – O(n)
    - Concat – O(n)
    - Slice – O(n)
    - Splice – O(n)
    - Sort – O(n*log(n))
    - forEach/map/filter/reduce/etc. (iterable methods) – O(n).
