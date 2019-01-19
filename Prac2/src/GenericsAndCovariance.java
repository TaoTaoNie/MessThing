import java.util.ArrayList;
import java.util.List;

/**
 * @author leetHuam
 * @version 1.0
 */
public class GenericsAndCovariance {
    List<? extends Fruit> flist= new ArrayList<Apple>();

//    List<? extends Fruit> flist = Arrays.asList(new Apple());
//    Apple a = (Apple)flist.get(0);
}

class Fruit {}
class Apple extends Fruit {}
class Jonathan extends Apple {}
class Orange extends Fruit {}
