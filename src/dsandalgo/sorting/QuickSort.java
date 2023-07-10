package dsandalgo.sorting;

import java.util.Random;

public class QuickSort {

/*
--------------------------
Rules for Quick sort
---------------------------
1>Choose a random pivot index
2>Move the element in the random pivot index to the extreme right
3>Start i pointer before the start of the array
4>Start j pointer on the extreme right, which is where the pivot is right now.
5>Move i to the right until it reaches an element greater than or equal to the pivot, or i reaches the right end.
6>Move j to the left until it reaches an element less that or equal to pivot, or j reaches the left end
7>Now swap what's in i with what's in j.
8>Repeat process until i>=j .
9>Once i>=j, swap what's in i with the pivot.
10>Now recursively do the same on both sides of the pivot.

* */
    Random random = new Random();

    public int[] sortArray(int[] nums) {
        sortArrayHelper(0, nums.length - 1, nums);
        return nums;
    }


    private void sortArrayHelper(int lowIdx, int highIdx, int[] nums) {

        if (lowIdx >= highIdx) {
            return;
        }


        int i = lowIdx - 1;
        int j = highIdx;

        int pivotIdx = selectPivotIdx(lowIdx, highIdx, nums);
        int pivot = nums[pivotIdx];

        //swap element at pivot index with the right most element
        swap(pivotIdx, highIdx, nums);

        while (i < j) {
            do {
                //advance i till element at i is equal to or greater than the pivot
                i++;
            } while (nums[i] < pivot && i < highIdx);


            do {
                //move j backwards until j is equal to or less than the pivot
                j--;
            } while (nums[j] > pivot && j > lowIdx);

            if (i >= j) {
                break;
            }

            swap(i, j, nums);


        }


        //swap element at index i with pivot (which is at the high index)
        swap(i, highIdx, nums);


        //At this point the pivot is at index i

        //recursively sort left.
        sortArrayHelper(lowIdx, i - 1, nums);

        //recursively sort right.
        sortArrayHelper(i + 1, highIdx, nums);


    }


    private int selectPivotIdx(int lowIdx, int highIdx, int[] nums) {

        return random.nextInt((highIdx - lowIdx) + 1) + lowIdx;
    }

    private static void swap(int i, int j, int[] arr) {
        if (i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
