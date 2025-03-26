import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        int i = 0, j = 0;
        while (j < t.length()) {
            if (i == s.length()) {
                return true;
            }
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return (i == s.length());
    }

    /**
     * Similar to isSubsequence, but for a sequence of strings s (Follow-up question).
     * Used extra memory for binary search.
     */
    public boolean[] isSubsequenceMass(String[] s,  String t) {
        Map<Character, int[]> m = new HashMap<>();
        Map<Character, Integer> freqMap;
        boolean valid;
        for (int i = 0; i < t.length(); i++) {
            if (!m.containsKey(t.charAt(i))) {
                m.put(t.charAt(i), new int[t.length()]);
                m.get(t.charAt(i))[i] = 1;
            }
            else {
                m.get(t.charAt(i))[i] = m.get(t.charAt(i))[i-1] + 1;
            }
        }
        
        boolean[] result = new boolean[s.length];
        Arrays.fill(result, false);
        valid = true;
        for (int i = 0; i < s.length; i++) {
            if (s[i].length() > t.length()) {
                continue;
            }
            
            freqMap = new HashMap<>();
            for (int j = 0; j < s[i].length(); j++) {
                if (!m.containsKey(s[i].charAt(j))) {
                    valid = false;
                    break;
                }
                if (!freqMap.containsKey(s[i].charAt(j))) {
                    freqMap.put(s[i].charAt(j), 1);
                }
                else freqMap.put(s[i].charAt(j), freqMap.get(s[i].charAt(j)) + 1);
                if (Arrays.binarySearch(m.get(s[i].charAt(j)), freqMap.get(s[i].charAt(j))) < 0) {
                    valid = false;
                    break;
                }
            }

            result[i] = valid;
        }
        return result;
    }
}