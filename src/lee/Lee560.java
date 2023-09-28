package lee;

import java.util.HashMap;

/**
 *
 代码

 测试用例
 测试用例
 执行结果

 560. 和为 K 的子数组
 中等
 相关标签
 相关企业
 提示
 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。

 子数组是数组中元素的连续非空序列。
 */
public class Lee560 {

    public static int subarraySum(int[] nums, int k) {
        int res = 0;
        for (int i = 0;i<nums.length;i++){
            int j = i;
            int sum = 0;
            boolean flag = false;
            while (j < nums.length){
                sum += nums[j];
                if(sum == k){
                    res++;
                }
                j++;
            }
        }
        return res;
    }

    public int subarraySum2(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap< Integer, Integer > mp = new HashMap < > ();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,-1,0},0));
    }
}
