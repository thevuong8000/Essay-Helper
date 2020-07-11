package proj5;

/**
 * sample client for grammar checker
 * author: Son Nguyen (Kyrie)
 * version: 6/3/2020
 */
public class Client
{
    public static void main(String[] args) {
        BinarySearchTree<Integer> testTree = new BinarySearchTree<Integer>();
        testTree.insert(42);
        testTree.insert(53);
        testTree.insert(31);
        testTree.insert(7);
        testTree.insert(92);
        testTree.insert(50);

        System.out.println(testTree.toString());
        System.out.println(testTree.height());
        testTree.delete(50);
        testTree.insert(100);
        testTree.delete(7);
        System.out.println(testTree.toString());
        System.out.println(testTree.height());


        Thesaurus testThesaurus = new Thesaurus("src/smallThesaurus.txt");
        System.out.println("Synonym for chuckalaboomboom: " + testThesaurus.getSynonymFor("chuckalaboomboom"));
        System.out.println("Synonym for whirlpool: " + testThesaurus.getSynonymFor("whirlpool"));
        System.out.println(testThesaurus.toString());
        testThesaurus.insert("blue", new String[]{"bleu"});
        testThesaurus.delete("whirlpool");
        System.out.println("Synonym for whirlpool: " + testThesaurus.getSynonymFor("whirlpool"));
        System.out.println(testThesaurus.toString());

        WordCounter testWordCounter = new WordCounter();
        testWordCounter.findFrequencies("src/nonsense.txt");
        System.out.println(testWordCounter.toString());
        System.out.println("Count of hi: " + testWordCounter.getFrequency("hi"));

        GrammarChecker testGrammarChecker = new GrammarChecker("src/bigThesaurus.txt", 2);
        testGrammarChecker.improveGrammar("src/apartment.txt");
        System.out.println();
        testGrammarChecker.improveGrammar("src/lamb.txt");

    }
}
