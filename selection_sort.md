# Selection Sort

- Selection sort is similar to bubble sort in that it sorts elements in an array based on value. However, instead of placing the largest values into the sorted position first, it places the smallest value into the smallest position first.
    - Take an array [5,3,4,1,2]. First, 5 and 3 are compared and 3 is found to be the smallest value. Then 3 and 4 are compared, then 3 and 1, then 1 and 2. Since one was found to be the minimum, 5 and 1 are swapped.
## Pseudocode
- Store the first element in the array as the minimum value.
- Compare the minimum to the next item in the array until you find a smaller number.
- If a smaller number is found, designate it as the new minimum and save its index. Continue comparing until the end of the array.
- If the minimum is not the value you began with, swap the two values.
- Repeat with the next element until the array is sorted.
## Implementation
- My Approach:
```
function selectionSort(array) {
    for(let i = 0; i < array.length; i++) {
        let minIndex = i;
        let swapElements = false;
        for(let j = i; j < array.length; j++) {
            if(array[minIndex] > array[j]) {
                minIndex = j;
                swapElements = true;
            }
        }
        if(swapElements) {
            [array[i], array[minIndex]] = [array[minIndex], array[i]];
        }
    }
    return array;
}
```
- Solution:
```
function selectionSort(array) {
    for(let i = 0; i < array.length; i++) {
        let minIndex = i;
        for(let j = i + 1; j < array.length; j++) {
            if(array[minIndex] > array[j]) {
                minIndex = j;
            }
        }
        if(i !== minIndex) {
            [array[i], array[minIndex]] = [array[minIndex], array[i]];
        }
    }
    return array;
}
```
- j should be set to i + 1 because you don't want to compare array[0] with itself on the first iteration of the inner loop.
- You don't need a swapped variable because you can just compare i to minIndex, which may or may not have been updated in the inner loop.
- The Big O (time complexity) of selection sort is O(n^2). Selection sort is only better than Bubble sort if you want to minimize the number of swaps you want to make. In Bubble sort, you make multiple swaps during each pass while in Selection sort, you're only making one swap during each pass.