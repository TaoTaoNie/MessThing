package AdapterPatterns;

import java.io.IOException;
import java.io.InputStream;

/**
 * 这是一个对象适配器，通过在适配器中使用被适配者的对象来完成相应的适配
 * @author leetHuam
 * @version 1.0
 */
public class InstanceAdapter implements ReaderXml {
    B adaptee = new B();

    @Override
    public InputStream readerXml() throws IOException {
        return adaptee.xmlReader();
    }
}
