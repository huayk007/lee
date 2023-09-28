package lee;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 239. 滑动窗口最大值
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值
 */
public class Lee239 {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int max = Integer.MIN_VALUE;
        int[] res = new int[nums.length - k + 1];
        List<Integer> list = new ArrayList<>(k);
        while (j < nums.length){
            if(j - i < k){
                list.add(nums[j]);
                max = Math.max(max, nums[j]);
                if(nums[j] >= max){
                    max = nums[j];
                }
                if(j - i == k -1){
                    res[0] = max;
                }
                j++;
            }else {
                list.remove(0);
                list.add(nums[j]);
                max = Math.max(max,nums[j]);
                res[j-k +1] = list.stream().max(Integer::compareTo).get();
                i++;
                j++;
            }
        }
        return res;
    }

    public static int[] maxSlidingWindowOffical(int[] nums, int k) {
        PriorityQueue<Integer> list = new PriorityQueue<>((x,y) ->  (x < y) ? 1 : ((x == y) ? 0 : -1));
        int i = 0;
        int j = 0;
        int max = Integer.MIN_VALUE;
        int[] res = new int[nums.length - k + 1];
        while (j < nums.length){
            if(j - i < k){
                list.add(nums[j]);
                max = Math.max(max, nums[j]);
                if(nums[j] >= max){
                    max = nums[j];
                }
                if(j - i == k -1){
                    res[0] = max;
                }
                j++;
            }else {
                list.remove(nums[j-k]);
                list.add(nums[j]);
                max = list.element();
                res[j-k +1] =max;
                i++;
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxSlidingWindowOffical(new int[]{1,3,-1,-3,5,3,6,7},3));
    }

}
