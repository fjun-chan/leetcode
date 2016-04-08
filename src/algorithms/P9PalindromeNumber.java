package algorithms;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * Created by fjun on 4/8/16.
 */
public class P9PalindromeNumber {

    public static void main(String[] args) {
//        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(12210));
        System.out.println(isPalindrome(1));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        int y = 0;
        while (x != 0) {
            y = y * 10 + x % 10;
            if (y == 0) {
                return false;
            }
            x /= 10;
            if (x == y || x / 10 == y || y / 10 == x) {
                return true;
            }
        }
        return false;
    }
}
