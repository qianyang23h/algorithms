


// 归并排序
public class MergeSort {

    public static void main(String[] args) {
        // int[] arr = {2, 3, 1, 5, 7, 4, 6 ,8 ,9};
        int[] arr = {1,4,7,8, 3,6,9};   //构造一个前后两个子数组已经排好顺序的数组 

        // merge(arr, 0, 4, arr.length - 1);
        sort(arr, 0, 6);

        print(arr);
    }

    static void sort(int[] arr, int left, int right){
        if(left == right) return;

        // 分为两半
        // int mid = (right + left) / 2;  // 这种情况可能出现int值溢出的情况
        int mid = left + (right -left) / 2;
        // 左边排序
        sort(arr, left, mid);
        // 右边排序
        sort(arr, mid+1, right);
        // 将左右排好序的两子数组合并
        merge(arr, left, mid+1, right);
    }

    // 将两个有序的子数组进行合并
    static void merge(int[] arr, int leftPtr, int rightPtr, int rightBound){
        int mid = rightPtr - 1;
        int[] temp = new int[rightBound - leftPtr + 1];

        // 定义三个指针i，j，k
        int i = leftPtr;
        int j = rightPtr;
        int k = 0;

        while(i <= mid && j <= rightBound){
            if(arr[i] <= arr[j]){  // 此处判断为<=，保证这是一个稳定的排序方法，遇到相等的数字，前后顺序不变
                temp[k++] = arr[i++];
            }
            else{
                temp[k++] = arr[j++];
            }
        }

        // 检查两个子数组是否有剩余没有添加到temp[]中的元素
        while(i <= mid) temp[k++] = arr[i++];
        while(j <= rightBound) temp[k++] = arr[j++];
        
        // print(temp);
        // 将temp数组赋值给arr
        for(int m = 0; m < temp.length; m++){
            arr[leftPtr + m] = temp[m];
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
