package app.avltree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

public class AVLTree {

    private Node root;

    public AVLTree() {
        this.root = null;
    }

    /**
     * Set the root of the tree to null. Deleting all the data
     */
    public void clean() {
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
     * Delete data from the tree
     *
     * @param data an int value
     */
    public void delete(int data) {
        this.root = deleteNode(this.root, data);
    }

    /**
     * Traverse the tree using inOrder traversal
     *
     * @param action A callback function with the node being processed
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

    /**
     * Traverse the tree using preOrder traversal
     *
     * @param action A callback function with the node being processed
     */
    public void preOrderTraversal(Consumer<Node> action) {
        preOrder(this.root, action);
    }

    private void preOrder(Node root, Consumer<Node> action) {
        if (root != null) {
            action.accept(root);
            preOrder(root.left, action);
            preOrder(root.right, action);
        }

    }

    /**
     * Traverse the tree using postOrder traversal
     *
     * @param action A callback function with the node being processed
     */
    public void postOrderTraversal(Consumer<Node> action) {
        postOrder(this.root, action);
    }

    private void postOrder(Node root, Consumer<Node> action) {
        if (root != null) {
            preOrder(root.left, action);
            preOrder(root.right, action);
            action.accept(root);
        }
    }

    public void levelOrderTraversal(Consumer<Node> action) {
        int h = root.height;
        for (int i = 0; i <= h; i++)
            printCurrentLevel(root, i, action);
    }

    /* Print nodes at the current level */
    private void printCurrentLevel(Node root, int level, Consumer<Node> action) {
        if (root == null)
            return;
        if (level == 0)
            action.accept(root);
        else if (level > 0) {
            printCurrentLevel(root.left, level - 1, action);
            printCurrentLevel(root.right, level - 1, action);
        }
    }

    /**
     * Find node given its data attribute
     *
     * @param action A callback function with the node being processed
     */
    public Node searchNode(int data) {
        return search(data, this.root);
    }

    private Node search(int data, Node root) {
        // this algorithm runs the tree while the root is not equal to null,
        // using the BST rules
        while (root != null) {
            if (data > root.data) {
                root = root.right;
            } else if (data < root.data) {
                root = root.left;
            } else {

                // if it's not > or < then it's the same and that case
                // we return that node
                return root;
            }
        }

        // finally return the node searched or in case of it doesn´t appears
        // it returns null
        return root;
    }

    public String getArrayRepresentation() {

        // if the tree is empty returns empty string
        if (this.root == null) {
            return "";
        }

        // breadth first search with modifications
        // to save the indexes of the nodes

        Queue<Node> queue = new LinkedList<>();
        Queue<Integer> indexQueue = new LinkedList<>();
        ArrayList<Node> bfsNodes = new ArrayList<>();
        ArrayList<Integer> indexes = new ArrayList<>();

        queue.add(this.root);
        indexQueue.add(0);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int currentIndex = indexQueue.poll();
            indexes.add(currentIndex);
            bfsNodes.add(current);

            if (current.left != null) {
                queue.add(current.left);
                indexQueue.add(currentIndex * 2 + 1);
            }
            if (current.right != null) {
                queue.add(current.right);
                indexQueue.add(currentIndex * 2 + 2);
            }
        }

        // create the array representation
        String arrayRepresentation = this.root.data + ",";
        for (int i = 1; i < indexes.size(); i++) {
            int previous = indexes.get(i - 1);
            int current = indexes.get(i);

            for (int j = previous + 1; j < current; j++) {
                arrayRepresentation += "null,";
            }
            arrayRepresentation += bfsNodes.get(i).data + ",";
        }

        // use regex to trim trailing commas
        return arrayRepresentation.replaceAll(",+$", "");
    }

    /**
     * Get a link for visualizing the tree
     * 
     * @return url
     */
    public String getLinkForVisualization() throws Exception {
        String arrayRepresentation = getArrayRepresentation();
        if (arrayRepresentation.equals("")) {
            throw new Exception("Empty tree");
        }
        String url = "https://dgop92.github.io/binary-tree-builder/?indextree=%s";
        return String.format(url, arrayRepresentation);
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

    private Node deleteNode(Node root, int data) {

        // return null if the node doesn't esxist
        if (root == null) {
            return root;
        }

        /*
         * we proceed to search the node comparing the given value with the value of
         * each node visited, following the rules of the BST variant
         */
        if (data < root.data) {
            root.left = deleteNode(root.left, data);
        } else if (data > root.data) {
            root.right = deleteNode(root.right, data);
        } else {

            /**
             * when the node is found, we follow with the elimination depending of the case:
             * if it's a leaf node, a node with one child or one node with two childs
             */

            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            /*
             * if the node has not a null link, it means the node has two childs; in that
             * case we search the minimun node of the Tree, after we change the data in the
             * node to delete and we finally eliminate the node that replaced the original
             * one
             */

            Node minNode = AVLTreeUtilities.minimunNodeOfTree(root.right); // Search the minimun
            root.data = minNode.data; // change the value of original for the minimun
            root.right = deleteNode(root.right, minNode.data); // Deleting the minimun node
        }

        /*
         * Later to do the delete operation we run the ancestors of the modified node
         * seing if there is a change in the height of these, getting their BF or
         * balance factor, if the BF of some ancestor node is not between -1 and 1, we
         * do the respective rotations; whether simple, doble, left or right.
         */

        // The following code is executed while backtracking to the tree root

        // update the height of the node
        root.height = AVLTreeUtilities.getNewHeight(root);

        // According to the balance of the node apply the respective rotations
        int balance = AVLTreeUtilities.getBalance(root);

        // Left Left Case
        if (balance > 1 && AVLTreeUtilities.getBalance(root.left) >= 0) {
            return rightRotate(root);
        }

        // Left Right
        if (balance > 1 && AVLTreeUtilities.getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right
        if (balance < -1 && AVLTreeUtilities.getBalance(root.right) <= 0) {
            return leftRotate(root);
        }

        // Right Left
        if (balance < -1 && AVLTreeUtilities.getBalance(root.right) > 0) {
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
