package dsandalgo.sorting;

public class InsertionSort {

    //Average time complexity: O(n^2)
    //Space Complexity O(1)

    public static void sort(int[] arr) {
        for (int boundaryIndex = 0; boundaryIndex < arr.length; boundaryIndex++) {

            for (int sortItemIdx = boundaryIndex; sortItemIdx > 0; sortItemIdx--) {

                if (arr[sortItemIdx] < arr[sortItemIdx - 1]) {
                    swap(sortItemIdx - 1, sortItemIdx, arr);
                } else {
                    break;
                }

            }
        }
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
