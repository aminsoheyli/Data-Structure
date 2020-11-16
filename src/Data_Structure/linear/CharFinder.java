package Data_Structure.linear;

import java.util.HashMap;
import java.util.HashSet;

public class CharFinder {
    public static char findFirstNonRepeatingChar(String str) {
        var map = new HashMap<Character, Integer>();
        var chars = str.toCharArray();
        for (char ch : chars) {
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }

        for (char ch : chars)
            if (map.get(ch) == 1)
                return ch;
        return Character.MIN_VALUE;
    }

    public static char findFirstRepeatedChar(String str) {
        var set = new HashSet<Character>();
        for (char ch : str.toCharArray()) {
            if (set.contains(ch))
                return ch;
            set.add(ch);
        }
        return Character.MIN_VALUE;
    }
}
