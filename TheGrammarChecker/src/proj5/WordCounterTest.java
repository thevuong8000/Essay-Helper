
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;

/**
 * test the functionality of Counter.java and WordCounter.java
 * author: Son Nguyen (Kyrie)
 * version: 6/3/2020
 */
public class WordCounterTest {

    @Rule // a test will fail if it takes longer than 1/10 of a second to run
    public Timeout timeout = Timeout.millis(100);

    private WordCounter wc;

    @Before
    public void setUp() throws Exception {
        wc = new WordCounter();
    }

    @After
    public void tearDown() throws Exception {
        wc = null;
    }

    @Test // string representation of word counter
    public void testToString(){
        assertEquals("", wc.toString());
        wc.findFrequencies("src/nonsense.txt");
        String expected = "have: 1\n" +
                "hi: 6\n" +
                "if: 1\n" +
                "line: 1\n" +
                "probably: 1\n" +
                "reading: 1\n" +
                "seconds: 1\n" +
                "spend: 1\n" +
                "this: 1\n" +
                "three: 1\n" +
                "time: 1\n" +
                "wasted: 1\n" +
                "you: 2\n";
        assertEquals(expected, wc.toString());
    }

    @Test // get frequency of a word
    public void testGetFrequency() {
        wc.findFrequencies("src/nonsense.txt");
        assertEquals(6, wc.getFrequency("hi"));
        assertEquals(2, wc.getFrequency("you"));
        assertEquals(1, wc.getFrequency("three"));
        assertEquals(0, wc.getFrequency("iPhone"));
    }
}
