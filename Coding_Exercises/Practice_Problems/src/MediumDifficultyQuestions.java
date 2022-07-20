import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
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

      static class TreeRootInfo {
        //Represents the root of the subtree we're trying to build.
        public int rootIdx;
    
        public TreeRootInfo(int rootIdx) {
          this.rootIdx = rootIdx;
        }
      }
    
      public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        // Write your code here.
        TreeRootInfo treeInfo = new TreeRootInfo(0);
        return reconstructBstFromRange(Integer.MIN_VALUE, Integer.MAX_VALUE,
                                       preOrderTraversalValues, treeInfo);
      }
    
      public BST reconstructBstFromRange(int lowerBound, int upperBound,
                                         List<Integer> preOrderTraversalValues,
                                         TreeRootInfo currentSubtreeInfo) {
        if(currentSubtreeInfo.rootIdx == preOrderTraversalValues.size()) {
          return null;
        }
        
        int rootValue = preOrderTraversalValues.get(currentSubtreeInfo.rootIdx);
        if(rootValue < lowerBound || rootValue >= upperBound) {
          return null;
        }
    
        currentSubtreeInfo.rootIdx += 1;
        BST leftSubtree = reconstructBstFromRange(lowerBound, rootValue, preOrderTraversalValues,
                                                  currentSubtreeInfo);
        BST rightSubtree = reconstructBstFromRange(rootValue, upperBound, preOrderTraversalValues,
                                                  currentSubtreeInfo);
    
        BST bst = new BST(rootValue);
        bst.left = leftSubtree;
        bst.right = rightSubtree;
        return bst;
        //Time: O(n) Spece: O(n) where n is the size of the array.
        //The recursion takes up h frames on the callstack, where h is the height of the tree.
      }

      public static void invertBinaryTree(BinaryTree tree) {
        // Write your code here.
        BinaryTree leftSubtree = swapChildren(tree.right);
        BinaryTree rightSubtree = swapChildren(tree.left);
        tree.left = leftSubtree;
        tree.right = rightSubtree;
        //Time: O(n) Space: O(d) where d is the depth of the tree
      }
    
      public static BinaryTree swapChildren(BinaryTree tree) {
        if(Objects.isNull(tree)) {
          return tree;
        }
        if(Objects.isNull(tree.left) && Objects.isNull(tree.right)) {
          return tree;
        }
    
        BinaryTree leftSubtree = swapChildren(tree.right);
        BinaryTree rightSubtree = swapChildren(tree.left);
        tree.left = leftSubtree;
        tree.right = rightSubtree;
    
        return tree;
      }

      public static void invertBinaryTree2(BinaryTree tree) {
        // Write your code here.
        if(Objects.isNull(tree)) {
          return;
        }
    
        swapChildren(tree);
        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
      }
    
      public static void swapChildren2(BinaryTree tree) {
        BinaryTree left = tree.left;
        tree.left = tree.right;
        tree.right = left;
      }
      
      static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;
    
        public BinaryTree(int value) {
          this.value = value;
        }
      }

      static class BinaryTreeWithParent {
        public int value;
        public BinaryTreeWithParent left = null;
        public BinaryTreeWithParent right = null;
        public BinaryTreeWithParent parent = null;
    
        public BinaryTreeWithParent(int value) {
          this.value = value;
        }
      }
    
      public BinaryTreeWithParent findSuccessor(BinaryTreeWithParent tree, BinaryTreeWithParent node) {
        // Write your code here.
        //This problem is unique in that we have a reference to a node's parent.
        //The in-order successor of any given node is the left-most node of its right subtree.
        //When a node does not have a right subtree, its in-order successor must be an ancestor node.
        //It must be a left decedent of its ancestor, not a right decedent. If it were a right decedet,
        //it's ancestor would have already been visited and couldn't be a successor.
        //To find the successor ancestor, you reference parent nodes until you find one where the node
        //in question is in its left subtree (the parent must be to the right).
        if(!Objects.isNull(node.right)) {
          return leftMostNode(node.right);
        }
    
        return getRightMostParent(node);
        //Time: O(h) where h is the height of the tree. Space: O(1)
      }
    
      private BinaryTreeWithParent leftMostNode(BinaryTreeWithParent node) {
        BinaryTreeWithParent current = node;
        while(!Objects.isNull(current.left)) {
          current = current.left;
        }
    
        return current;
      }
    
      private BinaryTreeWithParent getRightMostParent(BinaryTreeWithParent node) {
        BinaryTreeWithParent current = node;
        while(!Objects.isNull(current.parent) && current.parent.right == current) {
          current = current.parent;
        }
    
        return current.parent;
      }

      static class TreeDHInfo {
        public int diameter;
        public int height;
    
        public TreeDHInfo(int diameter, int height) {
          this.diameter = diameter;
          this.height = height;
        }
      }
    
      public int binaryTreeDiameter(BinaryTree tree) { 
        return getTreeDHInfo(tree).diameter;
        //Time: O(n), where n is the number of nodes in the tree.
        //Space: O(h) average, where h is the height. O(n) wost case
      }
    
      public TreeDHInfo getTreeDHInfo(BinaryTree tree) {
        if(Objects.isNull(tree)) {
          return new TreeDHInfo(0, 0);
        }
    
        TreeDHInfo leftSubtree = getTreeDHInfo(tree.left);
        TreeDHInfo rightSubtree = getTreeDHInfo(tree.right);
    
        int longestPathThroughRoot = leftSubtree.height + rightSubtree.height;
        int maxDiameterSoFar = Math.max(leftSubtree.diameter, rightSubtree.diameter);
        int currentDiameter = Math.max(maxDiameterSoFar, longestPathThroughRoot);
        int currentHeight = Math.max(leftSubtree.height, rightSubtree.height) + 1;
    
        return new TreeDHInfo(currentDiameter, currentHeight);
      }

      static class TreeBalancedInfo {
        public final boolean isBalanced;
        public final int height;
    
        public TreeBalancedInfo(int height, boolean isBalanced) {
          this.height = height;
          this.isBalanced = isBalanced;
        }
      }
    
      public boolean heightBalancedBinaryTree(BinaryTree tree) {
        // Write your code here.
        return calculateTreeInfo(tree).isBalanced;
        //Time: O(n) where n is the number of nodes in the tree
        //Space: O(h) where h is the height of the tree.
      }
    
      public TreeBalancedInfo calculateTreeInfo(BinaryTree tree) {
        if(Objects.isNull(tree)) {
          return new TreeBalancedInfo(-1, true);
        }
    
        TreeBalancedInfo leftSubtree = calculateTreeInfo(tree.left);
        if(!leftSubtree.isBalanced) {
          return new TreeBalancedInfo(-1, false);
        }
        TreeBalancedInfo rightSubtree = calculateTreeInfo(tree.right);
    
        int leftSubtreeHeight = leftSubtree.height + 1;
        int rightSubtreeHeight = rightSubtree.height + 1;
        int subtreeHeight = Math.max(leftSubtreeHeight, rightSubtreeHeight);
        boolean subtreesBalanced = leftSubtree.isBalanced && rightSubtree.isBalanced;
        boolean isBalanced = subtreesBalanced && Math.abs(leftSubtreeHeight - rightSubtreeHeight) <= 1;
    
        return new TreeBalancedInfo(subtreeHeight, isBalanced);
      }

      public static int maxSubsetSumNoAdjacent(int[] array) {
        // Write your code here.
        //This problem requires dynamic programming. We start witht the simplest form of the
        //problem and use that solution to find the solution of incrementally harder versions
        //of the same problem.
    
        //To solve the problem, you start at the first element and calculate the largest
        //sum of non-adjacent integers from index 0 up to that that element.
    
        //Example: [7, 10, 12, 7, 9, 14]
        //Largest Sum Array: [7, 10, 19, 19, 28, 33]
        //As the size of the subarray grows, so does the number of possible sums. For example,
        //when we get to index 3, the possible sums are 19, 17, and 14. THis is because
        //you can skip more than one number to be considered non-adjacent.
    
        //There is a pattern between the maximum sum at a given index and the maximum sum at the
        //previous index. Consider an input array named 'array' and a corresponding maximum sum array
        //named 'maxSums'.
        //maxSums[i] = max(maxSums[i - 1], maxSums[i - 2] + array[i])
    
        //There are two base cases in this algorithm. You need to be able to generate the maxSum for the
        //first two indices without using the formula.
        //maxSum[9] = array[0] and maxSum[1] = max(array[0], array[1])
    
        //Time: O(n) Space: O(n) where n is the number of elements in the input array.
    
        //Since the formula only relys on maxSum[i - 1] and maxSum[i - 2], you only need to
        //store the two previous maximumSums
        //Instead of using an array, you could use two variables:
        //first = maxSums[i - 1]
        //second = maxSums[i - 2]
        //current = max(first, second + array[i])
        //At the end of each iteration second = first and first = current.
    
        //Time: O(n) Space: O(1) where n is the number of elements in the input array.
        
        if(array.length == 0) {
          return 0;
        } else if(array.length == 1) {
          return array[0];
        } else if(array.length == 2) {
          return Math.max(array[0], array[1]);
        } else {
          int first = Math.max(array[0], array[1]);
          int second = array[0];
          int maxSum = 0;
          
          for(int i = 2; i < array.length; i++) {
            maxSum = Math.max(first, second + array[i]);
            second = first;
            first = maxSum;
          }
    
          //[7, 10, 12, 7, 9, 14]
          //[7, 10, 19, 19, 28, 33]
          return maxSum;
          //Time: O(n) Space: O(1) where n is the number of elements in the input array.
        }
      }

      public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        // Write your code here.
        //This problem requires dynamic programming.
        //To start you need to initialize an array from 0 to n (inclusive).
        //This array will represent the number of ways you can make change for that
        //amount of money using the available denominations.
        //You assume there is only 1 way to make change for $0, to use no coins.
        //We can call this array 'possibilities'.
    
        //For each denomination is 'denoms', you iterate through 'possibilities'.
        //Using j as a pointer for 'possibilities' and i as a pointer for 'denoms':
        //if(denoms[i] <= possibilities[j]) you skip the possibility. Otherwise,
        //possibilities[j] += possibilities[j - denoms[i]].
    
        int[] possibilities = new int[n+1];
        possibilities[0] = 1;
    
        for(int denomination : denoms) {
          for(int amount = 1; amount < possibilities.length; amount++) {
            if(denomination <= amount) {
              possibilities[amount] += possibilities[amount - denomination];
            }
          }
        }
        
        return possibilities[n];
        //Time: O(n*m) Space: O(n) where n is the amount and m is the number of denominations
      }

      public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        // Write your code here.
        int[] possibilities = new int[n + 1];
        //We want to be able to get the minimum number of coins needed to make each possibility,
        //so we initialize the array with very large numbers to make initial comparisons easy.
        Arrays.fill(possibilities, 1, possibilities.length, Integer.MAX_VALUE);
    
        int candidate = 0;
        for(int denomination : denoms) {
          for(int amount = 1; amount < n + 1; amount++) {
            if(denomination <= amount) {
              //You can't add 1 to Integer.MAX_VALUE, so we need to check the element at index
              //[amount - denomination] before trying to add to it.
              if(possibilities[amount - denomination] == Integer.MAX_VALUE) {
                candidate = possibilities[amount - denomination];
              } else {
                candidate = possibilities[amount - denomination] + 1;
              }
    
              possibilities[amount] = Math.min(possibilities[amount], candidate);
            }
          }
        }
        
        return possibilities[n] != Integer.MAX_VALUE ? possibilities[n] : -1;
        //Time: O(n*m) Space: O(n) where n is the amount and m is the number of denominations.
      }

      public static int levenshteinDistance(String str1, String str2) {
        // Write your code here.
        //This problem requires dynamic programming.
        //You start by building a two-dimensional array that contains the minimum number
        //of edit operations that we can perform on a substring of the first string to turn it
        //into another substring of the second string.
        //For each element in the 2D array, you look at the three neighboring elements.
        //If the letters you're comparing are not equal, the element is equal to 
        //min(three neighbors) + 1. Otherwise, if the letters are equal, the element is
        //equal to min(three neighbors). In this case, the minimum is the element diagonally
        //up and to the left.
    
        //if(str1[r - 1] == str2[c- 1]) : E[r][c] = E[r - 1][c - 1].
        //else : E[r][c] = 1 + min(E[r][c - 1], E[r - 1][c], E[r - 1][c - 1]).
        //Time: O(m * n) where m is the size of the first string and n is the size of the second.
        //Space: O(m * n) where m is the size of the first string and n is the size of the second.
    
        //Note: Since we only need value in the preceding row and column, we can reduce our space
        //complexity by only keeping track of the current row and previous row.
        //This reduces our space complexity to O(n), where n is the length of the shorter string.
        int[][] edits = new int[str2.length() + 1][str1.length() + 1];
        
        for(int i = 0; i < str2.length() + 1; i++) {
          for(int j = 0; j < str1.length(); j++) {
            edits[i][j] = j;
          }
          edits[i][0] = i;
        }
    
        for(int i = 1; i < str2.length() + 1; i++) {
          for(int j = 1; j < str1.length() + 1; j++) {
            if(str2.charAt(i - 1) == str1.charAt(j - 1)) {
              edits[i][j] = edits[i - 1][j - 1];
            } else {
              edits[i][j] = 
                1 + Math.min(edits[i - 1][j - 1], Math.min(edits[i - 1][j], edits[i][j - 1]));
            }
          }
        }
    
        return edits[str2.length()][str1.length()];
        //Time: O(m * n) where m is the size of the first string and n is the size of the second.
        //Space: O(n) where n is the length of the shorter string.
      }

      public int numberOfWaysToTraverseGraphRec(int width, int height) {
        // Write your code here.
        TraversalHelper helper = new TraversalHelper(0);
        numberOfWaysToTraverseGraphRec(helper, 1, 1, width, height);
        return helper.paths;
        //Time: O(2^(n + m)) where n is the width and m is the height.
        //This is because, for each position in the graph, you need to make two recursive calls
        //until you reach your base case.
        //Space: O(n + m) because it takes n + m recursive calls to reach a base case.
      }
    
      static class TraversalHelper {
        public int paths;
    
        public TraversalHelper(int paths) {
          this.paths = paths;
        }
      }
    
      public void numberOfWaysToTraverseGraphRec(TraversalHelper helper,
                                              int xpos, int ypos, int width, int height) {
        if(xpos == width && ypos == height) {
          helper.paths++;
        }
    
        if(xpos < width) {
          numberOfWaysToTraverseGraphRec(helper, xpos + 1, ypos, width, height);
        }
        if(ypos < height) {
          numberOfWaysToTraverseGraphRec(helper, xpos, ypos + 1, width, height);
        }
      }

      public int numberOfWaysToTraverseGraph(int width, int height) {
        // Write your code here.
        //This approach uses Dynamic Programming to store the result of the problem.
        //Each intermediate problem involves finding the number of ways to get to an
        //adjacent square in the graph.
        //The number of ways to get to any given square is the sum of the number of
        //ways to get to its adjacent (upper and left) squares.
        //You start by filling out the border of your graph. When you're on a border
        //square, there is only one way to reach it from the start (going either left
        //or up).
    
        int[][] ways = new int[height][width];
        
        for(int i = 0; i < width; i++) {
          for(int j = 0; j < height; j++) {
            if(i == 0 || j == 0) {
              ways[j][i] = 1;
            } else {
              int waysLeft = ways[j][i - 1];
              int waysUp = ways[j - 1][i];
              ways[j][i] = waysLeft + waysUp;
            }
          }
        }
    
        return ways[height - 1][width - 1];
        //Time: O(n*m) where n is the width of the graph and m is the height.
        //The time complexity is lower because we don't need to make two recursive calls
        //at each position.
        //Space: O(n*m)
      }

      public static int kadanesAlgorithm(int[] array) {
        // Write your code here.
        //This problem involves dynamic programming and the 'sliding window' approach.
        //You start with a 'window' that only includes the first element.
        //You find the maximum sum of numbers that ends at the right end of the window.
        //This maximum sum will end up being either the sum of all numbers in the window
        //or just the number at the right end of the window.
        //Example:
          //Array:       [3,5,-9,1,3,-2,3,4,7,2-9,6,3,1,-5,4]
          //Largest Sum: [3,8,-1,1,4,2,5,9,16,18,9,15,18,19,14,18]
        //In other words, at index i, the maximum sum is:
          //max(previousSum + array[i], array[i])
    
        int maxSum = array[0];
        int maxSumAtIndex = array[0];
        
        for(int i = 1; i < array.length; i++) {
          maxSumAtIndex = Math.max(maxSumAtIndex + array[i], array[i]);
          maxSum = Math.max(maxSumAtIndex, maxSum);
        }
        
        return maxSum;
        //Time: O(n) Space: O(1)
      }

      public static boolean hasSingleCycle(int[] array) {
        // Write your code here.
        Set<Integer> visitedIndices = new HashSet<>();
        int startingIndex = 0;
        
        while(visitedIndices.size() < array.length) {
          int nextIndex = calculateIndex(startingIndex, array);
          if(!visitedIndices.contains(nextIndex)) {
            visitedIndices.add(nextIndex);
            startingIndex = nextIndex;
          } else {
            return false;
          }
        }
        
        return true;
        //Time: O(n) //Space: O(n)
      }
    
      private static int calculateIndex(int currentIndex, int[] array) {
        int jump = array[currentIndex];
        int endingIndex = currentIndex + jump;
        if(endingIndex >= array.length) {
          endingIndex = endingIndex % array.length;
        }
        if(endingIndex < 0) {
          endingIndex = array.length + (endingIndex % array.length);
        }
    
        return endingIndex;
      }

      public static boolean hasSingleCycle2(int[] array) {
        // Write your code here.
        int indicesVisited = 0;
        int currentIndex = 0;
        
        while(indicesVisited < array.length) {
          if(indicesVisited > 0 && currentIndex == 0) {
            return false;
          }
    
          indicesVisited++;
          currentIndex = calculateIndex2(currentIndex, array);
          
        }
        
        return currentIndex == 0;
        //Time: O(n) //Space: O(1)
      }
    
      private static int calculateIndex2(int currentIndex, int[] array) {
        int jump = array[currentIndex];
        int nextIndex = (currentIndex + jump) % array.length;
        
        return nextIndex >= 0 ? nextIndex : nextIndex + array.length;
      }

      static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();
    
        public Node(String name) {
          this.name = name;
        }
    
        public List<String> breadthFirstSearch(List<String> array) {
          // Write your code here.
          Queue<Node> queue = new LinkedList<>();
          queue.add(this);
          
          while(!queue.isEmpty()) {
            Node currentNode = queue.remove();
            array.add(currentNode.name);
            for(Node child : currentNode.children) {
              queue.add(child);
            }
          }
          return array;
          //Time: O(V + E) where V is the number of vertices (nodes) and E is the number
          //of edges (connections). You need to add a node to the list AND visit the node,
          //which is why it's greater than O(V).
          //Space: O(V) due to the size of the queue being used to perform the search,
          //as well as the additional data added to the input array.
        }
    
        public Node addChild(String name) {
          Node child = new Node(name);
          children.add(child);
          return this;
        }
      }

      public static List<Integer> riverSizes(int[][] matrix) {
        // Write your code here.
        //This is a graph traversal algorithm. Each time you encounter a a 1, you
        //need to treet it as the root node of a graph. 
        //To find the river size, you perform a DFS or BFS. You need to find the river
        //size in this manner because each 1 you encounter isn't necessarily at either
        //end of the river it belongs to.
        //Each point in the matrix can be treated as a graph node, with up to 4 neighboring
        //nodes. Each time you encounter a 1, you beform a B/DFS to find the river size.
        //As you traverse the graph (matrix), you keep track of all of the nodes (points)
        //you've visited to avoid visiting nodes more than once.
    
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        List<Integer> sizes = new ArrayList<>();
    
        for(int y = 0; y < matrix.length; y++) {
          for(int x = 0; x < matrix[y].length; x++) {
            if(visited[y][x]) {
              continue;
            } else {
              findRiverSize(x, y, matrix, visited, sizes);
            }
          }
        }
        return sizes;
        //Time: O(n) where n is the number of elements in the matrix
        //Spece: O(n) because of the boolean matrix tracking visited elements.
      }
    
      static class Point {
        public int x;
        public int y;
    
        public Point(int x, int y) {
          this.x = x;
          this.y = y;
        }
      }
    
      private static void findRiverSize(int x, int y, int[][] matrix,
                                   boolean[][] visited, List<Integer> sizes) {
        int currentSize = 0;
        Queue<Point> pointsToVisit = new LinkedList<>();
        pointsToVisit.add(new Point(x, y));
    
        while(!pointsToVisit.isEmpty()) {
          Point currentPoint = pointsToVisit.remove();
          int xPosition = currentPoint.x;
          int yPosition = currentPoint.y;
    
          if(visited[yPosition][xPosition]) {
            continue;
          }
    
          visited[yPosition][xPosition] = true;
          if(matrix[yPosition][xPosition] == 0) {
            continue;
          }
    
          currentSize += 1;
          List<Point> unvisitedNeighbors = getUnvisitedNeighbors(xPosition, yPosition, matrix, visited);
          pointsToVisit.addAll(unvisitedNeighbors);
        }
    
        if(currentSize > 0) {
          sizes.add(currentSize);
        }
      }
    
      private static List<Point> getUnvisitedNeighbors(int x, int y, int[][] matrix,
                                                         boolean[][] visited) {
        List<Point> unvisitedNeighbors = new ArrayList<>();
    
        if(x > 0 && !visited[y][x - 1]) {
          unvisitedNeighbors.add(new Point(x - 1, y));
        }
        if(x < matrix[y].length - 1 && !visited[y][x + 1]) {
          unvisitedNeighbors.add(new Point(x + 1, y));
        }
        if(y > 0 && !visited[y - 1][x]) {
          unvisitedNeighbors.add(new Point(x, y - 1));
        }
        if(y < matrix.length - 1 && !visited[y + 1][x]) {
          unvisitedNeighbors.add(new Point(x, y + 1));
        }
        
        return unvisitedNeighbors;
      }

      public static AncestralTree getYoungestCommonAncestor(
        AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
      // Write your code here.
      //One approach would be to iterate through the tree upwards to try and find the
      //common ancestor. This only works if the two ancestors are at equal depths within
      //the tree.
      
      //To fix this, you need to calculate the depth of each descendant until by going
      //up until you hit the top ancestor, counting the each node along the way.
      //Once you find the difference in depths, you give the deeper descendant a 'head start'
      //by starting its upward iteration first, then starting the upward iteration
      //of the shallower descendant once you've reached an equal playing field.
      
      //Example: If descendant T has a depth of 4 and I a depth of 2, you would move
      //up from T two times, then start moving up from both T and I until you 
      //found a common ancestor.
      //This approach works in all cases.
      int depthOne = calculateDepth(descendantOne);
      int depthTwo = calculateDepth(descendantTwo);
      int depthDifference = Math.abs(depthOne - depthTwo);
      AncestralTree deeperTree = depthOne > depthTwo ? descendantOne : descendantTwo;
      AncestralTree shallowerTree = depthOne > depthTwo ? descendantTwo : descendantOne;
  
      for(int i = 0; i < depthDifference; i++) {
        deeperTree = deeperTree.ancestor;
      }
  
      while(deeperTree != shallowerTree) {
        deeperTree = deeperTree.ancestor;
        shallowerTree = shallowerTree.ancestor;
      }
      
      return shallowerTree;
      //Time: O(d) where d is the depth of the deepest descendant.
      //Space: O(1) because this can be implemented iteratively.
    }
  
    private static int calculateDepth(AncestralTree tree) {
      int depth = 0;
  
      while(!Objects.isNull(tree.ancestor)) {
        depth++;
        tree = tree.ancestor;
      }
  
      return depth;
    }
  
    static class AncestralTree {
      public char name;
      public AncestralTree ancestor;
  
      AncestralTree(char name) {
        this.name = name;
        this.ancestor = null;
      }
  
      // This method is for testing only.
      void addAsAncestor(AncestralTree[] descendants) {
        for (AncestralTree descendant : descendants) {
          descendant.ancestor = this;
        }
      }
    }

    public int[][] removeIslands(int[][] matrix) {
      // Write your code here.
      //Perform a BFS on each element in the border of the matrix that is a one.
      //During the search, mark a node as visited when it is removed from the queue.
      //If an ajacent node is one, add it to the BFS queue and mark all other 
      //adjacent nodes as visited.
      //After doing this, go back through the matrix, looking at unvisited nodes.
      //If a node has a value of 1, change it to a zero.
      //Return the modified input matrix.
      boolean[][] visited = new boolean[matrix.length][matrix[0].length];
  
      for(int i = 0; i < matrix.length; i++) {
        if(!visited[i][0]) {
          breadthFirstSearch(0, i, matrix, visited);
        }
        if(!visited[i][matrix[i].length - 1]) {
          breadthFirstSearch(matrix[i].length - 1, i, matrix, visited);
        }
      }
  
      for(int i = 0; i < matrix[0].length; i++) {
        if(!visited[0][i]) {
          breadthFirstSearch(i, 0, matrix, visited);
        }
        if(!visited[matrix.length - 1][i]) {
          breadthFirstSearch(i, matrix.length - 1, matrix, visited);
        }
      }
  
      for(int y = 1; y < matrix.length - 1; y++) {
        for(int x = 1; x < matrix[y].length - 1; x++) {
          if(!visited[y][x] && matrix[y][x] == 1) {
            matrix[y][x] = 0;
          }
        }
      }
  
      return matrix;
      //Time: O(n) where n is the number of elements in the input matrix.
      //Space: O(n) where n is the number of elements in the 'visited' matrix.
      //Note: To improve the space complexity, you could change all of the bordering ones to twos. In rhe
      //second step of the algorithm, you change the twos back to ones and ones to zeros.
      //This helps you avoid the auxilary 'visited' matrix.
    }
  
    private void breadthFirstSearch(int x, int y, int[][] matrix, boolean[][] visited) {
      Queue<IslandPoint> pointsToVisit = new LinkedList<>();
      pointsToVisit.add(new IslandPoint(x, y));
  
      while(!pointsToVisit.isEmpty()) {
        IslandPoint currentPoint = pointsToVisit.remove();
        int xPosition = currentPoint.x;
        int yPosition = currentPoint.y;
        visited[yPosition][xPosition] = true;
  
        if(matrix[yPosition][xPosition] == 0) {
          continue;
        }
  
        if(xPosition > 0 && !visited[yPosition][xPosition - 1]) {
          pointsToVisit.add(new IslandPoint(xPosition - 1, yPosition));
        }
        
        if(xPosition < matrix[yPosition].length - 1 && !visited[yPosition][xPosition + 1]) {
          pointsToVisit.add(new IslandPoint(xPosition + 1, yPosition));
        }
        
        if(yPosition > 0 && !visited[yPosition - 1][xPosition]) {
          pointsToVisit.add(new IslandPoint(xPosition, yPosition - 1));
        }
        
        if(yPosition < matrix.length - 1 && !visited[yPosition + 1][xPosition]) {
          pointsToVisit.add(new IslandPoint(xPosition, yPosition + 1));
        }
      }
    }
  
    static class IslandPoint {
      public int x;
      public int y;
  
      public IslandPoint(int x, int y) {
        this.x = x;
        this.y = y;
      }
    }

    public boolean cycleInGraph(int[][] edges) {
      // Write your code here.
      //A cycle occurs in a graph whenever a vertex points to one of its ancestors.
      //Example: 0 -> 1 -> 2 -> 0. The edges pointing to new nodes in the graph
      //are called tree edges while edges pointing from a descendant node to an 
      //ancestor node are called back edges. 2 is a descendent of 0, so when 2
      //has an edge that points to 0, it's considered a cycle.
      //A cross edge is an edge that points from an existing node to another existing
      //node that is no an ancestor node.
  
      //You need two auxiliary data structures for this problem:
      //visited - will keep track of vertices visited.
      //inStack - will keep track of vertices in the current recursive stack. 
      //Every time you process a node in your recursion, you add it to visited and inStack.
      //When you find a node that is in visited, it most also be in inStack for it to be a 
      //back edge.
      //When you finish processing a vertex, you remove it from the recursive stack,
      //but not from visited.
      int numberOfNodes = edges.length;
      boolean[] visited = new boolean[numberOfNodes];
      boolean[] inStack = new boolean[numberOfNodes];
  
      for(int node = 0; node < numberOfNodes; node++) {
        if(visited[node]) {
          continue;
        } else {
          boolean containsCycle = isNodeInCycle(edges, node, visited, inStack);
          if(containsCycle) {
            return true;
          }
        }
      }
      
      return false;
      //Time: O(v + e) because you need to consider all vertices and edges in a DFS.
      //Space: O(v) for the recursive stack. 
    }
  
    private boolean isNodeInCycle(int[][] edges, int node, boolean[] visited,
                                  boolean[] inStack) {
      visited[node] = true;
      inStack[node] = true;
  
      int[] neighbors = edges[node];
      for(int neighbor : neighbors) {
        if(!visited[neighbor]) {
          boolean containsCycle = isNodeInCycle(edges, neighbor, visited, inStack);
          if(containsCycle) {
            return true;
          }
        } else if(inStack[neighbor]) {
          return true;
        }
        
      }
  
      inStack[node] = false;
      return false;
    }

    public int minimumPassesOfMatrix(int[][] matrix) {
      // Write your code here.
      //Create a queue of positions that are positive. When you remove an element,
      //look at all of its adjacent elements and convert any that are negative to positive.
      //Add these converted elements to a secondary queue.
      //When you finish going through the values in the primary queue, increment a variable
      //that keeps track of the number of passes by one. then swap the references of
      //the primary and secondary queue so that the primary queue contains elements for
      //the next pass and the secondary queue is empty again.
      //When you exhaust both queues, you check to see if any values in the matrix are
      //still negative. If they are, you return negative one.
      //Otherwise, you return the number of passes minus one.
      //To optimize the solution, you keep track of how many elements are in the current
      //queue at the beginning of the iteration. You loop that many times and then check
      //if the queue is empty. If it's not, you update the size and repeat.
  
      int passes = convertNegatives(matrix);
  
      if(!containsNegative(matrix)) {
        return passes - 1;
      }
  
      return -1;
      //Time: O(n) where n is the number of elements in the matrix.
      //Space: O(n).
    }
  
    private int convertNegatives(int[][] matrix) {
      Queue<MatrixPoint> nextPassQueue = gatAllPositivePositions(matrix);
      int passes = 0;
  
      while(!nextPassQueue.isEmpty()) {
        Queue<MatrixPoint> currentPassQueue = nextPassQueue;
        nextPassQueue = new LinkedList<>();
  
        while(!currentPassQueue.isEmpty()) {
          MatrixPoint currentPoint = currentPassQueue.remove();
          int currentX = currentPoint.x;
          int currentY = currentPoint.y;
  
          List<MatrixPoint> adjacentPositions = getAdjacentPositions(currentX, currentY, matrix);
          for(MatrixPoint position : adjacentPositions) {
            int positionX = position.x;
            int positionY = position.y;
  
            int value = matrix[positionY][positionX];
            if(value < 0) {
              matrix[positionY][positionX] = value * -1;
              nextPassQueue.add(new MatrixPoint(positionX, positionY));
            }
          }
        }
  
        passes += 1;
      }
  
      return passes;
    }
  
    private Queue<MatrixPoint> gatAllPositivePositions(int[][] matrix) {
      Queue<MatrixPoint> positivePositions = new LinkedList<>();
  
      for(int y = 0; y < matrix.length; y++) {
        for(int x = 0; x < matrix[y].length; x++) {
          if(matrix[y][x] > 0) {
            positivePositions.add(new MatrixPoint(x, y));
          }
        }
      }
  
      return positivePositions;
    }
  
    private List<MatrixPoint> getAdjacentPositions(int currentX, int currentY, int[][] matrix) {
      List<MatrixPoint> adjacentPositions = new ArrayList<>();
      
      if(currentX > 0) {
        adjacentPositions.add(new MatrixPoint(currentX - 1, currentY));
      }
      if(currentX < matrix[currentY].length - 1) {
        adjacentPositions.add(new MatrixPoint(currentX + 1, currentY));
      }
      if(currentY > 0) {
        adjacentPositions.add(new MatrixPoint(currentX, currentY - 1));
      }
      if(currentY < matrix.length - 1) {
        adjacentPositions.add(new MatrixPoint(currentX, currentY + 1));
      }
  
      return adjacentPositions;
    }
  
    private boolean containsNegative(int[][] matrix) {
      for(int y = 0; y < matrix.length; y++) {
        for(int x = 0; x < matrix[y].length; x++) {
          if(matrix[y][x] < 0) {
            return true;
          }
        }
      }
  
      return false;
    }
  
    static class MatrixPoint {
      public int x;
      public int y;
  
      public MatrixPoint(int x, int y) {
        this.x = x;
        this.y = y;
      }
    }

    public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
      // Write your code here.
      Map<Integer, List<Integer>> taskIndices = new HashMap<>();
      for(int i = 0; i < tasks.size(); i++) {
        int task = tasks.get(i);
        taskIndices.putIfAbsent(task, new ArrayList<>());
        taskIndices.get(task).add(i);
      }
  
      Collections.sort(tasks);
      ArrayList<ArrayList<Integer>> optimalAssignments = new ArrayList<>();
  
      int left = 0;
      int right = tasks.size() - 1;
      
      while(left < right) {
        int leftValue = tasks.get(left);
        int rightValue = tasks.get(right);
        
        ArrayList<Integer> optimalAssignment = new ArrayList<>();
        optimalAssignment.add(taskIndices.get(leftValue).remove(0));
        optimalAssignment.add(taskIndices.get(rightValue).remove(0));
        optimalAssignments.add(optimalAssignment);
        
        left++;
        right--;
      }
      
      return optimalAssignments;
      //Time: O(n*log(n)) where n is the number of tasks.
      //Space: O(n) where n is the number of tasks.
    }

    public int validStartingCity(int[] distances, int[] fuel, int mpg) {
      // Write your code here.
      //The city you need to start at is counter-intuitively the city you enter with
      //the least amount of gas. This 'minimum city' will be the same regardless of 
      //which city you start from.
      //By starting from this city, you eliminate this deficit from you route.
      int remainingMiles = 0; 
      int minimumRemainingMiles = 0;
      int minimumCity = 0; 
  
      for(int i = 1; i < distances.length; i++) {
        remainingMiles += fuel[i - 1]*mpg - distances[i - 1];
        if(remainingMiles < minimumRemainingMiles) {
          minimumRemainingMiles = remainingMiles;
          minimumCity = i;
        }
      }
  
      return minimumCity;
      //Time: O(n) where n is the number of cities
      //Space: O(1)
    }

    static class MinHeap {
      List<Integer> heap = new ArrayList<Integer>();
  
      public MinHeap(List<Integer> array) {
        heap = buildHeap(array);
      }
  
      public List<Integer> buildHeap(List<Integer> array) {
        // Write your code here.
        //Time: O(n) - You're calling siftDown n times, so you would expect a time of n*log(n).
        //However, sifting down isn't the same for all nodes, sifting down on a leaf is O(1) while
        //sifting down on the root takes O(log(n)). Most nodes are at the bottom, with the root node being
        //the only one that truly takes O(log(n)) time. Therefor, siftDown really reduces to O(1).
        //Space: O(1)
        int firstParentIndex = (array.size() - 2) / 2;
        for(int currentIndex = firstParentIndex; currentIndex >= 0; currentIndex--) {
          siftDown(currentIndex, array.size() - 1, array);
        }
        return array;
      }
  
      public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
        // Write your code here.
        //Time: O(log(n)) - This is because the process is similar to binary search due to the relationship
        //between parent elmements and child elements
        //Space: O(n)
        int childOneIdx = 2*currentIdx + 1;
        while (childOneIdx <= endIdx) {
          int childTwoIdx = 2*currentIdx + 2 <= endIdx ? 2*currentIdx + 2 : -1;
          int idxToSwap;
          if(childTwoIdx != -1 && heap.get(childTwoIdx) < heap.get(childOneIdx)) {
            idxToSwap = childTwoIdx;
          } else {
            idxToSwap = childOneIdx;
          }
          if(heap.get(idxToSwap) < heap.get(currentIdx)) {
            swap(currentIdx, idxToSwap, heap);
            currentIdx = idxToSwap;
            childOneIdx = currentIdx * 2 + 1;
          } else {
            return;
          }
        }
      }
  
      public void siftUp(int currentIdx, List<Integer> heap) {
        // Write your code here.
        //Time: O(log(n)) - This is because the process is similar to binary search due to the relationship
        //between parent elmements and child elements
        int parentIdx = (currentIdx - 1) / 2;
        while(currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)) {
          swap(currentIdx, parentIdx, heap);
          currentIdx = parentIdx;
          parentIdx = (currentIdx - 1) / 2;
        }
      }
  
      public int peek() {
        // Write your code here.
        //Time: O(1) Space: O(1)
        return heap.get(0);
      }
  
      public int remove() {
        // Write your code here.
        //Time: O(log(n)) - This is because the process is similar to binary search due to the relationship
        //between parent elmements and child elements
        swap(0, heap.size() - 1, heap);
        int valueToRemove = heap.get(heap.size() - 1);
        heap.remove(heap.size() - 1);
        siftDown(0, heap.size() - 1, heap);
        return valueToRemove;
      }
  
      public void insert(int value) {
        // Write your code here.
        //Time: O(log(n)) - This is because the process is similar to binary search due to the relationship
        //between parent elmements and child elements
        heap.add(value);
        siftUp(heap.size() - 1, heap);
      }
  
      public void swap(int i, int j, List<Integer> heap) {
        Integer temp = heap.get(j);
        heap.set(j, heap.get(i));
        heap.set(i, temp);
      }
    }

    static class DoublyLinkedList {
      public DLLNode head;
      public DLLNode tail;
  
      public void setHead(DLLNode node) {
        // Write your code here.
        if(Objects.isNull(head)) {
          head = node;
          tail = node;
        } else {
          insertBefore(head, node);
        }
        //Time: O(1) Space: O(1)
      }
  
      public void setTail(DLLNode node) {
        // Write your code here.
        if(Objects.isNull(tail)) {
          setHead(node);
        } else {
          insertAfter(tail, node);
        }
        //Time: O(1) Space: O(1)
      }
  
      public void insertBefore(DLLNode node, DLLNode nodeToInsert) {
        // Write your code here.
        if(nodeToInsert == head && nodeToInsert == tail) {
          return;
        }
        
        remove(nodeToInsert);
        nodeToInsert.prev = node.prev;
        nodeToInsert.next = node;
        if(node.prev == null) {
          head = nodeToInsert;
        } else {
          node.prev.next = nodeToInsert;
        }
        node.prev = nodeToInsert;
        //Time: O(1) Space: O(1)
      }
  
      public void insertAfter(DLLNode node, DLLNode nodeToInsert) {
        // Write your code here.
        if(nodeToInsert == head && nodeToInsert == tail) {
          return;
        }
        
        remove(nodeToInsert);
        nodeToInsert.prev = node;
        nodeToInsert.next = node.next;
        if(Objects.isNull(node.next)) {
          node.next = nodeToInsert;
          tail = nodeToInsert;
        } else {
          node.next.prev = nodeToInsert;
        }
        node.next = nodeToInsert;
        //Time: O(1) Space: O(1)
      }
  
      public void insertAtPosition(int position, DLLNode nodeToInsert) {
        // Write your code here.
        if(position == 1) {
          setHead(nodeToInsert);
        } else {
          DLLNode current = head;
          for(int i = 1; i < position && !Objects.isNull(current); i++) {
            current = current.next; 
          }
  
          if(Objects.isNull(current)) {
            setTail(nodeToInsert);
          } else {
            insertBefore(current, nodeToInsert);
          }
        }
        //Time: O(1) Space: O(1)
      }
  
      public void removeNodesWithValue(int value) {
        // Write your code here.
        DLLNode current = head;
        while(!Objects.isNull(current)) {
          DLLNode nodeToRemove = current;
          current = current.next;
          if(nodeToRemove.value == value) {
            remove(nodeToRemove);
          }
        }
        //Time: O(n) where n is the numnber of nodes in the linked.
        //Space: O(1)
      }
  
      public void remove(DLLNode node) {
        // Write your code here.
        if(node == head) {
          head = head.next;
        }
        if(node == tail) {
          tail = tail.prev;
        }
        removeNodeBindings(node);
        //Time: O(1) Space: O(1)
      }
  
      public boolean containsNodeWithValue(int value) {
        // Write your code here.
        DLLNode current = head;
        while(!Objects.isNull(current)) {
          if(current.value == value) {
            return true;
          }
          current = current.next;
        }
        return false;
        //Time: O(n) where n is the number of nodes in the linked list
        //Space: O(1)
      }
  
      private void removeNodeBindings(DLLNode node) {
        if(node.prev != null) node.prev.next = node.next;
        if(node.next != null) node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
      }
    }
  
    // Do not edit the class below.
    static class DLLNode {
      public int value;
      public DLLNode prev;
      public DLLNode next;
  
      public DLLNode(int value) {
        this.value = value;
      }
    }

    public static void removeKthNodeFromEnd(LinkedListNode head, int k) {
      // Write your code here.
      //This question can be solved by traversing the linked list using two pointers.
      //Both pointers will start at the head. The second pointer will traverse k nodes.
      //You then move both pointers forward until the second pointer points to null.
      //This positions the first pointer to be k nodes from the end of the list (null).
      //Afterwards, you can remove the previou node.
      //If the first pointer is still pointing to the head, you update its value and
      //next pointer.
  
      LinkedListNode previous = null;
      LinkedListNode firstPointer = head;
      LinkedListNode secondPointer = head;
  
      for(int i = 0; i < k; i++) {
        secondPointer = secondPointer.next;
      }
  
      while(!Objects.isNull(secondPointer)) {
        secondPointer = secondPointer.next;
        previous = firstPointer;
        firstPointer = firstPointer.next;
      }
  
      if(!Objects.isNull(previous)) {
        previous.next = previous.next.next;
      } else {
        firstPointer.value = firstPointer.next.value;
        firstPointer.next = firstPointer.next.next;
      }
    }
  
    static class LinkedListNode {
      int value;
      LinkedListNode next = null;
  
      public LinkedListNode(int value) {
        this.value = value;
      }
    }

    class sumOfLinkedListsProgram {
      // This is an input class. Do not edit.
      public static class LinkedList {
        public int value;
        public LinkedList next;
    
        public LinkedList(int value) {
          this.value = value;
          this.next = null;
        }
      }
    
      public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        // Write your code here.
        int sum = convertToNumber(linkedListOne) + convertToNumber(linkedListTwo);
        return convertToLinkedList(sum);
        //Time O(n) Space: O(n)
      }
    
      public int convertToNumber(LinkedList list) {
        LinkedList current = list;
        int sum = current.value;
        int power = 1;
        while(!Objects.isNull(current.next)) {
          current = current.next;
          sum += current.value * (int) Math.pow(10, power);
          power++;
        }
    
        return sum;
        //Time: O(n) where n is the size of the linked list.
        //Space: O(1).
      }
    
      public LinkedList convertToLinkedList(int num) {
        int length = getLength(num);
        LinkedList list = new LinkedList(getDigit(num, 0));
        LinkedList current = list;
        for(int i = 1; i < length; i++) {
          current.next = new LinkedList(getDigit(num, i));
          current = current.next;
        }
    
        return list;
        //Time: O(n) where n is the size of the linked list.
        //Space: O(n).
      }
    
      public int getDigit(int num, int i) {
        return (num / (int) Math.pow(10, i)) % 10;
        //Time: O(1) Space: O(1)
      }
    
      public int getLength(int num) {
        return (int) Math.log10(num) + 1;
        //Time: O(1) Space: O(1)
      }
    }

    class sumOfLinkedListsImprovedProgram {
      // This is an input class. Do not edit.
      public static class LinkedList {
        public int value;
        public LinkedList next;
    
        public LinkedList(int value) {
          this.value = value;
          this.next = null;
        }
    
        public String toString() {
          return String.format("%d", value);
        }
      }
    
      public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        // Write your code here.
        LinkedList pointerOne = linkedListOne;
        LinkedList pointerTwo = linkedListTwo;
        LinkedList listSum = null;
        LinkedList currentDigit = listSum;
        int carryOver = 0;
    
        while(pointerOne != null || pointerTwo != null || carryOver > 0) {
          int sum = carryOver;
          sum = pointerOne == null ? sum : sum + pointerOne.value;
          sum = pointerTwo == null ? sum : sum + pointerTwo.value;
          
          LinkedList nextDigit = null;
          
          if(sum > 9) {
            nextDigit = new LinkedList(sum % 10);
            carryOver = sum / 10;
          } else {
            nextDigit = new LinkedList(sum);
            carryOver = 0;
          }
    
          if(listSum == null) {
            listSum = nextDigit;
            currentDigit = listSum;
          } else {
            currentDigit.next = nextDigit;
            currentDigit = nextDigit;
          }
    
          if(pointerOne != null) {
            pointerOne = pointerOne.next;
          }
          if(pointerTwo != null) {
            pointerTwo = pointerTwo.next;
          }
        }
        
        return listSum;
        //Time: O(n) where n is the size of the longer list.
        //Space: O(n)
      }
    }

    class PermutationsProgram {
      public static List<List<Integer>> getPermutations(List<Integer> array) {
        // Write your code here.
        List<List<Integer>> permutations = new ArrayList<>();
        getPermutations(0, array, permutations);
        return permutations;
        //Time: O(n*n!) Space: O(n*n!)
      }
    
      public static void getPermutations(int i, List<Integer> array, List<List<Integer>> permutations) {
        if(i == array.size() - 1) {
          permutations.add(new ArrayList<>(array));
        } else {
          for(int j = i; j < array.size(); j++) {
            swap(array, i, j);
            getPermutations(i + 1, array, permutations);
            swap(array, i, j);
          }
        }
      }
    
      public static void swap(List<Integer> array, int i, int j) {
        Integer temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
      }
    }
    
    class PermutationsProgram2 {
      public static List<List<Integer>> getPermutations(List<Integer> array) {
        // Write your code here. Example: [1, 2, 3]
        //A permutation is a unique ordering of elemens in an array. The number of
        //permutations for an array of unique integers is n!, where n is the length
        //of the array.
        //For each position i in a permutation (zero-indexed), there are n - (i +1)
        //possibilities for the next number in the permutation. For example. Any
        //permutation that starys with 1 has two possibilities for the next number.
        //The same is true for permutations that start with 2 and 3.
        //Psuedocode:
        //helper(array, permutation, permutations):
        //  if(array is empty):
        //    permutations.add(permutation);
        //  else:
        //    for(number in array):
        //      new array = remove number from array;
        //      new permutation = permutation + number;
        //      helper(new array, new permutation, permutations);
    
        List<List<Integer>> permutations = new ArrayList<>();
        getPermutations(array, new ArrayList<>(), permutations);
        return permutations;
        //Time: O(n^ 2 * n!) - The base case of the recursive algorithm will be hit
        //n! times. For each permutation, the recursive case will be hit n times and
        //requires O(n) work. This leads to a final time complexity of (n^2 * n!).
        //Space: O(n*n!) - There will be n! permutations of size n. Each permutation
        //has a length of n.
      }
    
      private static void getPermutations(List<Integer> array, List<Integer> currentPermutation,
                                          List<List<Integer>> permutations) {
        if(array.isEmpty() && currentPermutation.size() > 0) {
          permutations.add(currentPermutation);
        } else {
          for(int i = 0; i < array.size(); i++) {
            List<Integer> newArray = new ArrayList<>(array);
            newArray.remove(i);
            List<Integer> newPermutation = new ArrayList<>(currentPermutation);
            newPermutation.add(array.get(i));
            getPermutations(newArray, newPermutation, permutations);
          }
        }
      }
    }

    class PowersetProgram {
      public static List<List<Integer>> powerset(List<Integer> array) {
        // Write your code here.
        List<List<Integer>> powerset = new ArrayList<>();
        powerset.add(new ArrayList<>());
    
        Map<Integer, Integer> elementIndexes = new HashMap<>();
        for(int i = 0; i < array.size(); i++) {
          elementIndexes.put(array.get(i), i);
        }
    
        for(int i = 0; i < array.size(); i++) {
          List<Integer> baseArray = new ArrayList<>();
          baseArray.add(array.get(i));
          addPowersetForElement(powerset, array, baseArray, elementIndexes);
        }
    
        return powerset;
        //Time: O(2^n * n) where n is the number of elements in the array
        //Space: O(2^n * n)
      }
    
      private static void addPowersetForElement(List<List<Integer>> powerset, List<Integer> array,
                                                List<Integer> baseArray, Map<Integer, Integer> elementIndexes) {
        Queue<List<Integer>> arrayQueue = new LinkedList<>();
        arrayQueue.add(baseArray);
        powerset.add(baseArray);
        
        while(!arrayQueue.isEmpty()) {
          List<Integer> currentBaseArray = arrayQueue.remove();
          Integer lastElement = currentBaseArray.get(currentBaseArray.size() - 1);
          Integer startIndex = elementIndexes.get(lastElement) + 1;
          for(int i = startIndex; i < array.size(); i++) {
            List<Integer> arrayToAdd = new ArrayList<>(currentBaseArray);
            arrayToAdd.add(array.get(i));
            if(i < array.size() - 1) {
              arrayQueue.add(arrayToAdd);
            }
            powerset.add(arrayToAdd);
          }
        }
      }
    }

    class Program {
      public static List<List<Integer>> powerset(List<Integer> array) {
        // Write your code here.
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
    
        for(Integer element : array) {
          int length = subsets.size();
          for(int i = 0; i < length; i++) {
            List<Integer> currentSubset = new ArrayList<>(subsets.get(i));
            currentSubset.add(element);
            subsets.add(currentSubset);
          }
        }
        
        return subsets;
      }
    }
}
