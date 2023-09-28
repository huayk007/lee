package lee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * 中等
 * 相关标签
 * 相关企业
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）
 */
public class Lee438 {

    public static List<Integer> findAnagrams(String s, String p) {
       char[] chars = p.toCharArray();
        Arrays.sort(chars);
        String str = new String(chars);
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i<s.length();i++){
            if(s.length() - i < p.length()){
                break;
            }
            String ss = s.substring(i,i+p.length());
            char[] charArr = ss.toCharArray();
            Arrays.sort(charArr);
            if(new String(charArr).equals(str)){
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("abab","ab"));
    }
}
