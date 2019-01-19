/**
 * @author leetHuam
 * @version 1.0
 */
public class Caller {
    private Incrementable callbackReference;
    Caller(Incrementable cbn) {callbackReference = cbn;}
    void go() {callbackReference.increment();}
}
