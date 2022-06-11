import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
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

      public int[][] mergeOverlappingIntervals(int[][] intervals) {
        // Write your code here.
        //The intervals in the input array aren't necessarily sorted. This means that,
        //for each interval, you need to look at the other intervals to determine if
        //they overlap with the current interval.
        //Intervals overlap if the the end of one interval is greater than or equal to
        //the start of the other.
        //**This is only true when the intervals are sorted in ascending order with respect
        //to the start value** Ex: [3, 4], [1, 2], this would be an overlap even though it's
        //not. [1, 2], [3, 4] do not overlap.
    
        //You first need to sort the input array with respect to the start of each interval.
        //Starting with the second interval in the array, look to the left and see if the left
        //overlaps with the current interval. If they do, merge them.
        //To merge to intervals, you take the start of the first interval, then
        //max of the end of both intervals.
        //As you iterate through the array, you compare the current interval to the current
        //merged interval and update the current merged interval as needed.
    
        int[][] sortedIntervals = intervals.clone();
        Arrays.sort(sortedIntervals, (a, b) -> Integer.compare(a[0], b[0]));
    
        List<int[]> mergedIntervals = new ArrayList<int[]>();
        int[] currentInterval = sortedIntervals[0];
        mergedIntervals.add(currentInterval);
    
        for(int[] nextInterval : sortedIntervals) {
          int currentIntervalEnd = currentInterval[1];
          int nextIntervalStart = nextInterval[0];
          int nextIntervalEnd = nextInterval[1];
    
          if(currentIntervalEnd >= nextIntervalStart) {
            //Primitive arrays are pass by reference, so this line will modify the interval that most
            //recently added to the ArrayList.
            currentInterval[1] = Math.max(currentIntervalEnd, nextIntervalEnd);
          } else {
            currentInterval = nextInterval;
            mergedIntervals.add(currentInterval);
          }
        }
        
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
        //Time: O(n*log(n)) Space: O(n)
      }

      static class BST {
        public int value;
        public BST left;
        public BST right;
    
        public BST(int value) {
          this.value = value;
        }
    
        public BST insert(int value) {
          // Write your code here.
          // Do not edit the return statement of this method.
          BST current = this;
          BST newNode = new BST(value);
          while(!Objects.isNull(current)) {
            if(value < current.value) {
              if(Objects.isNull(current.left)) {
                current.left = newNode;
                break;
              } else {
                current = current.left;
              }
            } else {
              if(Objects.isNull(current.right)) {
                current.right = newNode;
                break;
              } else {
                current = current.right;
              }
            }
          }
          
          return this;
          //Average Time: O(log(n))
          //Worst Time: O(n) - skewed BST
          //Space: O(1) for the iterative approach
          //Space: O(log(n)) to O(n) for the recursive approach
        }
    
        public boolean contains(int value) {
          // Write your code here.
          BST current = this;
          while(!Objects.isNull(current)) {
            if(value == current.value) {
              return true;
            } else if(value < current.value) {
              current = current.left;
            } else {
              current = current.right;
            }
          }
          return false;
          //Average Time: O(log(n))
          //Worst Time: O(n) - skewed BST
          //Space: O(1) for the iterative approach
          //Space: O(log(n)) to O(n) for the recursive approach
        }
    
        public BST remove(int value) {
          // Write your code here.
          // Do not edit the return statement of this method.
          //To remove a node in a BST, you must replace it with its in-order successor,
          //which is the left-most value in its right subtree.
          //The removal process occurs in two steps: first you find the node, then you
          //remove the node.
          remove(value, null);
          return this;
          //Average Time: O(log(n))
          //Worst Time: O(n) - skewed BST
          //Space: O(1) for the iterative approach
          //Space: O(log(n)) to O(n) for the recursive approach
        }
    
        public void remove(int value, BST parent) {
          BST current = this;
          while(!Objects.isNull(current)) {
            if(value < current.value) {
              parent = current;
              current = current.left;
            } else if(value > current.value) {
              parent = current;
              current = current.right;
            } else {
              //If the node you're removing has a left and right subtree, you want to find
              //the left-most node of the right subtree and replace it with the value
              //you want to remove
              if(!Objects.isNull(current.left) && !Objects.isNull(current.right)) {
                //Overide the current node's value with the value of that node.
                current.value = current.right.getMinValue();
                //Now, to remove the node, you call the remove method on the right subtree of
                //current (the subtree where the replacement node was found) and you specify 
                //the parent of that subtree as the current node.
                current.right.remove(current.value, current);
              } else if(Objects.isNull(parent)) {
                if(!Objects.isNull(current.left)) {
                  current.value = current.left.value;
                  current.right = current.left.right;
                  current.left = current.left.left;
                } else if(!Objects.isNull(current.right)) {
                  current.value = current.right.value;
                  current.left = current.right.left;
                  current.right = current.right.right;
                } else {
                  //do nothing
                }
              } else if(parent.left == current) {
                if(!Objects.isNull(current.left)) {
                  parent.left = current.left;
                } else {
                  parent.left = current.right;
                }
              } else if(parent.right == current) {
                if(!Objects.isNull(current.left)) {
                  parent.right = current.left;
                } else {
                  parent.right = current.right;
                }
              }
              break;
            }
          }
        }
    
        private int getMinValue() {
          BST current = this;
          while(!Objects.isNull(current.left)) {
            current = current.left;
          }
          return current.value;
        }
      }

      public static boolean validateBst(BST tree) {
        // Write your code here.
        //You must validate the BST holistically. You can't simply validate node-by-node
        //by checking that node's left and right children.
        //Each given node has maximum and minimum possible value based on its position within
        //the tree.
        //Each node must be less than its closest right parent and greater than or equal
        //to its closest left parent.
        return validateBst(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
        //Time: O(n) where n is the number of nodes in the BST
        //Space: O(d) where d is the depth of the tree.
      }
    
      private static boolean validateBst(BST tree, int maxValue, int minValue) {
        if(tree.value < minValue || tree.value >= maxValue) {
          return false;
        }
        if(!Objects.isNull(tree.left) && !validateBst(tree.left, minValue, tree.value)) {
          return false;
        }
        if(!Objects.isNull(tree.right) && !validateBst(tree.right, tree.value, maxValue)) {
          return false;
        }
    
        return true;
      }

      public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        if(!Objects.isNull(tree.left)) {
          inOrderTraverse(tree.left, array);
        }
        array.add(tree.value);
        if(!Objects.isNull(tree.right)) {
          inOrderTraverse(tree.right, array);
        }
        return array;
        //Time: O(n) Space: O(n) 
      }
    
      public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        array.add(tree.value);
        if(!Objects.isNull(tree.left)) {
          preOrderTraverse(tree.left, array);
        }
        if(!Objects.isNull(tree.right)) {
          preOrderTraverse(tree.right, array);
        }
        return array;
        //Time: O(n) Space O(n)
      }
    
      public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        if(!Objects.isNull(tree.left)) {
          postOrderTraverse(tree.left, array);
        }
        if(!Objects.isNull(tree.right)) {
          postOrderTraverse(tree.right, array);
        }
        array.add(tree.value);
        return array;
        //Time: O(n) Space: O(n)
      }

      public static BST minHeightBstNaive(List<Integer> array) {
        // Write your code here.
        return minHeightBstNaive(null, array, 0, array.size() - 1);
        //Using the insert method - Time: O(n*log(n)) Space: O(n)
      }
    
      private static BST minHeightBstNaive(BST root, List<Integer> array, int start, int end) {
        if(end < start) {
          return root;
        }
        
        int middle = end + (start - end) / 2;
        int valueToAdd = array.get(middle);
        if(Objects.isNull(root)) {
          root = new BST(valueToAdd);
        } else {
          root.insert(valueToAdd);
        }
    
        minHeightBstNaive(root, array, start, middle - 1);
        minHeightBstNaive(root, array, middle + 1, end);
        
        return root;
      }

      public static BST minHeightBst(List<Integer> array) {
        // Write your code here.
        return minHeightBst(array, 0, array.size() - 1);
        //Directly inserting the nodes - Time: O(n) Space: O(n)
      }
    
      private static BST minHeightBst(List<Integer> array, int start, int end) {
        if(end < start) {
          return null;
        }
    
        int middle = (start + end) / 2;
        BST node = new BST(array.get(middle));
        
        node.left = minHeightBst(array, start, middle - 1);
        node.right = minHeightBst(array, middle + 1, end);
        
        return node;
      }

      static class TreeInfo {
        public int numVisitedNodes;
        public int lastVisitedNode;
    
        public TreeInfo(int numVisitedNodes, int lastVisitedNode) {
          this.numVisitedNodes = numVisitedNodes;
          this.lastVisitedNode = lastVisitedNode;
        }
      }
    
      public int findKthLargestValueInBst(BST tree, int k) {
        // Write your code here.
        TreeInfo treeInfo = new TreeInfo(0, -1);
        reverseOrderTraversal(tree, k, treeInfo);
        return treeInfo.lastVisitedNode;
        //Time: O(h + k) where h is the height of the tree and k is the input.
        //Space: O(h) because we need to place h frames on the call stack.
      }
    
      public void reverseOrderTraversal(BST node, int k, TreeInfo treeInfo) {
        if(Objects.isNull(node) || treeInfo.numVisitedNodes >= k) {
          return;
        }
    
        reverseOrderTraversal(node.right, k, treeInfo);
        if(treeInfo.numVisitedNodes < k) {
          treeInfo.numVisitedNodes += 1;
          treeInfo.lastVisitedNode = node.value;
          reverseOrderTraversal(node.left, k, treeInfo);
        }
      }
}
