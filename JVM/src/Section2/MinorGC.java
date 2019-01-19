package Section2;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * @author leetHuam
 * @version 1.0
 */
public class MinorGC {
    private static final int _1MB = 1024 * 1024;

    private void print() {}

    @SuppressWarnings("unused")
    private static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[_1MB / 4];
        allocation3 = new byte[4 * _1MB];
        allocation4 = new byte[4 * _1MB];
        allocation4 = null;
        allocation4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testAllocation();
    }
}
