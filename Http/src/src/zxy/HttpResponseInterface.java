package src.zxy;

import java.io.BufferedOutputStream;
import java.io.IOException;

public interface HttpResponseInterface {
    void Handle(String method, String body, StringBuffer header, BufferedOutputStream ostream) throws IOException;
}
