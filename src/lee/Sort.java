package lee;

public class Sort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,8,5,6,9,7};
//        insert(arr);
//        selectSort(arr);
        bubbleSort(arr);
        System.out.println(arr);
    }

    private static void bubbleSort(int[] arr){
        int length = arr.length;
        for (int i = length - 1;i >= 0;i--){
            boolean flag = false;
            for (int j = 0;j<i;j++){
                int temp = arr[j];
                if(temp > arr[j+1]){
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
    }

    private static void insert(int[] arr){
        int length = arr.length;
        for (int i = 1;i<length;i++){
            int j = i-1;
            int value = arr[i];
            for (; j >= 0; --j) {
                if (arr[j] > value) {
                    // 数据移动
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+1] = value;
        }
    }

    private static void selectSort(int[] arr){
        int length = arr.length;
        for (int i = 0;i<length;i++){
            int min = arr[i];
            int index = -1;
            for (int j = i;j<length;j++){
                if(arr[j] < min){
                    min = arr[j];
                    index = j;
                }
            }
            if(index != -1){
                arr[index] = arr[i];
                arr[i] = min;
            }
        }
    }
}
