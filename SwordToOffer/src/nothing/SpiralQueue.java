package nothing;

/**
 * 螺旋队列问题，详情见 https://blog.csdn.net/yhmhappy2006/article/details/2934435
 * @author leetHuam
 * @version 1.0
 */
public class SpiralQueue {
    private int spiralQue(int x, int y) {
        int c = max(abs(x), abs(y));
        int max = (2 * c + 1) * (2 * c + 1);

        if (y == -c) {
            return max + y + x;
        } else if (x == -c) {
            return max + 3 * x -y;
        } else if (y == c) {
            return max - 5 * y - x;
        } else if (x == c) {
            return max - 7 * x + y;
        }else {
            return Integer.MAX_VALUE;
        }
    }

    private int abs(int n) {
        return n <= 0 ? -n : n;
    }

    private int max(int n, int m) {
        return n >= m ? n : m;
    }

    public static void main(String[] args) {
        System.out.println(new SpiralQueue().spiralQue(1,2));
    }
}
