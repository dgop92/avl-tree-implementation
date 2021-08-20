package app.avltree;

public class Node {

    public int data;
    public int height;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 0;
    }
}
