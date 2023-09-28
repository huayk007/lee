package lee;

/**
 * 53. 最大子数组和
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 */
public class Lee53 {


    /**
     * 滑动窗口
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int left = 0, right = 0;
        int windowSum = 0, maxSum = Integer.MIN_VALUE;
        while(right < nums.length){
            // 扩大窗口并更新窗口内的元素和
            windowSum += nums[right];
            right++;

            // 更新答案
            maxSum = windowSum > maxSum ? windowSum : maxSum;

            // 判断窗口是否要收缩
            while(windowSum < 0) {
                // 缩小窗口并更新窗口内的元素和
                windowSum -=  nums[left];
                left++;
            }
        }

        return maxSum;
    }

    /**
     * 动态规划
     *
     * @param arrs
     * @return
     *
     */
    public static int maxSubArrayDynamic(int[] arrs){
        int n = arrs.length;
        int[] dp = new int[n];
        dp[0] = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 1;i<n;i++){
            dp[i] = Math.max(arrs[i],arrs[i] + dp[i-1]);
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArrayDynamic(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
