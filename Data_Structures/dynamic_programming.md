# Dynamic Programming

## Introduction
- Dynamic programming is a method for solving a complex problem by breaking it down into a collection of smaller, simpler subproblems, solving each of these subproblems once, and storing their solutions.
- Most problems cannot be solved with dynamic programming. However, the solutions to the problems that can be solved using dynamic programming are much more efficient than other solutions.
    - It’s like the divide and conquer algorithm. It doesn’t work on every problem but works very well when applied appropriately.
- Dynamic programming only works on problems overlapping subproblems and optimal structure.
## Overlapping Subproblems
- A problem is said to have overlapping subproblems when it can be broken down into several subproblems which are reused several times.
- A good example of a problem that has overlapping subproblems is the Fibonacci sequence. The Fibonacci sequence is one where each number is the sum of the previous two numbers in the sequence: 1,1,2,3,5,8,13…
    - Finding the 5th number in the Fibonacci sequence involves adding the 3rd and 4th numbers together.
    - Finding the 4th number involves adding the 2nd and 3rd numbers together.
    - Finding the 3rd number involves adding the 1st and 2nd numbers together.
    - Each of these problems represents an overlapping subproblem in the goal of finding the 5th Fibonacci number. To solve the problem, you need to find the 1st, 2nd, 3rd numbers more than once.
- The merge sort algorithm learned previously would be an example of the divide and conquer algorithm because it can be broken down into subproblems, but none of those subproblems overlap (repeat) during the execution of the algorithm (assuming the array being sorted contains unique numbers.
## Optimal Substructure
- A problem is said to have optimal substructure when an optimal solution can be constructed from optimal solutions of its subproblems.
- An example of optimal substructure is the shortest path algorithm. The shortest (optimal) path from node A to node E also includes the shortest path from node A to node d, the shortest path from A to C, and so on. The shortest path between two nodes consists of the shortest paths between the starting node and the intermediate nodes.
## Writing a Recursive Solution
- Using the Fibonacci problem as an example, the recursive solution involves establishing a base case and then having a function repeatedly invoke itself until that base case is reached.
- For this problem, the base case would be if the number passed to the function is less than or equal to 2. If this is the case, you return 1. Otherwise, you return the sum of the invocation of the function with num – 1 and num – 2 passed to it.
- The time complexity of the recursive solution is O(2^n), which is really bad (worse than n^2). It’s a very simple and easy to understand solution, but it is not performant at all.
    ![](https://i.stack.imgur.com/kgXDS.png)
    <img src="https://pbs.twimg.com/media/CnCqdu-VIAEsbZZ?format=jpg&name=4096x4096" />
- The reason the time complexity is so bad is because you repeat function calls during the recursion. For example, running Fibonacci(5) will result in the following calls: [5,4,3,3,2,2,1,2,1].
    - Here, you can see that the calls for Fibonacci of 3, 2, and 1 are called more than once during the recursion. With dynamic programming, we can improve upon this solution by only performing these overlapping subproblems once.
## Memoization
- Dynamic programming involves breaking down a problem into a series of simpler problems, solving those simple problems **just once**, and storing their solutions.
- Storing the solution of each subproblem can be done using a method called memoization.
- Memoization involves storing the return value of expensive function calls and returning the cached result when the same input occurs again. The return values can be stored in any data structure, such as an array or object.
- The time complexity of the solution using dynamic programming and memoization is O(n) because you only need to perform the calculation for each Fibonacci number in the sequence once. Looking up a value in an array is constant time, so those operations don’t affect the time complexity. 
## Tabulation
- Storing the result of a previous calculation in a table (usually an array). This is usually done using iteration, instead of recursion.
- Using tabulation can result in a solution that has better space complexity than one derived using memoization.
- The recursive solution (using memoization) is a top-down approach because the function starts by trying to calculate the result, then works down until it reaches the base case. The iterative solution (using tabulation) starts from the base case and works up until it calculates the result.
- Tabulation results in better space complexity than memoization because it significantly reduces the number of function calls being added to the call stack. For large enough numbers (~10,000), the recursive Fibonacci function will result in a stack overflow because of the excessive amount of function calls being added to the call stack.
- The tabulation and memoization solutions both have a time complexity of O(n).