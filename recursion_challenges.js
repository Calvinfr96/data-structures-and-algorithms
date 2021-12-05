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

console.log(power(81, 0))