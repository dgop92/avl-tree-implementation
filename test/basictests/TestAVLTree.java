package basictests;

import org.junit.Test;

import app.avltree.AVLTree;
import app.avltree.Node;
import junit.framework.TestCase;

public class TestAVLTree extends TestCase {

    @Test
    public void testSomethingDummy() {
        System.out.println("Look in debug console this text");
        assertEquals(10, 10);
    }

    @Test
    public void testBSTInvariant() {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(10);
        avlTree.insert(5);
        avlTree.insert(3);
        StringBuilder stringBuilder = new StringBuilder();
        avlTree.inOrderTraversal(node -> stringBuilder.append(node.data));
        assertEquals("3510", stringBuilder.toString());
    }

    @Test
    public void testSearchNode() {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(10);
        avlTree.insert(5);
        avlTree.insert(9);
        avlTree.insert(34);

        Node foundNode = avlTree.searchNode(9);
        assertEquals(9, foundNode.data);

        Node foundNode2 = avlTree.searchNode(92);
        assertEquals(null, foundNode2);
    }
}
