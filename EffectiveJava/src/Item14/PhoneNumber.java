package Item14;

import java.util.Comparator;

/**
 * @author leetHuam
 * @version 1.0
 */
public class PhoneNumber implements Comparable<PhoneNumber>, Test{
    private int areaCode;
    private int prefix;
    private int lineNum;

    private static final Comparator<PhoneNumber> COMPARATOR = Comparator.comparingInt((PhoneNumber pn) -> pn.areaCode).thenComparing(pn -> pn.prefix).thenComparing(pn -> pn.lineNum);

    public int compareTo(PhoneNumber pn) {
        return COMPARATOR.compare(this, pn);
    }

    public int add() {
        return 1;
    }
}
