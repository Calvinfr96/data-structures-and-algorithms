# Big O Notation

- For all data structures and algorithms (DSA) problem you encounter, there will be many implementations that work. Big O notation is used to determine which implementation is best. It is a system of generalizing and comparing code in terms of their efficiency. It gives you a numeric representation of the efficiency of code.
- Big O notation is also useful for talking about the trade-offs between different approaches.
- When trying to debug code, it helps to understand efficiency to pin point problems that make your code slower.

## Timing Code
- Problem Statement: Write a function that calculates the sum of all integers from one up to and including some number n.
- The primary concerns relating to big O are speed and memory usage.
- Timing code by simply recording the start and end time of a function can be problematic because different machines record different times and the same machine can record different times when running the same function using the same inputs.
    - Furthermore, for very performant algorithms, the speed measurements may not be precise enough to show a difference.
- Instead of using time to compare code, Big O Notation compares code based on the number of simple operations that are required to execute the code. A simple operation is something like multiplication or addition. Take the following two function:  
```
function addUpTo(n) {
    return n * (n + 1) / 2;
}
```  
And  
```
function addUpTo(n) {
    let total = 0;
    for (let i = 1; i <= n; i++) {
        total += i;
    }
    return total;
}