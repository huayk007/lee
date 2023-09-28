package lee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 *
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class Lee49 {

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> resultList = map.getOrDefault(key,new ArrayList<String>());
            resultList.add(str);
            map.put(key,resultList);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] list = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.printf(groupAnagrams(list).toString());
    }
}
