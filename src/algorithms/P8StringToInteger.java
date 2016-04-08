package algorithms;

/**
 * Implement atoi to convert a string to an integer.
 * <p>
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * <p>
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 * <p>
 * Update (2015-02-10):
 * The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
 * <p>
 * <p>
 * Created by fjun on 4/8/16.
 */
public class P8StringToInteger {
    public static void main(String[] args) {
//        System.out.println(myAtoi("1"));
//        System.out.println(myAtoi("+1"));
//        System.out.println(myAtoi("-1"));
//        System.out.println(myAtoi("-1a1"));
//        System.out.println(myAtoi("-+1"));
//        System.out.println(myAtoi("+-1"));
//        System.out.println(myAtoi("   0110 "));
//        System.out.println(myAtoi("   +1 110 "));
        System.out.println(myAtoi("2147483648"));
        System.out.println(myAtoi("214748365"));
        System.out.println(myAtoi("-2147483647"));
        System.out.println(myAtoi("-2147483648"));
        System.out.println(myAtoi("9223372036854775809"));
        System.out.println(myAtoi("    10522545459"));
    }

    public static int myAtoi(String str) {
        int sum = 0;
        int len = 0;
        int flag = 1;
        for (char c : str.toCharArray()) {
            if (c == ' ' || c == '\t') {
                if (len != 0) {
                    return flag * sum;
                }
            } else if (c == '+') {
                if (len != 0) {
                    return flag * sum;
                }
                len ++;
            } else if (c == '-') {
                if (len != 0) {
                    return flag * sum;
                }
                flag = -1;
                len ++;
            } else if ( c >= '0' && c <= '9') {
                int n = c - '0';
                if (Integer.MAX_VALUE / 10 >= sum) {
                    sum = sum * 10 + n;
                } else {
                    return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                if (sum < 0) {
                    return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                len ++;
            } else {
                return flag * sum;
            }
        }
        return flag * sum;
    }

    public static int myAtoiBad(String str) {
        int sum = 0;
        int len = 0;
        int flag = 1;
        for (char c : str.toCharArray()) {
            switch (c) {
                case ' ':
                case '\t':
                    if (len != 0) {
                        return flag * sum;
                    }
                    break;
                case '+':
                    if (len != 0) {
                        return flag * sum;
                    }
                    len ++;
                    break;
                case '-':
                    if (len != 0) {
                        return sum;
                    }
                    len ++;
                    flag = -1;
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    if (sum > Integer.MAX_VALUE / 10) {
                        return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                    }
                    if (sum == Integer.MAX_VALUE / 10) {
                        int t = (c - '0');
                        if (t == 7) {
                            if (flag == -1) return sum * flag * 10 - t;
                            else return Integer.MAX_VALUE;
                        } else if (t > 7) {
                            return flag == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                        }
                    }
                    sum = sum * 10 + (c - '0');
                    len ++;
                    break;
                default:
                    return flag * sum;
            }
        }
        return flag * sum;
    }
}
