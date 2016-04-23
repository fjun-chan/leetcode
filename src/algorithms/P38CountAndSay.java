package algorithms;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 *
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 *
 * Note: The sequence of integers will be represented as a string.
 *
 * Created by fjun on 4/23/16.
 */
public class P38CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(10));
    }

    public static String countAndSay(int n) {
        if (n == 0) return "";
        if (n == 1) return "1";
        final String last = countAndSay(n - 1);
        if (last == null || last == "") return last;
        int cnt = 1;
        char current = last.charAt(0);
        final int len = last.length();
        StringBuilder sb = new StringBuilder(256);
        for (int i = 1; i < len; i ++) {
            char c = last.charAt(i);
            if (c == current) {
                cnt ++;
            } else {
                sb.append(cnt).append(current);
                cnt = 1;
                current = c;
            }
        }
        sb.append(cnt).append(current);
        return sb.toString();
    }
}
