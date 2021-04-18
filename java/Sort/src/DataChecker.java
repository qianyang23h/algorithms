import java.util.Random;


import java.util.Arrays;

public class DataChecker {
    static int[] generateRandomArray(){
        Random r = new Random();
        int[] arr = new int[1000];
        for(int i = 0 ; i < arr.length; i++){
            arr[i] = r.nextInt(1000); 
        }
        return arr;
    }

    static void check(){
        int[] arr = generateRandomArray();
        int[] arr2 = new int[arr.length];
        // 这里需要复制一下arr
        System.arraycopy(arr, 0, arr2, 0, arr.length);

        Arrays.sort(arr);
        // SelectionSort.selectionSort(arr2);
        // BubbleSort.bubbleSort(arr2);
        ShellSort.sort(arr2);

        boolean same = true;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != arr2[i]) same = false;
        }
        System.out.println(same == true ? "right" : "wrong");;

    }

    public static void main(String[] args) {
        check();
    }
}
