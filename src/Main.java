import dsandalgo.recursion.Permutations46;
import dsandalgo.recursion.Subsets78;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        Subsets78 subsets = new Subsets78();

        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> ans = subsets.subsets(nums);

        System.out.println(ans);

    }

}