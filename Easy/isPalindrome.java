public class isPalindrome {
    public boolean isPalindrome_(String s) {
        int l = 0, r = s.length() - 1;
        char cl, cr;
        while (l <= r) {
            cl = Character.toLowerCase(s.charAt(l));
            cr = Character.toLowerCase(s.charAt(r));
            if (cl == cr) {
                l++; r--;
            }
            else if (!Character.isLetterOrDigit(cl)) {
                l++;
            }
            else if (!Character.isLetterOrDigit(cr)) {
                r--;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
