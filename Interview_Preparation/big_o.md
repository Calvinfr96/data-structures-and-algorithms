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
    - For example, consider the following runtime complexities:
        - ```O(N + P)``` where P < N/2 - This reduces to O(N) because P is a non-dominant term.
        - ```O(N + log(N))``` - This reduces to O(N) because log(N) is a non-dominant term.
        - ```O(N + M)``` - Cannot be reduced without knowing the relationship between N and M.

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
- The runtime complexity of a recursive function with multiple branches is O(branches^depth), where branches is the number of times each recursive call branches.

## Special Cases
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
    - Printing a String takes O(N) time, where N is the number of characters in the String.
    - Another way of thinking about this is that the "length" of the inner and outer loops scales linearly with the input, resulting in an O(N^2) runtime complexity.
- Another way of looking at the above method is by looking at the average number of iterations in the inner loop. The inner loop has 9, 8, 7, 6, …, 2, 1 iterations, meaning the average number of iterations is N/2. Multiplying this by the number of iterations in the outer loop (N) results in (N^2)/2.
- Consider an example of an algorithm that takes an array of strings, sorts each string, then sorts the full array.
- You might reason that sorting each string is O(N*log(N)), doing this for N strings results in O(N^2 * log(N)). Sorting the array takes an additional O(N*log(N)), for a total of O(N^2 * log(N) + N*log(N)), which reduces to O(N^2 * log(N)).
    - This is wrong because you’re using the variable N improperly. Specifically, you’re using it to represent the length of the array _and_ the length of each string.
    - A better approach would be to assign the length of the longest string to a variable called s and assign the length of the array to a. Sorting each string is O(s * log(s)). Doing this for ‘a’ strings is O(a * s * log(s)).
    - Sorting all of the strings requires that you compare all of the string. Each string comparison takes O(s) time and there are O(a * log(a)) comparisons, for a total of O(a * s * log(a)).
    - This results in a total time complexity of O(a * s * (log(a) + log(s)), which can’t be reduced further. 
- Consider the following method, which sums the nodes of a _balanced_ binary search tree:
```
int sum(Node node) {
    if(node == null) {
        return 0;
    }

    return sum(node.left) + node.value + sum(node.right);
}
```
- Here, there are two branches at each recursive call, so the runtime complexity is O(2^depth). This is an exponential runtime, which would ordinarily be very bad.
    - However, when you consider the depth of a _balanced_ binary search tree is roughly log(N) where N is the number of nodes, the runtime becomes O(2^log(N)). Assuming a log of base 2, this reduces to O(N).
- Consider the following method, which determines if a number is prime by dividing by numbers ranging from 2, to the square root of he number.
```
boolean isPrime(int n) {
    for(int x = 2; x * x <= n; x++) {
        if(n % x == 0) {
            return false;
        }
    }
    return true;
}
- The above conditional can be simplified to x < sqrt(n), meaning the runtime complexity of the method is O(sqrt(N)).
- Looking back at the recursive fibonacci method:
public int f(int n) {
    if(n <= 1) {
        return 1;
    } else {
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
```
- There are two branches for each recursive call ```(n-1) and (n -2)```, with a depth of N. Therefore, the time complexity of the method is O(2^N).
- Generally speaking, whe you see an algorithm with multiple recursive calls, the runtime is exponential.
- Consider the following code, which print Fibonacci numbers from 0 through n:
```
void allFib(int n) {
    for(int i = 0; i <= n; i++) {
        System.out.println(i + ": " + fib(i));
    }
}

int fib(int n) {
    if(n <= 0) {
        return 0;
    } else if(n == 1) {
        return 1;
    }
    return fib(n - 1) + fib(n - 2);
}
```
- You might be tempted to say the time complexity is O(n*2^n) because fib(n) has a time complexity of 2^n and is run n times. However, n is varying (it is the i of the for loop). Therefore, the total amount of work is 2 + 2^2 + 2^3 + … + 2^n, which simplifies to O(2(n+) – 2).
- This example uses memoization to produce an iterative solution to the fibonacci problem:
```
void allFib(int n) {
    int[] memo = new int[n+1];
    for(int i = 0; i <= n; i++) {
        System.out.println(i + ": " + fib(i, memo));
    }
}

int fib(int n, int[] memo) {
    if(n <= 0) {
        return 0;
    } else if(n == 1) {
        return 1;
    } else if(memo[n] > 0) {
        return memo[n];
    }

    memo[n] = fib(n - 1, memo) + fib(n - 2, memo)
}
```
- Here, the result of each call to the function is stored in an int[]. This allows each recursive call to finish in O(1) time if the value at the index is greater than 0. Values don’t need to be recalculated, they’re simply retrieved from the memo array.
- This technique reduces the time complexity from O(2^N) to O(n).
- Consider the following function, which prints the powers of two from 1 to a numbe n (inclusive):
```
int powerOf2(int n) {
    if(n < 1){
        return 0;
    } else if(n == 1) {
        return 1;
    } else {
        int prev = powerOf2(n / 2);
        int curr = prev * 2;
        System.out.println(curr);
    }
} 
```
- This method will recurse in the following manner:
``` 
powerOf2(50) --> powerOf2 (25) --> powerOf2(12) --> powerOf2(6) --> powerOf2(3) --> powerOf2(1) -->
prints & returns 1 --> prints & returns 2 --> prints & returns 4 --> prints & returns 8 --> prints & returns 16 -->
prints & returns 32
```
- The function itself (the portion in the `else` block) is O(1). This block is executed log(n) times because it only prints the number up to n that are equal to a power of 2. Therefore, the runtime complexity of the method is O(log(n)).

## Additional Examples
1. The runtime complexity is O(N) because the number of operations scales linearly as b increases.
2. Each call to the method is O(1). The number of recursive method calls will increase linearly as b increase. Therefore, the runtime complexirt is O(N).
3. This method is O(1) since it only performs two arithmetic operations.
4. The while loop will iterate as long as a <= b. Therefore, it will loop `a/b` times. The code inside of the loop is O(1). Therefore, the total time complexity is O(a/b). When considering the runtime complexity of methods with more than one parameter, you want to analyze how it changes when _all_ parameters are increasing together, not when just one of the parameters are increasing.
5. 
```
int sqrt(int n) {
    return sqrt_helper(n, 1, n);
}

int sqrt_helper(int n, int min, int max) {
    if(max < min) {
        return -1;
    }
    int guess = (min + max) / 2; //25
    if(guess * guess == n) {
        return guess;
    } else if(guess * guess < n) {
        return sqrt_helper(n, guess + 1, max);
    } else {
        return sqrt_helper(n, min, guess - 1);
    }
}
```
- sqrt(50) --> sqrt_helper(50, 1, 50) --> sqrt_helper(50, 1, 24) --> sqrt_helper(50, 1, 11)...
- During the recursion, the only parameter changing value is `int max`. It is being cut in half each time the method is called, this results in a log(N) runtime complexity similar to a binary search.