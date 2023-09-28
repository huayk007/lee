package lee;

import java.util.Arrays;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class Lee128 {

    public static int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int max = 0;
        int result = 1;
        for (int i = 0;i<nums.length;i++){
            if (i==0){
                max = 1;
            }else {
                if (nums[i] == nums[i-1] + 1){
                    result = Math.max(result,++max);
                }else if(nums[i] == nums[i-1]){
                    continue;
                }else {
                    max = 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.printf(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}) + "");
    }
}
