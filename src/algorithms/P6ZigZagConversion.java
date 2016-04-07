package algorithms;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * <p>
 *
 * Created by fjun on 4/7/16.
 */
public class P6ZigZagConversion {
    public static void main(String[] args) {
        System.out.println(convert("ABC", 2));
//        zigZag();
    }

    public static String convert(String s, int numRows) {
        final int len = s.length();
        char[] res = new char[len];
        int cur = 0;
        for (int cr = 0; cr < numRows; cr ++) {
            int n = 0;
            while (true) {
                int i = (numRows - 1) * 2 * n + cr;
                if (i >= len) {
                    break;
                }
                res[cur ++] = s.charAt(i);
                if (cr != 0 && cr != numRows - 1) {
                    i = (numRows - 1) * 2 * (n + 1) - cr;
                    if (i >= len) {
                        break;
                    }
                    res[cur ++] = s.charAt(i);
                }
                n ++;
            }
        }
        return new String(res);
    }

    public static void zigZag() {
        int c = 7;
        int r = 4;
        for (int cr = 0; cr < r; cr ++) {
            for (int n = 0; n < c; n ++) {
                int i = (r - 1) * 2 * n + cr;
                System.out.print(i + getTabs(r - 1 - cr));
                if (cr != 0 && cr != r - 1) {
                    i = (r - 1) * 2 * (n + 1) - cr;
                    System.out.print(i);
                }
                System.out.print(getTabs(cr));
            }
            System.out.println();
        }
    }

    private static String getTabs(int num) {
        StringBuilder sb = new StringBuilder(num);
        for (int i = 0; i < num; i ++) {
            sb.append("\t");
        }
        return sb.toString();
    }

    public static void zigZagMistake() {
        int c = 7;
        int m = c%2 == 0 ? c/2 : c/2 + 1;
        int r = 5;
        for (int cr = 0; cr < r; cr ++) {
            if (cr % 2 == 0) {
                for (int n = 0; n < c; n++) {
                    System.out.print(cr + (r + r / 2) * n + "\t\t");
                }
            } else {
                for (int n = 0; n < 2 * c; n++) {
                    System.out.print((n%2==0 ? cr+(r+r/2)*n/2
                            : cr+(r+r/2)*(n-1)/2+r-cr+cr/2) + "\t");
                }
            }
            System.out.println();
        }
    }

    public static String convertMistake(String s, int numRows) {
        final int len = s.length();
        char[] res = new char[len];
        int round = numRows + numRows / 2;
        int cur = 0;
        for (int cr = 0; cr < numRows; cr ++) {
            int n = 0;
            while (true) {
                int index;
                if (cr % 2 == 0) {
                    index = cr + round * n;
                } else {
                    index = (n % 2 == 0 ? cr + round * n / 2
                            : cr + round * (n - 1) / 2 + numRows - cr + cr / 2);
                }
                if (index >= len) {
                    break;
                }
                res[cur ++] = s.charAt(index);
                n ++;
            }
        }
        return new String(res);
    }
    /*
2:
    0   3   6   9
    1 2 4 5 7 8 10
3:
    0   4   8
    1 3 5 7 9  11
    2   6   10
4:
    0   6    12    18
    1 4 7 10 13 16 19
    2   8    14    20
    3 5 9 11 15 17 21
5:
    0   7     14    21
    1 5 8  12 15 19 22
    2   9     16    23
    3 6 10 13 17 20 24
    4   11    18    25

     */
}
