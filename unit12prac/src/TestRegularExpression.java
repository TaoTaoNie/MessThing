import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author leetHuam
 * @version 1.0
 */
public class TestRegularExpression {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage:\n java TestRegularExpression " +
            "characterSequence regularExpression+");
            System.exit(0);
        }
        System.out.println("Input: \"" + args[0] + "\"");
        for (int i = 1; i < args.length; i++) {
            System.out.println("RegularExpression: \"" + args[i] + "\"");
            Pattern p = Pattern.compile(args[i]);
            Matcher matcher = p.matcher(args[0]);
            System.out.println("Match \"" + args[i] + "\" : " + matcher.find() + matcher.group());

        }
        Pattern pattern = Pattern.compile(args[1]);
        Matcher matcher = pattern.matcher(args[0]);
        System.out.println("RegularExpression: \"" + args[0] + "\"");
        System.out.println("Match \"" + args[1] + "\" : " + matcher.find());
    }

}
