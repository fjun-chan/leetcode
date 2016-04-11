package algorithms;

/**
 * 14. Longest Common Prefix
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * Created by fjun on 4/11/16.
 */
public class P14LongestCommonPrefix {
    public  static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"c", "c"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < minLen) {
                minLen = str.length();
            }
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int len = strs.length;
        while(true) {
            if (index >= minLen) {
                return sb.toString();
            }
            char c = strs[0].charAt(index);
            boolean stop = false;
            for (int i = 1; i < len; i ++) {
                if (c != strs[i].charAt(index)) {
                    stop = true;
                    break;
                }
            }
            if (stop) {
                return sb.toString();
            }
            sb.append(c);
            index ++;
        }
    }
}
