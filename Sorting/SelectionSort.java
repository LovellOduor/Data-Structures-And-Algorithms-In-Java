// Selection Sort
/*
The algortithm works by keeping track of both a sorted and unsorted array.
On every iteration it loops through the values in the unsorted array, finds 
the minimum value and adds it to the sorted array.
Steps
1. Create an outer loop which starts from zero and loops until the second last value of the array 
this index will be our sorted array index.
2. Create variable minIndex initialized to the outer loop index to keep track of the minimum value in
the unsorted array. Loop through the unsorted array starting from the sorted array index offset by one (index + 1)
until the last value in the array. Using an if statement check if the value in the unsorted array is less
than the value stored by our minIndex if so then it becomes our new minIndex.
3. After exiting the loop, we swap the value in our minIndex with the value of our sorted Index (the outer loop current index)
*/
public class SelectionSort{
    public void swap(int[] arr, int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    
    public void sort(int[] arr, int arrLength){
        for(int sortedIdx = 0; sortedIdx < arrLength - 1; sortedIdx++){// sorted Loop
            int minIdx = sortedIdx;
            for(int unsortedIdx = sortedIdx+1; unsortedIdx < arrLength; unsortedIdx++){
                if(arr[unsortedIdx] < arr[minIdx]){
                    minIdx = unsortedIdx;
                }
            }
            swap(arr,minIdx,sortedIdx);
        }
    }

    public void printArray(int[] arr, int arrLength){
        for(int i = 0; i < arrLength; i+= 1){
            System.out.print(arr[i]+", ");
        }
    }

    public static void main(String[] args){
        int[] arr = {5,3,2,1};
        SelectionSort ssrt = new SelectionSort();
        ssrt.sort(arr,arr.length);
        ssrt.printArray(arr,arr.length);
    }
}