package ymz;

import ntt.SimpleInterface;

/**
 * @author leetHuam
 * @version 1.0
 */
public class SimpleClass {
    protected class Inner implements SimpleInterface {
        public Inner() {}
        public void f() {}
    }
}
