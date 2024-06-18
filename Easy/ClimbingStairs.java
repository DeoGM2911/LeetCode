import java.util.*;

public class ClimbingStairs {
    public int climbStairs(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(-1, 0); memo.put(0, 1);
        int i = 1;

        while (!memo.containsKey(n)) {
            memo.put(i, memo.get(i-1) + memo.get(i-2));
            i++;
        }

        return memo.get(n);
    }
}
