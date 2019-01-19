package AdapterPatterns;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author leetHuam
 * @version 1.0
 */
public class B implements XmlReader {
    @Override
    public InputStream xmlReader() throws IOException{
        return new FileInputStream("test.txt");
    }
}
