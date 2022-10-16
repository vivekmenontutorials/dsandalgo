package dsandalgo.BinarySearchTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTreeTreeImpl<T extends Comparable> implements BinarySearchTree<T> {

    /*
    -----------------------
    SAMPLE CODE FOR TESTING
    -------------------------

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
     */
    private BinaryTreeNode root;
    private int size;


    @Override
    public BinaryTreeNode insert(T item) {
        if (item == null) {
            throw new RuntimeException("Null items not allowed!");
        }
        BinaryTreeNode newNode = new BinaryTreeNode(item);
        if (root == null) {
            root = newNode;
        } else {
            BinaryTreeNode parent = findParentForInsert(root, item);
            if (item.compareTo(parent.getItem()) > 0) {
                //bigger than parent
                parent.setRight(newNode);

            } else {
                //equal or less
                parent.setLeft(newNode);
                newNode.setParent(parent);
            }
            newNode.setParent(parent);
        }

        size++;
        return newNode;

    }

    @Override
    public boolean doesItemExist(T item) {

        if (item == null) {
            return false;
        }

        return findNode(root, item) != null ? true : false;
    }


    @Override
    public List<T> findClosestMatch(T item) {
        if (root == null || item == null) {
            return null;
        }

        return findClosest(root, null, null, item);
    }

    @Override
    public T getFirst() {
        if (root == null) {
            return null;
        }

        BinaryTreeNode current = root;

        while (current.getLeft() != null) {
            current = current.getLeft();
        }

        return (T) current.getItem();
    }

    @Override
    public T getLast() {
        if (root == null) {
            return null;
        }

        BinaryTreeNode current = root;

        while (current.getRight() != null) {
            current = current.getRight();
        }

        return (T) current.getItem();
    }

    @Override
    public List<T> getSorted() {
        List<T> items = new ArrayList<>();

        inOrderTraversal(root, items);
        return items;
    }

    private void inOrderTraversal(BinaryTreeNode<T> node, List<T> items) {
        if (node.getLeft() != null) {
            inOrderTraversal(node.getLeft(), items);
        }
        items.add(node.getItem());
        if (node.getRight() != null) {
            inOrderTraversal(node.getRight(), items);
        }

    }

    @Override
    public void delete(T item) {

        BinaryTreeNode<T> nodeToDelete = findNode(root, item);
        if (nodeToDelete != null) {
            if (nodeToDelete.getLeft() == null && nodeToDelete.getRight() == null) {
                deleteNodeWithNoChild(nodeToDelete);
            } else if (nodeToDelete.getLeft() == null || nodeToDelete.getRight() == null) {
                deleteNodeWithOneChild(nodeToDelete);
            } else {
                deleteNodeWithTwoChildren(nodeToDelete);
            }
            size--;
        }

    }

    private void deleteNodeWithNoChild(BinaryTreeNode<T> nodeToDelete) {


        if (nodeToDelete.getParent() != null) {
            if (nodeToDelete.getParent().getLeft() == nodeToDelete) {
                nodeToDelete.getParent().setLeft(null);
            } else {
                nodeToDelete.getParent().setRight(null);
            }

            nodeToDelete.setParent(null);
        }

        nodeToDelete.setLeft(null);
        nodeToDelete.setRight(null);
        nodeToDelete.setParent(null);
    }

    private void deleteNodeWithOneChild(BinaryTreeNode<T> nodeToDelete) {

        BinaryTreeNode<T> newChildNode;

        if (nodeToDelete.getLeft() != null) {
            newChildNode = nodeToDelete.getLeft();
        } else {
            newChildNode = nodeToDelete.getRight();
        }

        if (nodeToDelete.getParent() == null) {
            root = newChildNode;
        } else {
            BinaryTreeNode<T> parent = nodeToDelete.getParent();
            if (parent.getLeft() == nodeToDelete) {
                parent.setLeft(newChildNode);
            } else {
                parent.setRight(newChildNode);
            }
        }

        nodeToDelete.setLeft(null);
        nodeToDelete.setRight(null);
        nodeToDelete.setParent(null);
    }

    private void deleteNodeWithTwoChildren(BinaryTreeNode<T> nodeToDelete) {

        BinaryTreeNode rightMin = nodeToDelete.getRight();
        while (rightMin.getLeft() != null) {
            rightMin = rightMin.getLeft();
        }

        nodeToDelete.setItem((T) rightMin.getItem());

        if (rightMin.getRight() == null) {
            deleteNodeWithNoChild(rightMin);
        } else {
            deleteNodeWithOneChild(rightMin);
        }

    }


    private List<T> findClosest(BinaryTreeNode<T> currentNode,
                                BinaryTreeNode<T> before,
                                BinaryTreeNode<T> after,
                                T item) {


        if (currentNode != null && currentNode.getItem().compareTo(item) == 0) {
            //found an exact match
            List<T> adj = new ArrayList<>();
            adj.add(item);
            return adj;
        }

        if (currentNode == null) {
            List<T> adj = new ArrayList<>();

            if (before != null && before.getItem().compareTo(item) < 0) {
                adj.add(before.getItem());
            } else {
                adj.add(null);
            }


            if (after != null && after.getItem().compareTo(item) > 0) {
                adj.add(after.getItem());
            } else {
                adj.add(null);
            }

            return adj;
        }

        if (item.compareTo(currentNode.getItem()) > 0) {

            //current node smaller than item we are searching
            // track the closest item below the item

            if (before == null || currentNode.getItem().compareTo(before.getItem()) > 0) {
                //biggest item smaller than the item we are searching
                before = currentNode;
            }

            return findClosest(currentNode.getRight(), before, after, item);
        } else {
            //current node bigger than item we are searching
            // track the closest item above the item

            if (after == null || currentNode.getItem().compareTo(after.getItem()) < 0) {
                //smallest item bigger that the item we are searching
                after = currentNode;
            }

            return findClosest(currentNode.getLeft(), before, after, item);
        }

    }

    private BinaryTreeNode findNextNodeInSearch(BinaryTreeNode<T> node, T findItem) {
        T nodeItem = node.getItem();
        switch (findItem.compareTo(nodeItem)) {
            case 1:
                return node.getRight();
            default:
                return node.getLeft(); //assuming that we add duplicates to the left
        }

    }

    private BinaryTreeNode findParentForInsert(BinaryTreeNode<T> currentNode, T item) {

        BinaryTreeNode nextNode = findNextNodeInSearch(currentNode, item);
        if (nextNode == null) {
            return currentNode;
        } else {
            return findParentForInsert(nextNode, item);
        }

    }


    private BinaryTreeNode<T> findNode(BinaryTreeNode<T> currentNode, T item) {
        if (currentNode.getItem().compareTo(item) == 0) {
            return currentNode;
        } else {
            BinaryTreeNode next = findNextNodeInSearch(currentNode, item);
            if (next == null) {
                return null;
            } else {
                return findNode(next, item);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(String.valueOf(root.getItem()));
        sb.append("]");
        Queue<BinaryTreeNode<T>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> node = queue.remove();
            String strLeftVal = "NULL";
            String strRightVal = "NULL";
            if (node.getLeft() != null) {
                strLeftVal = String.valueOf(node.getLeft().getItem());
                queue.add(node.getLeft());
            }
            sb.append("[");
            sb.append(strLeftVal);
            sb.append("]");

            if (node.getRight() != null) {
                strRightVal = String.valueOf(node.getRight().getItem());
                queue.add(node.getRight());
            }
            sb.append("[");
            sb.append(strRightVal);
            sb.append("]");


        }

        return sb.toString();
    }

}
