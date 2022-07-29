# Insertion Sort

- Of the three elementary sorting algorithms (Bubble, Selection, and Insertion Sort), selection performs well and has the most practical application.
- Insertion sort works by gradually creating a larger left half of the array that is always sorted. It kind of works like the sliding window approach, you start with a “window” of one element and add elements to the window by adding them to their correct sorted position.
    - For example, if you sort the array [5,3,4,1,2], you start with a window of 5. Then you expand the window by adding 3 before 5. Then you expand the window by adding 4 in between 3 and 5. Then you expand the window by adding 1 before 3. Finally, you expand the window by adding 2 between 1 and 3.
## Pseudocode
- Start by picking the second element in the array, creating a sorted “window” that contains the first element.
- Compare the second element with the one before and swap if necessary.
- Continue to the next element. If it is in the incorrect order, iterate through the sorted “window” to place the element in the correct spot.
- Repeat until the array is sorted.
## Implementation
-Solution:
```
function insertionSort(array) {
    for(let i = 1; i < array.length; i++) {
        let currentVal = array[i];
        for(var j = i - 1; j >= 0 && array[j] > currentVal; j--) {
            array[j + 1] = array[j];
        }
        array[j + 1] = currentVal;
    }
    return array;
}
```
- Explanation:
    - i is the variable being added to the sorted portion of the array.
    - j is the right end of the sorted portion of the array, one index below j.
    - j ranges from 0 to i - 1, ensuring the sorted portion always extends to the element before i.
    - i ranges from 1 to the length of the array, ensuring all elements are sorted.
    - For each iteration of the inner loop, array[j] is "copied forward" if it is greater than array[i].
    - Once the inner for loop is complete, array[i] is copied into the position after j when the loop finishes.
    - Take the array [2,3,4,1,5,6,7], for this iteration array[i] (currentVal) is at 1:
    1. 4 > 1, so 4 gets copied to where 1 was: [2,3,4,4,5,6,7].
    2. 3 > 1, so 3 gets copied to where 4 was: [2,3,3,4,5,6,7].
    3. 2 > 1, so 2 gets copied to where 3 was: [2,2,3,4,5,6,7]. This concludes the loop.
    4. After the loop finishes, currentVal is copied to where array[j] was when the loop finished. In this case, 2: [1,2,3,4,5,6,7].
- The time complexity of insertion sort is O(n^2) for a completely unsorted array. For an array that is almost entirely sorted, the time complexity is O(n).
- Insertion sort is good at adding items to a previously sorted array. For example, if you’re adding items to an array based on submissions made online. This sorting algorithm will be able to add those values in O(n) time.
