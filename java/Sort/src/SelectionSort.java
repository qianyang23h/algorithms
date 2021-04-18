// 选择排序
// 不稳
// 最简单但是最没用的排序算法

public class SelectionSort{
    public static void main(String[] args) {
    int[] arr = {2, 3, 1, 5, 7, 4, 6 ,8 ,9};
    selectionSort(arr);

    // 验证选择排序的不稳定：排序对象数组
    // Num[] arr1 = new Num[3];

   }

    static void selectionSort(int[] arr){
        if(arr == null & arr.length < 2){
            return;
        }

        for(int i = 0; i < arr.length - 1 ; i++){
            int minpos = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[minpos]){
                    minpos = j;
                }
            }
            // System.out.println("minpos:" + minpos);

            swap(arr, i, minpos);
            
            // System.out.println("经过" + i + "次循环后，数据的内容为：");
            // print(arr);
        }
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void print(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }


}
