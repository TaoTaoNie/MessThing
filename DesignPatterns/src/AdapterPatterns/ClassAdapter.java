package AdapterPatterns;

import java.io.IOException;
import java.io.InputStream;

/**
 * 这是一个类适配器的例子，类适配器就是通过继承现有类和目标接口，再通过相应的操作可以写成一个适配器
 * @author leetHuam
 * @version 1.0
 */
public class ClassAdapter extends B implements ReaderXml  {
    @Override
    public InputStream readerXml() throws IOException {
        return xmlReader();
    }
}
