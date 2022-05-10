import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {
    public static int[] twoNumberSumNaive(int[] array, int targetSum) {
        // Write your code here.
            for(int i = 0; i < array.length - 1; i++) {
							int firstNum = array[i];
                for(int j = i + 1; j < array.length; j++) {
									int secondNum = array[j];
                    if(firstNum + secondNum == targetSum) {
											 return new int[] {firstNum, secondNum};
                    }
                }
            }
			
			return new int[0];
            // Time: O(n^2), Space: O(n)
      }

      public static int[] twoNumberSumOptimal(int[] array, int targetSum) {
          Set<Integer> nums = new HashSet<>();

          for(int i : array) {
              int difference = targetSum - i;
              if(nums.contains(difference)) {
                  return new int[] {i, difference};
              } else {
                  nums.add(i);
              }
          }

          return new int[0];
          //Time: O(N) Space: O(N)
          //This algorithm takes advantage of the fact that if sum - xi = xj, the xi + xj = sum. For each number in the input array, If (sum - xi) has not in the set, then you store xi in a set. If there is another number xj in the input array such that sum - xj = xi, then you have found the two numbers.

          //There is a third solution that involves sorting and multiple pointers that has O(N*log(N)) time and O(N) space.
      }

      public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.
            int pointer2 = 0;
            for(int pointer1 = 0; pointer1 < array.size() && pointer2 < sequence.size(); pointer1++) {
                //Whenever we're indexing arrays, we need to make sure we control for out of bounds indices for all arrays we work with.
                if(array.get(pointer1) == sequence.get(pointer2)) {
                    pointer2++;
                }
            }
        return pointer2 == sequence.size();
        //Time: O(N) where N is the length of the array. Space: O(1).
      }

      public static int[] sortedSquaredArray(int[] array) {
        //This method must account for arrays that contain negative integers, you can't just square each element and return.
        int[] squaredInts = new int[array.length];
            
            for(int i = 0; i < array.length; i++) {
                squaredInts[i] = (int) Math.pow(array[i], 2.0);
            }
            
            Arrays.sort(squaredInts);
            return squaredInts;
            //Time: O(n*log(n)) Space: O(n).
      }

      public static int[] sortedSquaredArrayOptimal(int[] array) {
          //The optimal solution takes advantage of the fact that the array is sorted. The previous solution would work even for an unsorted array.
          int[] squaredInts = new int[array.length];

          //These two pointers track the largest number in the array. For an array that contains positives and negatives, the largest square will be at either end. Ex: [-7, -3, 1, 5, 9]. 9 is the largest square
          int start = 0;
          int end = array.length - 1;

          for(int i = array.length - 1; i >=0; i--) {
              if(Math.abs(array[start]) > Math.abs(array[end])) {
                  squaredInts[i] = array[start] * array[start];
                  start++;
              } else {
                  squaredInts[i] = array[end] * array[end];
                  end--;
              }
          }

          return squaredInts;
      } 
    public static void main(String[] args) throws Exception {
        int[] nums = new int[] {-7,1,3,5};
        System.out.println(Arrays.toString(sortedSquaredArrayOptimal(nums)));
    }
}
