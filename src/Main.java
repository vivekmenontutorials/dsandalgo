import dsandalgo.binarysearchtree.BinarySearchTree;
import dsandalgo.binarysearchtree.BinarySearchTreeTreeImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        BinarySearchTree<Integer> bst = new BinarySearchTreeTreeImpl<>();
        bst.insert(18);
        bst.insert(12);
        bst.insert(25);
        bst.insert(4);
        bst.insert(15);
        bst.insert(25);
        bst.insert(30);
        bst.insert(1);
        bst.insert(13);
        bst.insert(17);
        bst.insert(28);
        bst.insert(3);
        bst.insert(14);
        bst.insert(29);
        System.out.println("Exists: " + bst.doesItemExist(14));
        List<Integer> adjs = bst.findClosestMatch(27);

        System.out.println("Closest match: " + adjs);
        System.out.println("First: " + bst.getFirst());
        System.out.println("Last: " + bst.getLast());

        System.out.println("Sorted: " + bst.getSorted());


        bst.delete(18);

        System.out.println("Sorted: " + bst.getSorted());
        System.out.println("Serialized tree: " + bst);

    }
}