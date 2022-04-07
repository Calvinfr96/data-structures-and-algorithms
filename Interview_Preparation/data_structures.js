// Question 1.1 - Is Unique

function isUnique(string) { //Optimal Space - Multiple Pointers
    for(let i = 0; i < string.length; i++) {
        let char = string[i];
        for(let j = i + 1; j < string.length; j++) {
            if(char == string[j]) {
                return false;
            }
        }
    }

    return true;
}

function isUnique2(string) { //Optimal Time - Frequency Counters
    const letters = {}
    for(let char of string) {
        letters[char] || (letters[char] = 0);
        letters[char]++;
        if(letters[char] > 1) {
            return false;
        }
    }
    return true;
}

//Question 1.2
function checkPermutation(string1, string2) {
    if(string1.length !== string2.length) {
        return false;
    }

    sorted1 = string1.split('').sort().join('');
    sorted2 = string2.split('').sort().join('');

    for(let i = 0; i < sorted1.length; i++) {
        if(sorted1[i] !== sorted2[i]) {
            return false;
        }
    }

    return true;
}

function checkPermutation2(string1, string2) {
    if(string1.length !== string2.length) {
        return false;
    }

    frequencies1 = {};
    frequencies2 = {};

    for(let char of string1) {
        frequencies1[char] || (frequencies1[char] = 0);
        frequencies1[char]++;
    }

    for(let char of string2) {
        frequencies2[char] || (frequencies2[char] = 0);
        frequencies2[char]++;
    }

    for(let key in frequencies1) {
        if(frequencies1[key] !== frequencies2[key]) {
            return false;
        }
    }

    return true;
}

//Question 1.3
function URLify(string) {
    charArray = [];

    for(let char of string) {
        if(char === ' ') {
            charArray.push('%');
            charArray.push('2');
            charArray.push('0');
        } else {
            charArray.push(char);
        }
    }

    return charArray
}

//Question 1.4
function paildromePermutation(string) {
    //Palindrome: A word that is spelled the same forwards and backwards
    //Basically, check if the word could be a palindrome if you rearranged the letters.
    // a. Same distribution of letters
    // b. Only one letter can have an odd frequency.
    //Permutation: A rearrangement of letters.
    // a. Same distribution of letters

    frequencies = {};
    oddFrequencies = 0;

    for(let char of string.toLowerCase()) {
        if(char !== ' ') {
            frequencies[char] || (frequencies[char] = 0);
            frequencies[char]++;
        }
    }

    for(let key in frequencies) {
        if(frequencies[key] % 2 !== 0) {
            oddFrequencies++;
            if(oddFrequencies > 1) {
                return false;
            }
        }
    }

    return true

}

//Question 1.5
function checkOneInsertionOrDeletion(string1, string2) {
    if(Math.abs(string1.length - string2.length) > 1) {
        return false;
    }

    const shorter = string1.length < string2.length ? string1 : string2;
    const longer = string1.length < string2.length ? string2 : string1;

    let pointer1 = 0;
    let pointer2 = 0;

    while(pointer1 < longer.length && pointer2 < shorter.length) {
        if(longer[pointer1] === shorter[pointer2]) {
            pointer2++;
        }
        pointer1++;
    }

    return pointer2 === shorter.length;

}

function checkOneCharReplaced(string1, string2) {
    if(string1.length !== string2.length) {
        return false;
    }
    let mismatches = 0;

    for(let i = 0; i < string1.length; i++) {
        if(string1[i] !== string2[i]) {
            mismatches++;
        }
    }

    return mismatches < 2
}

function editedOnce(string1, string2) {
    if(string1 === string2) {
        return true;
    }

    const checkOneInsertedOrDeleted = checkOneInsertionOrDeletion(string1, string2);
    const checkOneReplacement = checkOneCharReplaced(string1, string2);

    if(checkOneInsertedOrDeleted && checkOneReplacement) {
        return false;
    }

    return checkOneInsertedOrDeleted || checkOneReplacement;
}

//Question 1.6
function stringCompression(string) {
    let frequency = 1;
    let result = "";

    //aabcccccaaa

    for(let i = 1; i <= string.length; i++) {
        if(string[i] === string[i - 1]) {
            frequency++;
        } else {
            result += string[i - 1];
            result += frequency;
            frequency = 1;
        }
    }

    return result.length > string.length ? string : result;
}

//Question 1.7
function rotateMatrix(array) {
    //Rotating a matrix involves taking the transpose of the matrix, then reversing the columns of the transposed matrix
    //Taking the transpose of a matrix means making the first column the first row, the second column the second row, and so on
    transposeMatrix(array);
    reverseColumns(array);
    return array;
}

function transposeMatrix(array) {
    //Taking the transpose of a matrix means flipping it over its diagonal, so that the element at X[i][j]
    //is swapped with the element at X[j][i]
    for(let i = 0; i < array.length; i++) {
        for(let j = i + 1; j < array.length; j++) {
            swap(array, i, j, j, i);
        }
    }

    return array;
}

function reverseColumns(array) {
    //To reverse a column, you need to start swap the first and last positions, then keep swapping, moving
    //inward until you reach the middle
    for(let column = 0; column < array.length; column++) {
        let i = 0;
        let j = array.length - 1;
        while(i < j) {
            swap(array, i, column, j, column);
            i++;
            j--;
        }
    }

    return array;
}

function swap(array, a, b, x, y) {
    const temp = array[a][b];
    array[a][b] = array[x][y];
    array[x][y] = temp;
}

// Question 1.8
function zeroMatrix(array) {
    const columns = [];
    const rows = [];

    for(let i = 0; i < array.length; i++) {
        for(let j = 0; j < array.length; j++) {
            if(array[i][j] === 0) {
                rows.push(i);
                columns.push(j);
            }
        }
    }

    for(let column of columns) {
        allZeros(array, false, column)
    }

    for(let row of rows) {
        allZeros(array, true, row)
    }

    return array;
}

function allZeros(array, row, n) {
    if(row) {
        for(let i = 0; i < array.length; i++) {
            array[n][i] = 0;
        }
    } else {
        for(let i = 0; i < array.length; i++) {
            array[i][n] = 0;
        }
    }

    return array;
}

function stringRotation(string1, string2) {
    if(string1.length !== string2.length) {
        return false;
    }

    const superString = string2 + string2;
    return isSubstring(string1, superString);

}

function isSubstring(string1, string2) {
    if(string1 === string2) {
        return true;
    }

    const shorter = string1.length > string2.length ? string2 : string1;
    const longer = string1.length > string2.length ? string1 : string2;

    let j = 0;
    for(let i = 0; i < longer.length; i++) {
        if(j > 0 && longer[i] !== shorter[j]) {
            return false;
        }
        if(longer[i] === shorter[j]) {
            j++
        }
        if(j === shorter.length) {
            return true;
        }
    }

    return false;
}

function findRotation(string1, string2) {
    const charArray = [];

    let j = 0;
    for(let i = 0; i < string2.length; i++) {
        if(string2[i] === string1[j]) {
            charArray.push(string1[j]);
            j++;
        }
    }

    return charArray.join('');
}

console.log(stringRotation("waterbottle", "erbottlewat"));