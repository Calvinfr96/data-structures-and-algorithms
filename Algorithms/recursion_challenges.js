function power(base, exponent){
    //Problem: Write a function that, given a base and an exponent, returns the result of raising the base to the exponent.
    //Do not worry about negative exponents or bases.

    //Examples: power(2,2) // 4. power(2,0) // 1. power(2,4) // 16.

    //Breakdown:
    // Step 1: If the exponent is zero, return 1.
    // Step 2: Define a variable called product and initialize it as the base.
    // Step 3: Create a recursive function called multiply. Within multiply:
    // Step 3a: If the exponent is zero, return 1. If the exponent is 1, return the product. Otherwise, call multiply recursively and
    // pass it the base and (exponent - 1) as arguments.
    // Step 3b: Return the updated product.
    // Step 4: Call multiply by passing it the base and the product.
    // Step 5: return the product.s

    //Solve:
    if(exponent === 0) {
        return 1;
    }
    
    let product  = base;

    function multiply(base, exponent) {
        if(exponent === 0) {
            return 1;
        } else if(exponent === 1) {
            return product;
        } else {
            product *= multiply(base,exponent-1);
            return product;
        }
    }

    multiply(base, exponent);

    return product;
}

function powerRF(base, exponent){
    //Problem: Write a function that, given a base and an exponent, returns the result of raising the base to the exponent.
    //Do not worry about negative exponents or bases.

    //Examples: power(2,2) // 4. power(2,0) // 1. power(2,4) // 16.

    //Breakdown:
    // Step 1: If the exponent is zero, return 1.
    // Step 2: Define a variable called product and initialize it as the base.
    // Step 3a: If the exponent is zero, return 1. If the exponent is 1, return the product. Otherwise, call powerRF recursively and
    // pass it the base and (exponent - 1) as arguments. Multiply product by this recursive call.
    // Step 3b: Return the updated product.
    // Step 5: return the product.

    //Solve:

    if(exponent === 0) {
        return 1;
    } else if(exponent === 1) {
        return product;
    } else {
        base*powerRF(base, exponent-1);
    }

    return product;
    //Look Back / Refactor: There was no need to define a product variable, you can directly multiply base*powerRF(base, exponent - 1)
}

function factorial(num) {
    //Problem: Write a function that accepts a number and returns the factorial of that number. The factorial of zero is one.

    //Examples: factorial(2) // 2. factorial(4) // 24. factorial(0) // 1.

    //Breakdown:
    // Step 1: If num is 0 or 1, return 1.
    // Step 1a: If num > 1, recursively call factorial by passing it (num - 1). Multiply num by this call.
    // Step 2: Return num.

    //Solve:
    if(num < 0) {
        return 0;
    } else if(num <= 1) {
        return 1;
    } else {
        return num*factorial(num - 1);
    }

    //Look Back / Refactor: The base case should be expanded so that 0 is returned for negative numbers and 1 is returned for 0 or 1.
    //Also, you can put the return statement in the else block.
}

function productOfArray(array) {
    //Problem: Define a function that takes in an array and returns the product of all elements within the array.

    //Examples: productOfArray([1,2,3]) // 6. productOfArray([2,3,4]) // 24. productOfArray([]) // 0.

    //Breakdown:
    // Step 1: If the size of the array is zero, return zero. If the the size of the array is one, return the first element of the array.
    // Step 2: Otherwise, multiply the first element of the array by the recursive call of productOfArray with array.slice(1) 
    // passed as an argument.

    //Solve:
    if(array.length === 0) {
        return 0;
    } else if(array.length === 1) {
        return array[0];
    } else {
        return array[0]*productOfArray(array.slice(1));
    }

    //Look Back / Refactor: Difference of opinion. The solution returns one if an empty array is passed an argument instead of zero.

}

function recursiveRange(num) {
    //Problem: Write a function which accepts a number and returns the sum of numbers from 0 to the number.

    //Examples: recursiveRange(5) // 15. recursiveRange(7) // 28. recursiveRange(0) // 0.

    //Breakdown:
    // Step 1: If the number is one, return one. If the number is zero, return 0. Otherwise, return the sum of the number and the 
    // recursive call of recursiveRange with (num - 1) passed as an argument.

    //Solve:
    if (num === 0) {
        return 0;
    } else {
        return num + recursiveRange(num - 1);
    }

    //Look Back / Refactor: The base case doesn't need to include num === 1.
}

function fib(num) {
    //Problem: Write a function that accepts a number and returns the nth number in the Fibonacci sequence (1,1,2,3,5,8...).

    //Examples: fib(1) // 1. fib(4) // 3. fib(10) // 55. fib(28) // 317811.

    //Breakdown: 
    // Step 1: If the number equals 1 or 2, return 1. If the number equals zero, return zero. Otherwise, return fib(num - 1) + fib(num - 2)

    //Solve:
    if(num <= 2) {
        return 1;
    } else {
        return fib(num - 1) + fib(num - 2);
    }

    //Look Back / Refactor: The base case should be expanded so that one is returned when num <= 2, not just when num = 1 or 2.
}