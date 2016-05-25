package algorithms;

import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

import java.lang.reflect.Array;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.MulticastChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 *
 * Note:
 * The numbers can be arbitrarily large and are non-negative.
 * Converting the input string to integer is NOT allowed.
 * You should NOT use internal library such as BigInteger.
 *
 * Created by fjun on 4/23/16.
 */
public class P43MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(multiply("9932", "4376"));
        System.out.println(multiply("0", "0"));
    }

    public static String multiply(String num1, String num2) {
        final int split = 4;
        final int mask = (int)Math.pow(10, split);
        final List<Integer> l1 = split(num1, split);
        final List<Integer> l2 = split(num2, split);

        final List<Integer> result = new ArrayList<>(l1.size() + l2.size());
        int round = 0;
        for (int n2 : l2) {
            int index = round;
            for (int n1 : l1) {
                final int sum = n1 * n2;
                if (result.size() <= index) {
                    result.add(index, sum);
                } else {
                    result.set(index, result.get(index) + sum);
                }
                index ++;
            }
            round ++;
        }
        StringBuilder sb = new StringBuilder(result.size() + 10);
        int carry = 0;
        for (int r : result) {
            int s = r + carry;
            carry = s / mask;
            int l = s % mask;
            for (int i = 0; i < split; i ++) {
                sb.append(l % 10);
                l /= 10;
            }
        }
        while (carry > 0) {
            sb.append(carry % 10);
            carry /= 10;
        }
        while (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.reverse().toString();
    }

    public static List<Integer> split(String num, int splitLen) {
        final int len = num.length();
        List<Integer> list = new ArrayList<>(len / splitLen + 1);
        int had = 0;
        while (true) {
            int to = len - had;
            int from = Math.max(0, to - splitLen);
            if (from >= to) {
                break;
            }
            int r = 0;
            for (int i = from; i < to; i ++) {
                r = r * 10 + num.charAt(i) - '0';
            }
            list.add(r);
            had += splitLen;
        }
        return list;
    }
}

