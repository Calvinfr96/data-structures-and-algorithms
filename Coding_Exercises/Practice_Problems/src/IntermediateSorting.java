import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
* The intermediate sorting algorithms (Merge, Quick, and Radix Sort) improve upon the basic sorting algorithms by lowering the time complexity of the sort. However, they are harder to understand.
* Merge and Quick Sort take advantage of the fact that an array of size one is inherently sorted, while Radix sort takes advantage of a unique property of integers.
* Merge and Quick Sort, along with the basic sorting algorithms are known as comparison sorts, which have a minimum time complexity of O(N*log(N)).
* While Radix Sort is effecient, the algorithm used can't properly sort negative values.
*/
public class IntermediateSorting {
    //Merge Sort
    public static List<Integer> mergeSort(List<Integer> array) {
        return mergeSort(array, 0, array.size());
    }
    
    private static List<Integer> mergeSort(List<Integer> array, int start, int end) {
        if(array.size() < 2) {
            return array;
        }

        List<Integer> left = mergeSort(array.subList(start, end / 2));
        List<Integer> right = mergeSort(array.subList(end / 2, end));

        return mergeHelper(left, right);

    }

    //Quick Sort
    public static List<Integer> quickSort(List<Integer> array) {
        return quickSort(array, 0, array.size() - 1);
    }

    private static List<Integer> quickSort(List<Integer> array, int start, int end) {
        if(start < end) {
            int pivotIndex = pivotHelper(array, start, end);
            quickSort(array, 0, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, end);
        }

        return array;
    }

    //Radix Sort
    public static List<Integer> radixSort(List<Integer> array) {
        int maxDigits = maxDigits(array);

        for(int i = 0; i < maxDigits; i++) {
            List<List<Integer>> buckets = new ArrayList<>(10);
            for(int j = 0; j < 10; j++) {
                buckets.add(new ArrayList<>());
            }
            for(Integer num : array) {
                int position = findDigit(num, i);
                buckets.get(position).add(num);
            }

            array = flatten(buckets);
        }
        return array;
    }

    //Merge Sort Helper Method
    private static List<Integer> mergeHelper(List<Integer> list1, List<Integer> list2) {
        List<Integer> combinedList = new ArrayList<>();
        int pointer1 = 0;
        int pointer2 = 0;

        while(pointer1 < list1.size() && pointer2 < list2.size()) {
            if(list1.get(pointer1) < list2.get(pointer2)) {
                combinedList.add(list1.get(pointer1));
                pointer1++;
            } else {
                combinedList.add(list2.get(pointer2));
                pointer2++;
            }
        }

        while(pointer1 < list1.size()) {
            combinedList.add(list1.get(pointer1));
            pointer1++;
        }
        while(pointer2 < list2.size()) {
            combinedList.add(list2.get(pointer2));
            pointer2++;
        }

        return combinedList;
    }

    //Quick Sort Helper Method
    private static int pivotHelper(List<Integer> array, int start, int end) {
        int pivotElement = array.get(start);
        int pivotIndex = start;

        for(int i = start + 1; i <= end; i++) {
            if(array.get(i) < pivotElement) {
                pivotIndex++;
                swap(array, pivotIndex, i);
            }
        }
        swap(array, start, pivotIndex);
        return pivotIndex;
    }

    //Radix Sort Helper Methods
    private static int findDigit(int num, int index) {
        return (int) Math.floor(Math.abs(num) / Math.pow(10, index)) % 10;
    }

    private static int numDigits(int num) {
        return (int) Math.floor(Math.log10(num)) + 1;
    }

    private static int maxDigits(List<Integer> nums) {
        Collections.sort(nums);
        Collections.reverse(nums);
        
        return numDigits(nums.get(0));
    } 

    private static List<Integer> flatten(List<List<Integer>> array) {
        List<Integer> flattened = new ArrayList<>();
        for(List<Integer> list : array) {
            for(Integer num : list) {
                flattened.add(num);
            }
        }

        return flattened;
    }

    //Swapping Helper Method
    private static List<Integer> swap(List<Integer> array, int a, int b) {
        if(array.size() < 2) {
            return array;
        }

        Integer temp = array.get(a);
        array.set(a, array.get(b));
        array.set(b, temp);

        return array;
    }
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 10, 5, 10000, 500, 1000, 2, 30, 4);
        System.out.println(radixSort(nums));
    }
}
