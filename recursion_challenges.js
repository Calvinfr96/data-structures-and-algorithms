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
    let product  = base;

    if(exponent === 0) {
        return 1;
    } else if(exponent === 1) {
        return product;
    } else {
        product*= powerRF(base, exponent-1)
    }

    return product;
}

function factorial(num) {
    //Problem: Write a function that accepts a number and returns the factorial of that number. The factorial of zero is one.

    //Examples: factorial(2) // 2. factorial(4) // 24. factorial(0) // 1.

    //Breakdown:
    // Step 1: If num is 0 or 1, return 1.
    // Step 1a: If num > 1, recursively call factorial by passing it (num - 1). Multiply num by this call.
    // Step 2: Return num.

    //Solve:
    if(num === 0 || num === 1) {
        return 1;
    } else {
        num*=factorial(num - 1)
    }

    return num
}

console.log(factorial(4))