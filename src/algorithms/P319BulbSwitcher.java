package algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * There are n bulbs that are initially off. You first turn on all the bulbs. Then,
 * you turn off every second bulb. On the third round, you toggle every third bulb
 * (turning on if it's off or turning off if it's on). For the ith round, you toggle every i bulb.
 * For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.

Example:

Given n = 3.

At first, the three bulbs are [off, off, off].
After first round, the three bulbs are [on, on, on].
After second round, the three bulbs are [on, off, on].
After third round, the three bulbs are [on, off, off].

So you should return 1, because there is only one bulb is on.

 *
 *
 * Created by fjun on 4/5/16.
 */
public class P319BulbSwitcher {
    public static void main(String[] args) {
        for (int i = 1; i < 101; i ++) {
            System.out.println(i + "==> " + bulbSwitch(i));
        }
    }

    public static int bulbSwitch(int n) {
        // 从TLE的执行的执行结果总结出规律，但为什么呢？。。
        // 参见：https://segmentfault.com/a/1190000004315488
        /*
        我们可以很容易地想到，最后状态是on的灯泡代表的标号，说明只有奇数个约数。
        eg:在N足够大的情况下：
            1号：因为只为1的倍数，只switch一次，on
            2号：为1,2的倍数，switch两次，off
            3号：为1,3的倍数，switch两次，off
            4号：为1,2,4的倍数，switch三次，on
            ...
            而什么情况会只有奇数个约数呢 ===> 平方数。
            因而只需找到在不大于N的范围内的平方数个数即可。
         */

        return (int) Math.sqrt(n);
    }

    // TLE
    public static int bulbSwitchTLE(int n) {
        Set<Integer> hadTurnOff = new HashSet<Integer>(n);
        for (int i = 2; i <= n; i ++) {
            for (int j = 1; j <= n; j ++) {
                if (j % i == 0) {
                    if (hadTurnOff.contains(j)) {
                        hadTurnOff.remove(j);
                    } else {
                        hadTurnOff.add(j);
                    }
                }
            }
        }
        return n - hadTurnOff.size();
    }
}
