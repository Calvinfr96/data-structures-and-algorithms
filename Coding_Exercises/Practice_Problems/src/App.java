import java.util.Arrays;
import java.util.HashSet;
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

    public static void main(String[] args) throws Exception {
        int[] array = {3,5,-4,8,11,1,-1,6};
        String result = Arrays.toString(twoNumberSumOptimal(array, 10));
        System.out.println(result);
    }
}
