package Array;

/**
 * 剑指offer-P51
 * @author leetHuam
 * @version 1.0
 */
public class ReplaceBlank {
    /**
     * 请实现一个函数， 把字符串中的每个空格替换为 "%20" .例如，输入 "We are happy.", 则输出 "We%20are%20happy."
     * @param str 输入的字符串
     */
    private static void replaceBlank(StringBuffer str) {
        if (str == null || str.length() <= 0)
            return;
        int originalLength = 0;
        int numberOfBlank = 0;
        for (int i = 0; i < str.length(); i++) {
            ++originalLength;
            if (Character.isSpaceChar(str.charAt(i)))
                ++numberOfBlank;
        }
        int newLength = originalLength + numberOfBlank * 2;
        str.setLength(newLength);
        int indexOfOriginal = originalLength - 1;
        int indexOfNew = newLength - 1;
        while (indexOfOriginal >= 0 && indexOfNew > indexOfOriginal) {
            if (Character.isSpaceChar(str.charAt(indexOfOriginal))) {
                str.setCharAt(indexOfNew--, '0');
                str.setCharAt(indexOfNew--, '2');
                str.setCharAt(indexOfNew--, '%');
            }else {
                str.setCharAt(indexOfNew--, str.charAt(indexOfOriginal));
            }
            --indexOfOriginal;
        }
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("we are");
        replaceBlank(stringBuffer);
        System.out.println(stringBuffer);
    }

}
