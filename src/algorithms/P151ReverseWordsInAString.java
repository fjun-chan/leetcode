package algorithms;

/**
 *
 *  Given an input string, reverse the string word by word.
 *
 *  For example,
 *
 *  Given s = "the sky is blue",
 *  return "blue is sky the".
 *
 *  Update (2015-02-12):
 *  For C programmers: Try to solve it in-place in O(1) space.
 *
 * Created by fjun on 4/3/16.
 */
public class P151ReverseWordsInAString {
    public static void main(String[] args) {
        System.out.println(reverseWords("    a"));
    }

    public static String reverseWords(String s) {
        int end = s.length();
        StringBuilder sb = new StringBuilder(end);
        int curEnd = end;
        int curStart = end;
        for (int i = end - 1; i >= 0; i --) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (curStart != curEnd) {
                    String cur = s.substring(curStart, curEnd);
                    if (sb.length() > 0){
                        sb.append(" ");
                    }
                    sb.append(cur);
                }
                curStart = i;
                curEnd = i;
            } else {
                curStart --;
            }
        }

        if (curStart != curEnd) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(s.substring(curStart, curEnd));
        }
        return sb.toString();
    }
}
