package HashMapTest;

import java.util.*;

/**
 * @author leetHuam
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        while (scanner.hasNext()) {
            String s1 = scanner.nextLine();
            int n = Integer.valueOf(s1.split(" ")[0]);
            int m = Integer.valueOf(s1.split(" ")[1]);
            int[][] nums = new int[n][m];
            for (int i = 0; i < n; i++) {
                String s2 = scanner.nextLine();
                String[] temp = s2.split(" ");
                for (int j = 0; j < m; j++) {
                    nums[i][j] = Integer.valueOf(temp[j]);
                }
            }
            int first = getFirst(nums, n, m);
            int second = getSecond(nums, n, m);
            if (first == second) {
                System.out.println(getLeast2(nums, n, m));
            } else {
                System.out.println(getLeast1(nums, n, m, first, second));
            }
        }
    }

    private static int getLeast1(int[][] nums, int n, int m, int first, int second) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 1; j < m; j += 2) {
                    if (nums[i][j] != first) {
                        count1++;
                    }
                }
            } else {
                for (int j = 0; j < m; j += 2) {
                    if (nums[i][j] != first) {
                        count1++;
                    }
                }
            }
        }
        for (int x = 0; x < n; x++) {
            if (x % 2 == 0) {
                for (int y = 0; y < m; y += 2) {
                    if (nums[x][y] != second) {
                        count2++;
                    }
                }
            } else {
                for (int y = 1; y < m; y += 2) {
                    if(nums[x][y] != second) {
                        count2++;
                    }
                }
            }
        }
        return count1 + count2;
    }

    private static int getLeast2(int[][] nums, int n, int m) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 1; j < m; j += 2) {
                    count++;
                }
            } else {
                for (int j = 0; j < m; j += 2) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int getFirst(int[][] nums, int n, int m) {
        int result = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 1; j < m; j+= 2) {
                    if (map.containsKey(nums[i][j])) {
                        map.put(nums[i][j], map.get(nums[i][j]) + 1);
                    } else {
                        map.put(nums[i][j], 1);
                    }
                }
            } else {
                for (int j = 0; j < m; j += 2) {
                    if (map.containsKey(nums[i][j])) {
                        map.put(nums[i][j], map.get(nums[i][j]) + 1);
                    } else {
                        map.put(nums[i][j], 1);
                    }
                }
            }
        }
        int max = Collections.max(map.values());
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue() == max) {
                result = entry.getKey();
            }
        }
        return result;
    }

    private static int getSecond(int[][] nums, int n, int m) {
        int result = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < m; j+= 2) {
                    if (map.containsKey(nums[i][j])) {
                        map.put(nums[i][j], map.get(nums[i][j]) + 1);
                    } else {
                        map.put(nums[i][j], 1);
                    }
                }
            } else {
                for (int j = 1; j < m; j += 2) {
                    if (map.containsKey(nums[i][j])) {
                        map.put(nums[i][j], map.get(nums[i][j]) + 1);
                    } else {
                        map.put(nums[i][j], 1);
                    }
                }
            }
        }
        int max = Collections.max(map.values());
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue() == max) {
                result = entry.getKey();
            }
        }
        return result;
    }
}
