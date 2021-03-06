# Searching Algorithms

## Objectives
- Describe what a searching algorithm is.
- Implement linear search on arrays.
- Implement binary search on sorted arrays.
- Implement a naïve searching algorithm.
- Implement the KMP string searching algorithm,
## Linear Search
- Given an array, the simplest way of searching for a value is to look at every element of the array in order and compare it against the desired value. This method is called linear search and is best used on unsorted data.
- Linear search example: A simple searching function is one that accepts an array and value and returns the index of that value if it is found in the array and false otherwise.
```
function linearSearch(array, value) {
    for(let i = 0; i < array.length; i++) {
        if(array[i] === val) {
            return i;
        }
    }
    return -1;
}
```
    - The Big O (time complexity) of this searching algorithm is O(n). The best-case scenario (where the item you’re looking for is the first element) is O(1). The worst-case scenario (here the item you’re looking for is the last element) is O(n). The average time complexity is also O(n) (remember constants don’t matter).
## Binary Search
- While linear search is best used for unsorted data. There is another sorting algorithm more well-suited for sorted data called binary search. When dealing with sorted data, binary search is more efficient because it allows you to eliminate half of all remaining elements at a time instead of just one element. **It must be used with sorted arrays though**.
- The idea behind this algorithm is to divide and conquer. You estimate a half-way point in the sorted array, then you determine if the value you’re searching for is greater than or less than the value of the array at the half-way point. If it is lower, you eliminate the second half (assuming the order is highest-to-lowest). If it is higher, you eliminate the first half. You keep doing this on each successive halve until you find your desired value.
- Binary search example: Write a function that accepts a **sorted** array and a value, then returns the index of the value if found. To implement this function, create a pointer at each end of the array.
    - Looping through the array while the left pointer < the right pointer:
    - Take the average index of left and right and use that as a middle pointer.
    - If the element at the middle pointer is equal to the value, return the index.
    - If the value is too small, move the left pointer to the middle.
    - If the value is too large, move the right pointer to the middle.
    - If the value is never found, return -1.
```
function binarySearch(array, value) {
    let left = 0;
    let right = array.length - 1;
    let middle  = Math.floor((left+right)/2);

    while(left <= right) {
        if(array[middle] === value) {
            return middle;
        } else if(array[middle] < value) {
            left = middle+1;
            middle  = Math.floor((left+right)/2);
        } else {
            right = middle-1;
            middle  = Math.floor((left+right)/2);
        }
    }
    return -1;
}
```
- The Big O (time complexity) of the binary search algorithm above is O(log(n)) in the worst and average case, and O(1) in the best case. The worst case is when the value in question isn’t found until left <= right or is not found at all, and the best case is when the value in question is found on the first try.
## Searching Strings
- To implement a searching algorithm for a string that looks for a substring within a larger string, implement the following algorithm:
    - Loop over each character in the characters in both strings with a for loop. If the characters from the  iteration of each loop don’t match, break out the loop, otherwise keep going.
    - If you complete the inner loop an find a match, increment the count of matches.
    - Finally return the count.
- My Approach:
```
function search(string1, string2) {
    //Problem: Write a function that takes in two strings and returns the number of times string1 appears in string2
    
    //Example: search('l','challenge') // 2.
    
    //Breakdown:
    // Step1: Create two pointers called pointer1 and pointer2 assigned to string1 and string2, respectively. Set both equal to zero.
    // Also create a variable called counter and set it equal to zero.
    // Step2: Loop through string2 using pointer2. If string1[ponter1] === string2[pointer2], increment pointer1.
    // Step3: If pointer1 = string1.length - 1, increment the count and set pointer1 back to zero.
    // Step4: Return the count.

    //Solve:
    let pointer1 = 0;
    let count = 0;

    for(let char of string2) {
        if(string1[pointer1] === char) {
            if(pointer1 === string1.length - 1) {
                count++;
                pointer1 = 0;
            } else {
                pointer1++
            }
        }
    }

    return count;
}
```
- Naive Approach:
```
function naiveSearch(string1, string2) {
    let count = 0;
    for(let i = 0; i < string1.length; i++) {
        for(let j = 0; j < string2.length; j++) {
            if(string1[i+j] !== string2[j]) {
                break;
            }
            if(j === string2.length - 1) {
                count++
            }
        }
    }
    return count;
}
```