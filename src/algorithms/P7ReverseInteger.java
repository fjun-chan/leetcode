package algorithms;

/**
 * Reverse digits of an integer.
 * <p>
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * <p>
 * Created by fjun on 4/8/16.
 */
public class P7ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(-1234));
    }

    public static int reverse(int x) {
        long r = 0;
        while (x != 0) {
            r = r * 10 + x % 10;
            x = x / 10;
        }
        if (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE) {
            r = 0;
        }
        return (int)r;
    }

}
