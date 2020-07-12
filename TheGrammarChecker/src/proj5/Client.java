

/**
 * sample client for grammar checker
 * author: Son Nguyen (Kyrie)
 * version: 6/3/2020
 */
public class Client
{
    public static void main(String[] args) {
        GrammarChecker testGrammarChecker = new GrammarChecker("../bigThesaurus.txt", 2);
        testGrammarChecker.improveGrammar("../../../input.txt");
    }
}
