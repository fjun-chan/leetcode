package algorithms;

/**
 *13. Roman to Integer
 *
 * Given a roman numeral, convert it to an integer.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * Created by fjun on 4/11/16.
 */
public class P13RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("MMMCMXCIX"));
    }

    public static int romanToInt(String s) {
        int num = 0;
        int len = s.length();
        for (int i = 0; i < len; i ++) {
            char c = s.charAt(i);
            int n = getNum(c);
            if (i < len - 1 && n < getNum(s.charAt(i + 1))) {
                num -= n;
            } else {
                num += n;
            }
        }
        return num;
    }
    /**
     * I   V   X   L   C   D   M
     * 1   5   10  50  100 500 1000
     */
    public static int getNum(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
