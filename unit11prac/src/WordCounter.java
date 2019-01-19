import java.util.Comparator;

/**
 * @author leetHuam
 * @version 1.0
 */
public class WordCounter {
    private final String word;
    public static final Comparator<WordCounter> CASE_INSENSITIVE_ORDER = new Comparator<WordCounter>() {
        @Override
        public int compare(WordCounter o1, WordCounter o2) {
            return o1.word.compareToIgnoreCase(o2.word);
        }
    };
    private int frequency;

    WordCounter(String word) {
        this.word = word;
        frequency = 1;
    }

    void incFrequency() {++frequency;}

    public boolean equals(Object o) {
        return o instanceof WordCounter && word.equals(((WordCounter)o).word);
    }

    public int hashCode() {return word.hashCode();}
}
