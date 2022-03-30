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