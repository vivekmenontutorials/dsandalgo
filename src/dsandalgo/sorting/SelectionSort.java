package dsandalgo.sorting;

public class SelectionSort {

    public static void sort(int[] arr) {

        for (int fillPosition = 0; fillPosition < arr.length; fillPosition++) {
            int minIdx = fillPosition;

            for (int i = fillPosition; i < arr.length; i++) {
                if (arr[i] < arr[minIdx]) {
                    minIdx = i;
                }
            }
            swap(fillPosition, minIdx, arr);
        }
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
