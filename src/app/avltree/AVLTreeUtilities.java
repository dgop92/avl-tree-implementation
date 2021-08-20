package app.avltree;

public class AVLTreeUtilities {

    public static int getHeight(Node root) {
        return root == null ? -1 : root.height;
    }

    public static int getNewHeight(Node root) {
        return 1 + Math.max(
            getHeight(root.left), 
            getHeight(root.right)
        );
    }
    
    public static int getBalance(Node root) {
        if (root == null) {
            return 0;
        }

        return getHeight(root.left) - getHeight(root.right);
    }

    
    
}
