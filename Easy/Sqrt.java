public class Sqrt {
    public int mySqrt(int x) {
        long h = x, l = 0;
        long guess = (h + l) / 2;
        while (l <= h) {
            if ((guess * guess) == x) return (int) guess;
            else if ((guess * guess) > x) h = guess - 1;
            else l = guess + 1;
            guess = (h + l) / 2;
        }

        if ((guess * guess) > x) return (int) guess - 1;
        return (int) guess;
    }
}
