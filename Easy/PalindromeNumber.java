import java.util.*;

/**
 * Given an integer, return true if the integer is a palindrome, false otherwise
 * two solutions are provided (convert to string and not convert to string)
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String str = Integer.toString(x, 10);
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindromeNotToString(int x) {
        List<Integer> nums = new ArrayList<>();  // Store from last to the first number
        if (x < 0) {
            return false;
        }

        while (x != 0) {
            nums.add(x % 10);
            x = x / 10;  // Integer division
        }

        for (int i = 0; i < nums.size() / 2; i++) {
            if (nums.get(i) != nums.get(nums.size() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int x = 0;
        PalindromeNumber p = new PalindromeNumber();
        System.out.println(p.isPalindrome(x));
        System.out.println(p.isPalindromeNotToString(x));
    }
}
