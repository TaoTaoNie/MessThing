package atomic;

/**
 * @author leetHuam
 * @version 1.0
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    public static synchronized int nextSerialNumber() {
        return serialNumber++;
    }
}
