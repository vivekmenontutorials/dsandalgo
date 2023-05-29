package dsandalgo.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets78 {

    public List<List<Integer>> subsets(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> remaining = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            remaining.add(nums[i]);
        }
        List<Integer> selected = new ArrayList<>();
        List<List<Integer>> results = new ArrayList<>();
        helper(selected, remaining, results);
        return results;
    }

    private void helper(List<Integer> selected,
                        List<Integer> remaining,
                        List<List<Integer>> results) {

        if (remaining.size() == 0) {
            List<Integer> result = new ArrayList<>(selected);
            results.add(result);
            return;
        }


        //choose
        int chosenNum = remaining.get(0);
        remaining.remove(0);

        //explore with
        selected.add(chosenNum);
        helper(selected, remaining, results);

        //explore without
        selected.remove(selected.size() - 1);
        helper(selected, remaining, results);

        //unchoose
        remaining.add(0, chosenNum);


    }
}
