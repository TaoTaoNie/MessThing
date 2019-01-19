import java.util.HashMap;
import java.util.Map;

/**
 * @author leetHuam
 * @version 1.0
 */
public class ClassTypeCapture<T> {
    private Class<T> kind;
    private Map<String, Class<?>> types = new HashMap<String, Class<?>>();

    public Object createNew(String typeName) {
        Class<?> c1 = types.get(typeName);
        try {
            return c1.newInstance();
        }catch (NullPointerException e) {
            System.out.println("Not a registered typename: " + typeName);
        }catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }

    public void addType(String typeName, Class<?> kind) {
        types.put(typeName, kind);
    }

    private ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    private boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<>(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));
        ClassTypeCapture<House> ctt2 = new ClassTypeCapture<>(House.class);
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));
    }
}
