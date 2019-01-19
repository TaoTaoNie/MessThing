package Section2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leetHuam
 * @version 1.0
 */
public class HeapOOM {
    static class OOMObject {}
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
