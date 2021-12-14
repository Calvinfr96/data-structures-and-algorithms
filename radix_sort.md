# Radix Sort

## Introduction
- All the sorting algorithms we’ve learned so far (bubble, selection, insert, merge, and quick sort) can be grouped together as comparison sorts. This means at a base level; these algorithms are comparing one element to another.
- The lowest possible time complexity (considering an average case) of any comparison sort is O(n*log(n)).
- There are other sorting algorithms that are not based on comparison. These algorithms sort data by taking advantage of special properties of said data. For example, integer sorting algorithms only work with integers and don’t use direct comparisons. Radix sort is an example of an integer sort.
- Radix Sort is a sorting algorithm that works on lists of numbers. It never makes comparisons between elements. Instead, it exploits the fact that information about the size of a number is encoded in the number of digits.
- Radix Sort works by looking at each digit in a number and grouping based on the value of that number, starting with the ones place, and going up to the magnitude of the highest number.
    - During each sort, the list is rearranged by placing the buckets in order from 0 to 9, maintaining the order of the numbers within the bucket.
