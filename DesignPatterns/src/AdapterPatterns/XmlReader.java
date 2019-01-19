package AdapterPatterns;

import java.io.IOException;
import java.io.InputStream;

public interface XmlReader {
    InputStream xmlReader() throws IOException;
}
