package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * 卡特兰数
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 *
 * Created by fjun on 4/12/16.
 */
public class P22GenerateParentheses {
    public static void main(String args[]) {
        System.out.println(new P22GenerateParentheses().generateParenthesis(4));
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        gen(n, n, "", list);
        return list;
    }

    public void gen(int left, int right, String str, List<String> list) {
        if (left == 0 && right == 0) {
            list.add(str);
        }
        if (left > 0) {
            gen(left - 1, right, str + '(', list);
        }
        if (right > 0 && left < right) {
            gen(left, right - 1, str + ')', list);
        }
    }
}
