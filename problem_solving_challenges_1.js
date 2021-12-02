function sameFrequency(num1, num2){
    //Problem: Write a function that determins if two numbers have the same frequency of digits.

    //Example: sameFrequency(182, 218) // true. sameFrequency(13, 34) // false.

    //Breakdown:
    // Step 1: Convert numbers to strings. return false if lengths do not match
    // Step 2: Create empty object called frequencies to store frequency of digits
    // Step 3: Use for... of loop to collect frequencies from num1
    // Step 5: Use for...of loop to iterate through num2. For each character in num2:
        //if the character is key in frequencies, decrement the value by one.
        //if the character is not a key in frequencies or the value of the key is zero, return false.
    // reutrn true

    //Solve:
    const str1 = `${num1}`
    const str2 = `${num2}`
    if (str1.length !== str2.length) {
        return false
    }
    const frequencies = {}


    for(let char of str1) {
        frequencies[char] = (frequencies[char] || 0) + 1;
    }

    for(let char of str2) {
        if(frequencies[char]) {
            frequencies[char] -= 1;
        } else {
            return false
        }
    }
    return true

    //Look Back/Refactor: The function could be made more effecient by returning false if the two strings do not have the same length.
    //This check should be made at the beginning, before anything else is done with the strings.
}

function areThereDuplicatesFC() {
    //Problem: Write a function that accepts a variable number of arguments(integers). The function should return true if there
    //are duplicates passed in and false otherwise.

    //Example: areThereDuplicates(1, 2, 3) // false. areThereDuplicates(1, 1, 2) // true.

    //Breakdown:
    // Step 1: The function does not need parameters since it takes a variable number of arguments. Use the arguments object
    // to collect the values passed in.
    // Step 2: Create an empty object called frequencies to collect the frequency of each element in the arguments array.
    // Step 3: Iterate through frequencies and check that that value of each key is one. If so, return true. Otherwise,
    // return false.

    //Solve:
    const frequencies = {};

    for(let i = 0; i < arguments.length; i++) {
        frequencies[arguments[i]] = (frequencies[arguments[i]] || 0) + 1;
    }

    for(let key in frequencies) {
        if(frequencies[key] !== 1) {
            return true
        }
    }
    return false

    //Look Back/Refactor: You can also use frequencies[key] > 1 in the second for loop. You can also use the ...args parameter instead
    //of iterating through the arguments object. The ...args parameter gives access to the arguments as an array instead of an object.
}

function areThereDuplicatesMP(...args) {
    //Problem: Write a function that accepts a variable number of arguments(integers). The function should return true if there
    //are duplicates passed in and false otherwise.

    //Example: areThereDuplicates(1, 2, 3) // false. areThereDuplicates(1, 1, 2) // true.

    //Breakdown:
    // Step 1: The function does not need parameters since it takes a variable number of arguments. Use the arguments object
    // to collect the values passed in. Using ...args as a parameter gives access to the arguments as an array.
    // Step 2: Create two pointers. Set the first eqaul to zero and the second equal to one.
    // Step 3: Sort the arguments array.
    // Step 4: Loop through the arguments array. If the first pointer equals the second, return true. Otherwise, increment each
    // pointer by one.

    //Solve:
    let pointer1 = 0;
    args.sort();

    for(let pointer2 = 1; pointer2 < args.length; pointer2++) {
        if(args[pointer1] === args[pointer2]) {
            return true
        } else {
            pointer1++
        }
    }
    return false

    //Look Back/Refactor: This approach only works if the array is sorted. If it were unsorted, you would likely need to use nested 
    //looping, resulting in a time complexity of O(n^2).
}