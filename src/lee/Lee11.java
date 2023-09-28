package lee;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 *
 */
public class Lee11 {
    public static int maxArea(int[] height) {
//        int max = Integer.MIN_VALUE;
//        for(int i=0;i<height.length;i++){
//            for (int j = i+1;j<height.length;j++){
//                int hei = Math.min(height[i],height[j]);
//                max = Math.max(hei * (j-i),max);
//            }
//        }
//        return max;
        int max = Integer.MIN_VALUE;
        int i=0;
        int j = height.length - 1;
        while (i<j){
            max = height[i] < height[j] ? Math.max(max,(j-i)*height[i++]):Math.max(max,(j-i)*height[j--]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
