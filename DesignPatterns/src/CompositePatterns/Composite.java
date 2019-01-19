package CompositePatterns;

import java.util.ArrayList;

/**
 * @author leetHuam
 * @version 1.0
 */
public class Composite extends Component {
    private ArrayList<Component> list = new ArrayList<>();

    @Override
    public void add(Component component) {
        list.add(component);
    }

    @Override
    public void remove(Component component) {
        list.remove(component);
    }

    @Override
    public void operation() {
        for (Object obj : list)
            ((Component)obj).operation();
    }

    @Override
    public  Component  getChild(int i) {
        return (Component)list.get(i);
    }
}
