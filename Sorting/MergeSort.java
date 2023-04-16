//Merge Sort 
/*
Merge sort is a divide and conquer algorithm that divides a large problem into 
two or more sub-problems of the same or related type. Until it becomes simple 
enough to solve directly. The solutions to the sub problems are then combined to
form a final solution to the problem.
Steps
Divide 
1. Divide the array into segments recursively, by spliting it into half
   until it can't be divided further.
Conquer
2. We take the smaller divided arrays, sort them and merge to get the sorted array

Illustration

                        [2, 10, 5, 3, 6, 4, 11]
                                  / \
 -- We split                     /   \                -- We split from mid + 1 to high
from low to mid      [2, 10, 5, 3]    [6, 4, 11]     
                          / \              / \
                         /   \            /   \
                    [2, 10]  [5, 3]   [6, 4]   [11]
-- At this point the  / \      / \      / \      |    -- This means the array can't be 
low index is         /   \    /   \    /   \     |    further divided into segments. so we return
equal to the high  [2]  [10] [5]  [3] [6]  [4]   |    from the sort operation and proceed to merge
                    \    /    \   /    \   /     |    -- The algorithm will then revert to the previous
                     \  /      \ /      \ /           array and pass it to the merge operation in which it will also    
                    [2, 10]   [3, 5]   [4, 6]  [11]   perform the actual sorting. 
                       \       /          \     /                           
                        \     /            \   / 
                    [2, 3, 5, 10]       [4, 6, 11]  
                          \                  /   
                           \                / 
                         [2, 3, 4, 5, 6, 10, 11]
-- The left part of the array
is usually sorted first followed
by the right part
*/

public class MergeSort{
    public void merge(int[] arr, int[] temp, int low, int mid, int high){
        // We add all the values we want sorted from the input array to the temporary array
        for(int i = low; i <=high; i++){
            temp[i] = arr[i];
        }
        // We keep track of the indices for both the left part i starting from low
        // and j starting from mid+1 that tracks the right array indices and finally
        // k that traverses the original array.
        int i = low; int j = mid + 1; int k = low;

        while(i<=mid && j<= high){
            // We compare the values and update the least value to the original array
            // while incrementing the respective array indices as well as the original 
            // array index.
            if(temp[i] <= temp[j]){
                arr[k] = temp[i];
                i++;
            }else{
                arr[k] = temp[j];
                j++;
            }
            k++;
        }
        // Finally we iterate thorugh the values in the left part of the array that 
        // are already sorted but were greater than the right array values
        // and append them to the original array. 
        // Note if the left array values are exhausted first, the right array 
        // values should already be ordered in the original array
        while(i<= mid){
            arr[k] = temp[i];
            i++;
            k++;
        }
    }
    public void sort(int[] arr, int[] temp, int low, int high){
        // We check whether we have completley divided an array segment up to it's final
        // element if so we return from the sort operation
        if(low < high){
            // We store the mid value of the array this way to avoid an integer overflow error for large int values 
            int mid = low + (high - low)/2;
            // We sort the left part considering low to mid
            sort(arr, temp, low, mid);
            // We sort the right part considering mid to high
            sort(arr, temp, mid+1, high);
            // Finally we perform the merge operation
            merge(arr,temp,low,mid,high);
        }
    }
    public void printArray(int[] arr){
        for(int i:arr){
            System.out.print(i + ", ");
        }
    }
    public static void main(String[] args){
       int[] arr = {1,5,3,7,8,2,6,4};
       int[] temp = new int[8];
       MergeSort mrgsrt = new MergeSort();
       mrgsrt.sort(arr,temp,0,arr.length -1);
       mrgsrt.printArray(arr);
    }
}