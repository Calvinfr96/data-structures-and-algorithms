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
- As an example, consider a problem in which you are asked to write a function called sumZero, which accepts a sorted array of integers. The function should find the first pair whose sum is zero. The function should return the pair as an array or undefined if said pair does not exist.
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
- As another example, consider a problem in which you are asked to write a function called countUniqueValues, which accepts a sorted array and counts the unique values in the array. There can be negative numbers in the array, but it must always be sorted. Instead having a pointer at both ends of the array, you have two pointers at the beginning and move them forward based on certain conditions.
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