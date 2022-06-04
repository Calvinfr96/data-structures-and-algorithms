import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MediumDifficultyQuestions {
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        Arrays.sort(array);//O(n*log(n)) where n is the number of elements in 'array'
        List<Integer[]> sums = new ArrayList<>();
        
        for(int index = 0; index < array.length - 2; index++) {//O(n)
          int secondIndex = index + 1;
          int thirdIndex = array.length - 1;
    
          while(secondIndex < thirdIndex) {//O(n)
            int sum = array[index] + array[secondIndex] + array[thirdIndex];
            if(sum < targetSum) {
              secondIndex++;
            } else if(sum > targetSum) {
              thirdIndex--;
            } else {
              sums.add(new Integer[] {array[index], array[secondIndex], array[thirdIndex]});
              secondIndex++;
              thirdIndex--;
            }
          }
        }
    
        return sums;
        //Time: O(n*log(n) + n^2) Space: O(n)
      }

      public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        
        int smallestDifference = Integer.MAX_VALUE;
        int[] result = new int[2];
        int pointerOne = 0;
        int pointerTwo = 0;
    
        while(pointerOne < arrayOne.length && pointerTwo < arrayTwo.length) {
          int numOne = arrayOne[pointerOne];//-1
          int numTwo = arrayTwo[pointerTwo];//15
    
          if(numOne < numTwo) {
            pointerOne++;
          } else if(numOne > numTwo) {
            pointerTwo++;
          } else {
            result[0] = numOne;
            result[1] = numTwo;
            break;
          }
    
          if(Math.abs(numOne - numTwo) < smallestDifference) {
            smallestDifference = Math.abs(numOne - numTwo);
            result[0] = numOne;
            result[1] = numTwo;
          }
        }
    
        return result;
        //Time: O(n*log(n) + m*log(m)) Space: O(1)
      }

      public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        // Write your code here.
        //Algorithm: Consider the multiple pointers technique when dealing with array manipulation.
        //Place two pointers, 'start' and 'end' at each end of the array.
        //While 'start' < 'end':
          //If 'start' is not the target element increment it.
          //If 'end' is the target element, decrement it.
          //If 'start' is the target element and 'end' is not, you can swap them.
            //After swapping, move 'start' and 'end' inwards.
        int left = 0;
        int right = array.size() - 1;
    
        while(left < right) {
          if(array.get(left) == toMove && array.get(right) != toMove) {
            swap(array, left, right);
            left++;
            right--;
          }
          if(array.get(left) != toMove) {
            left++;
          }
          if(array.get(right) == toMove) {
            right--;
          }
        }

        // ALTERNATIVE SOLUTION
        // while(left < right) {
        //     while(left < right && array.get(right) == toMove) {
        //         right--;
        //     }
        //     if(left == toMove) {
        //         swap(array, left, right);
        //     }
        //     left++;
        // }
        
        return array;
        //Time: O(n) Space: O(1)
      }
    
      private static void swap(List<Integer> array, int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
      }

      public static boolean isMonotonic(int[] array) {
        // Write your code here.
        if(array.length <= 2) {
          return true;
        }
    
        int direction = array[1] - array[0];
        for(int i = 2; i < array.length; i++) {
          if(direction == 0) {
            direction = array[i] - array[i - 1];
            continue;
          }
          if(breaksDirection(direction, array[i - 1], array[i])) {
            return false;
          }
        }
    
        return true;
      }
    
      private static boolean breaksDirection(int direction, int prevNum, int currentNum) {
        int difference = currentNum - prevNum;
    
        if(direction > 0) {
          return difference < 0;
        } else {
          return difference > 0; 
        }
      }

      public static List<Integer> spiralTraverse(int[][] array) {
        // Write your code here.
        int startRow = 0;
        int endRow = array.length - 1;
        int startColumn = 0;
        int endColumn = array[0].length - 1;
        List<Integer> traversal = new ArrayList<>();
    
        while(startRow <= endRow && startColumn <= endColumn) {
          for(int i = startColumn; i <= endColumn; i++) {
            traversal.add(array[startRow][i]);
          }
          
          for(int j = startRow + 1; j <= endRow; j++) {
            traversal.add(array[j][endColumn]);
          }
          
          for(int k = endColumn - 1; k >= startColumn; k-- ) {
            //Handles edge case where there's a single middle row in the matrix. This row is covered by the traversal in the
            //first for loop.
            if(startRow == endRow) {
              break;
            }
            traversal.add(array[endRow][k]);
          }
          
          for(int m = endRow - 1; m > startRow; m--) {
            //Handles edge case where there's a single middle column in the matrix. This row is covered by the traversal in the
            //second for loop.
            if(startColumn == endColumn) {
              break;
            }
            traversal.add(array[m][startColumn]);
          }
    
          startRow++;
          endRow--;
          startColumn++;
          endColumn--;
        }
    
        return traversal;
        //Time: O(N) where N is the total number of elements in the 2D array.
        //Space: O(N) space where N is the total number of elements in the 2D array.
      }

      public static int longestPeak(int[] array) {
        // Write your code here.
        //To solve this problem, you need to break it down into two steps:
        //First, you find the peaks within the array.
        //Second, you find the length of each peak, compare them, and return the largest one.
        if(array.length < 3) {
          return 0;
        }
        //Finds the index of each peak in the array
        List<Integer> peakIndices = findPeaks(array);
        //Establishes a minimum longest peak to be updated later.
        int longestPeakLength = 0;
    
        for(Integer peakIndex : peakIndices) {
          //For each peak, we find its length and update the longest peak if necessary.
          int peakLength = findPeakLength(array, peakIndex);
          if(peakLength > longestPeakLength) {
            longestPeakLength = peakLength;
          }
        }
        
        return longestPeakLength;
        //Time: O(n) Space: O(m) where m is the number of peak in the array.
      }
    
      private static List<Integer> findPeaks(int[] array) {
        //A number is a peak if it is larger than the numbers to the left and right of it.
        List<Integer> peakIndices = new ArrayList<>();
        //A peak cannot exist at the ends of the array, by definition.
        for(int i = 1; i < array.length - 1; i++) {
          if(array[i - 1] < array[i] && array[i + 1] < array[i]) {
            peakIndices.add(i);
          }
        }
    
        return peakIndices;
      }
      
      private static int findPeakLength(int[] array, int i) {
        int length = 1;
        int left = i - 1;
        int right = i + 1;
    
        while(true) {
          boolean peakLengthIncreased = false;
          if(left >= 0) {
            if(array[left] < array[left + 1]) {
              length++;
              peakLengthIncreased = true;
              left--;
            }
          }
    
          if(right < array.length) {
            if(array[right] < array[right - 1]) {
              length++;
              peakLengthIncreased = true;
              right++;
            }
          }
    
          if(left < 0 && right >= array.length) {
            break;
          }
          if(!peakLengthIncreased) {
            break;
          }
        }
    
        return length;
      }

      public int[] arrayOfProducts(int[] array) {
        // Write your code here.
        int[] leftProducts = getLeftProducts(array);
        return getProducts(array, leftProducts);
        //Time: O(n) Space: O(n)
      }
    
      private int[] getLeftProducts(int[] array) {
        int[] leftProducts = new int[array.length];
        int product = 1;
        leftProducts[0] = product;
        
        for(int i = 1; i < array.length; i++) {
          product*= array[i - 1];
          leftProducts[i] = product;
        }
    
        return leftProducts;
      }
    
      private int[] getProducts(int[] array, int[] leftProducts) {
        //[5,1,4,2]
        //[1,5,5,20]
        int[] products = new int[array.length];
        int product = 1;
    
        for(int i = array.length - 1; i>=0; i--) {
          products[i] = product*leftProducts[i];
          product *= array[i];
        }
    
        return products;
      }

      public int firstDuplicateValue(int[] array) {
        // Write your code here.
        Set<Integer> uniqueValues = new HashSet<>();
    
        for(int i = 0; i < array.length; i++) {
          int element = array[i];
          if(!uniqueValues.contains(element)) {
            uniqueValues.add(element);
          } else {
            return element;
          }
        }
    
        return -1;
        //Time: O(n) Space: O(n)
      }
      
      public int firstDuplicateValueAlt(int[] array) {
        // Write your code here.
        //This solution takes advantage of the fact that the values of the array
        //range from 1 to n (the length of the array), inclusive.
        //This means you can "sort" array by subtracting one from each value. This gives
        //you the position it would be in if you actually sorted the array.
    
        //abs(value) - 1 = index
        //At array[index], check if the value is negative. If it's not, multiply array[i]
        //by -1. If array[index] is negative, return abs(array[i])
    
        for(int value : array) {
          int absValue = Math.abs(value);
          if(array[absValue - 1] < 0) {
            return absValue;
          } else {
            array[absValue - 1] *= -1;
          }
        }
    
        return -1;
        //Time: O(n) Space: O(1).
        //While this solution has a more optimal space complexity, it is harder to grasp intuitively. Depending on
        //the average use case, this may not be worth the reduced space usage.
      }
}
