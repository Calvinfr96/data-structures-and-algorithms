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