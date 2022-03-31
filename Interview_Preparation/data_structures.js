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

function editedOnce(string1, string2) {
    if(Math.abs(string1.length - string2.length > 1)) {
        return false;
    }
}

console.log(editedOnce("poop", "pop"));