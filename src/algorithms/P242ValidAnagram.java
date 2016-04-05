package algorithms;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
 * Created by fjun on 4/5/16.
 */
public class P242ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("tar", "rat"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s == t) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        final int CHAR_COUNT = 26;
        int[] cs = new int[CHAR_COUNT];
        int[] ct = new int[CHAR_COUNT];
        int len = s.length();
        for (int i = 0; i < len; i ++) {
            cs[s.charAt(i) - 'a'] += 1;
            ct[t.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < CHAR_COUNT; i ++) {
            if (cs[i] != ct[i]) {
                return false;
            }
        }
        return true;
    }
}
