package HashMapTest;

import java.util.*;

/**
 * @author leetHuam
 * @version 1.0
 */
public class HashMapTest {
    private static Map<Integer, Integer> map = new HashMap<>(66667);
    private static List<Integer> list = new ArrayList<>(50000);
    public static void main(String[] args) {
        for (int i = 0; i < 50000; i++) {
            map.put(i,i);
            list.add(i);
        }
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        Iterator entryIterator = entrySet.iterator();
        Set<Integer> keySet = map.keySet();
        Iterator keyIterator = keySet.iterator();
        Iterator listIterator = list.iterator();
        long s1 = System.currentTimeMillis();
        while (entryIterator.hasNext()) {
            @SuppressWarnings("unchecked")
            Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) entryIterator.next();
            System.out.println(entry.getKey());
        }
        long s2 = System.currentTimeMillis();
        System.out.println("使用Entry迭代器遍历HashMap耗时：" + (s2 - s1));
        long s3 = System.currentTimeMillis();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            System.out.println(entry.getKey());
        }
        long s4 = System.currentTimeMillis();
        System.out.println("使用ForEach遍历HashMap耗时：" + (s4 - s3));
        long s5 = System.currentTimeMillis();
        while (keyIterator.hasNext()) {
            System.out.println(keyIterator.next());
        }
        long s6 = System.currentTimeMillis();
        System.out.println("使用Key迭代器遍历HashMap耗时：" + (s6 - s5));
        long s7 = System.currentTimeMillis();
        while(listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
        long s8 = System.currentTimeMillis();
        System.out.println("使用迭代器遍历ArrayList耗时: " + (s8 - s7));
        long s9 = System.currentTimeMillis();
        for (Integer i : list) {
            System.out.println(i);
        }
        long s10 = System.currentTimeMillis();
        System.out.println("使用ForEach遍历ArrayList耗时：" + (s10 - s9));
    }
}
