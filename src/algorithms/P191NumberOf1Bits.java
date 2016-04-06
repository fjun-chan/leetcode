package algorithms;

/**
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 * <p>
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 * <p>
 * Created by fjun on 4/6/16.
 */
public class P191NumberOf1Bits {
    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
    }

    public static int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            n &= n - 1;
            cnt ++;
        }
        return cnt;
    }

    // you need to treat n as an unsigned value
    public static int hammingWeightCheat(int n) {
        return Integer.bitCount(n);
    }
}
