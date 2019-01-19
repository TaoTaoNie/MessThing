import java.util.*;

/**
 * @author leetHuam
 * @version 1.0
 */
public class E20_VowelsInfo {
    private final static Set<Character> vowels =  new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    static void updateStat(Map<Character, Integer> stat, char letter) {
        Character ch = Character.toLowerCase(letter);
        Integer freq = stat.get(ch);
        stat.put(ch, freq == null ? 1 : freq + 1);
    }

    public static void main(String[] args) {
        HashMap<Character, Integer> fileStat = new HashMap<Character, Integer>();
        HashSet<String> processedWords = new HashSet<String>();
        HashMap<Character, Integer> wordStat = new HashMap<Character, Integer>();

    }
}
