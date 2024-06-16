import java.util.*;

// Worst case O(n)
public class ValidParen {
    public boolean isValid(String s) {
        Stack<Character> open = new Stack<>();
        Map<Character, Character> pairs = new HashMap<>();

        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c == '(') || (c == '[') || (c == '{')) {
                open.push(s.charAt(i));
            } else {
                if (open.isEmpty()) {
                    return false;
                } else {
                    if (open.pop() != pairs.get(c)) {
                        return false;
                    }
                }
            }
        }
        return open.isEmpty();
    }
}
