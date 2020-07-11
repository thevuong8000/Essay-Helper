package proj5;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;

/**
 * test the functionality of Synonym.java, SynonymsList.java,
 * and Thesaurus.java since all methods in Synonym.java and
 * SynonymsList.java are used in Thesaurus.java
 * author: Son Nguyen (Kyrie)
 * version: 6/3/2020
 */
public class ThesaurusTest {
    @Rule // a test will fail if it takes longer than 1/10 of a second to run
    public Timeout timeout = Timeout.millis(100);

    private Thesaurus makeDefaultThesaurus() {
        Thesaurus sample = new Thesaurus();
        return sample;
    }

    private Thesaurus makeSpecificThesaurus(String file) {
        Thesaurus sample = new Thesaurus(file);
        return sample;
    }

    @Test // string representation of a thesaurus;
    public void testToString() {
        Thesaurus defaultThesaurus = makeDefaultThesaurus();
        defaultThesaurus.insert("blue", new String[]{"turquoise","sad","cyan","azure",
                "cobalt","navy","powder blue","indigo","peacock","ultramarine","aquamarine"});
        defaultThesaurus.insert("grungy",new String[]{"dingy","dirty","dusty","grimy",
                "grubby","messy","miry","muddy","scruffy","slovenly","smirchy","smoky","smudgy",
                "smutchy","smutty","snuffy","sooty","untidy"});
        String expected = "blue - {turquoise, sad, cyan, azure, cobalt, navy, powder blue, indigo, peacock, ultramarine, aquamarine}\n" +
                "grungy - {dingy, dirty, dusty, grimy, grubby, messy, miry, muddy, scruffy, slovenly, smirchy, smoky, smudgy, smutchy, smutty, snuffy, sooty, untidy}\n";
        assertEquals(expected, defaultThesaurus.toString());
    }

    @Test // delete a keyword and its synonyms
    public void testDelete() {
        Thesaurus defaultThesaurus = makeDefaultThesaurus();
        defaultThesaurus.insert("blue", new String[]{"turquoise","sad","cyan","azure",
                "cobalt","navy","powder blue","indigo","peacock","ultramarine","aquamarine"});
        defaultThesaurus.insert("grungy",new String[]{"dingy","dirty","dusty","grimy",
                "grubby","messy","miry","muddy","scruffy","slovenly","smirchy","smoky","smudgy",
                "smutchy","smutty","snuffy","sooty","untidy"});
        defaultThesaurus.delete("grungy");
        String expected = "blue - {turquoise, sad, cyan, azure, cobalt, navy, powder blue, indigo, peacock, ultramarine, aquamarine}\n";
        assertEquals(expected, defaultThesaurus.toString());
    }

    @Test // insert a keyword and its synonyms
    public void testInsert() {
        Thesaurus defaultThesaurus = makeDefaultThesaurus();
        defaultThesaurus.insert("blue", new String[]{"turquoise","sad","cyan","azure",
                "cobalt","navy","powder blue","indigo","peacock","ultramarine","aquamarine"});
        defaultThesaurus.insert("grungy",new String[]{"dingy","dirty","dusty","grimy",
                "grubby","messy","miry","muddy","scruffy","slovenly","smirchy","smoky","smudgy",
                "smutchy","smutty","snuffy","sooty","untidy"});
        String expected = "blue - {turquoise, sad, cyan, azure, cobalt, navy, powder blue, indigo, peacock, ultramarine, aquamarine}\n" +
                "grungy - {dingy, dirty, dusty, grimy, grubby, messy, miry, muddy, scruffy, slovenly, smirchy, smoky, smudgy, smutchy, smutty, snuffy, sooty, untidy}\n";
        assertEquals(expected, defaultThesaurus.toString());
    }

    @Test // get a synonym for a word
    public void testGetSynonym() {
        Thesaurus smallThesaurus = makeSpecificThesaurus("src/smallThesaurus.txt");
        assertEquals("", smallThesaurus.getSynonymFor("Kyrie"));
        assertFalse("nasty".equals(smallThesaurus.getSynonymFor("nasty")));
    }
}