package dsandalgo.BinarySearchTree;

import java.util.List;

public interface BinarySearchTree<T extends Comparable> {

    /**
     * Insert item into binary search tree
     *
     * @param item The comparable to be inserted. For example this could be an Integer
     * @return the inserted new node
     */
    BinaryTreeNode insert(T item);

    /**
     * Return true if the item exists in the binary search tree
     *
     * @param item
     * @return ture is the item exists else false
     */
    boolean doesItemExist(T item);

    /**
     * If an exact match is found, this returns one item.
     * Else it returns two items, the closest item below and the closest item above, in that order
     *
     * @param item Item we are looking for
     * @return closest matched item(s)
     */
    List<T> findClosestMatch(T item);

    /**
     * Find the smallest item in the tree
     * @return
     */
    T getFirst();

    /**
     * Find the largest item in the tree
     * @return
     */
    T getLast();

    /**
     * Get items in ascending order
     */
    List<T> getSorted();

    /**
     * Delete item from tree
     * @param item
     */
    void delete(T item);
}
