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
    for (let i = 0; i < Math.max(5, n); i++) {
        console.log(n)
    }
}
```  
- In this function, as n grows, the number of operations grows proportionally. This means that the algorithm has a time complexity of O(n).
```
function logAtMost5(n) {
    for (let i = 0; i < Math.min(5, n); i++) {
        console.log(n)
    }
}
```
- In this function, as n grows, the number of operations remains constant because the maximum number of times it will log a number is 5. This means the algorithm has a time complexity of O(1).

Space Complexity
- Time complexity is concerned with analyzing the runtime of an algorithm as the size of inputs increases.
- Space complexity, which also uses Big O Notation, is concerned with analyzing how much additional memory we need to allocate to run the code in the algorithm.
    - When analyzing the space complexity of an algorithm, the size of the input is not considered. The size of an algorithm, excluding the size of the input, is also known as auxiliary space complexity.
- Things to consider when analyzing space complexity in JS:
    - Most primitives (Booleans, numbers, undefined, and null) are constant space.
    - Strings require O(n) space, where n is the string length. This means that 1 takes up the same amount of space as 1000 or that true takes up the same amount of space as false.
    o	Reference types such as arrays and objects are generally O(n), where n is the number of elements in an array or the number of keys in an object. This means that an array of size 40 takes up twice as much space as an array of size 20.
- Take the following example:
```
function sum(arr) {
    let total = 0;
    for (let i = 0; i < arr.length; i++) {
        total += 0;
    }
    return total;
}
```
- Within this algorithm, two numbers are declared (let total = 0 and let I = 0). This means the algorithm has a space complexity of O(1).
```
function double(arr) {
    let newArray = []
    for (i = 0; i < newArray.length; i++) {
        newArray.push(2*arr[i])
    }
}
```
- Within this algorithm, an array is declared and a number is declared (let I = 0). Within the loop, items are pushed onto the array and then the array is returned. The size of the array returned scales proportionally to the size of input array. This results in a space complexity of O(n + 2), which reduces to O(n).

## Logarithms
- Big O Complexities that aren’t O(1), O(n), or O(n^2) typically involve logarithms. Examples include O(log(n) and O(n*log(n)).
- A logarithm is the inverse of exponentiation. This means the output of the logarithm is the exponent you would raise the base of the logarithm to get the input. Log base 2 of 8 equals 3 because 2^3 is 8.
- For Big O Analysis, a base of 2 is typically used for logarithms.
- O(log(n)) is the second-best time / space complexity you can achieve for a given algorithm. In order from best to worst, the most common complexities are: O(1), O(log(n)), O(n), O(n*log(n)), and O(n^2).
- Certain searching and efficient sorting algorithms have logarithmic time complexities.
- Recursion sometimes involves logarithmic space complexity.

## Recap
- To analyze performance of an algorithm, we use Big O Notation. We are mainly concerned with analyzing how the runtime and memory usage of an algorithm changes as the size of input changes.
- Big O Notation is not concerned with precisely defining the number of operations. It is only concerned with the general trend of input size vs. runtime or memory usage.
- Time and space complexity only depend on the algorithm, not on the hardware used to run the algorithm.
