# Big O Notation
- For all data structures and algorithms (DSA) problems you encounter, there will be many implementations that work. Big O notation is used to determine which implementation is best. It is a system of generalizing and comparing code in terms of their efficiency. It gives you a numeric representation of the efficiency of code.
- Big O notation is also useful for talking about the trade-offs between different approaches.
- When trying to debug code, it helps to understand efficiency to pin point problems that make your code slower.

## Timing Code
- Problem Statement: Write a function that calculates the sum of all integers from one up to and including some number n.
- The primary concerns relating to big O are speed and memory usage.
- Timing code by simply recording the start and end time of a function can be problematic because different machines record different times and the same machine can record different times when running the same function using the same inputs.
    - Furthermore, for very performant algorithms, the speed measurements may not be precise enough to show a difference.

## Counting Operations
- Instead of using time to compare code, Big O Notation compares code based on the number of simple operations that are required to execute the code. A simple operation is something like multiplication or addition. Things like variable declarations are also considered simple operations, but you don’t need to get to bogged down in the details for the purposes of the analysis. Take the following two functions:  
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
```
- The first implementation has a total of three simple operations:
    1. Multiplication
    2. Division
    3. Addition
    - It is also important to note that the number of operations remains the same regardless of the input n.
- The second implementation has a variable number of operations that depends on the input n. If n is 5, there is a total of 5 operations (5 additions). If n is 1,000,000,000, there is a total of 1,000,000,000 operations (1,000,000,000 additions). Breaking down the function, for iteration of the loop, there are:
    1.	4 assignments (```i++``` counts as an addition and assignment).
    2.	2 additions
    3.	1 comparison
    - This means there could be as many as 5n + 2 operations. However, the actual number of operations doesn't matter as much as the general trend of how the number of operations increases with respect to the input. For this function, the number of operations grows proportionally (linearly) with n.

## Time Complexity
- The first function has a constant number of operations regardless of n. This means that, as n increases, the amount of time it takes the function to execute will also remain fairly (not exactly) constant.
- The second function has a number of operations that grows proportionally with n. this means that, as n increases, the amount of time it takes the function to execute will also grow linearly with n.

## Introduction to Big O
- Big O Notation is a way to formalize fuzzy counting. It allows us to talk formally about how the runtime of an algorithm grows as the number of inputs grow. It describes the relationship between the input size and the runtime of a function.
- We say that an algorithm is O(f(n)) if the number of simple operations the computer must do is eventually less than a constant times f(n) as n increases.
- f(n) could be linear, meaning f(n) = n. In general, we compare how the input n on the left side of the equation scales with the runtime n on the right sie.
    - f(n) could be quadratic, meaning f(n) = n^2.
    - f(n) could be constant, meaning f(n) = 1.
    - f(n) could also be something entirely different.
- Big O represents the upper bound of runtime. In other words, the worst-case scenario. In the case of the first function, we say that it has a time complexity of O(1). The second function has a time complexity of O(n).
- Here are a few other examples:
```
function countUpandDown(n) {
    console.log("Going up!");
    for (let i = 0; i < n; i++) {
        console.log(i);
    }
    console.log("At the top!\nGoing down...");
    for (let j = n - 1; j >= 0; j--) {
        console.log(j);
    }
    console.log("Back down. Bye!")
}
```
- In this function, the first for loop in the function is O(n). The second for loop is also O(n). This means that the over all time complexity is O(n).
```
function printAllPairs(n) {
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            console.log(i, j);
        }
    }
}
```
- This function also involves two for loops which are O(n). However, because one loop is nested inside of the other, you multiply instead of adding, resulting in a complexity of O(n<sup>2</sup>).

## Simplifying Big O Expressions
- The exact number of operations required to execute an algorithm is not important for calculating the Big O of an algorithm. It’s more important how the number of operations scales with the input.
- When determining the time complexity of an algorithm, there are some helpful rules for Big O Expressions: 
    - Constants don’t matter. This means that O(2n) can be simplified to O(n) and O(500) can be simplified to O(1). O(13n^2) can be simplified to O(n^2).
    - Smaller terms don’t matter either. This means if an algorithm contains 10n +2 operations, where n is the input, the algorithm has a Big O of O(n). If there are 5n^2 + n + 8 operations, the algorithm has a Big O of O(n^2). This is because the highest order term in the expression. In this case, that term is n^2.
- There are also some helpful shortcuts you can take when performing Big O analysis:
    - Arithmetic operations are constant. This means it takes a computer the same amount of time to do 2 + 2 as it does 1,000 + 1,000.
    - Variable assignments are also constant.
    - Accessing elements in an array using the index or accessing elements in an object using the key are also constant.
    - In a loop, the complexity is the length of the loop multiplied by the complexity of whatever happens inside the loop.
- The following examples show simple Big O analysis:
```
function logAtLeast5(n) {
    for (let i = 0; i < Math.max(5, n)) {
        console.log(n)
    }
}
```  
- In this function, as n grows, the number of operations grows proportionally. This means that the algorithm has a time complexity of O(n).
```
function logAtMost5(n) {
    for (let i = 0; i < Math.min(5, n)) {
        console.log(n)
    }
}
```
- In this function, as n grows, the number of operations remains constant because the maximum number of times it will log a number is 5. This means the algorithm has a time complexity of O(1).
