# Recursion

- Solutions to problems in programming generally fall into two categories: there is an iterative solution and a recursive solution.
- Recursion involves taking a problem and doing it over and over on a changing piece of data until you hit a base case.

## Objectives
- Define what recursion is and how it can be used.
- Understand the two essential components of a recursive function.
- Visualize the Call Stack to better debug and understand recursive functions.
- Compare helper-method recursion and pure recursion and use these methods to solve more difficult problems.

## Defining Recursion
- A process (function in the case of programming) that calls itself.
- Recall that when a function is passed as an argument and invoked by another function, the function being passed as an argument is the callback and the function which invokes the callback is a higher-order function.
- Recursion is important because it’s used in a lot of programming applications. For example, the JSON.stringify method is recursive. DOM traversal algorithms are also recursive.
- Recursion can sometimes offer a cleaner solution to a problem than an iterative approach.

## The Call Stack
- In almost all programming languages, there is some built in data structure that manages what happens when functions are invoked.
- The Call Stack is a stack data structure. Whenever a function is invoked, it is place on the top of (pushed onto) the Call Stack. When JavaScript sees the ‘return’ keyword, or when a function ends, the compiler will remove (pop) the function off the top of the stack.
- Typically, functions are pushed onto the Call Stack and popped off when they finish executing. With recursive functions, new functions (the same function) are continuously added to the stack.

## Writing Recursive Functions
- When writing recursive functions, you are invoking the same function repeatedly with a different input until you reach a base case.
- The base case is the condition when recursion ends, this is the most important aspect of recursion to understand.
- In general, writing recursive functions require two essential conditions: Recursive functions must have a base case. Also, the function being called recursively must be invoked with different inputs during each ‘cycle’,
- As an example, consider a function that prints numbers starting from some number and going down to zero.
```
function countDown(num) {
    if(num <= 0) {
        console.log("All done!");
        return; // The recusive loop is ended by returning when the base case is reached.
    }

    console.log(num);
    num--;
    countDown(num); // Recursion is accomplished by having a function invoke itself.
}
```
- Iterative solution (for comparison):
```
function countDown(num) {
    for(let i = num; i > 0; i--) {
        console.log(num)
    }

    console.log("All done!");
}
```
- As another example, consider a function that computes the sum of a range of numbers from one to some number.
```
function sumRange(num) {
    if(num === 1) {
        return 1;
    } else {
        return num + sumRange(num - 1)
    }
}
```
- This function can seem confusing because it looks like it will always return 1 when given a number, but this is not the case:
- The recursion occurs in the following steps, consider the call sumRange(3):
1. sumRange(3) returns num + sumRange(2)
2. sumRange(2) returns num + sumRange(1)
3. sumRange(1) returns 1
4. sumRange(2) resolves to 3 (num = 2 + sumRange(1) = 1)
5. sumRange(3) resolves to 6 (num = 3 + sumRange(2) = 3)
- The most important thing to note is that each function call is not immediately resolved, it must wait until the next recursive call in the chain in resolved. The chain doesn't end until the base case is reached, then each call behind it is resolved.
- So you're basically moving down the recursive chain until the base case is reached, then back up the chain as each recursive call is resolved.
- A common example used to teach recursion is a factorial function. Iteratively, this function can be written iteratively, using a for loop, as follows:
```
function factorial(num) {
    let total = 1;
    for(i = 2; i <= num; i++) {
        total *= i;
    }
    return total;
}
```
- It can also be written recursively in a manner similar to sumRange:
```
function factorial(num) {
    if(num === 1) {
        return 1;
    } else {
        return num*factorial(num - 1);
    }
}
```
- The base case needs to be one because 1! = 1.

## Recursion Pitfalls
- Recursion will exceed the limits of the Call Stack if there is no base case or the base case is inadequate.
- Recursion can also be problematic if you don’t return the right thing in your base case or you forget to return something in your base case. For example, if you returned num*factorial(num) instead of two for your base case. This would also have the effect of exceeding the limitations of the Call Stack
- Exceeding the call stack is commonly referred to as Stack Overflow.

## Helper Method Recursion
- The pure recursion method involves creating a function that calls itself.
- Helper method recursion involves creating two functions. The outer function calls the helper method, and the helper method calls itself recursively.
- As an example, consider a function that accepts an array of integers and returns an array that includes all odd numbers in the argument array. The outer function would be responsible for storing the array of odd numbers while the helper method would be responsible for looking for the odd numbers and adding them to the array. Without the recursive helper method, the collection array would be reset to an empty array during each recursive call.
```
function collectOddValues(array) {
    const results = [];

    function helper(input) {
        if(input.length === 0) {
            return;
        }
        if(input[0] % 2 !== 0) {
            results.push(input[0]);
        }
        helper(input.slice(1));
    }
    helper(array);

    return results;
}
```
- Helper method recursion is useful when trying to compile some sort of result like an array using a gradual process.
- The general pattern of helper-method recursion is to have a non-recursive outer function wrap around a recursive inner (helper) function.

## Pure Recursion
- The same example from Helper Method Recursion can be solved using pure recursion, where the recursive function is completely self-contained with no external data structure (the collection array in the outer function for helper-method recursion). The purely recursive solution to this problem uses a similar approach to the recursive function that computed the sum of numbers from 1 to n or the factorial function:
```
function collectOddValues(array) {
    const newArray = [];

    if(array.length === 0) {
        return newArray;
    }

    if(array[0] % 2 !== 0) {
        newArray.push(array[0])
    }

    newArray = newArray.concat(collectOddValues(array.slice(1)))
    return newArray
}
```
- Take an example input of [1,2,3,4,5], the recursive execution of the function proceeds as follows:
1. collectOddValues([1,2,3,4,5]) returns [1].concat(collectOddValues([2,3,4,5]))
2. collectOddValues([2,3,4,5]) returns [ ].concat(collectOddValues([3,4,5]))
3. collectOddValues([3,4,5]) returns [3].concat(collectOddValues([4,5]))
4. collectOddValues([4,5]) returns [ ].concat(collectOddValues([5]))
5. collectOddValues([5]) returns [5].concat(collectOddValues([]))
6. collectOddValues([]) returns []
7. [5].concat([])) resolves to [5]
8. [ ].concat([5]) resolves to [5]
9. [3].concat([5]) resolves to [3,5]
10. [ ].concat([3,5]) resolves to [3,5]
11. [1].concat([3,5]) resolves to [1,3,5]
- Pure Recursion Tips
    - For arrays, use methods like slice, the spread operator, and concat that make copies of arrays, so you don’t mutate them.
    - Remember strings are immutable, so you will need to use methods like slice or substring to create copies of strings.
    - To make copies of objects, use Object.assign or the spread operator. 
