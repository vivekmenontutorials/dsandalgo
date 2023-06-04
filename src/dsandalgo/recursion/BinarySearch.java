package dsandalgo.recursion;

public class BinarySearch {

    public static int findIndex(int[] arr, int findMe) {
        return helper(arr, findMe, 0, arr.length - 1);

    }

    public static int helper(int[] arr,
                             int findMe,
                             int startIdx,
                             int endIdx) {
        if (startIdx > endIdx) {
            //failure base case
            return -1;
        }

        int midIdx = (startIdx + endIdx) / 2;

        if (arr[midIdx] == findMe) {
            //success base case
            return midIdx;
        } else {
            if (findMe > arr[midIdx]) {
                //search right
                return helper(arr, findMe, midIdx + 1, endIdx);
            } else {
                //search left
                return helper(arr, findMe, startIdx, midIdx - 1);
            }

        }

    }


}
