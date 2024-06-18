public class AddBinary {
    // 0 + 0 -> 0
    // 1 + 1 -> 0 remain 1
    // 1 + 0 -> 1
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0) {
            char ca = (i >= 0) ? a.charAt(i) : '0';
            char cb = (j >= 0) ? b.charAt(j) : '0';
            int da = Integer.parseInt(String.valueOf(ca)), db = Integer.parseInt(String.valueOf(cb));

            res.append(da ^ db ^ carry);
            if (da == db && da != carry) {carry = da;}

            i--;  j--;
        }

        if (carry == 1) res.append(1);

        return res.reverse().toString();
    }
}
