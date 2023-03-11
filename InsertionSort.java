public class InsertionSort{
    public void printArray(int arr[]){
        for(int i = 0; i<arr.length;i++){
            System.out.print(arr[i]+", ");
        }
    }

    // Insertion Sort
    public void sort(int[] arr, int arrayLength){
        // Note that we start looping from the nextValue from the start of the array with index 1
        // because we consider the first value of the array as the first value in the sored part of the
        // array.
        for(int i = 1; i < arrayLength; i++){
            int nextVal = arr[i];
            int currentIdx = i - 1;
            /* We loop checking whether the current Index in the sorted array is greater
            than or equal to zero or greater than the nextValue in the unsorted array
            if so we set the next value in the unsorted array to the current value in the
            sorted array. We do this in a while loop so as to compare the value that was 
            in the sorted array with the stored val from unsorted array and with all previous values 
            in the sorted array, while shifting array values to the right until we find a value that's lesser and final exit the while loop */
            while(currentIdx >= 0 && arr[currentIdx]>nextVal){
                // Shift array values to the right
                arr[currentIdx + 1] = arr[currentIdx];
                // Move the current index to it's previous value 
                currentIdx = currentIdx - 1; 
            }
            // Move the current index to it's next value and assign the value stored 
            // from the unsorted part of the array to it's appropriate location in the sorted part.
            arr[currentIdx + 1] = nextVal;
        }
    }

    public static void main(String[] args){
        InsertionSort isrt = new InsertionSort();
        int[] arr = {5,2,4,1,3};
        isrt.sort(arr, arr.length);
        isrt.printArray(arr);
    }
}