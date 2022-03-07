function coinChange(denominations, amount) {
    //Problem: Given an amount of money in pennies and an array of denominations, find the number of ways
    //you can make change for the given amount.

    //Examples: denominations = [1,5,10,25] coinChange(denominations, 10) = 4, coinChange(denominations, 25) = 13

    //Steps: Using denominations = [1,5,10,25] and amount = 25
    //1. Create an array the size of amount + 1, called combinations.
    //a. The values stored at each index in the array will be the number of combinations possible for that amount of money.
    //For example, the value at index  will be the number of combinations for 5 cents.
    //2. Fill each element in the array according to the following logic: If the amount >= coin, then 
    //combinations[amount] += combinations[amount - coin]. 
    //a. Set the value at index 0 to 1. When iterating through the array with denominations[0] = 1, 1 >= 1, so you say
    //combinations[1] += combinations[1 - 1] -> 0 += 1.

    //Breakdown:
    //Using Dynamic programming, you're building up to the solution by starting from one cent and going up to the amount
    //passed to the function.
    //combinations[amount] rerpresents the number of combinations for the amount of money that the index represents.
    //


    const combinations = Array.from({length: amount + 1}, () => 0);
    combinations[0] = 1;

    for(let denomination of denominations) {
        for(let i = 1; i < combinations.length; i++) {
            if(i >= denomination) {
                combinations[i] += combinations[i - denomination];
            }
        }
    }

    return combinations[amount];
}

function constructNote(message, characters) {
    if(message.length === 0) {
        return true
    }
    const splitMessage = message.toLowerCase().split('').filter(char => char !== ' ');
    const charSet = characters.toLowerCase().split('').filter(char => char !== ' ')
    return contains(splitMessage, charSet);
}

function contains(arr1, arr2) {
    if(arr1.length > arr2.length) {
        return false;
    }
    let matches = 0;

    for(let idx1 of arr1) {
        for(let idx2 of arr2) {
            if(idx1 === idx2) {
                matches++;
                if(matches === arr1.length) {
                    return true
                }
            }
        }
    }

    return false
}

function findAllDuplicates(numArray) {
    if(!numArray.length) {
        return undefined;
    }

    const frequencies = {};
    const duplicates = [];

    for(let num of numArray) {
        frequencies[num] = (frequencies[num] || 0) + 1;
    }

    for(let key in frequencies) {
        if(frequencies[key] > 1){
            duplicates.push(key);
        }
    }

    return duplicates;
}

function findPair(array, target) {
    for(let i = 0; i < array.length; i++) {
        for(let j = i + 1; j < array.length; j++) {
            if(Math.abs(array[i] - array[j]) === Math.abs(target)) {
                return true;
            }
        }
    }

    return false
}

console.log(findPair([-4,4], 8))