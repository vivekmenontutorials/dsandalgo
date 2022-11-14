package dsandalgo.binarysearch;


/**
 * Sample code to invoke this
 * <p>
 * int[] arr = new int[]{1, 2, 5, 16, 18, 37, 45, 67, 89, 100, 123, 400, 900, 1001};
 * int idx= BinarySearch.findNumIndex(arr,18);
 * System.out.println("Index of num: "+idx);
 */
public class BinarySearch {


    /**
     * Finds the index of a number in a sorted array (sorted ascending)
     *
     * @param sortedArr The array in which we want to find the number
     * @param numToFind The number to be found
     * @return index of the number to be found. Return -1 if not found
     */
    public static int findNumIndex(int[] sortedArr,
                                   int numToFind) {

        int operations = 0; //this is just to track the complexity of the algorithm

        if (sortedArr == null || sortedArr.length == 0) {
            return -1;
        }

        int startIdx = 0;
        int endIdx = sortedArr.length - 1;

        while (startIdx <= endIdx) {
            operations++;

            int midIdx = (startIdx + endIdx) / 2;
            int midNum = sortedArr[midIdx];
            System.out.println("midIdx:" + midIdx);

            if (midNum == numToFind) {
                trackComplexity(sortedArr.length, operations);
                return midIdx;
            } else if (midNum < numToFind) {
                //the number you are looking for is on the right of mid
                startIdx = midIdx + 1;

            } else {
                //the number you are looking for is on the left of mid
                endIdx = midIdx - 1;

            }

        }

        trackComplexity(sortedArr.length, operations);
        return -1;


    }

    /***
     * Calculates the max total number of operations based on Big O, which is log of num of elements to base 2
     * Then prints the theoretical upper limit based on big an and the actual number of operations
     * @param numOfElements
     * @param operations
     */
    private static void trackComplexity(int numOfElements, int operations) {

        int lgN = (int) ((int) Math.ceil(Math.log(numOfElements)) / Math.log(2));
        String msg = String.format("Big O upper limit number of operations [%s], " +
                        "Actual number of operations [%s]"
                , lgN, operations);

        System.out.println(msg);

    }


}
