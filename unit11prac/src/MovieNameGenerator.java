/**
 * @author leetHuam
 * @version 1.0
 */
public class MovieNameGenerator implements Generator<String> {
    private String[] characters = {"Grumpy", "Happy", "Sleepy", "Dopey", "Doc", "Sneezy", "Bashful", "Snow white", "White Queen", "Prince"};
    private int next;

    @Override
    public String next() {
        String r = characters[next];
        next = (next + 1) % characters.length;
        return r;
    }
}
