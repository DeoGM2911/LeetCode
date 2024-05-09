import java.util.*;

/**
 * Convert a string of roman number to arabic number
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        Map<Character, Integer> m = new HashMap<>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);

        int num = 0;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (i + 1 < s.length()) {
                char d = s.charAt(i + 1);
                int diff = m.get(d) - m.get(c);
                if ((diff > 0) && ((diff % 4 == 0) || (diff % 9 == 0))) {
                    num += diff;
                    i += 2;
                }
                else {
                    num += m.get(c);
                    i++;
                }
            }
            else {
                    num += m.get(c);
                    i++;
            }
        }

        return num;
    }
}
