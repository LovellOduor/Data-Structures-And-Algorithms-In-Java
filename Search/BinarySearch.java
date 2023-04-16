public class BinarySearch{
    public boolean search(int[] arr,int arrayLength,int value){
        int min = 0;
        int max = arrayLength - 1;
        while(min <= max){
            int mid = (min+max)/2;
            if(arr[mid] == value){
                return true;
            }
            if(value < arr[mid]){
                max = mid-1;
            }else{
                min = mid+1;
            }    
        }
        return false;        
    }

    /* 
    Given a sorted array of distinct integers and a target value return the index
    if the target is found. If not return the index where it would be if it where inserted in 
    order. The algorithm should run in O (log n) time.
    */

    public int insertIndexPosition(int[] arr, int arrayLength, int value){
        int min = 0;
        int max = arrayLength-1;
        while(min<=max){
            // We assign mid to min + (max - min) / 2 to avoid integer overflow error
            int mid = min + (max - min) / 2;
            if(value == arr[mid]){
                return mid;
            }
            if(value < arr[mid]){
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }
        // We return min or the lowest value for in the case that both min and max
        // point to zero max could end up being negative while min would be zero or incremented
        // to one in certain cases when both max and min are equal.
        return min;
    }

    public static void main(String[] args){
        BinarySearch bs = new BinarySearch();
        int[] arr = {1,2,3,4,5,6};
        // System.out.println(bs.search(arr,arr.length,5));
        System.out.println(bs.insertIndexPosition(arr,arr.length,7));
    }
}