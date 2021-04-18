
public class BubbleSort {

    // 冒泡排序
    // 时间复杂度：O(n^2)  
    // 不稳定
    static void bubbleSort(int[] arr){

        
        for(int i = arr.length -1; i > 0; i--){
            findMax(arr, i);
        }
        print(arr);
    }


    // 当不会写多层嵌套的循环，可以将功能细化，逐一实现
    static void findMax(int[] arr, int index){
        for(int j = 0; j < index; j++){
            if(arr[j] > arr[j+1]){
                swap(arr, j, j+1);
            }
        }
    }

    static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[i+1];
        arr[i+1] = tmp;
    }

    static void print(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 4, 5, 7, 1};
        bubbleSort(arr);
    }
}
