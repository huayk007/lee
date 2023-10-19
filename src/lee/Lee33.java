package lee;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题
 */
public class Lee33 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2},0));
    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low < 2 * nums.length && high > - nums.length){
            int mid = low + (high - low)/2;
            int index = mid;
            if(mid < 0 ){
                index = mid + nums.length;
            }else if(mid >= nums.length){
                index = mid - nums.length;
            }
            if(target == nums[index]){
                return mid;
            }else if(target > nums[index]){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
