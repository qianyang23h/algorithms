import java.util.PriorityQueue;
import java.util.Comparator;



// 使用系统提供的堆结构PriorityQueue
public class ContainerHeap {
    
    // 例题：
    // 已知一个几乎有序的数组。几乎有序是指，如果把数组排好序的话，每个元素移动的距离一定不超过k，
    // 并且k相对于数组长度来说是比较小的。请选择一个合适排序策略，对这个数组排序。
    // 时间复杂度：O(N*logK)
    public void sortedArrDistanceLessK(int[] arr, int K){
        // 默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        // 将前K+1个数push进堆(0..K), 这K+1个数必有一个数放在0位置
        int index = 0;
        for(; index <= Math.min(arr.length-1, K); index++){
            heap.add(arr[index]);
        }

        int i = 0;


        for(; index < arr.length; index++, i++){
            arr[i] = heap.poll();
            heap.add(arr[index]);
        }

        while(!heap.isEmpty()){
            arr[i++] = heap.poll();
        }
        
    }


    // 自定义一个比较器，将PriorityQueue的默认小根堆变成大根堆
    public static class MyComp implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
        
    }

    public static void main(String[] args) {
        // // PriorityQueue默认是一个小根堆
        // PriorityQueue<Integer> heap = new PriorityQueue<>();
        // heap.add(5);
        // heap.add(6);
        // heap.add(3);
        // heap.add(2);
        // heap.add(0);

        // while(!heap.isEmpty()){
        //     System.out.println(heap.poll());
        // }


        // PriorityQueue变成一个大根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(new MyComp());
        heap.add(5);
        heap.add(6);
        heap.add(3);
        heap.add(2);
        heap.add(0);

        while(!heap.isEmpty()){
            System.out.println(heap.poll());
        }
    }

    

}
