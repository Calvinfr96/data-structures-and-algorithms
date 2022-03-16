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
## Logarithmic Runtime
- Binary search is an example of an algorithm that has a runtime complexity of log(N) where log represents a logarithm with a base of two.
    - Recall that binary search involves looking at for a number in a **sorted** array by comparing the number to the middle element of the array. If the number is smaller than the middle, you repeat the process for the half of the array to the left of the middle. If the number of is larger than the middle element, you repeat the process for the half of the array to the right of the middle.
    - After each iteration, the number of elements being searched is cut in half. This results in a log(n) runtime complexity.
- While the base of a log(n) runtime is typically two, the base doesn’t really matter for the purpose of big O analysis. Generally speaking, the runtime will increase logarithmically with the input size, so the actual base doesn’t really matter.
## Recursive Runtime
- Consider the Fibonacci function. As n grows, the number of operations performed by the function doubles, leading to a runtime complexity of O(2^n). This is because calls are repeated during the recursion. For example, a call to f(4) has the following breakdown:
```
public int f(int n) {
    if(n <= 1) {
        return 1;
    } else {
        return fibonacci(n - 1) + fibonacci(n - 1);
    }
}
```
    - F(4) --> f(3) + f(3) --> f(2) + f(2) + f(2) + f(2) --> (f(1) + f(0))*4.
- Unlike logarithmic runtimes, the base of exponential runtimes is significant. For example, comparing 2^n and 8^n, 8^n can be written as 2^2n * 2^n, 2^2n is not a constant factor and cannot be ignored.

## Special Case
- Consider the runtime of the following function:
```
public void printUnorderedPairs(int[] array) {
    for (int i = 0; i < array.length(); i++) {
        for (int j = i + 1; j < array.length(); j++) {
            System.out.println(array[i], + ", ", " array[j]);
        }
    }
}
```
- The run time for this method is more complex than O(N^2) or O(log(N)).
- Consider how the number of operations scales with the length of the array:
    - length = 2 : operations = 1
    - length = 3 : operations = 3
    - length = 4 : operations = 6
    - length = 5 : operations = 10
    - Generally, the sum is (N - 1) + (N -2) + (N - 3) + ... + 2 + 1 = [N(N - 1)]/2. This reduces to O(N^2).
    - Another way of thinking about this is that the "length" of the inner and outer loops scales linearly with the input, resulting in an O(N^2) runtime complexity.