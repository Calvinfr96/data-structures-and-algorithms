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
}

function isPalindrome(string) {
    //Problem: Write a function that accepts a string an returns true if the string is a palindrome and false otherwise.

    //Examples: isPalindrome('awesome') // false. isPalindrome('amanaplanacanalpanama') // true.

    //Breakdown:
    // Step 1: Using helper-method recursion, employ the reverse function to check if string === reverse(string).
    // Step 2: Return the boolean value of this expression.

    //Solve:
    return string === reverse(string) ? true : false
}