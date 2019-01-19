package ObserverPatterns;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leetHuam
 * @version 1.0
 */
public class WechatServer implements Observerable {
    private List<Observer> list;
    private String message;

    public WechatServer() {
        list = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Object o : list) {
            ((Observer)o).update(message);
        }
    }

    public void setInformation(String message) {
        this.message = message;
        System.out.println("微信更新消息：" + message);
        notifyObserver();;
    }
}
