/**
 * Note B is the fastest: O(n). A is the second fastest (also O(n) but a larger multiple of n)
 */
class Solution {
    public int canCompleteCircuitA(int[] gas, int[] cost) {
        /**
         * A key observation: If we start from station i and stuck at station j, then
         * none of the station in between is a valid starting point (We can prove this by contradiction).
         * Then, we can simply do a linear scan in the array. If we encounter a positive gas[i] - cost[i]
         * it's a candidate and keep going until we stuck. Then we can keep going until we meet another 
         * candidate. Here's another key observation: If we wrap around and stuck, there's guaranteed no 
         * valid starting point (which follows from the first observation).
         */
        int n = gas.length;
        int i = 0;
        int remainGas;
        int next;
        
        int[] netRemain = new int[n];
        for (int j = 0; j < n; j++) {
            netRemain[j] = gas[j] - cost[j];
        }
        
        while (i < n) {
            if (gas[i] - cost[i] >= 0) {
                next = (i+1);
                remainGas = netRemain[i];
                while (next%n != i && netRemain[next%n] + remainGas >= 0) {
                    remainGas = netRemain[next%n] + remainGas;
                    next = (next + 1);
                }
                if (next%n == i) return i;
                if (next != i && next > n) return -1; 
                i = next;
            }
            i++;
        }
        return -1;
    }

    public int canCompleteCircuitB(int[] gas, int[] cost) {
        /**
         * An interesting observation: There is no valid starting point IFF the total (gas - cost) < 0.
         * Then, we only need to check the total gas - cost. If this is negative, we return -1. Else, we're
         * guaranteed to have exactly one solution. Then, we can scan the array until we meet a point that
         * doesn't stuck.
         */
        int n = gas.length;
        int totalRemain = 0;
        for (int i = 0; i < n; i++) {
            totalRemain += gas[i] - cost[i];
        }

        // No valid starting point
        if (totalRemain < 0) return -1;

        // Solution is guaranteed to exist.
        int start = 0;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += gas[i] - cost[i];
            if (total < 0) {  // Relation to canCompleteCircuitA: This means we can eliminate 
                // all starting points from 0 to i
                total = 0;
                start = i + 1;
            }
        }
        return start;
    }


    public int canCompleteCircuitNaive(int[] gas, int[] cost) {
        int n = gas.length;
        int[] netRemain = new int[n];
        for (int i = 0; i < n; i++) {
            netRemain[i] = gas[i] - cost[i];
        }
        
        // Test every possible starting point (netRemain >= 0)
        int remainGas;
        int next;
        for (int i = 0; i < n; i++) {
            if (netRemain[i] >= 0) {
                next = (i+1) % (n);
                remainGas = netRemain[i];
                while (next != i && netRemain[next] + remainGas >= 0) {
                    remainGas = netRemain[next] + remainGas;
                    next = (next + 1) % n;
                }
                if (next == i) return i;  // Completed a cycle
            }
        }
        return -1; // No valid starting place
    }
}