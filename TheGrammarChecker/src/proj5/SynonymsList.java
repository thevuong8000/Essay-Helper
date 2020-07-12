

/**
 * A bag of synonym objects that holds synonyms of a word
 * author: Son Nguyen (Kyrie)
 * version: 6/3/2020
 */
public class SynonymsList implements Comparable<SynonymsList> {

    // instance variables
    private String keyword;
    private GenericContainableBag<Synonym> synonyms;

    /**
     * Contain a keyword following by its synonyms
     * @param keyword the keyword
     * @param synonyms list of synonyms
     */
    public SynonymsList(String keyword, String[] synonyms) {
        this.keyword = keyword;
        this.synonyms = new GenericContainableBag<Synonym>(synonyms.length);
        for (int i = 0; i < synonyms.length; i++) {
            Synonym toAdd = new Synonym(synonyms[i]);
            this.synonyms.add(toAdd);
        }
    }

    /**
     * @return the keyword of the synonyms list
     */
    public String getKeyword() {
        return this.keyword;
    }

    /**
     * @return a random synonym
     */
    public Synonym getSynonym() {
        return this.synonyms.grabRandom();
    }

    /**
     * add new synonym to this synonyms list
     * @param synonym a new synonym
     */
    public void add(String synonym) {
        Synonym toAdd = new Synonym(synonym);
        synonyms.add(toAdd);
    }

    /**
     * compare two lists of synonyms by theirs keywords
     * @param other another list of synonyms
     * @return compareTo of theirs keywords
     */
    public int compareTo(SynonymsList other) {
        return keyword.compareTo(other.keyword);
    }

    /**
     * @return string representation of a list of synonyms of a word
     */
    public String toString() {
        String toReturn =  keyword + " - " + synonyms + "\n";
        return toReturn;
    }
}
