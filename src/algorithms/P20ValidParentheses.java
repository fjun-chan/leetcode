package algorithms;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

 * Created by fjun on 4/12/16.
 */
public class P20ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("[]"));
    }

    public static boolean isValid(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        for (char c : s.toCharArray()) {
            int len = sb.length();
            char top = len == 0 ? ' ' : sb.charAt(len - 1);
            if (top == '(' && c == ')' || top == '{' && c == '}'
                    || top == '[' && c == ']') {
                sb.deleteCharAt(len - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.length() == 0;
    }
}
