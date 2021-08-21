package app.avltree;

import java.util.function.Consumer;

public class AVLTree {

    private Node root;

    public AVLTree() {
        this.root = null;
    }

    /**
     * Insert a new data into the tree
     * 
     * @param data an int value
     */
    public void insert(int data) {
        this.root = addNode(this.root, data);
    }

    /**
     * Traverse the tree using inOrder traversal
     * 
     * @param action A callback function with the node being proecced
     */
    public void inOrderTraversal(Consumer<Node> action) {
        inOrder(this.root, action);
    }

    private void inOrder(Node root, Consumer<Node> action) {
        if (root != null) {
            inOrder(root.left, action);
            action.accept(root);
            inOrder(root.right, action);
        }
    }

    private Node addNode(Node root, int data) {

        // Base case for these recursive function. 
        // if a leaf node is reached, append the node
        if (root == null) {
            return new Node(data);
        }

        // Conditionals to satisfy the BST tree invariant
        if (data < root.data) {
            root.left = addNode(root.left, data);
        } else {
            root.right = addNode(root.right, data);
        }

        // Note: the following code is executed after inserting the node
        // update the height of the node
        root.height = AVLTreeUtilities.getNewHeight(root);

        // According to the balance of the node apply the respective rotations

        int balance = AVLTreeUtilities.getBalance(root);

        // Left Left Case
        if (balance > 1 && data < root.left.data) {
            return rightRotate(root);
        }

        // Left Right
        if (balance > 1 && data > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right
        if (balance < -1 && data > root.right.data) {
            return leftRotate(root);

        }

        // Right Left
        if (balance < -1 && data < root.right.data) {
            root.right = this.rightRotate(root.right);
            return this.leftRotate(root);
        }

        return root;

    }

    private Node rightRotate(Node unbalancedNode) {

        Node newRoot = unbalancedNode.left;

        unbalancedNode.left = newRoot.right;
        newRoot.right = unbalancedNode;
        unbalancedNode.height = AVLTreeUtilities.getNewHeight(unbalancedNode);
        newRoot.height = AVLTreeUtilities.getNewHeight(newRoot);

        return newRoot;

    }

    private Node leftRotate(Node unbalancedNode) {

        Node newRoot = unbalancedNode.right;

        unbalancedNode.right = newRoot.left;
        newRoot.left = unbalancedNode;

        unbalancedNode.height = AVLTreeUtilities.getNewHeight(unbalancedNode);
        newRoot.height = AVLTreeUtilities.getNewHeight(newRoot);

        return newRoot;

    }

    public Node getRoot() {
        return root;
    }
}
