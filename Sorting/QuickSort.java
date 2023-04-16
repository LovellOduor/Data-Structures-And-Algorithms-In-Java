//Quicksort
/*
This is a diivide and conquere algorithm that breaks the array into subarrays while sorting
the subarrays. It can be performed by the following steps.
1. Determining a pivot point to partion the array.
2. Partition the array based on the pivot point.
3. Repeat the process for the subarray to the left of the pivot exclusive of the pivot.
4. Repeat the process for the subarray to the right of the pivot exclusive of the pivot.
*/

public class QuickSort{
    public void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    // Partitioning 
    /* This is the first stage of quick sort that involves splitting the array into two
    to do this we take a pivot value that will allow us to sort all the values less than it
    to the left of the array and all the values grater than it to the right of the array.
    - All the values from the low indext to the lowPtr -1 index will be less than our pivot.
    - All the values from the highPointer to high will be larger than our pivot value.
    - The highPtr - 1 will be equal to our pivot value after partitioning as it will end up in
      the middle of the array.
    */
    public int partition(int[] arr,int low, int high){
        int lowPtr = low;
        int pivot = arr[high];
        int highPtr;
        for(highPtr=low; highPtr <= high; highPtr++){
            if(arr[highPtr] <= pivot){
                swap(arr,lowPtr,highPtr);
                lowPtr++;
            }
        }
        return lowPtr - 1;       
    }

    // Sort
    /*
    The sort operation is performed recursively to sort the entire array.
    The base case checks whether low is less than high, meaning we have divided
    a sub-array until it's gotten to a single value.
    We use the value returned from partition to sort the left part of the array
     divided by the pivot and the right part, without including the pivot.
    */
    public void sort(int[] arr, int low, int high){
        if(low < high){
            int pivotPtr = partition(arr,low,high);
            sort(arr,low,pivotPtr-1);
            sort(arr,pivotPtr+1,high);
        }
    }
    public void printArray(int[] arr){
        for(int i: arr){
            System.out.print(i+", ");
        }
    }
    public static void main(String[] args){
        int[] arr = {1,2,4,5,7,8,9,10,6};
        QuickSort qsrt = new QuickSort();
        qsrt.sort(arr,0,arr.length-1);
        qsrt.printArray(arr);
    }
}