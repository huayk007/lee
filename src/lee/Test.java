package lee;

import java.text.MessageFormat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test {


    public static void main(String[] args) {
        String str = MessageFormat.format("sfsdf{0} = {1}","  hello","world");
        System.out.println(str);
        Test test = new Test();
        test.f(0,0);
        System.out.println("max===="+test.maxW);
        Map<String,String> map = new LinkedHashMap<>(10,0.75F,true);
        map.put("11a","sss");
        map.put("22b","sss");
        map.put("11b","sss");
        map.put("1","sss");
        map.put("11c","sss");
        System.out.println(map.get("11b"));
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(map);
    }

    // 回溯算法实现。注意：我把输入的变量都定义成了成员变量。
    private int maxW = Integer.MIN_VALUE; // 结果放到 maxW 中
    private int[] weight = {2,2,4,6,3};  // 物品重量
    private int n = 5; // 物品个数
    private int w = 9; // 背包承受的最大重量
    public void f(int i, int cw) { // 调用 f(0, 0)
        if (cw == w || i == n) { // cw==w 表示装满了，i==n 表示物品都考察完了
            if (cw > maxW){
                maxW = cw;
            }
            System.out.println(cw);
            return;
        }
        f(i+1, cw); // 选择不装第 i 个物品
        if (cw + weight[i] <= w) {
            f(i+1,cw + weight[i]); // 选择装第 i 个物品
        }
    }
}
