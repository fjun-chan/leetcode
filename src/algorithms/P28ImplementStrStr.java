package algorithms;

/**
 * Implement strStr().
 * <p>
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Created by fjun on 4/16/16.
 */
public class P28ImplementStrStr {

    public static void main(String[] args){
        System.out.println(strStr("mississippi", "a"));
    }

    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        final int hlen = haystack.length(), nlen = needle.length();
        if (nlen == 0) return 0;
        if (hlen == 0) return -1;
        if (hlen < nlen) return -1;

        final int hmax = hlen - nlen;
        for (int h = 0; h <= hmax; h ++) {
            int n = 0;
            int s = h;
            while (n < nlen) {
                if (haystack.charAt(s++) != needle.charAt(n)) {
                    break;
                }
                n++;
            }
            if (n == nlen) {
                return h;
            }
        }
        return -1;
    }
}
