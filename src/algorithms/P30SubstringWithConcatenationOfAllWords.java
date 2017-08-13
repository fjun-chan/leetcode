package algorithms;

import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words
 * exactly once and without any intervening characters.
 *
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 *
 * You should return the indices: [0,9].
 * (order does not matter).
 *
 * Created by fjun on 4/20/16.
 */
public class P30SubstringWithConcatenationOfAllWords {
    final static ReentrantLock lock = new ReentrantLock(true);
    public static final Thread t = new Thread() {
        public void run() {
            lock.lock();
            lock.lock();
            System.out.println("in thread");
            lock.unlock();
            lock.unlock();
        }
    };

    public static void main(String[] args) throws InterruptedException {
        // 我试下中文
        Condition condition;
        HashMap map;
        t.start();
        Thread.sleep(1);

        lock.lock();
        System.out.println("OK");
        lock.unlock();
    }
}
