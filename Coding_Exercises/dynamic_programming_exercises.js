function coinChange(denominations, amount) {
    //Problem: Given an amount of money in pennies and an array of denominations, find the number of ways
    //you can make change for the given amount.

    //Examples: denominations = [1,5,10,25] coinChange(denominations, 10) = 4, coinChange(denominations, 25) = 13

    //Steps: Using denominations = [1,5,10,25] and amount = 25
    //1. Find the largest denomination that can be used to make change (25).
    //2. Calculate amount % denominations[i] for each denomination up to the largest.
    //Each one with a remainder of zero represents one way.
    //3. 
}