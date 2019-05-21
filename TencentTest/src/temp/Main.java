package temp;

import java.util.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int string2int(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int sign = 1;
        boolean demical = false;
        if (str.charAt(0) == '-') {
            sign = -1;
        }
        int count = 0;
        int res = 0, length = str.length();
        for (int j = 0; j < length; j++) {
            if (str.charAt(j) == '.') {
                count++;
            }
        }
        if (count > 1) {
            return 0;
        }
        for (int i = str.charAt(0) == '+' || str.charAt(0) == '-' ? 1 : 0; i < length; i++) {
            if ((str.charAt(i) > '9' || str.charAt(i) < '0') && str.charAt(i) != '.') {
                return 0;
            } else if (str.charAt(i) == '.' && !demical) {
                demical = true;
            } else if (str.charAt(i) == '.' && demical) {
                return 0;
            } else {
                if (demical) {
                    return res * sign;
                } else {
                    res = res * 10 + str.charAt(i) - '0';
                }
            }
        }
        return res * sign;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int res;
            String _str;
            try {
                _str = in.nextLine();
            } catch (Exception e) {
                _str = null;
            }
            res = string2int(_str);
            System.out.println(String.valueOf(res));
        }
    }
}
