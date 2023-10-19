package lee;

public class Search {

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,4,5,6,6,7,8,9};
        System.out.println(binerySearch4(arr,3));
    }

    private static int binerySearch(int[] arr,int value){
        int length = arr.length;
        int leftIndex = 0;
        int rightIndex = length - 1;
        while (rightIndex >= leftIndex){
            int mid = leftIndex + (rightIndex - leftIndex)/2;
            if(arr[mid] == value){
                return mid;
            }
            if(arr[mid] > value){
                rightIndex = mid - 1;
            }else {
                leftIndex = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个等于值的元素下标
     * @param arr
     * @param value
     * @return
     */
    private static int binerySearch2(int[] arr,int value){
        int length = arr.length;
        int leftIndex = 0;
        int rightIndex = length - 1;
        int result = -1;
        while (rightIndex >= leftIndex){
            int mid = leftIndex + (rightIndex - leftIndex)/2;
            if(arr[mid] == value){
                result = mid;
                rightIndex = mid - 1;
            }
            else if(arr[mid] > value){
                rightIndex = mid - 1;
            }else {
                leftIndex = mid + 1;
            }
        }
        return result;
    }

    /**
     * 查找最后一个等于值的元素下标
     * @param arr
     * @param value
     * @return
     */
    private static int binerySearch3(int[] arr,int value){
        int length = arr.length;
        int leftIndex = 0;
        int rightIndex = length - 1;
        int result = -1;
        while (rightIndex >= leftIndex){
            int mid = leftIndex + (rightIndex - leftIndex)/2;
            if(arr[mid] == value){
                result = mid;
                leftIndex = mid + 1;
            }
            else if(arr[mid] > value){
                rightIndex = mid - 1;
            }else {
                leftIndex = mid + 1;
            }
        }
        return result;
    }

    /**
     * 查找最后一个小于等于值的元素下标
     * @param arr
     * @param value
     * @return
     */
    private static int binerySearch4(int[] arr,int value){
        int length = arr.length;
        int leftIndex = 0;
        int rightIndex = length - 1;
        int result = Integer.MAX_VALUE;
        while (rightIndex >= leftIndex){
            int mid = leftIndex + (rightIndex - leftIndex)/2;
            if(arr[mid] <= value){
                leftIndex = mid + 1;
            }
            else if(arr[mid] > value){
                rightIndex = mid - 1;
                result = Math.min(result,mid);
            }
        }
        return result;
    }
}
