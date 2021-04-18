

// 额外空间复杂度O(1)
public class  HeapSort {
    public static void heapSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }


        // 1. 让数组变成一个大根堆
        // 方法一：O(N*logN)
        for(int i = 0; i < arr.length; i++){  // O(N)
            heapInsert(arr, i); // O(logN)
        }

        // 方法二：O(N)
        for(int i = arr.length - 1; i >= 0; i--){
            heapify(arr, i, arr.length);
        }

        // 2.依次pop出最大值
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);

        // O(N*logN)
        while(heapSize > 0){  // O(N)
            heapify(arr, 0, heapSize);   // O(logN)
            swap(arr, 0, --heapSize);    // O(1)
        }
    }

    // heap[index]刚来的数，往上调整
    private static void heapInsert(int[] heap, int index){
        // 比较当前节点和父节点， 如果当前节点值比父节点值大，则交换；否则，不动
        
        // 边界条件 
        // 1.heap[index] <= heap[(index - 1) / 2]
        // 2.index = 0   heap[0] > heap[(0 -1)/2]  ==> heap[0] > heap[0] 不成立
        while(heap[index] > heap[(index - 1) / 2]){
            swap(heap, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // arr[index]当前节点，往下调整
    public static void heapify(int[] arr, int index, int heapSize){
        int left = index * 2 + 1;
        while(left < heapSize){ // 当有孩子的情况下（左孩子下标不越界）
            // 左右两个孩子，谁大，谁把下标给largest
            // 右孩子胜出 1）有右孩子  2）右孩子值>左孩子值
            // 否则左孩子胜出
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            
            largest = arr[largest] > arr[index] ? largest : index;
            
            // 当前index节点大于两个孩子节点
            if(largest == index){
                break;
            }

            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }


    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
