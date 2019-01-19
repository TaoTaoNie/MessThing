package nothing;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author leetHuam
 * @version 1.0
 */
public class Regular {
    private int inx;
    /**
     * 剑指offer-P124
     * 题目描述
     *          请实现一个函数用来匹配包含  '.' 和 '*' 的正则表达式。模式中的字符 '.'  表示任意一个字符，而 '*' 表示它前面的字符可以出现
     *          任意次（含 0 次）。在本题中，匹配是指字符串中的所有字符匹配整个模式。
     * @param str 匹配的字符串
     * @param pattern 模式
     * @return 是否匹配成功，成功返回 true 失败返回 false
     */
    private static boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null)
            return false;
        return matchCore(str, 0, pattern, 0);
    }

    private static  boolean matchCore(char[] str, int s, char[] pattern, int p) {
        if (str.length <= s && pattern.length <= p)
            return true;
        if (str.length > s && pattern.length <= p)
            return false;
        if (p + 1 < pattern.length && pattern[p + 1] == '*') {
            if (s >= str.length)
                return matchCore(str, s, pattern, p + 2);
            else {
                if (pattern[p] == str[s] || pattern[p] == '.') {
                    return matchCore(str, s + 1, pattern, p +2) ||
                            matchCore(str, s + 1, pattern, p) ||
                            matchCore(str, s, pattern, p + 2);
                }else
                    return matchCore(str, s, pattern, p + 2);
            }
        }
        if (s >= str.length)
            return false;
        if (str[2] == pattern[p] || pattern[p] == '.')
            return matchCore(str, s +1, pattern, p + 1);
        return false;

    }

    /**
     * 剑指offer-P127
     * 题目描述
     *         请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串 “+100”、“5e2”、“-123”、“301416” 及 “-1E-16”都表示
     *         数值，但 “12e”、“1a3.14”、“1.2.3”、“+-5”及“12e+5.4”都不是
     * @param str 被验证的字符串
     * @return 返回是否表示一个数值
     */
    private boolean isNumeric(char[] str) {
        if (str == null || str.length == 0)
            return false;
        inx = 0;
        boolean flag = scanInteger(str);
        if (inx < str.length && str[inx] == '.') {
            inx += 1;
            flag = scanUInteger(str) || flag;
        }

        if (inx < str.length && (str[inx] == 'e' || str[inx] == 'E')) {
            inx += 1;
            flag = flag && scanInteger(str);
        }
        return flag && inx >= str.length;
    }

    private boolean scanInteger(char[] str) {
        if (inx < str.length && (str[inx] == '+' || str[inx] == '-'))
            inx += 1;
        return scanUInteger(str);
    }

    private boolean scanUInteger(char[] str) {
        int inx1 = inx;
        while (inx < str.length && str[inx] >= '0' && str[inx] <= '9')
            inx += 1;
        return inx > inx1;
    }

    public static void main(String[] args) {
        char[] str = {'a', 'a', 'a', 'a', 'a', 'a'};
        char[] pattern = {'a', 'a', '.', 'b'};
        Pattern p = Pattern.compile("a[0-9]b*");
        Matcher matcher = p.matcher(new String(str));
        System.out.println(match(str, pattern));
    }
}
