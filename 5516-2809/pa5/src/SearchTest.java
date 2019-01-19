import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


public class SearchTest {
    private static Search s;
    private static String[] words_10 = {"SMITH", "JOHNSON", "WILLIAMS", "JONES", "BROWN", "DAVIS", "MILLER", "WILSON", "MOORE", "TTT"};

    // Choose Your own words wisely
    private static String[] words_20 = {};
    private static String[] words_50 = {};
    private static String[] words_100 = {};
    private static String[] words_200 = {};

    private static int[] ns = {10, 20, 50, 100, 200};
    private static int[] works = {10, 20, 50};
    private static int[] hashs = {10, 500};
    private static String[][] words = {words_10, words_20, words_50, words_100, words_200};

    private static FileWriter fileWriter;

    public static void append(String s) throws IOException {
        fileWriter.write(s);
    }

    @AfterClass
    public static void tearDown() throws IOException {
        fileWriter.close();
    }

    @BeforeClass
    public static void init() throws IOException {
        s = new Search(100, 500, 100);
        fileWriter = new FileWriter("search.csv");
    }

    @Test
    public void test_strategy_1() {
        ArrayList<Entry> a = new ArrayList<Entry>();
        a.add(new Entry("bac", 2));
        a.add(new Entry("bbc", 3));
        a.add(new Entry("acc", 4));
        s.set_elements(a);
        int v = s.search_strategy_1("acc");
        assertEquals(4, v);
    }

    @Test
    public void test_strategy_2() {
        ArrayList<Entry> a = new ArrayList<Entry>();
        a.add(new Entry("bac", 2));
        a.add(new Entry("bbc", 3));
        a.add(new Entry("acc", 4));
        s.set_elements(a);
        s.set_sorted_elements();
        int v = s.search_strategy_2("acc");
        assertEquals(4, v);
    }


    @Test
    public void test_strategy_3() {
        ArrayList<Entry> a = new ArrayList<Entry>();
        a.add(new Entry("bac", 2));
        a.add(new Entry("bbc", 3));
        a.add(new Entry("acc", 4));
        s.set_elements(a);
        s.set_hash_elements();
        int v = s.search_strategy_3("acc");
        assertEquals(4, v);
    }

    @Test
    public void demo() throws IOException {
        long t1, t2;
        s = new Search(100, 500, 100);
        t1 = System.currentTimeMillis();
        s.search_strategy_1("WILSON");
        t2 = System.currentTimeMillis();
        append("sample_strategy_1_w10_h500,100," + (t2 - t1));
        System.out.println("Time: " + (t2 - t1) + "\t Operations: " + s.get_work_counter());
    }
}
