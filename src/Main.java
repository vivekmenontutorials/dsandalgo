import dsandalgo.recursion.BinarySearch;
import dsandalgo.recursion.Palindrome;
import dsandalgo.sorting.InsertionSort;
import dsandalgo.sorting.SelectionSort;

public class Main {
    public static void main(String[] args) {

        int[] arr = new int[]{7, 1, 9, 0,4,55,6,89,1,2,33,4,1,2,88};
        SelectionSort.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

}