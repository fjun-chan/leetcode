package algorithms;

import java.util.Arrays;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num
 * calculate the number of 1's in their binary representation and return them as an array.
 *
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 *
 * Created by fjun on 4/4/16.
 */
public class P338CountingBits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }

    public static int[] countBits(int num) {
        int[] r = new int[num + 1];
        r[0] = 0;
        for (int i = 0; i <= num; i ++) {
            int h = i >> 1;
            if ((i & 1) > 0) {
                r[i] = r[h] + 1;
            } else {
                r[i] = r[h];
            }

        }
        return r;
    }
}
