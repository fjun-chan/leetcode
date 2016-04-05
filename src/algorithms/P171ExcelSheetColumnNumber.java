package algorithms;

/**
 * Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28

 * Created by fjun on 4/5/16.
 */
public class P171ExcelSheetColumnNumber {
    public static void main(String[] args) {
        System.out.println(titleToNumber("AB"));
    }

    public static int titleToNumber(String s) {
        int num = 0;
        for (char c : s.toCharArray()) {
            int i = c - 'A' + 1;
            num = num * 26 + i;
        }
        return  num;
    }
}
