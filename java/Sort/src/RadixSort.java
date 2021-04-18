import java.lang.Math;
import java.util.Arrays;




// 基数排序

public class RadixSort {
    


    public static void main(String[] args) {
        int[] arr = {123, 456, 222};
        int[] output = sort(arr);
        print(output);
    }


    static int[] sort(int[] arr){
        // 求最高位数
        // ...
        
        int[] output = new int[arr.length];
        int[] count = new int[10];

        for(int i = 0; i < count.length; i++){
            int division = (int)Math.pow(10, i);
            for(int j = 0; j < arr.length; j++){
                int num = arr[j] / division % 10;
                count[num]++;
            }


            // count累加数组
            for(int m = 1; m < count.length; m++){
                count[m] = count[m] + count[m-1];
            }

            for(int k = 0; k < arr.length; k++){
                int num = arr[k] / division % 10;
                output[--count[num]] = arr[k];
            }

            // 将output[]赋值给arr[],然后继续下一遍排序
            System.arraycopy(output, 0, arr, 0, arr.length);
            // 将count[]重置为0
            Arrays.fill(count, 0);

        }
        return output;
    }

    static void print(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
