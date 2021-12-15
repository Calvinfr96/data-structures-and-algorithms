# Problem Solving Approach

## Objectives
- Define what an algorithm is.
- Devise a plan to solve algorithms.
- Compare and contrast problem-solving patterns including frequency counters, two-pointer problems, and divide and conquer.
What is an algorithm?
- An algorithm is a process or set of steps to accomplish a certain task.
- Everything you do in programming involves some sort of algorithm.
- You can improve your problem-solving skills by taking the following steps:
    1.	Devise a plan for solving problems.
    2.	Master common problem-solving patterns.
- Problem Solving Approach
    1.	Understand the problem.
    2.	Explore concrete examples.
    3.	Break it down.
    4.	Solve and simplify.
    5.	Look back and refactor.

## What is an algorithm?
- An algorithm is a process or set of steps to accomplish a certain task.
- Everything you do in programming involves some sort of algorithm.
- You can improve your problem-solving skills by taking the following steps:
    1.	Devise a plan for solving problems.
    2.	Master common problem-solving patterns.
- Problem Solving approach
    1.	Understand the problem.
    2.	Explore concrete examples.
    3.	Break it down.
    4.	Solve and simplify.
    5.	Look back and refactor.

## Understanding The Problem
- It’s important to thoroughly understand the problem at hand before you start attempting to solve it.
- Make sure you can restate the problem in your own words.
- Understand what inputs go into the problem. What do they look like?
- Understand the outputs that should come from the solution to the problem. What do they look like?
- Can the outputs be determined from the inputs? In other words, do you have enough information to solve the problem? (Sometimes you need to start solving the problem to determine this, but it’s still good to consider this early on.)
- How should the important pieces of data be labeled? What are the things that matter?

## Explore Concrete Examples
- Coming up with examples can help you solve the problem better.
- Examples also provide sanity checks that your eventual solution works how it should.
- Examples of problems can include user stories and unit tests.
- When exploring examples, you should start with simple examples, then progress to more complex examples.
- Next, explore edge cases such as examples with empty or invalid inputs.

## Break It Down
- Break down the problem by writing out the steps it takes to solve the problem. This forces you to think about your code before writing it. It also helps you catch lingering conceptual issues or misunderstandings before you try solving the problem with code.
- A good way to break down the problem is by writing pseudocode. Writing pseudocode means writing out the steps you need to take to implement the solution using code, you don’t worry about specific syntax.
```
function charCount(str) {
    // create object to return at end
    // loop over string, for each character...
        // if the character is a number or letter or is a key in the object, increment its count by one.
        // if the character is a number or letter and is not a key in the object, add it to the object and set its value to one.
        // if the character is not alphanumeric, don't do anything.
    // return object at end.
}
```
- Writing pseudocode can especially be helpful in an interview setting because, even if you don’t know how to code out the solution, you’re demonstrating to the interviewer that you know how to break down and approach a problem from a more general perspective.
    - It’s more important that you demonstrate ability to solve problems than solving the problem. Some questions are designed to be so difficult they can’t be solved in a timely manner or at all.

## Solve or Simplify
- If you’ve broken down the problem into manageable steps that you feel comfortable implementing, then solve the problem. Otherwise, try to simplify the problem so that it is easier to solve.
    - You can simplify the problem by ignoring the part that is difficult and focusing on what you understand. Doing this enables you demonstrate to the interviewer that you can at least solve part of the problem. Also, something may click as you start to implement the solution.
- These are some other steps you can take to simplify the problem:
    1.	Find the core difficulty in what you’re trying to do.
    2.	Temporarily ignore that difficulty.
    3.	Write a simplified solution.
    4.	Incorporate the difficult part back in.

## Look Back and Refactor
- If you don’t take the time to look back on your code and reflect on it line by line, your code won’t be as good as it can be.
- When looking back and refactoring, you need to strive for an ideal balance of efficiency and legibility. You can ask these questions to achieve this:
    - Can you check the result?
    - Can you derive the result differently?
    - Can you understand it at a glance?
    - Can you use the result or method for some other problem?
    - Can you improve the performance of the solution?
    - Can you think of other ways to refactor?
    - How have other people solve the problem?

## Recap
- Understand the problem: Ask the interview questions to clarify your understanding of the problem they ask you to solve.
- Explore concrete examples: This will help you thoroughly understand all aspects of the problem, including inputs, outputs, edge cases, error handling, etc.
- Break it down: Write out pseudocode or a step by step process you will need to follow to solve the problem. Don’t just start writing code. This will help especially if you don’t finish, you can show the interviewer you had an idea of how to solve the rest of the problem.
- Solve/simplify: Once you’ve broken the problem down into an understandable step-by-step process solve it. If there are lingering misconceptions, simplify the problem by ignoring them and addressing them at some other point in the solving process.
- Look back/refactor: This will help you become a developer because you’re going back and figuring out what you could’ve done better.
