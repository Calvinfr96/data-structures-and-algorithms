# Problem Solving Patterns

**Note**: These problem-solving patterns may be helpful when applied to **some** of the problems you will come across, they do not apply to all of the problems you will face.

## Frequency Counters
- This pattern uses objects or sets to collect values or frequencies of values.
- This can often help to avoid the need for nested loops or O(n^2) operations with arrays or strings. The ‘frequency counter’ approach allows you to use two unnested for loops, which is better than using two nested for loops. Two unnested loops would be O(2n), which reduces to O(n). Two nested loops would be O(n^2).
- Below are two example functions, the first shows the naïve approach to the problem (not using the frequency counter pattern) and the other approach shows the more efficient solution (using the frequency counter pattern):
    - Write a function called same, which accepts two arrays. The function should return true if every value in the array has its corresponding value squared in the second array. The frequency of values must be the same.
```
function same(arr1, arr2) {
    if (arr1.length !== arr2.length) {
        return false;
    }

    for (let i = 0; i < arr1.length; i++) {
        let correctIndex = arr1.indexOf(arr1[i]**2)
        if (correctIndex === -1) {
            return false;
        }
        arr2.splice(correctIndex, 1)
    }
    return true
}
```
- This solution is O(n^2) because the indexOf method is implemented using a loop.
```
function same(arr1, arr2) {
    if (arr1.length !== arr2.length) {
        return false;
    }

    let frequencies1 = {};
    let frequencies2 = {};

    for(let num of arr1) {
        frequencies1[num] = (frequencies1[num] || 0) + 1;
    }
    for(let num of arr2) {
        frequencies2[num] = (frequencies2[num] || 0) + 1;
    }

    for(let key in frequencies1) {
        if(!(key**2 in frequencies2)) {
            return false;
        }
        if(frequencies2[key**2] !== frequencies1[key]) {
            return false;
        }
    }
    return true;
}
```
- This solution has a time complexity of O(n) because it avoids _nested_ loops.
- Another common application of the frequency counter pattern is the anagram problem. This problem requires you to write a function that tests whether or not two strings are anagrams (including two empty strings):
```
function validAnagram(str1, str2){
  if(str1.length !== str2.length) {
      return false;
  }
  
  const frequencies = {}
  
  for(let char of str1) {
      frequencies[char] = (frequencies[char] || 0) + 1;
  }
  
  for(let char of str2) {
      if(!frequencies[char]) {
          return false;
      } else {
          frequencies[char] -= 1;
      }
  }
  
  return true;
}
```
- This solution takes advantage of the fact that zero is a falsey value in JavaScript. During each iteration of the second loop, the frequency of the letter within ```frequencies``` is reduced by one. By the end of loop, each letter should have a frequency of zero. If there are more of one letter in string two than in string one by the end, ```!frequencies[char]``` will be a falsey value (0) and the function will return false.

## Multiple Pointers
- This pattern involves creating pointers or values that correspond to an index or position and move toward the beginning or end based on a certain condition. This pattern is very efficient for solving problems with minimal space complexity as well.
- You use this pattern for problems in which you are asked to find a pair of values within a linear structure such as an array or string. This pair of values must satisfy some condition.
- As an example, consider a problem in which you are asked to write a function called sumZero, which accepts a **sorted** array of integers. The function should find the first pair whose sum is zero. The function should return the pair as an array or undefined if said pair does not exist.
- The naïve solution uses nested looping and has a time complexity of O(n^2) and a space complexity of O(1).
```
function sumZero(array) {
    for(let i = 0; i < array.length; i++) {
        for(let j = i + 1; j < array.length; j++) {
            if(array[i] - array[j] === 0) {
                return [array[i], array[j]];
            }
        }
    }
}
```
- The refactored solution uses the multiple pointers pattern. Using this pattern, you put one pointer at the beginning of the array (the smallest value for a sorted array) and one at the end (the largest value for a sorted array). If the sum of the pointers is greater than zero, you move the right pointer to the left. If the sum of the pointers is less than zero, you move the left pointer to the right.
```
function sumZero(array){
    let left = 0;
    let right = array.length - 1;
    while(left < right) {
        let sum = array[left] + array[right];
        if(sum === 0) {
            return [array[left], array[right]]
        } else if(sum > 0) {
            right--;
        } else {
            left++
        }
    }
}
```
- This refactor has a time complexity of O(n) and space complexity of O(1).
- As another example, consider a problem in which you are asked to write a function called countUniqueValues, which accepts a **sorted** array and counts the unique values in the array. There can be negative numbers in the array, but it must always be sorted. Instead having a pointer at both ends of the array, you have two pointers at the beginning and move them forward based on certain conditions.
```
function countUniqueValues(array){
  if(array.length === 0) {
      return 0;
  }
    let pointer1 = 0;
    for(let pointer2 = 1; pointer2 < array.length; pointer2++) {
        if(array[pointer1] !== array[pointer2]) {
            pointer1++
            array[pointer1] = array[pointer2]
        }
    }
    return pointer1 + 1
}
```

## Sliding Window Pattern
- This pattern is useful for when you have a set of data such as an array or a string, and you’re looking for a subset of that data that is continuous in some way. For example, this pattern would be useful for finding the longest sequence of unique characters within a string.
    - Another useful problem this pattern is ideal for is one in which you must create a function that finds the maximum sum of n consecutive elements within an array.
- The pattern works by creating a window, which can be either an array or a single number. Depending on a certain condition, the window either increases or closes (and a new window is created).
- As an example, take the problem where you must find the largest subset of n consecutive elements in an array. Implementing the sliding window pattern here means that you create a window of n digits at the beginning of the array and shift it forward by one element until you reach the end of the array. As you move forward, you update the value of max sum.
    - Naïve Approach:
    ```
    function maxSubarraySum(array, num) {
        if(num > array.length) {
            return null;
        }
        let max = -Infinity;
        for(let i = 0; i < array.length - num + 1; i++) {
            let temp = 0;
            for(let j = 0; j < num j++) {
                temp += array[i + j];
            }
            if(temp > max) {
                max = temp;
            }
        }
        return max;
    }
    ```
    - This solution uses the sliding window approach, but does so ineffeciently because the window is recalculated during each iteration instead of being shifted or slid.
    - Sliding Window Approach
    ```
    function maxSubarraySum(array, num) {
        let maxSum = 0;
        let tempSum = 0;
        if (array.length < num) {
            return null;
        }

        for(let i = 0; i < num; i++) {
            maxSum += array[i];
        }
        tempSum = maxSum;
        for(let i = num; i < array.length; i++) {
            tempSum = tempSum - array[i - num] + array[i];
            maxSum = Math.max(maxSum, tempSum);
        }
        return maxSum;
    }
    ```
    - This solution uses the sliding window approach by creating an initial window, then sliding it forward (by subtracting the number moving out of the window from the left and adding the one moving into the window from the right) until the end of the array. As the window moves, the sum of the elements within it is calculated. This sum is compared against the maximum sum and the maximum is updated accordingly.

## Divide and Conquer
- This pattern involves breaking a large set of data into small chunks, then repeating a process with a subset of data.
- As an example, consider a problem where you need to write a function that, given a **sorted** array of integers, accepts a value and returns the index where the value is located. If the value is not found, the function should return -1.
    - Using the divide and conquer approach, you would roughly split the array in half, then you would take the number you split the array on and compare it to the number you’re looking for. If the desired number is greater, you look at the second half of the array. if it’s smaller, you look at the first half.
    - You repeat this process for each subarray that is created until you find the number you’re looking for.
- The divide on conquer pattern is typically used for complicated operations such as sorting large sets of data. The are also used in binary search algorithms. This pattern can be used on structures such as arrays, linked lists, and trees.
- Example of divide and conquer pattern used in a searching function:
```
function search(array, val) {
    let min = 0;
    let max = array.length - 1;
    
    while(min <= max) {
        let middle = Math.floor((min + max) / 2);
        let currentElement = array[middle];

        if(currentElement < val) {
            min = middle + 1; 
        } else if(currentElement > val) {
            max = middle - 1;
        } else {
            return middle;
        }
    }
    return -1;
}
```
- This algorithm has a time complexity of O(log(N)) and a space complexity of O(1). 