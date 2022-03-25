# Technical Questions

## How To Prepare
- **Memorizing solutions will not help you become better at solving technical problems**, just as it didn't help you become better at solving physics problems.
- For each technical problem you encounter, to the following:
    1. Try to solve the problem on your own. Develop a solution with as little help as possible.
    2. Make sure to think about time and space complexity when solving a problem.
    3. Practice writing code on paper. Also test your code on paper with the general cases, base cases, and error cases.
    4. Test your paper code by typing it as-is into an IDE. Take note of the mistakes you make and try not to make them again.

## Core Data Structures, Algorithms, and Concepts
- Most interviewers won't ask esoteric questions, such as algorithms for balancing a binary tree. Being several years out of school themselves, they probably don't remember either.
- However, they will ask questions that gauge your baseline understanding of the concepts. This is a list of must-have knowledge:
    1. Data Structures:
        - Linked Lists (Single, Double)
        - Trees, Tries, Graphs
        - Stacks and Queues
        - Heaps
        - Vectors / ArrayLists
        - **Hash Tables**
    2. Algorithms
        - Breadth-First Search
        - Depth-First Search
        - Binary Search
        - Merge Sort
        - Quick Sort
    3. Concepts
        - Bit Manipulation
        - Memory (Stack vs. Heap)
        - Recursion
        - Dynamic Programming
        - Time and Space Complexity
- For each of these topics, make sure you know how to use and implement them.

## Walking Through a Problem
1. Pay very close attention to the details provided in the problem statement, you'll probably need all of them to design an optimal algorithm.
    - Be sure to understand all aspects of the problem. Notably, make sure to take note of any _unique_ information in the problem. It's unlikely the interviewer would give you this information if it didn't affect the algorithm.
    - For example, if a problem states, "Given two **sorted** arrays..." you want to take note of the fact that the arrays are sorted because this will affect the algorithm. Write this information on the whiteboard.
    - Your first algorithm doesn't need to use the unique information. But if you're stuck, ask yourself if you've considered all available information.
2. Explore examples that involve user stories of the algorithm you're going to design. Start with simple "happy path" cases, then move to "unhappy" edge cases.
    - When trying to solve a problem for the first time, draw a _good_ example. A good example is one that pertains to an average case, not a special case. The example should also be specific, using actual numbers or strings. Also make sure it is sufficiently large.
3. Get a Brute-Force solution as soon as possible. Don't worry about building an effecient algorithm on the first go. State a naive algorithm and its runtime, then optimize from there. Try to do this on paper, without actually coding anything.
    - Although the brute-force algorithm might be terribly inefficient, it is important because it is the starting point for discussions about optimization. It also lets your interviewer know that you can at least come up with a quick but inefficient solution.
4. Walk through your brute-force solution with BUD optimization or try some of these ideas:
    - Look for unused information.
    - Solve the problem using another example to expose any overlooked patterns.
    - Solve the problem manually on an example, then reverse engineer it.
    - Solve it "incorrectly", then think about why the algorithm fails.
    - Make a time vs. space tradeoff. Sometimes storing extra information about a problem can reduce an algorithm's runtime. Hash tables are especially useful here.
    - Think about the best conceivable runtime.
5. Walk through your optimized solution in detail. Make sure you understand each detail before you start to code.
    - You should test your algorithm to make sure it's as close to perfect as possible.
    - Get a feel for the structure of the code before you write it. Know which variables you need and when they'll change.
    - If you don't understand exactly what you're about to write, you'll struggle to code it and will likely make major errors.
6. Implement the algorithm.
    - Make sure the code you write is neat and organized. Try to write it as if you we're typing it into an IDE.
    - Also make sure the code you write demonstrates your skills as a developer.
    - Write modular code and check for errors.
    - Use other classes and structures where appropriate. You don't need to fill in the details of the class, just pretend it exists and deal with it later.
    - Don't use variable names that are too short or too long.
7. Test your implemented algorithm.
    - Start with a conceptual test. This means reading and analyzing what each piece of code does.
    - Double check weird-looking code, such a for loops that start at `int i = 1`.
    - Double check areas of your code that are likely to cause problems, such as base cases in recursive code or null nodes ina binary tree.
    - Test your code with smaller, simpler examples. Also test your code with edge cases.

    ## Optimize and Solve Techniques
    - Look for BUD:
        - BUD stands for Bottlenecks, Unnecessary work, and Duplicated work. These are the three most common thing an algorithm can "waste time" doing. Looking for these problems in your initial, brute-force algorithm will help to optimize it.
        - Bottlenecks:
            - A bottleneck occurs in your code when one part of an algorithm has a runtime complexity significantly greater than another step. Consider a two-step algorithm and sorts and searches through the array. If the sorting is O(N*log(N)) and the search is O(N), it makes more sense to try and reduce the runtime of the sort because it would reduce the runtime more significantly than optimizing the search.
            - One way to eliminate a sorting step with a high runtime is to use a hash table. Sorting makes searching the array easier and faster, but if you throw all of the elements into a hash table, you can search for any element in O(1) time.
        - Unnecessary Work:
            - When iterating using a loop, using a break statement can be an effective way of avoiding unnecessary work. For example, consider a method where you're using four nested loops to find solutions of a^3 + b^3 = c^3 + d^3 from 1 to n, where each loop iterates over a variable from 1 to n. Once you find a solution for the fourth nested loop (d), you can stop iterating because their won't be more than one solution for d if a, b, and c are known.
            - To optimize further, you can eliminate the fourth loop by just calculating d given values for a, b, and c, then checking if those values satisfy the equation.
        - Duplicated Work:
            - Having four nested loops means that you're calculating each (a,b) pair, then checking to see if any (c,d) pair matches the (a,b) pair. Instead, you can store a list of (c,d) pairs in a hash table, then look for an (a,b) pair in that list. When a match is found, you print both pairs.
            - This reduces the runtime to O(N^2) because you can create the list and check for (a,b) pairs with two adjacent, nested loops that are both O(N^2), as opposed to four nested loops that are O(N^4).
    - Do It Yourself:
        - Before learning about Binary Search, you intuitively knew how to do this already. Consider someone gave you an alphabetized stack of papers and you had to find your paper, you'd pick a spot in the middle of the stack and check the name. If your name comes before that, you move and check again. If your name came after, you'd move forward in the stack and check again.
        - This is what Binary search is, you knew how to do it intuitively, you just didn't give it a name.
        - This is why it's important to try and solve a problem intuitively on a real, suitable example before trying to code it. Trying to code it first restricts your thinking to the constraints of the programming language.
