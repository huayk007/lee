package lee;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 *
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 *
 *
 *
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 *
 */
public class Lee216 {

    public static void main(String[] args) {
        Lee216 lee216 = new Lee216();
        lee216.combinationSum3(3,7);
    }

    private List<List<Integer>> result = new ArrayList<>();

    private LinkedList<Integer> path = new LinkedList<>();

    private int[] arr = {1,2,3,4,5,6,7,8,9};

    private int sumInt = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrace(k,n,sumInt,0);
        System.out.println(result);
        return result;
    }

    private void backtrace(int k,int n,int sum,int startIndex){
        if(sum > n){
            return;
        }
        if(path.size() == k){
            if(sum == n){
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for(int i = startIndex;i < 9 - (k - path.size()) + 1;i++){
            path.add(arr[i]);
            sumInt += arr[i];
            backtrace(k,n,sumInt,i+1);
            sumInt -= arr[i];
            path.removeLast();
        }

    }


}
