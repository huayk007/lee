package lee;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class Lee3 {
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() ==1){
            return s.length();
        }
        Map<Character,Integer> hashmap = new HashMap<>();
        char[] chars = s.toCharArray();
        int i = 0,j=1;
        int max = 1;
        hashmap.put(chars[0],0);
        while (i<chars.length && j<chars.length){
            if(i == j){
                j++;
                continue;
            }
            if(hashmap.containsKey(chars[j]) && hashmap.get(chars[j]) >= i){
                i = hashmap.get(chars[j]) + 1;
                hashmap.put(chars[j],j);
            }else {
                max = Math.max(max,j-i + 1);
                hashmap.put(chars[j],j);
            }
            j++;
        }
        return max;
    }

    public static int lengthOfLongestSubstringofficial(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0, len = s.length();
        for(int j = 0; j < len; j++) {
            if (dic.containsKey(s.charAt(j))) {
                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
            }
            dic.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringofficial("tmmzuxt"));
    }
}