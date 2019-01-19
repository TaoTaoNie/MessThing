import java.util.Iterator;

/**
 * @author leetHuam
 * @version 1.0
 */
public class E22_WordInfo2 {
    static void updateStat(Iterator<WordCounter> iterator, WordCounter wc) {
        while (iterator.hasNext()) {
            WordCounter currentWC = iterator.next();
            if (currentWC.equals(wc))
                currentWC.incFrequency();
        }
    }
}
