package algorithms;

/**
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.

 * Created by fjun on 4/5/16.
 */
public class P318MaximumProductOfWordLengths {

    public static int maxProduct(String[] words) {
        final int size = words.length;
        int[] bits = new int[size];
        for (int i = 0; i < size; i ++) {
            String word = words[i];
            bits[i] = 0;
            for (char c : word.toCharArray()) {
                bits[i] |= (1 << (c - 'a'));
            }
        }
        int max = 0;
        for (int i = 0; i < size; i ++) {
            for (int j = i + 1; j < size; j ++) {
                if ((bits[i] & bits[j]) == 0) {
                    int v = words[i].length() * words[j].length();
                    if (max < v) {
                        max = v;
                    }
                }
            }
        }
        return max;
    }
}
