# Merge Sort

## Introduction
- Merge sort is one of the intermediate sorting algorithms commonly used in programming.
- The intermediate sorting algorithms are harder and less intuitive` to understand, but they are faster when use on lager data sets.
- This family of sorting algorithms can improve time complexity from O(n^2) to O(n*log(n)). The increase in speed comes at the expense of simplicity and the time they take to understand.
- This algorithm was created in 1948 by John von Neumann. As the name suggests, it is a combination of merging and sorting. It exploits the fact that arrays consisting of 0 or one element are always sorted.
- It works by decomposing an array into smaller arrays of 0 or 1 elements, then building up a newly sorted array. This is known as a divide and conquer algorithm.
- For example, say you have the following array: [8,3,4,5,7,6,1,2]. Merger sort works by halving the array until it is decomposed into 8 single-element arrays. It then merges them back together two arrays at a time, comparing their values and placing them in the proper sorted position.
## Merging Arrays
- The first step in implementing the Merge Sort algorithm is writing a function to merge two **sorted** arrays. The arrays are already sorted and you’re simply retuning the sorted combination of those arrays.
- This function should have a time and space complexity of O(n + m), where n and m are the sizes of the arrays. It should modify the arrays in a non-destructive manner.
- Merging Pseudocode:
    - Create an array, look at the smallest values in each **sorted** input array.
    - Using the Multiple Pointers Approach, create two pointers, one for each array being compared.
    - While there are still elements in either array that haven’t been looked at:
    - If the value in the first array < the value in the second array, push the value in the first array into the results array and move to the next value in the first array.
    - If the value in the first array > the value in the second array, push the value in the second array into the results array and move to the next value in the second array.
    - Once we finish looking at all of the values in one array, push in all remaining values from the other array.
- Implementation:
```
function merge(array1, array2) {
    const sortedArray = [];
    let counter1 = 0;
    let counter2 = 0;

    while(counter1 < array1.length && counter2 < array2.length) {
        if(array2[counter2] > array1[counter1]) {
            sortedArray.push(array1[counter1]);
            counter1++;
        } else {
            sortedArray.push(array2[counter2]);
            counter2++;
        }
    }

    while(counter1 < array1.length) {
        sortedArray.push(array1[counter1]);
        counter1++;
    }
    while(counter2 < array2.length) {
        sortedArray.push(array2[counter2]);
        counter2++;
    }
    
    return sortedArray;
}

```
- You don't need two nested while loops as long both conditions are satisfied in the conditional for the one while loop (using &&).
- Only one of the last two while loops will run based on which array was not iterated through completely.
## Sorting Arrays
- Sorting Pseudocode:
    - The sorting pseudocode is recursive in nature. The first step is to break up the input array into two halves until you have arrays that are empty or only have one element. These arrays are automatically sorted since they contain one or no elements.
    - Next, you merge these arrays using the merge function until you have one array that is the same length as the input array.
    - Once the array has been merged back together, you return the merged and sorted array.
    ```
    function mergeSort(array) {
        if(array.length < 2) {
            return array;
        }
        const middle = Math.floor(array.length / 2);
        const left = mergeSort(array.slice(0,middle));
        const right = mergeSort(array.slice(middle));
        return merge(left,right);
    }

    ```
    - Take an example array of [10,24,76,73]:
    - mergeSort([10,24,73,76]: left1 = mergeSort([10,24])
    - mergeSort([10,24]): left2 = mergeSort([10]). This returns [10]. right2 = mergeSort([24]). This returns [24]. merge([10],[24]) returns [10,24].
    - This means left1 resolves to [10,24].
    - Now right1 = mergeSort([73,76])
    - mergeSort([76,73]): left3 = mergeSort([76]). This returns [76]. right3 = mergeSort([73]). This returns [73]. merge([76], [73]) returns [73,76].
    - This means right1 resolves to [73,76].
    - merge([10,24], [73,76]) returns [10,24,73,76].
    - An important thing to note about the recursion here is that left1 must fully resolve before right1 is calculated, then right1 must fully resolve before the function returns.
    - Both merge and mergeSort are being called recursively in this function.
## Time and Space Complexity
- The time complexity in the best (almost sorted), worst (completely reversed), and average (somewhat sorted) case is O(n*log(n)).
- The space complexity in all cases is O(n).
- The time complexity is the same in all cases because the algorithm will split the array and merge it back together regardless of its initial sort.
- The relationship between the size of the array and the number of splits performed by the mergeSort function is log(n) (base 2). For an 8-item array, 3 splits are performed. For 32-item array, 5 splits are performed.
- The relationship between the size of the array and the number of comparisons performed by the merge function is linear (O(n) comparisons).
- This means the total time complexity of the mergeSort function is O(n*log(n)).
