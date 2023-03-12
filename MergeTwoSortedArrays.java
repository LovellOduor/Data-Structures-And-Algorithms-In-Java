/* MergeTwoSorted arrays */
/*
1. The we pass two arrays array1 and array2 as well as their lengths. length1 and length2.
Wwe create a result array to store the merged arrays. And initialize pointers for the
result array, array1 and array2 to zero. 
2. Using a while loop we check whether we have reached the end of either array by checking whether the 
index/pointer of each array is less than the array's respective length.
3. Within the while loop, we compare the current value of array1 to that of array2 we add the lesser 
value into the result array and increment the array's index as well as the result array's index.
4. Finally if we exhaust either array and the while loop breaks, we add two while loops
checking whether the value of the either array is exhausted and if so we add all the remaining elemnts
to the result array and return the result.

*/
public class MergeTwoSortedArrays{
    public int[] merge(int arr1[], int arr2[], int n, int m){
        int[] result = new int[n+m];
        int i = 0; int j = 0; int k = 0;
        while(i<n && j<m){
            if(arr1[i] < arr2[j]){
                result[k] = arr1[i];
                i++;
            }else{
                result[k] = arr2[j];
                j++;
            }
            k++;
        }
        while(i<n){
            result[k] = arr1[i];
            k++;
            i++;
        }
        while(j<m){
            result[k] = arr2[j];
            k++;
            j++;
        }
        return result;
    }
    public void printArray(int[] arr){
        for(int c : arr){
            System.out.print(c+", ");
        }
    }
    public static void main(String[] args){
        MergeTwoSortedArrays m2arrs = new MergeTwoSortedArrays();
        int[] arr1  = {1,2,5,6};
        int[] arr2 = {3,4,7,8};
        int[] result = m2arrs.merge(arr1,arr2,arr1.length,arr2.length);
        m2arrs.printArray(result);
    }
}