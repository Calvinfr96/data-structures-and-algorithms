# Introduction to Sorting Algorithms

- Sorting is the process of rearranging the items within a data structure such as an array or a string so that the items are in some kind of order. For example, sorting an array of numbers in ascending or descending order.
- Learning sorting algorithms is important because sorting is an incredibly common task in programming. Even if you’re using built-in sorting methods, it’s important to understand the algorithm that method is using under the hood so that you understand its efficiency and how to use that method efficiently.
- There are many different ways to sort data and different techniques have their own advantages and disadvantages. This is why sorting makes a great interview question.
## Objectives
- Implement bubble, selection, and insertion sort (less efficient searching algorithms).
- Understand why it’s important to learn elementary searching algorithms (they can be more performant than advanced searching algorithms in certain applications).
## Built-in JavaScript Sort
- The built-in JS sort array method works by converting every item in an array to a string and then calculating the Unicode value of that string. The items are then sorted based on that value. This is the method used in the default implementation of sort, with no arguments passed to the method.
- The sort method accepts an optional callback (comparator) function that the method will use to compare the values in the array,
    - The comparator function looks at a pair of elements (a and b). The function determines the sort order of the pair based on the return value. If the function returns a negative number, JS will decide that a comes before b. If the function returns a positive number, it will decide that b comes before a. If the function returns zero, a and b are considered the same as far as sorting is concerned.
- This is an example comparator function that, when passed to sort, will sort numbers in ascending order:
```
const array = [6,4,10,15];
function numberCompare(num1,num2) {
    return num1 - num2;
}

array.sort(numberCompare) // [4,6,10,15]
```
- Without the function the numbers would be sorted in the following order: [10,15,4,6] (based on Unicode values).
- In this case, a = num1 and b = num2. If b > a for a given pair, then a - b returns a negative number and a comes before b. This is why the function sorts the array in ascending order when passed to the sort method as a callback.
## Comparing Bubble, Insertion, and Selection sort
- Bubble Sort:
    - Time Complexity (Best): O(n)
    - Time Complexity (Average): O(n)
    - Time Complexity (Worst): O(n^2)
    - Space Complexity: O(1)
    - Works best with data that is almost sorted.
- Insertion Sort:
    - Time Complexity (Best): O(n^2)
    - Time Complexity (Average): O(n^2)
    - Time Complexity (Worst): O(n^2)
    - Space Complexity: O(1)
    - Works best with data that is almost sorted.
    - Also works very well if you need data to be continuously sorted. It only needs to pass through the array once to add the data while maintaining the sort.
- Selection Sort:
    - Time Complexity (Best): O(n^2)
    - Time Complexity (Average): O(n^2)
    - Time Complexity (Worst): O(n^2)
    - Space Complexity: O(1)
    - Does not perform well with almost-sorted data. It's strongest positive is that it is easy to understand.
- In the grand scheme of things, these algorithms are all roughly equivalent.
- All these algorithms have quadratic time complexities. There are more effecient algorithms, but they're more complex.
- These algorithms perform best and can actually out=perform the more advanced algorithms when they are applied to small data sets.