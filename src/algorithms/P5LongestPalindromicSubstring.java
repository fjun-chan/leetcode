package algorithms;

/**
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000,
 * and there exists one unique longest palindromic substring.
 * <p>
 * Created by fjun on 4/3/16.
 */
public class P5LongestPalindromicSubstring {
    public static void main(String[] args) {
//        System.out.println(longestPalindrome("abb"));
//        System.out.println("=========================================");
//        System.out.println(longestPalindrome("efabacd"));
//        System.out.println("=========================================");
//        System.out.println(longestPalindrome("eaaf"));
//        System.out.println("=========================================");
//        System.out.println(longestPalindrome("\"ada\""));
    }
    private P5LongestPalindromicSubstring(){}

    public static String longestPalindrome(String s) {
        final int start = 0;
        final int length = s.length();
        final char[] ss = new char[s.length() * 2 + 1];
        {
            int index = 0;
            ss[index ++] = '#';
            for (int i = start; i < length; i++) {
                ss[index ++] = s.charAt(i);
                ss[index ++] = '#';
            }
        }

        final int end = ss.length;
        int max = 0, m = 0;
        for (int mid = start; mid < end; mid++) {
            int l = 1;
            while (mid - l >= start && mid + l < end) {
                if (ss[mid - l] == ss[mid + l]) {
                    l++;
                } else {
                    break;
                }
            }
            if (l > max) {
                max = l;
                m = mid;
            }
        }
        StringBuilder sb = new StringBuilder(max);
        int e = m + max;
        for (int i = m - max + 2; i < e; i += 2) {
            sb.append(ss[i]);
        }
        return sb.toString();
    }
}
