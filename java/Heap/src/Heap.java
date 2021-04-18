public class Heap {
    public static class MyMaxHeap{
        private int[] heap;
        private final int limit;
        private int heapSize;

        // 构造函数
        public MyMaxHeap(int limit){
            heap = new int[limit];
            this.limit =  limit;
            heapSize = 0;
        }

        public boolean isEmpty(){
            return heapSize == 0;
        }

        public boolean isFull(){
            return heapSize == limit;
        }

        // 用户此时，返回最大值，并在大根堆中，把最大值删掉，剩下的数依然保持大根堆
        public int pop(){
            int ans = heap[0];
            swap(heap, 0, --heapSize);
            heapify(heap, 0, heapSize);
            return ans;
        }

        // 从index位置，往下看，不断下沉
        // 终止条件：1.子节点都不比我大  2.无子节点
        public void heapify(int[] arr, int index, int heapSize){
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


        public void Push(int value){
            if(heapSize == limit){
                throw new RuntimeException("heap is full")
            }
            heap[heapSize] = value;
            heapInsert(heap, heapSize++);
        }

        private void heapInsert(int[] heap, int index){
            // 比较当前节点和父节点， 如果当前节点值比父节点值大，则交换；否则，不动
            
            // 边界条件 
            // 1.heap[index] <= heap[(index - 1) / 2]
            // 2.index = 0   heap[0] > heap[(0 -1)/2]  ==> heap[0] > heap[0] 不成立
            while(heap[index] > heap[(index - 1) / 2]){
                swap(heap, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        private void swap(int[] arr, int i, int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }


    }

    public static void main(String[] args) {
        
    }





}
