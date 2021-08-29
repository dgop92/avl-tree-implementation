package basictests;

import org.junit.Test;

import app.avltree.AVLTree;
import app.avltree.AVLTreeUtilities;
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

    @Test
    public void testAVLInvariant() {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(10);
        avlTree.insert(5);
        avlTree.insert(3);
        StringBuilder stringBuilder, stringBuilder2;
        stringBuilder = new StringBuilder();
        avlTree.preOrderTraversal(node -> {
            stringBuilder.append(node.data);
            assertTrue(Math.abs(AVLTreeUtilities.getBalance(node)) <= 1);
        });
        assertEquals("5310", stringBuilder.toString());

        // case two
        avlTree.clean();
        assertEquals(null, avlTree.getRoot());

        avlTree.insert(20);
        avlTree.insert(10);
        avlTree.insert(9);
        avlTree.insert(8);
        avlTree.insert(11);
        avlTree.insert(30);

        stringBuilder2 = new StringBuilder();
        avlTree.preOrderTraversal(node -> {
            stringBuilder2.append(node.data);
            assertTrue(Math.abs(AVLTreeUtilities.getBalance(node)) <= 1);
        });
        assertEquals("1098201130", stringBuilder2.toString());

    }

    @Test
    public void testDeleteNodeRotateLL() {
        AVLTree avlTree = new AVLTree();
        // left-left case
        avlTree.insert(5);
        avlTree.insert(3);
        avlTree.insert(4);
        avlTree.insert(1);
        avlTree.insert(6);
        avlTree.insert(7);

        avlTree.delete(6);
        avlTree.delete(7);
        avlTree.delete(4);

        StringBuilder stringBuilder = new StringBuilder();
        avlTree.postOrderTraversal(node -> {
            stringBuilder.append(node.data);
            assertTrue(Math.abs(AVLTreeUtilities.getBalance(node)) <= 1);
        });
        assertEquals("153", stringBuilder.toString());

    }

    @Test
    public void testDeleteRotateLR() {
        AVLTree avlTree = new AVLTree();

        avlTree.insert(6);
        avlTree.insert(5);
        avlTree.insert(7);
        avlTree.insert(8);
        avlTree.insert(9);
        avlTree.insert(3);
        avlTree.insert(4);

        avlTree.delete(9);
        avlTree.delete(7);
        avlTree.delete(8);
        avlTree.delete(6);

        StringBuilder stringBuilder = new StringBuilder();
        avlTree.preOrderTraversal(node -> {
            stringBuilder.append(node.data);
            assertTrue(Math.abs(AVLTreeUtilities.getBalance(node)) <= 1);
        });
        assertEquals("435", stringBuilder.toString());

    }

    // right right case
    @Test
    public void testDeleteRotateRR() {
        AVLTree avlTree = new AVLTree();

        avlTree.clean();

        avlTree.insert(10);
        avlTree.insert(15);
        avlTree.insert(20);
        avlTree.insert(5);
        avlTree.insert(6);

        avlTree.delete(5);
        avlTree.delete(6);

        StringBuilder stringBuilder = new StringBuilder();
        avlTree.preOrderTraversal(node -> {
            stringBuilder.append(node.data);
            assertTrue(Math.abs(AVLTreeUtilities.getBalance(node)) <= 1);
        });
        assertEquals("151020", stringBuilder.toString());

    }

    // Right Left case
    @Test
    public void testDeleteRotateRL() {
        AVLTree avlTree = new AVLTree();

        avlTree.clean();

        avlTree.insert(10);
        avlTree.insert(15);
        avlTree.insert(12);
        avlTree.insert(6);

        avlTree.delete(6);

        StringBuilder stringBuilder = new StringBuilder();
        avlTree.preOrderTraversal(node -> {
            stringBuilder.append(node.data);
            assertTrue(Math.abs(AVLTreeUtilities.getBalance(node)) <= 1);
        });
        assertEquals("121015", stringBuilder.toString());

    }

    @Test
    public void testInsertRotateLL() {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(5);
        avlTree.insert(3);

        avlTree.insert(1);
        StringBuilder stringBuilder = new StringBuilder();
        avlTree.postOrderTraversal(node -> {
            stringBuilder.append(node.data);
            assertTrue(Math.abs(AVLTreeUtilities.getBalance(node)) <= 1);
        });
        assertEquals("153", stringBuilder.toString());
    }

    @Test
    public void testInsertRotateLR() {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(5);
        avlTree.insert(3);
        avlTree.insert(4);

        StringBuilder stringBuilder = new StringBuilder();
        avlTree.preOrderTraversal(node -> {
            stringBuilder.append(node.data);
            assertTrue(Math.abs(AVLTreeUtilities.getBalance(node)) <= 1);
        });
        assertEquals("435", stringBuilder.toString());
    }

    @Test
    public void testInsertRotateRR() {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(10);
        avlTree.insert(15);

        avlTree.insert(20);
        StringBuilder stringBuilder = new StringBuilder();
        avlTree.preOrderTraversal(node -> {
            stringBuilder.append(node.data);
            assertTrue(Math.abs(AVLTreeUtilities.getBalance(node)) <= 1);
        });
        assertEquals("151020", stringBuilder.toString());
    }

    @Test
    public void testInsertRotateRL() {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(10);
        avlTree.insert(15);

        avlTree.insert(12);
        StringBuilder stringBuilder = new StringBuilder();
        avlTree.preOrderTraversal(node -> {
            stringBuilder.append(node.data);
            assertTrue(Math.abs(AVLTreeUtilities.getBalance(node)) <= 1);
        });
        assertEquals("121015", stringBuilder.toString());
    }

    @Test
    public void testBFdelta() {
        AVLTree avlTree = new AVLTree();

        avlTree.insert(10);
        avlTree.insert(15);
        avlTree.insert(12);

        StringBuilder stringBuilder = new StringBuilder();
        avlTree.preOrderTraversal(node -> {
            stringBuilder.append(node.data);
            assertTrue(Math.abs(AVLTreeUtilities.getBalance(node)) <= 1);
        });
        assertEquals("121015", stringBuilder.toString());
    }
}
