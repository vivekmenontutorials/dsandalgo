package dsandalgo.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations46 {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> chosenNums = new ArrayList();
        List<Integer> remainingNums = new ArrayList();
        List<List<Integer>> results = new ArrayList();

        for (int i : nums) {
            remainingNums.add(i);
        }

        permuteHelper(chosenNums, remainingNums, results);
        return results;
    }

    private void permuteHelper(
            List<Integer> chosenNums,
            List<Integer> remainingNums,
            List<List<Integer>> results) {

        if (remainingNums.size() == 0) {
            List<Integer> ints = new ArrayList<>(chosenNums);
            results.add(ints);
            return;
        }

        for (int idx = 0; idx < remainingNums.size(); idx++) {
            //choose
            int pickNum = remainingNums.get(idx);
            chosenNums.add(pickNum);
            remainingNums.remove(idx);

            //explore
            permuteHelper(chosenNums, remainingNums, results);

            //un-chose
            remainingNums.add(idx, pickNum);
            chosenNums.remove(chosenNums.size() - 1);


        }


    }
}
