/**
 * @author leetHuam
 * @version 1.0
 */
public class LoggingExceptions {
    public static void main(String[] args) {
        try{
            throw new LoggingException();
        }catch (Exception e) {
            System.err.println("Caught: " + e);
        }
        try{
            throw new LoggingException();
        }catch (Exception e){
            System.err.println("Caught: " + e);
        }
    }

}
