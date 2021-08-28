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

    /**
     * Find node given its data attribute
     *
     * @param action A callback function with the node being proecced
     */
    public Node searchNode(int data) {
        return search(data, this.root);
    }

    private Node search(int data, Node root) {
        if (root != null) {
            if (data > root.data) {
                search(data, root.right);
            } else if (data < root.data) {
                search(data, root.left);
            } else {
                return root;
            }
        }
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
        String url =
            "https://dgop92.github.io/binary-tree-builder/?indextree=%s";
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

    public Node deleteNode(Node root, int data) {
        if (root == null) {
            return root;
        }

        if (data < root.data) {
            root.left = deleteNode(root.left, data);
        } else if (data > root.data) {
            root.right = deleteNode(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            Node minNode = AVLTreeUtilities.minimunNodeOfTree(root.right);
            root.data = minNode.data;
            root.right = deleteNode(root.right, minNode.data);
        }

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
