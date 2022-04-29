import java.util.Arrays;

public class BasicSorting {
    public static int[] bubbleSort(int[] array) {
        for(int j = array.length -1; j >= 0; j--) {
            int swaps = 0;
            for(int i = 0; i < j; i++) {
                if(array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    swaps++;
                }
            }

            if(swaps == 0) {
                break;
            }
        }
        return array;
    }

    public static int[] selectionSort(int[] array) {
        for(int j = 0; j < array.length - 1; j++) {
            int minIndex = j;
            boolean ordered = true;
            for(int i = j + 1; i < array.length; i++) {
                if(array[i - 1] > array[i]) {
                    ordered = false;
                }
                if(array[minIndex] > array[i]) {
                    minIndex = i;
                }
            }
            
            if(ordered) {
                System.out.println("BREAKING...");
                break;
            }
            if(minIndex != j) {
                swap(array, j, minIndex);
            }
        }
        return array;
    } 
    //[3, 2, 4, 1, 5]
    //[1, 2, 4, 3, 5]

    private static int[] swap(int[] array, int a, int b) {
        if(array.length < 2) {
            return array;
        }

        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;

        return array;
    }
    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 4, 5};
        // nums = swap(nums, 0, 1);
        System.out.println(Arrays.toString(selectionSort(nums)));
    }
}
