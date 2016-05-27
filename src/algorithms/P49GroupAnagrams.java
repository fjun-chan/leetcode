package algorithms;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 *
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return: [
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 *
 * Note:
 * For the return value, each inner list's elements must follow the lexicographic order.
 * All inputs will be in lower-case.
 *
 * Created by fjun on 27/05/16.
 */
public class P49GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"has","rod","tom","hum","him","yon","met","dye"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        Map<Integer, List<String>> map = new HashMap<>(len * 4 / 3);
        for (String str : strs) {
            int key = getHashKey(str);
            List<String> had = map.get(key);
            if (had == null) {
                had = new ArrayList<>(32);
                map.put(key, had);
            }
            had.add(str);
        }
        List<List<String>> result = new ArrayList<>(map.size());
        for (List<String> l : map.values()) {
            Collections.sort(l);
            result.add(l);
        }
        return result;
    }

    private static final int[] PRIME = new int[]{
            2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101
    };
    private static int getHashKey(String str) {
        int h = 1;
        for (char c : str.toCharArray()) {
            h *= PRIME[c - 'a'];
        }
        return h;
    }

    public static List<List<String>> groupAnagramsV1(String[] strs) {
        Arrays.sort(strs);
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] cc = str.toCharArray();
            Arrays.sort(cc);
            String key = String.valueOf(cc);
            List<String> had = map.get(key);
            if (had == null) {
                had = new ArrayList<>();
                map.put(key, had);
                result.add(had);
            }
            had.add(str);
        }
        return result;
    }

}
