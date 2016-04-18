package algorithms;

public class P29DivideTwoIntegers {
    public static void main(String[] args) {
        System.out.println(divide(Integer.MIN_VALUE, -1));
    }

    public static int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        long res = 0;
        if (dividend == Integer.MIN_VALUE) {
            res = 1;
            dividend += Math.abs(divisor);
        }
        if (divisor == Integer.MIN_VALUE) return (int)res;

        boolean flag = ((dividend ^ divisor) >>> 31) == 1;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int digit = 0;
        while (divisor <= (dividend >> 1)) {
            digit ++;
            divisor <<= 1;
        }
        while (digit >= 0) {
            if (dividend >= divisor) {
                dividend -= divisor;
                res += (1 << digit);
            }
            divisor >>= 1;
            digit--;
        }
        res = flag ? - res : res;
        if (res >= Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int)res;
    }
}
