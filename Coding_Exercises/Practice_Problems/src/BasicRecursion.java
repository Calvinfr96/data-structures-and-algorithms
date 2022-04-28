import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicRecursion {
    public static void countDown(int num) {
        System.out.print(num + " ");
        if(num > 0) {//Base Case
            countDown(num - 1);//Recursive call with varying input.
            //Note: We don't return anything because we don't need to pass any information to the previous caller on the call stack.
        } else {
            System.out.println();
        }
    }

    public static int sumRange(int num) {
        if(num == 1) {//Base Case
            return 1;
        }

        return num + sumRange(num - 1);//Recursive call with varying input.
        //Note: In this case, we do need to return information to the previous caller. Specifically, we are returning the running total to the previous caller. When the base case is hit, 1 is returned to the previous caller, allowing it to compute its sum and pass that to the previous caller, until it reaches the bottom of the call stack.
    }

    public static int factorial(int num) {
        if(num == 0 || num == 1) {//Base Case
            return 1;
        }

        return num*factorial(num - 1);//Recursive call with varying input.
        //Note: In this case, we're passing the "running product" it the pervious caller so it can compute its product.
    }

    public static List<Integer> collectOddValues(List<Integer> nums) {
        List<Integer> results = new ArrayList<>();
        helper(nums, results, 0);//Calls helper method, which recursively calls itself until its base case is reached.
        return results;
    }

    private static void helper(List<Integer> nums, List<Integer> results, int index) {
        if(index < nums.size()) {//Base Case
            if(nums.get(index) % 2 != 0) {
                results.add(nums.get(index));
            }
            
            index += 1;//Varies input to recursive call below.
            
            helper(nums, results, index);
        }
    }

    public static List<Integer> collectOddValuesPR(List<Integer> nums) {
        List<Integer> newArray = new ArrayList<>();

        if(nums.isEmpty()) {
            return newArray;
        }

        if(nums.get(0) % 2 != 0) {
            newArray.add(nums.get(0));//3
        }

        List<Integer> arrayToAdd = new ArrayList<>(collectOddValuesPR(nums.subList(1, nums.size())));
        newArray.addAll(arrayToAdd);
        return newArray;
    }
    public static void main(String[] args) {
        countDown(10);
        System.out.println(sumRange(10));
        System.out.println(factorial(15));

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(collectOddValuesPR(nums));
    }  
}
