package proj5;

/**
 * A counter object that counts the number of appearance
 * of a word in a paragraph
 * author: Son Nguyen (Kyrie)
 * version: 6/3/2020
 */
public class Counter implements Comparable<Counter> {

    // instance variables
    private String word;
    private Integer count;

    /**
     * count the number of appearance of a word in a paragraph
     * @param word word needed to be counted
     */
    public Counter(String word) {
        this.word = word;
        count = 0;
    }

    /**
     * @return number of appearance
     */
    public Integer getCount() {
        return count;
    }

    /**
     * increase number of appearance
     */
    public void increment() {
        count++;
    }

    /**
     * decrease number of appearance
     */
    public void decrement() {
        count--;
    }

    /**
     * compare two counters
     * @param other another counter object
     * @return the compareTo of two words of those counters
     */
    public int compareTo(Counter other) {
        return word.compareTo(other.word);
    }

    /**
     * @return string representation of this counter
     */
    public String toString() {
        String toReturn = word +": " + count + "\n";
        return toReturn;
    }
}
