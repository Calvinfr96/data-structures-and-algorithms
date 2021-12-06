function reverse(string) {
    //Problem: Write a function that accepts and string and returns that string reversed.

    //Examples: reverse('string') // 'gnirts'. reverse('reverse') // 'esrever'.

    //Breakdown:
    // Step 1: If the length of the string is less than or equal to one, return the string.
    // Step 2: Define a variable called last and set it equal to the length of the string minus one.
    // Step 3: If the length of the string is greater than one, return the last character of the string +
    // reverse(string.slice(0, last)).

    //Solve:
    if(string.length <= 1) {
        return string;
    } else {
        const last = string.length - 1;
        return string[last] + reverse(string.slice(0, last));
    }

    //Look Back / Refactor: A simpler return expression would have been reverse(str.slice(1)) + str[0]. In this expression,
    //You're concatening the string character by character starting with the last and ending with the first.
}

function isPalindrome(string) {
    //Problem: Write a function that accepts a string an returns true if the string is a palindrome and false otherwise.

    //Examples: isPalindrome('awesome') // false. isPalindrome('amanaplanacanalpanama') // true.

    //Breakdown:
    // Step 1: Using helper-method recursion, employ the reverse function to check if string === reverse(string).
    // Step 2: Return the boolean value of this expression.

    //Solve:
    return string === reverse(string) ? true : false

    //Look Back / Refactor: Instead of using helper method recursion, you could have compared the first and last letters of the
    //string, checking for equality. If the first and last letters match, you pass string.slice(1,-1) to isPalindrome (first and last letters
    //removed). Otherwise, return false. The base case would be if the string is length one, return true and if the string is length two,
    //return string[0] === string[1].
}

function someRecursive(array, callback) {
    //Problem: Write a function that accepts an array and a callback and returns true if a single value in the array returns true when passed
    //to the callback, and false otherwise.

    //Examples: const isOdd = val => val % 2 !== 0; someRecursive([1,2,3,4], isOdd) // true. someRecursive([2,4,6,8], isOdd) // false.

    //Breakdown:
    // Step 1: Define a variable called elementValid and initialize it to false.
    // Step 2: If the array is empty, return false.
    // Step 3: If the callback returns true when the first element of the array is passed to it, return true. Otherwise, call someRecursive
    // by passing it array.slice(1) and the callback.

    //Solve:

    if(array.length === 0) {
        return false;
    } else if(callback(array[0])) {
        return true;
    } else {
        return someRecursive(array.slice(1), callback)
    }

    //Look Back / Refactor: Solution adequate.
}

function flatten(array) {
    //Problem: Write a function that transforms a multidimensional array into a one dimensional array.

    //Examples: flatten([1,2,3,[4,5]]) // [1,2,3,4,5]. flatten(1,2,[3,[4,5,[6,7]]]) // [1,2,3,4,5,6,7].

    //Breakdown:
    // Step 1: Define a variable called flattenedArray and initialize it as an empty array.
    // Step 2: Iterate through the array using a for...of loop, for each element: 
    // Step 2a: If the element is an array, call flatten on that element.
    // Step 2b: If the element is not an array, push it onto flattenedArray.
    // Step 3: Retrun flattenedArray

    //Solve:
    let flattenedArray = [];

    function collect(array) {
        for(let element of array) {
            if(Array.isArray(element)) {
                collect(element);
            } else {
                flattenedArray.push(element);
            }
        }
    }

    collect(array);
    return flattenedArray;

    //Look Back / Refactor: Solution is adequate. Pure recursion also could have been used.
}

function flattenPR(array) {
    //Problem: Write a function that transforms a multidimensional array into a one dimensional array.

    //Examples: flatten([1,2,3,[4,5]]) // [1,2,3,4,5]. flatten(1,2,[3,[4,5,[6,7]]]) // [1,2,3,4,5,6,7].

    //Breakdown:
    // Step 1: Define a variable called flattenedArray and initialize it as an empty array.
    // Step 2: If the input array length is zero, return flattenedArray.
    // Step 3: If the first element of array is an array, call flatten on that element.
    // Step 4: If the first element of the array is not an array, push it onto flattenedArray.
    // Step 5: Update the value of flattenedArray by concatenating it with the flatten(array.slice(1)).

    //Solve:
    let flattenedArray = [];

    if(array.length === 0) {
        return flattenedArray;
    }
    
    if(!Array.isArray(array[0])) {
        flattenedArray.push(array[0]);
    }

    flattenedArray = flattenedArray.concat(flatten(array.slice(1)));
    return flattenedArray;

    //Look Back / Refactor: Solution works. You also could have gone through the array with a for...of loop and used logic similar to
    //the helper-method recursion solution. If the element is an array, call flatten on it, otherwise push it onto the collection array.
}