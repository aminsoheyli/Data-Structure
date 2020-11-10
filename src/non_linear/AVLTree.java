package non_linear;

public class AVLTree {
    private class AVLNode {
        private int value;
        private int height;
        private AVLNode leftChild;
        private AVLNode rightChild;


        public AVLNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    private AVLNode root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private AVLNode insert(AVLNode root, int value) {
        if (root == null)
            return new AVLNode(value);

        if (value < root.value)
            root.leftChild = insert(root.leftChild, value);
        else if (value > root.value)
            root.rightChild = insert(root.rightChild, value);

        setHeight(root);

        return balance(root);
    }

    private AVLNode balance(AVLNode node) {
        var balanceFactor = balanceFactor(node);
        if (isLeftHeavy(node)) {
            if (balanceFactor(node.leftChild) < 0)
                node.leftChild = rotateLeft(node.leftChild);
            return rotateRight(node);
        } else if (isRightHeavy(node)) {
            if (balanceFactor(node.rightChild) > 0)
                node.rightChild = rotateRight(node.rightChild);
            return rotateLeft(node);
        }

        return node;
    }

    private AVLNode rotateLeft(AVLNode root) {
        var newRoot = root.rightChild;

        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private AVLNode rotateRight(AVLNode root) {
        var newRoot = root.leftChild;

        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private void setHeight(AVLNode node) {
        node.height = Math.max(
                height(node.leftChild),
                height(node.rightChild)) + 1;
    }

    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(AVLNode node) {
        return node == null ? 0 : height(node.leftChild) - height(node.rightChild);
    }

    private int height(AVLNode node) {
        return node == null ? -1 : node.height;
    }
}
