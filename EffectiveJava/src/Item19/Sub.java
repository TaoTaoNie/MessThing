package Item19;

import java.io.Serializable;
import java.time.Instant;

/**
 * @author leetHuam
 * @version 1.0
 */
public class Sub extends Super implements Serializable {
    private final Instant instant;
    Sub() {
        instant = Instant.now();
    }

    @Override
    public void overrideMe() {
        System.out.println(instant);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();
    }
}
