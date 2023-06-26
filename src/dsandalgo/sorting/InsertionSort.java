package dsandalgo.sorting;

public class InsertionSort {

    //Average time complexity: O(n^2)
    //Space Complexity O(1)

    public static void sort(int[] arr) {
        for (int boundaryIndex = 0; boundaryIndex < arr.length; boundaryIndex++) {

            for (int sortItemIdx = boundaryIndex; sortItemIdx > 0; sortItemIdx--) {

                if (arr[sortItemIdx] < arr[sortItemIdx - 1]) {
                    int temp = arr[sortItemIdx];
                    arr[sortItemIdx] = arr[sortItemIdx - 1];
                    arr[sortItemIdx - 1] = temp;
                } else {
                    break;
                }

            }

        }

    }
}
