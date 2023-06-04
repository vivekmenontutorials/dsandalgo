import dsandalgo.recursion.BinarySearch;

public class Main {
    public static void main(String[] args) {


        int[] num = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 90;
        int ans=BinarySearch.findIndex(num,target);
        System.out.println(ans);

    }

}