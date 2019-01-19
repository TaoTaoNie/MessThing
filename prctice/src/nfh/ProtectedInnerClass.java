package nfh;

import ntt.SimpleInterface;
import ymz.SimpleClass;

/**
 * @author leetHuam
 * @version 1.0
 */
public class ProtectedInnerClass extends SimpleClass {
    public SimpleInterface get()  {
        return new Inner();
    }

    public static void main(String[] args) {
        new ProtectedInnerClass().get().f();
    }
}
