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

    const str1 = `${num1}`
    const str2 = `${num2}`
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
  }

  console.log(sameFrequency(182, 218))
  console.log(sameFrequency(1,12))