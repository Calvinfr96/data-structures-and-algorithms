# Bubble Sort

## Overview
- Bubble sort is a good way to introduce sorting algorithms, but it is not commonly used in practical applications. It is also useful a benchmark to see how other algorithms improve upon it.
- Bubble sort is a sorting algorithm where the largest values bubble up to the top, one at a time. Bubble sort works by stepping through an array, comparing two numbers at a time, and swapping them if appropriate.
    - Take an array of [29, 10, 14, 30, 37, 14, 18]. During the first pass through the array, 29 and 10 are compared and swapped, then 29 and 14 are compared and swapped, 29 and 30 are compared and left alone, 30 and 37 are compared and left alone, 37 and 14 are compared and swapped, then 37 and 18 are compared and swapped.
    - This represents the “first pass” through the array. You’ll notice that the largest value “bubbled” to the top, hence the name bubble sort. During the second pass, 30 gets bubbled up to the top. This continues until the array is completely sorted.
## Pseudocode
- Start looping with a variable called i starting at the end of the array and move towards the beginning.
- Start an inner loop with a variable called j starting at the beginning and moving up to i – 1.
- If array[j] > array[j + 1], swap the values.
- Return the sorted array when the loops are finished.
## Implementation
- My Approach:
```
function bubbleSort(array) {
    for(let i = array.length - 1; i >= 0; i--) {
        for(let j = 0; j < i - 1; j++) {
            if(array[j] > array[j + 1]) {
                let temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
            }
        }
    }
    return array;
}
```
- Naive Solution:
```
function bubbleSort(array) {
    for(let i = 0;  i < array.length; i++) {
        for(let j = 0; j < array.length j++) {
            if(array[j] > array[j + 1]) {
                let temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
            }
            //Alternate Swap: [array[j], array[j+1]] = [array[j+1], array[j]]
        }
    }
}
```
- This solution works by making a pass throuh the array for each element (the outer loop). In the inner loop, You're comparing each number with the number after it, swapping if necessary, starting from the beginning. The outer loop ensures that this is done for each element, so each element is "bubbled" to the top during each pass (the inner loop).
- This solution is inefficient for several reasons:
    1. During the last iteration of the inner loop, you're comparing array[length - 1] with array[length], which is undefined.
    2. After the first pass, you don't need to go to the last element because it is already sorted. For each pass, you decrease the number of elements you need to sort by one. The inner loop in this solution does not account for that.
    - The solution can be improved by decreasing the "length" of the inner loop by one each time, like so:
    ```
    function bubbleSort2(array) {
        sortedIndex = array.length
        for(let i=0; i<array.length; i++) {
            for(let j = 0; j < sortedIndex - 1; j++) {
                if(array[j] > array[j + 1]) {
                    let temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
            sortedIndex--
        }
        return array;
    }
    ```
    - This can be improved by replacing sortedIndex with the iterator for the outer for loop, having it start at the length of the array, and decrease to 1.
    ```
    function bubbleSort2(array) {
        for(let i = array.length; i > 0; i--) {
            for(let j = 0; j < i - 1; j++) {
                if(array[j] > array[j + 1]) {
                    [array[j], array[j+1]] = [array[j+1], array[j]]
                }
            }
        }
        return array;
    }
    ```
    - Further optimizations can also be made. For example, if the array is almost sorted already and only has one unsorted item, you would want to account for that by only sorting the array one time, instead of [length] times.
    - You can short-circuit the loop if no swaps were made on the last pass through the array. This can be done by creating a Boolean called ‘swapped’. Set it equal to false in the outer loop, then true in the loop only if a swap was actually made.
    ```
    function bubbleSort2(array) {
        let swapped;
        for(let i = array.length; i > 0; i--) {
            swapped = false;
            for(let j = 0; j < i - 1; j++) {
                if(array[j] > array[j + 1]) {
                    [array[j], array[j+1]] = [array[j+1], array[j]]
                    swapped = true;
                }
            }
            if(!swapped) {
                break;
            }
        }
        return array;
    }
    ```
- The Big O (time complexity) of Bubble sort is O(n^2) in the worst-case scenario. If they data is nearly sorted, the time complexity is O(n).
