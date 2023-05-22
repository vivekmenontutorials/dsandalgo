import dsandalgo.recursion.Permutations46;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Permutations46 perm = new Permutations46();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> ans=perm.permute(nums);

        System.out.println(ans);

    }

}