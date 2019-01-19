package AdapterPatterns;

import java.io.IOException;
import java.io.InputStream;

public interface ReaderXml {
    InputStream readerXml() throws IOException;
}
