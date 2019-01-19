import java.lang.reflect.*;

/**
 * @author leetHuam
 * @version 1.0
 */
public class ClassAsFactory<T> {
    Class<T> kind;
    public ClassAsFactory(Class<T> kind) {
        this.kind = kind;
    }
    public T create(int arg) {
        try{
            for (Constructor<?> constructor : kind.getConstructors()) {
                Class<?>[] params = constructor.getParameterTypes();
                if (params.length == 1)
                    if (params[0] == int.class)
                        return kind.cast(constructor.newInstance(arg));
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
