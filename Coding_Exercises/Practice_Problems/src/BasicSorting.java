import java.util.Arrays;
/*
* Having a time complexity of O(N^2), the basic sorting algorithms (Bubble, Selection, and Insertion Sort) are less efficient than other sorthing algorithms. However, they are easier to understand.
*Each of the algorithms sorts an array in place by gradually moving elements to their correct sorted position.
*/
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
                break;
            }
            if(minIndex != j) {
                swap(array, j, minIndex);
            }
        }
        return array;
    }

    public static int[] insertionSort(int[] array) {
        for(int i = 1; i < array.length; i++) {
            int currentIndex = i;
            while(currentIndex > 0 && array[currentIndex] < array[currentIndex - 1]) {
                swap(array, currentIndex, currentIndex - 1);
                currentIndex--;
            }
        }
        return array;
    }

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
        System.out.println(Arrays.toString(insertionSort(nums)));
    }
}
