/**
 * Find the longest common prefix in an array of strings
 * Worst case: O(n * m) where n is the number of strings and m is the length of the found prefix
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < prefix.length(); j++) {
                if (j == strs[i].length() || prefix.charAt(j) != strs[i].charAt(j)) {
                    prefix = prefix.substring(0, j);
                }
            }
        }

        return prefix;
    }
}
