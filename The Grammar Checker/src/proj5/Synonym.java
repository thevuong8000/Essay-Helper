package proj5;

/**
 * A synonym object implementing containable that is a synonym of a word
 * author: Son Nguyen (Kyrie)
 * version: 6/3/2020
 */
public class Synonym implements Containable {

    // instance variable
    private String synonym;

    /**
     * Constructor
     * @param word word to get synonym
     */
    public Synonym(String word) {
        synonym = word;
    }

    /**
     * compare two synonyms
     * @param other another synonym
     * @return true if two synonyms are the same, false otherwise
     */
    public boolean equals(Object other) {
        if (other instanceof Synonym) {
            return toString().equals(other.toString());
        }
        return false;
    }

    /**
     * @return string representation of this synonym object
     */
    public String toString() {
        return synonym;
    }

}
