
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;

/**
 * test the functionality of BinarySearchTree.java
 * author: Son Nguyen (Kyrie)
 * version: 6/3/2020
 */
public class BSTTest {

    @Rule // a test will fail if it takes longer than 1/10 of a second to run
    public Timeout timeout = Timeout.millis(100);

    private BinarySearchTree<String> empty;

    @Before
    public void setUp() throws Exception {
        empty = new BinarySearchTree<String>();
    }

    @After
    public void tearDown() throws Exception {
        empty = null;
    }

    private BinarySearchTree<Integer> makeSampleBST() {
        BinarySearchTree<Integer> sample = new BinarySearchTree<Integer>();
        int[] sampleNodes = new int[]{270, 151, 333, 120, 250, 329, 370, 105, 234, 260, 320, 499};
        for (int sampleNode: sampleNodes) {
            sample.insert(sampleNode);
        }
        return sample;
    }

    @Test // string representation of a binary search tree
    public void testToString() {
        assertEquals("", empty.toString());

        BinarySearchTree<Integer> sample = makeSampleBST();
        String expected = "105120151234250260270320329333370499";
        assertEquals(expected, sample.toString());
    }

    @Test // insert a new item to a binary search tree
    public void testInsert() {
        empty.insert("Delete");
        empty.insert("Insert");
        empty.insert("Append");
        String expected1 = "AppendDeleteInsert";
        assertEquals(expected1, empty.toString());

        BinarySearchTree<Integer> sample = makeSampleBST();
        sample.insert(380);
        String expected = "105120151234250260270320329333370380499";
        assertEquals(expected, sample.toString());
    }

    @Test // delete an item in a binary search tree
    public void testDelete() {
        empty.delete("Anything");
        assertEquals("",empty.toString());
        empty.insert("Delete");
        empty.insert("Insert");
        empty.insert("Append");
        empty.delete("Delete");
        String expected1 = "AppendInsert";
        assertEquals(expected1, empty.toString());

        BinarySearchTree<Integer> sample = makeSampleBST();
        String original = sample.toString();
        sample.delete(380);
        assertEquals(original, sample.toString());
        sample.delete(105);
        String expected2 = "120151234250260270320329333370499";
        assertEquals(expected2, sample.toString());
        sample.delete(333);
        String expected3 = "120151234250260270320329370499";
        assertEquals(expected3, sample.toString());
    }

    @Test // search an item in a binary search tree
    public void testSearch() {
        assertNull(empty.search("Anything"));
        empty.insert("Delete");
        empty.insert("Insert");
        empty.insert("Append");
        empty.delete("Delete");
        assertEquals("Insert", empty.search("Insert"));

        BinarySearchTree<Integer> sample = makeSampleBST();
        assertNull(sample.search(380));
        assertEquals((Integer) 260, sample.search(260));
        assertEquals((Integer) 151, sample.search(151));
    }
}
