import java.util.*;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()) return 0;
        int maxLength = 1;
        Map<Character, Integer> lastSeen = new HashMap<>();

        int start = 0, end = 0;
        while (end < s.length() && start <= end) {
            char c = s.charAt(end);
            if (lastSeen.containsKey(c) && lastSeen.get(c) >= start) {
                start = lastSeen.get(c) + 1;
            }

            maxLength = Math.max(maxLength, end - start + 1);
            lastSeen.put(c, end);
            end++;
        }

        return maxLength;
    }
}
