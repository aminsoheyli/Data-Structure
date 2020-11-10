package non_linear;

import java.util.*;

public class BinarySearchTree {
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    private Node root;

    public BinarySearchTree() {
    }

    public BinarySearchTree(int value) {
        this.root = new Node(value);
    }

    public void insert(int value) {
        var node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }

        var current = root;
        while (true)
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            } else if (value > current.value) {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
    }

    public boolean contains(int value) {
        var current = root;
        while (current != null)
            if (value > current.value)
                current = current.leftChild;
            else if (value < current.value)
                current = current.rightChild;
            else
                return true;

        return false;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePreOrder(Node root) {
        // root left right
        if (root == null)
            return;

        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    private void traverseInOrder(Node root) {
        // left root right
        if (root == null)
            return;

        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    private void traversePostOrder(Node root) {
        // left right root
        if (root == null)
            return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null)
            return -1;

        if (isLeaf(root))
            return 0;

        return 1 + Math.max(
                height(root.leftChild)
                , height(root.rightChild));
    }

    // O(log n) for Binary Search Tree
    public int min() {
        return min(root);
    }

    // O(n) for Binary Tree
    private int min(Node root) {
        if (root == null)
            throw new IllegalStateException();

        if (isLeaf(root))
            return root.value;


        int minLeft = Integer.MAX_VALUE;
        if (root.leftChild != null)
            minLeft = min(root.leftChild);

        int minRight = Integer.MAX_VALUE;
        if (root.rightChild != null)
            minRight = min(root.rightChild);

        return Math.min(Math.min(minLeft, minRight), root.value);
    }

    private boolean isLeaf(Node node) {
        if (root == null)
            return false;

        return node.leftChild == null && node.rightChild == null;
    }

    public boolean equals(BinarySearchTree other) {
        if (other == null)
            return false;

        return equals(this.root, other.root);
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null)
            return true;

        if (first != null && second != null)
            return first.value == second.value
                    && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);

        return false;
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int min, int max) {
        if (root == null)
            return true;

        var value = root.value;

        return value >= min && value <= max
                && isBinarySearchTree(root.leftChild, min, value - 1)
                && isBinarySearchTree(root.rightChild, value + 1, max);
    }

    public List<Integer> getNodesAtDistance(int distance) {
        var list = new ArrayList<Integer>();
        getNodesAtDistance(root, distance, list);
        return list;
    }

    private void getNodesAtDistance(Node root, int distance, List<Integer> list) {
        if (root == null)
            return;

        if (distance == 0) {
            list.add(root.value);
            return;
        }

        getNodesAtDistance(root.leftChild, distance - 1, list);
        getNodesAtDistance(root.rightChild, distance - 1, list);
    }


    /**
     * @deprecated Runs in O(n^2)<br><br>
     * Use the {@link #traverseLevelOrderUsingQueue() traverseLevelOrderUsingQueue} method
     * that runs in O(n)
     */
    public void traverseLevelOrderByIteration() {
        for (int i = 0; i <= height(); i++)
            for (var item : getNodesAtDistance(i))
                System.out.print(item + " ");
    }

    /**
     * Runs in O(n)
     */
    public void traverseLevelOrderUsingQueue() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node tempNode = queue.remove();
            System.out.print(tempNode.value + " ");
            if (tempNode.leftChild != null)
                queue.add(tempNode.leftChild);

            if (tempNode.rightChild != null)
                queue.add(tempNode.rightChild);
        }
    }
}