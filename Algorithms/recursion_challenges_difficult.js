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

function capitalizeFirst(stringArray) {
    //Problem: Write a function that accepts an array of strings and returns an array with each string capitalized

    //Examples: capitalizeFirst(['car','taco','banana']) // ['Car','Taco','Banana']

    //Breakdown:
    // Step 1: Create a variable called capitalizedStrings and set it equal to an empty array.
    // Step 2: If the array is empty, return capitalized strings
    // Step 3: Create a helper function called capitalize that capitalizes the first character of a string passed to it.
    // Step 4: If the array is not empty, pass the first element to capitalize and push it into capitalizedStrings
    // Step 5: Return capitalizedStrings.

    //Solve:
    let capitalizedStrings = [];

    function capitalize(string) {
        return string[0].toUpperCase() + string.slice(1);
    }

    if(stringArray.length === 0) {
        return capitalizedStrings;
    } else {
        capitalizedStrings.push(capitalize(stringArray[0]));
    }

    capitalizedStrings = capitalizedStrings.concat(capitalizeFirst(stringArray.slice(1)));
    return capitalizedStrings;

    //Look Back / Refactor: Solution is adequate. You can also shrink the array from the other end by capitalizing the last element, the
    //passing stringArray.slice(0,-1) to the function recursively.
}

function nestedEvenSum(obj) {
    //Problem: Write a function that accepts an object (potentially nested) and returns the sum of all even values.

    //Example: obj = {one: 1, two: 2, nested: {three: 3, four: 4}, 6: 'six'}. nestedEvenSum(obj) // 6.

    //Breakdown:
    // Step 1: Declare a variable called evenSum and set it equal to zero.
    // Step 2: Define a helper method called findEvens that traverses through a nested object and looks for even values,
    // then adds them to the sum.
    // Step 3: Call findEvens on obj
    // Step 4: Return the sum.

    //Solve:
    let evenSum = 0;

    function findEvens(obj) {
        for(let key in obj) {
            if(typeof obj[key] === 'number' & obj[key] %2 === 0) {
                evenSum += obj[key];
            }
            if(typeof obj[key] === 'object' && obj[key] !== null) {
                findEvens(obj[key]);
            }
        }
    }

    findEvens(obj);

    return evenSum;

    //Look Back / Refactor: Solution adequate. The code can be made slightly more effecient by checking if obj[key] is
    //a number before determining if it is even.
}

function capitalizeWords(strings) {
    //Problem: Write a function that accepts an array of strings and returns an array with those strings in all caps.

    //Example: capitalizeWords(['alpha','bravo','charlie']) // ['ALPHA','BRAVO','CHARLIE'].

    //Breakdown:
    // Step 1: Declare a variable called capitalized and set it equal to an empty array.
    // Step 2: If the length of the strings array is zero, return.
    // Step 3: If the length of the strings array is not zero, capitalize the first element if it is a string.
    // Step 4: concatenate strings with the return value of capitalizedWords with strings.slice(1) passed as an argument.
    // Step 5: Return the resultant array from step 4.

    //Solve:
    const capitalized = [];

    if(strings.length === 0) {
        return capitalized;
    } else {
        if(typeof strings[0] === 'string') {
            capitalized.push(strings[0].toUpperCase());
        }
    }

    return capitalized.concat(capitalizeWords(strings.slice(1)));

    //Look Back / Refactor: Solution is adequate.
}

function stringifyNumbers(obj) {
    //Problem: Write a function that accepts an object and modifies it non-destructively by converting number values to strings.

    //Example: obj = {one: 1, two: 2, nested: {three: 3, four: 4}, 6: 'six'}.
    //stringifyNumbers(obj) // obj = {one: '1', two: '2', nested: {three: '3', four: '4'}, 6: 'six'}.

    //Breakdown:
    // Step 1: Create a variable called stringified and set it equal to a copy of obj using the spread operator.
    // Step 2: Create a function called findNumbers that traverses through all layers of the object looking for numbers.
    // When the function finds a value that is a number, it converts it to a string. When the function finds a value that is an object,
    // it calls findNumbers on that object.
    // Step 3: Return the modified object.

    //Solve:
    const stringified = Object.assign({}, obj);

    function findNumbers(obj) {
        for(let key in obj) {
            if(typeof obj[key] === 'number') {
                obj[key] = obj[key].toString();
            }
            if(typeof obj[key] === 'object' && obj[key] !== null) {
                findNumbers(obj[key]);
            }
        }
    }

    findNumbers(stringified);

    return stringified;

    //Look Back / Refactor: Solution adequate. You also could have built up an empty object by using the same findNumbers function, but
    //expanding it so that it does sets the copies a key's value instead of stringifying it if it is not a number.
}

function collectStrings(obj) {
    //Problem: Write a function which accepts an object and returns an array of values in said object that are strings.

    //Example: collectStrings({one: 1, two: 2, nested: {three: '3', four: '4'}, 6: 'six'}) // ['3','4','6'].

    //Breakdown: 
    // Step 1: Create a variable called strings and set it equal to an empty array.
    // Step 2: Create a helper method called findStrings that traverses through all layers of an object. If it finds a value
    // that is a string, it pushes it onto string. If it finds a value that is an object, it passes it as an argument to findStrings.
    // Step 3: Return strings.

    //Solve:
    const strings = [];

    function findStrings(obj) {
        for(let key in obj) {
            if(typeof obj[key] === 'string') {
                strings.push(obj[key]);
            }
            if(typeof obj[key] === 'object' && obj !== null) {
                findStrings(obj[key]);
            }
        }
    }

    findStrings(obj);

    return strings;

    //Look Back / Refactor: Solution adequate. You also could have used pure recursion by concatenating the string arrays together
    //as you passed through each layer of the nested object.
}

function collectStringsPR(obj) {
    let strings = [];

    for(let key in obj) {
        if(typeof obj[key] === 'string') {
            strings.push(obj[key]);
        }
        if(typeof obj[key] === 'object') {
            strings = strings.concat(collectStrings(obj[key])); //non-destructive.
        }
    }

    return strings;

    //Note: You perform the concatenation inside the for...in loop because the recursive invocations are non-blocking.
    //This means that the for loop for the first layer finishes, then the second layer and so on. 
}