//Solving the fibonacci problem using simple recursion
function fibonacci(num) {
    if(num === 0) return 0;
    if(num <=2) {
        return 1;
    } else {
        return fibonacci(num - 1) + fibonacci(num - 2)
    }
}

//Solving the fibonacci problem using dynamic programming
