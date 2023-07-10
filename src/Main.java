import dsandalgo.recursion.BinarySearch;
import dsandalgo.recursion.Palindrome;
import dsandalgo.sorting.InsertionSort;
import dsandalgo.sorting.QuickSort;
import dsandalgo.sorting.SelectionSort;

public class Main {
    public static void main(String[] args) {

        int[] arr = new int[]{3,2,5,1,10,0};
        QuickSort qs=new QuickSort();
        qs.sortArray(arr);


        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

}