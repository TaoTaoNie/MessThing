package src.zxy;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description: class to test Java
 * <p>
 * User: admin
 * Date: 2017-12-07
 * Time: 下午10:54
 * JDK: 1.8
 * <p>
 * Created with IntelliJ IDEA.
 * Email 980321356@qq.com
 *
 * @author 聂涛涛
 * @version 1.0
 */
public class Test extends Thread{
    public static void main(String[] args) {
//        System.out.println("你好：");
//          System.out.println("\r\n");
//        System.out.println("我好");\
        try {
//            NumberFormat numberFormat = NumberFormat.getNumberInstance();
//            String string = "7%";
//            Number number = numberFormat.parse(string);
//            System.out.println(number);
//            double nu = new Double(string.substring(0,string.indexOf("%"))) / 100.0 / 12;
//            System.out.println(20.0*12);
//            DecimalFormat decimalFormat = new DecimalFormat("#.00");
//            System.out.println(decimalFormat.format(3.256987));
//            Pattern p = Pattern.compile( "^(((00\\d)|(\\d{1,2})|(1[0-1]\\d))(\\.\\d{0,2})?)|120(\\.[0]{0,2})?$");
            Pattern p = Pattern.compile( "(([0-9])|([1-9][0-9])|(1[0-1][0-9])|(120))");
            Matcher matcher = p.matcher("100");
            System.out.println(matcher.matches());
        }catch (Exception e) {

        }
    }
}
