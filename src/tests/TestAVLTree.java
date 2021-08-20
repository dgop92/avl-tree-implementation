package tests;

import org.junit.Test;

import app.avltree.AVLTree;
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
}
