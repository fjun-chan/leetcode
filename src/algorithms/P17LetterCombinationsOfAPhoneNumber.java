package algorithms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 *
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * Created by fjun on 4/12/16.
 */
public class P17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("22"));
    }

    private static final char[][] CHARS = {
            {'a', 'b', 'c'}, // 2
            {'d', 'e', 'f'}, // 3
            {'g', 'h', 'i'}, // 4
            {'j', 'k', 'l'}, // 5
            {'m', 'n', 'o'}, // 5
            {'p', 'q', 'r', 's'}, // 7
            {'t', 'u', 'v'}, // 8
            {'w', 'x', 'y', 'z'} // 9

    };
    public static List<String> letterCombinations(String digits) {
        int len = 0;
        List<String> list = new ArrayList<String>();
        for (char c : digits.toCharArray()) {
            int index = c - '2';
            if (index < 0 || index >= CHARS.length) {
                return new ArrayList<String>();
            }
            char[] cs = CHARS[index];
            if (list.isEmpty()) {
                for (char cc : cs) {
                    list.add(String.valueOf(cc));
                }
            } else {
                ArrayList<String> nl = new ArrayList<String>(cs.length * list.size());
                for (String had : list) {
                    for (char cc : cs) {
                        nl.add(had + cc);
                    }
                }
                list = nl;
            }
            len ++;
        }
        return list;
    }
}
