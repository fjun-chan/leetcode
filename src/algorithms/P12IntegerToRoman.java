package algorithms;

/**
 *  12. Integer to Roman
 *
 * Given an integer, convert it to a roman numeral.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * Created by fjun on 4/10/16.
 */
public class P12IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(3999));
    }

    /**
     * 基本字符
     * I   V   X   L   C   D   M
     * 1   5   10  50  100 500 1000
     * 1) 相同的数字连写、所表示的数等于这些数字相加得到的数、如：Ⅲ=3；
     * 2) 小的数字在大的数字的右边、所表示的数等于这些数字相加得到的数、 如：Ⅷ=8、Ⅻ=12；
     * 3) 小的数字、（限于 Ⅰ、X 和 C）在大的数字的左边、所表示的数等于大数减小数得到的数、如：Ⅳ=4、Ⅸ=9；
     * 4) 正常使用时、连写的数字重复不得超过三次；
     * 5) 在一个数的上面画一条横线、表示这个数扩大 1000 倍。
     *
     */

    public static String intToRomanBetter(int num) {
        StringBuilder sb = new StringBuilder();
        String symbol[] =   {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int value[]     =   {1000,900,500,400, 100, 90,  50, 40,  10, 9,   5,  4,   1};
        for(int i=0;num!=0;++i) {
            while(num>=value[i]) {
                num-=value[i];
                sb.append(symbol[i]);
            }
        }
        return sb.toString();
    }

    public static String intToRoman(int num) {
        final String[][] ROMAN = {
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}
        };
        StringBuilder sb = new StringBuilder(16);
        sb.append(ROMAN[3][num / 1000 % 10]);
        sb.append(ROMAN[2][num / 100 % 10]);
        sb.append(ROMAN[1][num / 10 % 10]);
        sb.append(ROMAN[0][num % 10]);
        return sb.toString();
    }
}
