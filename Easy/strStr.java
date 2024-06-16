// 26. Worst case: O(n*m) where n and m are the lengths of the haystack and needle
import java.util.*;

public class strStr {
    /**
     * This method is the implementation of the Boyer-Moore algorithm
     * For best result, use String.indexOf(String s) in Java for fastest time and smallest space
     * @param haystack: the string that we need to search
     * @param needle: the pattern
     * @return: the index where the pattern is first found.
     */
    public int isSubstring(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        Map<Character, Integer> lastSeen = new HashMap<>();
        for (int i = 0; i < haystack.length(); i++) {
            lastSeen.put(haystack.charAt(i), -1);
        }

        for (int i = 0; i < needle.length(); i++) {
            lastSeen.put(needle.charAt(i), i);
        }

        int m = needle.length(); int n = haystack.length();
        int i = m - 1, k = i;
        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(k)) {
                if (k == 0) {
                    return i - k;
                }
                i--; k--;
            }
            else {
                i += m - Math.min(k, lastSeen.get(haystack.charAt(i)) + 1);
                k = m - 1;
            }
        }

        return -1;
    }

}
