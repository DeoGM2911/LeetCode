// Worst case: O(n)
public class LengthLastWord {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1, len = 0;
        while (i >= 0) {
            if (s.charAt(i) == ' ' && len == 0) i--;
            else {
                while (i >= 0 && s.charAt(i) != ' ') {len++; i--;}
                break;
            }
        }
        return len;
    }
}
