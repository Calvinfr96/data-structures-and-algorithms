import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* The intermediate sorting algorithms (Merge, Quick, and Radix Sort) improve upon the basic sorting algorithms by lowering the time complexity of the sort. However, they are harder to understand.
* Merge and Quick Sort take advantage of the fact that an array of size one is inherently sorted, while Radix sort takes advantage of a unique property of integers.
* While Radix Sort is effecient, the algorithm used can't properly sort negative values.
*/
public class IntermediateSorting {
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

    public static List<Integer> quickSort(List<Integer> array) {
        return quickSort(array, 0, array.size() - 1);
    }

    private static List<Integer> quickSort(List<Integer> array, int start, int end) {
        int pivotElement = pivotHelper(array, start, end);
        if(start < end && pivotElement < array.size() - 1) {
            quickSort(array, 0, pivotElement - 1);
            quickSort(array, pivotElement + 1, end);
        }

        return array;
    }

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

    public static int pivotHelper(List<Integer> array, int start, int end) {
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
        List<Integer> list = Arrays.asList(5,4,3,2,1);
        System.out.println(quickSort(list));
    }
}
