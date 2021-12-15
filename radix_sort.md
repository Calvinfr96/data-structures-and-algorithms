# Radix Sort

## Introduction
- All the sorting algorithms we’ve learned so far (bubble, selection, insert, merge, and quick sort) can be grouped together as comparison sorts. This means at a base level; these algorithms are comparing one element to another.
- The lowest possible time complexity (considering an average case) of any comparison sort is O(n*log(n)).
- There are other sorting algorithms that are not based on comparison. These algorithms sort data by taking advantage of special properties of said data. For example, integer sorting algorithms only work with integers and don’t use direct comparisons. Radix sort is an example of an integer sort.
- Radix Sort is a sorting algorithm that works on lists of numbers. It never makes comparisons between elements. Instead, it exploits the fact that information about the size of a number is encoded in the number of digits.
- Radix Sort works by looking at each digit in a number and grouping based on the value of that number, starting with the ones place, and going up to the magnitude of the highest number.
    - During each sort, the list is rearranged by placing the buckets in order from 0 to 9, maintaining the order of the numbers within the bucket.
## Helper Methods
- To implement the Radix Sort algorithm, we need three helper methods: a helper method to find a particular digit in a number, a helper method to find how many digits a number contains, and a helper method that finds the number of digits in the largest number of an array of numbers.
- Find Digit Helper Method (My Approach): 
```
function findDigit(num, n) {
    const numDigits = Math.ceil(Math.log10(num));
    if (n > numDigits - 1) {
        return 0;
    }
    if (n === 0) {
        return num - Math.floor(num / 10)*10;
    }
    if (n === numDigits - 1) {
        return Math.floor(num / 10**(numDigits - 1));
    }
    let next = num - Math.floor(num / 10**(numDigits - 1))*(10**(numDigits - 1));
    return findDigit(next, n);
}
```
- Number of Digits Helper Method (My Approach):
```
function numDigits(num) {
    return Math.ceil(Math.log10(num));
}
```
- Max Number of Digits Helper Method(My Approach)
```
function maxDigits(array) {
    let max = 1;
    for(let num of array) {
        if(numDigits(num) > max) {
            max = numDigits(num);
        }
    }
    return max;
}
```
- Find Digit Helper Method (Solution): 
```
function findDigit(num, n) {
    return Math.floor(Math.abs(num) / Math.pow(10,n)) % 10;
}
```
- Number of Digits Helper Method (My Approach):
```
function numDigits(num) {
    return Math.floor(Math.log10(num)) + 1;
}
```
- Max Number of Digits Helper Method(Solution)
```
function maxDigits(array) {
    let max = 0;
    for(let num of array) {
        max = Math.max(max, numDigits(num));
    }
    return max;
}
```
## Radix Sort Pseudocode
- Define a function that accepts a list of numbers
- Find the number with the maximum number of digits in that list.
- Iterate through the list n times, where n is the maximum number of digits.
- During each iteration separate the numbers into bucks based on the value if the kth digit.
- At the end of each iteration combine all of the groupings back into a single array and call the function again on that array.
- Do this until you have done it the appropriate number of times (step 1).
## Radix Sort Implementation
- My Approach: 
    - For the implementation of the algorithm, it is helpful to use the flatten function from our practice on recursion to convert the 2D array of “buckets” to a 1D array of numbers to return as the final sorted array. One way of implementing the algorithm is by recursively calling the function on the array that is modified by each sort. With this approach, you have n – 1 recursive calls, where n is the number of digits.
    ```
    function radixSort(array) {
        function sort(array, loopCount) {
            const buckets = [[],[],[],[],[],[],[],[],[],[]];
            for(let num of array) {
                const position = findDigit(num,loopCount);
                buckets[position].push(num);
            }
            if(loopCount< maxDigits(array)) {
                return sort(flatten(buckets), loopCount + 1);
            }
            return flatten(buckets);
        }
        return sort(array,0);  
    }
    ```
- Solution:
    - Another way of implementing the algorithm is to use an outer for loop to iterate n times, where n is the maximum number of digits, then use an inner for loop to iterate through the array of numbers. Inside the inner loop, you create a new array based on the sorting algorithm, then assign this array to the array of numbers so it is updated before the next iteration of the inner loop.
    ```
    function radixSort(array) {
        const maxDigitCount = maxDigits(array);
        for(let i = 0; i < maxDigitCount; i++) {
            let buckets = Array.from({length: 10}, () => []);
            for(let num of array) {
                const position = findDigit(num, i);
                buckets[position].push(num);
            }
            array = [].concat(...buckets)
        }
        return array;
    }
    ```
    - Note: Using the spread operator in the concat method allows you to pass the individual subarrays within digitBuckets as arguments instead of the 2D array. If we just passed digitBuckets to concat, it would be a 2D array, not a 1D array.
    - Using Array.from({length: 10}, () => []) is a nicer way of creating the 2D array than doing it manually.
## Time and Space Complexity
- The time complexity in the best (almost sorted), average, and worst (completely unsorted) cases is O(n*k) where n is the number of elements in the array and k is the average number of digits.
    - Due to the way computers store numbers, if the array consists entirely of random, unique numbers, then k approaches log(n). This means that for this case, radix sort is just as good as any of the comparison sorts. 
    - For an array that has duplicated values, radix sort is technically only theoretically better than the comparison sorts.
- The space complexity in all cases is O(n +k).

