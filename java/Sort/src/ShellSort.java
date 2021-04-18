
// 希尔排序(插入排序的改进算法)




public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 5, 7, 4, 6 ,8 ,9};

        sort(arr);

        print(arr);
    }

    static void sort(int[] arr){


        // 普通插入排序相当于gap=1的希尔排序
        // 采用间隔依次除以二的希尔排序
        for(int gap = arr.length; gap > 0; gap /= 2){
            for(int i = gap; i < arr.length; i++){
                for(int j = i; j > gap - 1; j -= gap){
                    if(arr[j] < arr[j-gap]){
                        swap(arr, j, j-gap);
                    }
                }
            }
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
