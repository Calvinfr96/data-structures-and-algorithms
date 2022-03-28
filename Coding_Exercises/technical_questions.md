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
    Simplify and Generalize:
    - This approach involves simplifying or tweaking a constraint in a problem, such as the data type, then solving the simplified version of the problem. Once you have an algorithm for the simplified version of the problem, you can try to adapt it for the more complex, original version of the problem.
    - For example, if you're writing a program to determine if a ransom note can be written with the words available in a magazine, you could simplify the problem by counting the frequency of each character of each word in the magazine. You can do the same for the ransom note, and then see if the magazine had all of the required characters.
    - To generalize this algorithm for the more complex version, you can now count the frequency of whole word, instead of characters, to make this determination.
- Base Case and Build:
    - This approach involves solving a problem using the base case (e.g. n = 1) first, then trying to build up from there.
    - When we get to more complex/interesting cases, we try to construct the solutions to those cases using the prior solutions.
    - Consider a method that must find all permutations of a string consisting of unique characters. As an example, consider the string "abcdefg". We can use the Base Case and Build approach as follows:
        - Case "a" --> {"a"}
        - Case "ab" --> {"ab", "ba"}
        - To build the next case, you can use the previous case by inserting "c" at each possible position in each string. This gives the solution for "abc"
        - Case "abc" --> {"cab", "acb", "abc", "cba", "bca", "bac}. We know this is the solution for this case because the number of permutations should be `3! = 6`.
    - Base Case and Build algorithms often lead to natural recursive algorithms.
- Data Structure Brainstorm:
    - This approach involves running through a list of data structures, trying to apply each one to the problem. This approach is useful because a problem becomes much easier to solve when you discover an optimal data structure to use.
    
## Best Conceivable Runtime
- Simply put, the Best Conceivable Runtime (BCR) of a solution to a problem is the lower limit of its conceivable runtime.
    - For example, if you're devising a solution to a problem that asks you to determine the number of elements two arrays, of size A and B, have in common, the lowest possible runtime for this solution is O(A + B) because you need to look at every element in each array at least once.
- The BCR of an algorithm can offer useful hints for some problems.
- Although the sound similar, the BCR of a solution to a problem does not relate to the best-case runtime complexity of an algorithm. The BCR is largely a function of inputs and outputs. The Best-Case Runtime is for a specific algorithm and is mostly useless since you mainly judge an algorithm by its worst or average-case runtime.
- It's important to note that you should never rely on an algorithm having one of the most common runtimes(O(1), O(log(N)), O(N), O(N*log(N)), O(N^2)). When you're stuck on a problem and are tempted to just guess one these, the runtime is most likely something unique, like O(N^2 * K).
- Thinking about the array problem above, this is how BCR can be useful in solving problems:
    - A brute force algorithm that involves searching all values in the second array for each value in the first would have a runtime of O(N2).
    - The BCR of the problem, assuming two sorted arrays of the same length, is O(A + B) = O(2N) = O(N).
    - This means an optimal algorithm should have a runtime between these two extremes.
    - Thinking about the problem in this way, you could consider ways of reducing the runtime, such as shortening the runtime of searching the second array from O(N) to O(log(N)) or O(1).
    - Optimizations: 1. Once a match is found in array B at index i, start searching array B starting at i + 1 instead of 0 for subsequence iterations. 2. Perform a binary search of array B for all elements in array A.
    - Further Optimizations: When considering optimizations to your algorithm, consider the fact that **any upfront work you do that is <= the BCR is "free"** because it won't impact the overall runtime of the algorithm.
    - For example, you can put all of the values of array B into a **hash table** in O(N) time, then search that table for values in array A in O(1) time, leading to a total runtime of O(N), which is the BCR.
    - If your interviewer asks for optimizations beyond this, you can tell them it's not possible since the BCR is O(N).
    - If the interviewer asked you to reduce the space complexity of the algorithm, you would have to drop the hash table. To optimize the search of B, take advantage of the fact that it is sorted. For each value x in A, stop searching B when you find a value y that is greater than x. For each subsequent search of B, pick up where you left off.
    - Now, the algorithm operates in O(1) space and O(N) time, so it can't be optimized any further.

## Handling Incorrect Answers
- The most important thing to remember while interviewing is that your first solution to every problem doesn't need to be correct. The interviewer is gauging your ability to breakdown and solve a problem, then improve upon that initial solution.
    - You don't even need to completely solve every problem. The interview is assessing you more along the lines of how optimal your final solution was, how long it took you to get there, how much assistance you needed, and how clean your code was.
    - Another important thing to remember is that your performance is evaluated relative to other candidates' performance.
- Most interview questions are too difficult for any candidate to solve optimally on the first try very quickly. A typical question would take even a strong candidate 20 to 30 minutes to solve.

## When You've Heard a Question Before
- If you're in an interview and are asked a question you've heard before, admit this to your interviewer. The whole point of an interview is to have your problem-solving skills evaluated. If you already know the question, you're not giving the interviewer a fair chance to do that.
- Additionally, if the interviewer can see that you already know the problem by the way you approach, you'll seem dishonest if you're not upfront about it. Conversely, you'll get points for being upfront and honest if you do admit you've seen the problem before.

## What Language to Use
- At many top companies, interviewers don't really care about what language you use to solve problems, they care more about assessing your problem-solving abilities than your knowledge of a specific language.
- Other companies are pickier and will require you to solve interview questions in a specific language. If you're given a choice, it's best to choose the language you're most comfortable with.
- If you have a set of languages to choose from, it's best to choose the one that is most prevalent, readable, and easy to use. The language should also be concise and not prone to issues. For example, using C++ means that, in addition to all of the usual bugs you could have in your code, you would also need to worry about memory management and pointer issues.

## Writing Good Code
- Broadly speaking, good, clean code has the following properties:
    - The code operates correctly on all expected and unexpected inputs.
    - The code should have optimal time and space complexity for the worst and average-case scenarios. It should also have optimal "real-life" efficiency. For example, a constant that may be dropped in Big-O analysis could be significant in real life.
    - The code should be simple and readable. Don't use unnecessary lines of code and remember that, while comments make code more readable, good code comments itself.
    - The code should be easily maintainable and extensible for the initial developer and future developers.
    - Applying these properties to your code requires a balancing act. You often need to sacrifice efficiency for readability and maintainability.
- When solving a problem, you want to use data structures generously. Consider a problem where you're asked to find the sum of two mathematical expressions of the form `Ax^a + Bx^b + ...`
    - A bad implementation would be to store the store the expression as a single array, where the kth element corresponds to the coefficient of the x^k term in the expression. This is bad because it can't handle negative or non-integer coefficients and has an O(n) space complexity.
    - A better, but still inefficient, implementation would be to store the expression as a set of two arrays, where the coefficients are stored in one array that is "matched" withe elements in another array that holds the exponents. This is messy because you need to keep track of two arrays. Furthermore, expressions could have undefined values if the arrays were different lengths and returning the resulting expression means returning two arrays.
    - A good implementation would be to design your own data structure for the expression. For example, you could create an `ExprTerm` class with a field for the coefficient and exponent. Then, an expression would just be an array of `ExprTerm`s.
- When solving a problem, you want to make your code efficient by reusing code (such as helper methods) whenever possible. Expanding off this point, you want to make your code modular by separating logic into its own method whenever possible. This will make your code more testable, reusable, and maintainable.
    - Modular code is more testable and maintainable because each module of code can be tested and verified independently. Modular code is more readable because each module can be given a name that describes the action it performs. When these modules are placed inside the main method, they describe the steps that the main method takes to perform its overall function.
- When possible, you should also make your solution flexible and robust by solving for a general case instead of the specific problem case. This requires a balancing act though, as the general case may be too difficult or time-consuming to solve.
- Whenever your code requires user input, it's important to always verify the input using if() or assert statements. You don't have to fully code out the error-checks, just acknowledge that they need to be performed.
