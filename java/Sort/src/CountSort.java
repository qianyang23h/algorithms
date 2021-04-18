import java.util.Arrays;



// 计数排序
// 空间复杂度:O(n+k)
// 算法特点：量大但范围小
//          如：某大型企业数万名员工年龄排序
//          如：如何快速得知高考名次（腾讯面试）



public class CountSort {
    
    public static void main(String[] args) {
        int[] arr = {0,1,2,0,5,3,2,4,5,1,3};
        // int[] output = sort1(arr);
        sort2(arr);
        // print(output);
    }

    // 基础版
    static int[] sort1(int[] arr){
        int[] output = new int[arr.length];
        int[] count = new int[6];

        for(int i = 0; i < arr.length; i++){
            count[arr[i]]++;
        }

        // System.out.println("count->");
        // print(count);
        // System.out.println();

        int i = 0;
        int j = 0;
        while(i < count.length){
            while(count[i]-- > 0) output[j++] = i;
            i++;
        }

        return output;
    }
    
    // 优化版
    // 基础版有一个缺点，数组范围101~150，我们却要创建一个长度为151的count[]，前面[0,100]都浪费啦
    static void sort2(int[] arr){
        // 找数组的最大值，最小值
        int max = arr[0];
        int min = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max) max = arr[i];
            if(arr[i] < min) min = arr[i];
        }
        int range = max - min; // 统计最大值和最小值的差值
        int[] count = new int[range+1];
        int[] output = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            count[arr[i]-min]++;
        }

        System.out.println(Arrays.toString(count));

        // 这里就和arr[]数组没关系啦
        int i = 0;
        int j = 0;
        while(j < count.length){
            while(count[j]-- > 0) output[i++] = j + min;
            j++;
        }

        System.out.println(Arrays.toString(output));

    }

    // 进阶版
    // 改进上述算法，将计数排序变为一个稳定的排序算法
    static int[] sort3(int[] arr){
        int[] output = new int[arr.length];
        int[] count = new int[6];

        for(int i = 0; i < arr.length; i++){
            count[arr[i]]++;
        }
        System.out.println(Arrays.toString(count));

        // 累加count数组，存储的是位置信息，count[] = {3, 8, 10}，8表示最后一个1的下标是（8-1）
        // 3表示最后一个0的下标是（3-1）... 
        for(int i = 1; i < count.length ; i++){
            count[i] = count[i] + count[i-1];
        }
        System.out.println(Arrays.toString(count));

        
        for(int i = arr.length - 1; i >= 0 ; i--){
            output[--count[arr[i]]] = arr[i];
        }

        return output;
    }


    static void print(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
