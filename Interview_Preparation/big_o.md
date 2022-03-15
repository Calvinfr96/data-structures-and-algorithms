# Big O

## Introduction
- Big O is the language and metric we use to describe the efficiency of algorithms.
- Time complexity of an algorithm describes how the asymptotic runtime of an algorithm increases with the size of an input.
    - Take an example of transporting something by email vs. plain. Transporting something by plane has a time complexity of O(1) because the travel time remains constant in proportion to the size of the file. Transporting something by email is approximately O(n) because the travel time increases linearly (approximately) in proportion to the size of the file.
- Big O time complexity describes the upper bound of runtime, meaning the runtime in the worst-case scenario. Although it’s less useful of a description, an algorithm with a time complexity of O(n) could also technically be described as O(n^2) or O(2^n), since this represents an upper bound.
- Big O can be used to describe the performance of an algorithm in the best, expected (average), and worst-case scenarios. The best-case scenario isn’t discussed as often because any algorithm can theoretically be O(1) in the best-case.
    - For many algorithms, the expected and worst cases are the same.
- Big O space complexity is a parallel concept to time complexity. An array of size n takes up O(n) space because the memory requirements grow linearly in proportion to the size of the array.
    - Space on the call stack in recursive functions counts as well. A function that adds numbers from 1 to n iteratively would have O(1) space complexity if it added without using arrays. However, the recursive solution would have O(n) space complexity because of the frames added to the call stack during execution.
    - The space requirements relating to the call stack do not depend simply on the number of calls made to a function, they depend on the number of frames that exist on the call stack simultaneously.
- When analyzing the time or space complexity of an algorithm, you take the function that describes the relationship between the runtime/space requirements and input size, then drop the constants and only keep the highest order term in the polynomial.

## Amortized Time
- An ```ArrayList``` is a dynamically sized array that allows you to have the benefits of an array while offering flexibility in size. The capacity of an ```ArrayList``` will grow such that the size of the array it is implemented with will double in size when its capacity is reached.
    - This means that adding an element when the array is at capacity will take O(n) time because you must copy all of the elements in the previous array over to the larger array before adding the element.
    - However, most of the time, you’re adding to the end of the array, which takes O(1) time.
    - Therefore, adding elements to an ```ArrayList``` takes O(n) time, but the _amortized_ time is O(1).
