// Dutch national flag / Sorting an array of zeros, ones and twos
/*
This algorithm is typicaly applied to sorting an array of zeros, ones and twos ins such a
manner that zeros are at the begining of the array, ones in the middle and twos at the end.

0000000000
1111111111
2222222222

Procedure
1. Create pointers for the ones (onePtr) intialized tp zero and twos (twoPtr)
initialized to the index of the last element of the array, and an index (i) to iterate through the
values in the array. Note we don't have a pointer for ones because they'll end up in the middle.
2. We loop while the iteration pointer i is less than or equal to the twoPtr cause the twos
at the end of the array will be sorted.
3. We consider three cases if the value at the i index is equal to 0 we swap that value
with the value at the zeroPtr, and increment both by 1;
4. If the value at index i is equal to 1, we simple increment i.
5. if the value at the i index is 2, then we swap that with the value at the twoPtr
and decrement the twoPtr by 1
*/
public class DutchNationalFlag{
    public void swap(int[] arr, int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    public void sort(int[] arr){
        int zeroPtr = 0;
        int twoPtr = arr.length-1;
        int i = 0;
        while(i <= twoPtr){
            if(arr[i] == 0){
                swap(arr,i,zeroPtr);
                zeroPtr++;
                i++;
            }else if(arr[i] == 1){
                i++;
            }else if(arr[i] == 2) {
                swap(arr,i,twoPtr);
                twoPtr--;
            }
        }
    }
    public void printArray(int[] arr){
        for(int i: arr){
            System.out.print(i+", ");
        }
    }
    public static void main(String[] arg){
        int[] arr = {0,1,2,2,2,0,1,1,1,0,2,1};
        DutchNationalFlag dnf = new DutchNationalFlag();
        dnf.sort(arr);
        dnf.printArray(arr);
    }
}