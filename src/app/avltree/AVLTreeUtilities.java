package app.avltree;

public class AVLTreeUtilities {

    /**
     * Compute the height of a node.
     * 
     * @param root a {@code Node}
     * @return height of node. if node is {@code null}, {@code -1} is returned
     */
    public static int getHeight(Node root) {
        return root == null ? -1 : root.height;
    }

    /**
     * Update the height of a node returning a new height
     * 
     * @param root a {@code Node}
     * @return the new height of the node
     */
    public static int getNewHeight(Node root) {
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    /**
     * Get the balance of a node
     * 
     * @param root a {@code Node}
     * @return balance of node. if node is {@code null}, {@code 0} is returned
     */
    public static int getBalance(Node root) {
        if (root == null) {
            return 0;
        }

        return getHeight(root.left) - getHeight(root.right);
    }
    
    /**
     * obtain the node with the minimum value of a tree
     * 
     * @param root a {@code Node}
     * @return node with minimum value
     */
    public static Node minimunNodeOfTree(Node root) {
        Node current = root;

        if (current.left != null) {
            current = current.left;
        }

        return current;
    }

}
