import java.util.Arrays;

public interface Selector {
    boolean end();
    Object current();
    void next();
}
