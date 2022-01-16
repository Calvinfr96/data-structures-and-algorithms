//Solving the fibonacci problem using simple recursion
function fibonacci(num) {
    if(num === 0) return 0;
    if(num <=2) {
        return 1;
    } else {
        return fibonacci(num - 1) + fibonacci(num - 2)
    }
}

//Solving the fibonacci problem using dynamic programming and memoization
function fibonacciDPMemo(num, memo = []) {
    if(memo[num]) return memo[num];
    if(num === 0) return 0;
    if(num <=2) {
        memo[num] = 1;
        return 1;
    }
    const result = fibonacciDP(num - 1, memo) + fibonacciDP(num - 2, memo);
    memo[num] = result;
    return result;
}

//Solveing the fibonacci problem using dynamic programming and tabulation (iterative solution)
function fibonacciDPTab(num) {
    if(num === 0) return 0;
    if(num <= 2) return 1;
    const fibNums = [0,1,1];
    for(let i = 3; i <= num; i++) {
        fibNums[i] = fibNums[i-1] + fibNums[i-2];
    }

    return fibNums[num];
}