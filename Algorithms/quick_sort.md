# Quick Sort

## Introduction
- Like Merge Sort, Quick Sort exploits the fact that arrays consisting of 0 or 1 elements are automatically sorted. The implementation of the sorting algorithm also uses recursion.
- Quick Sort works by selecting one element in the array called the “pivot” element and finding the index where the pivot element should be in the sorted array. This is done by placing all numbers less than the pivot element on the left side of the element (not necessarily in a sorted manner), then placing all elements that greater than the pivot element on the right side of the element.
    - Even if the elements on the left and right side of the pivot aren’t sorted, you can ensure that the pivot element is in the proper sorted position.
    - This process can be repeated on the left and right side of the pivot, recursively, until you have arrays that are 0 or 1 element in length.
    - Say you have the array [5,2,6,3,4,8,1]. We can select the middle element as the pivot and rearrange the array like so: [2,1,3,5,6,4,8]. Even though the numbers on the left and right of 3 aren’t sorted, we can say with certainty that 3 is the proper sorted position. We can repeat this process with the arrays [2,1] and [5,6,4,8].
## Pivot Helper Function
- Like the merge helper function in the Merge Sort algorithm, the Quick Sort algorithm has a helper function that arranges elements in an array on either side of the pivot element, which will automatically place the pivot element in its proper sorted position.
- Given an array, this helper function should designate an element as a pivot element and then arrange the elements in the array so that values less than the value of pivot are placed on its left side and values greater than the value of the pivot are placed on its right side.
- The order of the elements on either side of the pivot do not matter. The helper should perform these operations in place and should not create a new array. In other words, the helper should destructively modify the array.
- When complete, the helper function should return the index of the pivot element.
- The runtime of the Quick Sort algorithm depends in part on how you select the pivot element. Ideally, the pivot element should be the median value in the data set.
    - For simplicity, you can always choose the first element in the array as the pivot, but this can have consequences.
## Pivot Pseudocode
- Write a function called pivot that accepts three arguments: an array, a start index, and an end index. These values can default to 0 and the length of the array minus 1.
- Grab the pivot from the start of the array.
- Store the current pivot index in a variable, this will keep track of where the pivot should end up.
- Loop through the array from start to end:
    - If the pivot is greater than the current element, increment the pivot index variable and then swap the current element with the element at the pivot index.
- Swap the starting element (the pivot) with the element at the pivot index.
- Return the pivot index.
## Pivot Implementation
- My Approach:
```
function pivot(array, start = 0, end = array.length - 1) {
    const selectedIndex = start;
    let pivotIndex = start;
    
    for(let i = 1; i <= end; i++) {
        if(array[selectedIndex] > array[i]) {
            pivotIndex++;
            [array[i], array[pivotIndex]] = [array[pivotIndex], array[i]];
        }
    }
    [array[selectedIndex], array[pivotIndex]] = [array[pivotIndex], array[selectedIndex]];
    return pivotIndex;
}
```
- Solution: 
```
function pivot(array, start = 0, end = array.length - 1) {
    const selectedIndex = start;
    let pivotIndex = start;
    
    for(let i = start + 1; i < array.length; i++) {
        if(array[selectedIndex] > array[i]) {
            pivotIndex++;
            [array[i], array[pivotIndex]] = [array[pivotIndex], array[i]];
        }
    }
    [array[selectedIndex], array[pivotIndex]] = [array[pivotIndex], array[selectedIndex]];
    return pivotIndex;
}
```
## Quick Sort Implementation
- Pseudocode:
    - Call the pivot helper function on the array.
    - When the helper function returns the updated pivot index, recursively call the pivot helper on the subarray to the left and right of that index.
    - Your base case is a subarray with less than two items in it.
```
function quickSort(array, left = 0, right = array.length - 1) {
    if (left < right) {
        let pivotIndex = pivot(array, left, right);
        quickSort(array, left, pivotIndex - 1);
        quickSort(array, pivotIndex + 1);
    }
    return array;
}
```
## Time and Space Complexity
- The time complexity of Quick Sort in the best (unsorted) and average (fairly sorted) cases is O(n*log(n)). The time complexity in the worst (completely sorted) case is O(n^2).
    - As with Merge Sort, Quick Sort requires log(n) decompositions, where n is the size of the array.
    - For each decomposition, you must make O(n) comparisons. This results in a total complexity of O(n*log(n)) in the best and average case.
    - Completely sorted data is the worst case scenario for this algorithm because we are choosing the first element as the pivot point. The decomposition of the array is based on the left and right side of the pivot point, so if the array is completely sorted, the left side will always be one element and the right side will be the rest of the array. This leads to O(n) decompositions.
    - For each decomposition, you must make O(n) comparisons. This results in a total complexity of O(n^2) in the worst case.
    - This same problem occurs when the pivot is chosen as the last element. The time complexity in the worst case can be improved by picking a random element or a middle element instead of the first or last.
- The space complexity of Quick Sort in all cases is O(log(n))
