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