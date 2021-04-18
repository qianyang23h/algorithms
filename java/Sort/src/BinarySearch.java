public class BinarySearch {
    
    public static void main(String[] args) {
        int[] arr = {1,4,4,4,5,7,9};
        int res = getLessIndex(arr);
        System.out.println(res);
    }

    // 二分查找
    static int binarySearch(int[] sortedArr, int target){
        int left = 0;
        int right = sortedArr.length - 1;
        int mid = 0;
        while(left <= right){  // 边界条件搜索空间为空时终止，即left>right
            // mid = (left + right) / 2 这种写法容易出现int值溢出
            // mid = left = (right -left) / 2
            // N / 2  ==  N >> 1
            mid = left + ((right - left) >> 1);
            if(sortedArr[mid] == target){
                return mid;
            }
            else if(sortedArr[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return -1;
    }

    // 在一个有序数组中，找>=某个数最左侧的位置 
    static int left_bound(int[] sortedArr, int target){
        int left = 0;
        int right = sortedArr.length - 1;
        int index = -1; // 用来记录最左对号
        while(left <= right){
            int mid = left + ((right - left) >> 1);
            if(sortedArr[mid] >= target){
                index = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return index;
    }

    // 在一个有序数组中，找<=某个数最右侧的位置 
    static int right_bound(int[] sortedArr, int target){
        int left = 0;
        int right = sortedArr.length - 1;
        int index = -1; // 用来记录最左对号
        while(left <= right){
            int mid = left + ((right - left) >> 1);
            if(sortedArr[mid] <= target){
                index = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return index;
    }


    // 寻找局部最小(相邻数不相等)
    static int getLessIndex(int[] arr){
        if(arr.length == 0 || arr == null){
            return -1;
        }
        
        // 判断index=0是否为局部最小值
        if(arr[0] < arr[1] || arr.length == 1){
            return 0;
        }
        // 判断index=arr.length-1是否为局部最小值
        if(arr[arr.length-1] < arr[arr.length-2]){
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length - 2;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] > arr[mid-1]){
                right = mid - 1;
            }
            else if(arr[mid] > arr[mid+1]){
                left = mid + 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }

}
