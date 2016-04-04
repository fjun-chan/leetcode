package algorithms;

/**
 * Add Digits
 * <p>
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * <p>
 * For example:
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * <p>
 * Created by fjun on 4/4/16.
 */
public class P258AddDigits {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i ++) {
            System.out.println( i + "\t" + addDigitsV2(i));
        }
        System.out.println(addDigitsV2(38));
    }

    public static int addDigitsV2(int num) {
        if (num == 0) {
            return 0;
        }
        return num % 9 == 0 ? 9 : num % 9;
    }

    public static int addDigits(int num) {
        int sum = 0;
        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }
        if (sum < 10) {
            return sum;
        }
        return addDigits(sum);
    }
}
