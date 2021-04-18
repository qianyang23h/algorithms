

// 插入排序
// 平均时间复杂度: O(n^2)
// 最好情况时间复杂度：O(n)
// 插入排序时优于选择排序和冒泡排序的，因为插入排序每次都是将数字插入已经排好序的数组中，减少了比较的次数。


// 总结三种简单排序方法：
// 冒泡：基本不用，太慢（两两比较，两两交换）
// 选择：基本不用，不稳定
// 插入：样本小且基本有序时，效率比较高


public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 5, 7, 4, 6 ,8 ,9};
        sort_improve(arr);    
        print(arr);
    }


    static void sort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            for(int j = i; j > 0; j--){
                if(arr[j] < arr[j-1]){
                    swap(arr, j, j-1);
                }
            }
        }
    }


    // 定义一个临时变量tmp保存标记项arr[i]，找到插入的位置后，再插入
    static void sort_improve(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int tmp = arr[i];
            int vacancy = i; // vacancy用来记录空缺的位置
            int j;
            for(j = i; j > 0; j--){
                if(tmp < arr[j-1]){
                    arr[j] = arr[j-1];
                    vacancy = j - 1;
                }
            }
            arr[vacancy] = tmp; 
        }
        

        // 最优写法：将判断写入for循环中（这样就不需要定义vacancy变量记录空缺位置）
        // for (int i = 1; i < arr.length; i++) {
		// 	int e = arr[i];
		// 	int j;
		// 	for (j = i; j > 0 && e < arr[j - 1]; j--) {
		// 		arr[j] = arr[j - 1];
		// 	}
		// 	arr[j] = e;
		// }
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
