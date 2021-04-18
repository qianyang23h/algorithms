public class QuickSort {


    public static void main(String[] args) {
        int[] arr = {1,2,6,3,6,4,7,6};
        partition(arr, 0, arr.length-1);

        print(arr);
    }


    static void sort(int[] arr, int leftBound, int rightBound){
        if(leftBound >= rightBound) return;

        partition(arr, leftBound, rightBound);

        // // 左边排序
        // sort(arr, leftBound, mid-1);
        // // 右边排序
        // sort(arr, mid+1, rightBound);


    }


    // 通过pivot，将数组分为左右两个部分，左边部分小于pivot，右边部分大于pivot
    static void partition(int[] arr, int leftBound, int rightBound){
        int pivot = arr[rightBound];
        // 定义左右两端指针
        int left = leftBound;
        int right = rightBound - 1;


        while(left < right){  // 边界条件：找到povit的位置，即left == right
            while(left < right && arr[left] <= pivot) left++;   // 左边判别条件是arr[left] <= pivot
            while(left < right && arr[right] > pivot) right--;  // 右边判别条件是arr[right] > pivot  避免出现这种情况：1 2 6 3 6 4 6 7
            swap(arr, left, right);
            

            // 打印中间信息，调bug
            System.out.println("after swap, left->" + left + " right->" + right);
            print(arr);
            System.out.println();
        }
        // 当left = right就是povit在数组中正确的索引位置 
        swap(arr, left, rightBound);

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
