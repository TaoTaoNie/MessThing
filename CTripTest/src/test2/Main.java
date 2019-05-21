package test2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author leetHuam
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] params = line.split(" ");
            Map<String, Integer> map = new HashMap<>();
            for (int pindex = 1; pindex < params.length; pindex++) {
                if (params[pindex].length() <= 1) {
                    continue;
                }
                String[] order = params[pindex].split("/");
                int length = order.length;
                if (order[length - 1].length() == 0) {
                    length = length - 1;
                }
                StringBuilder sb = new StringBuilder();
                StringBuilder sbStr = new StringBuilder();
                sb.append(1);
                sbStr.append("/" + order[1]);
                for (int oindex = 2; oindex < length; oindex++) {
                    sbStr.append("/" + order[oindex]);
                }
                if (map.containsKey(sbStr.toString())) {
                    Integer oldNumber = map.get(sbStr.toString());
                    map.put(sbStr.toString(), oldNumber + 1);
                    for (int i = 2; i < length - 1; i++) {
                        sb.append(oldNumber + 1);
                    }
                    if (length >= 3) {
                        sb.append(1);
                    }
                } else {
                    map.put(sbStr.toString(), 1);
                    for (int i = 2; i < length - 1; i++) {
                        sb.append(1);
                    }
                    if (length >= 3) {
                        sb.append(1);
                    }
                }
                System.out.print(sb.toString());
                if (pindex != (params.length - 1)) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
