public class BubbleSort{
    int[] arr;
    int length;
    public BubbleSort(int[] myArray, int arrayLength){
        arr = myArray;
        length = arrayLength;
    }
    public void swap(int x,int y){
        int temp = arr[x];
        arr[x]  = arr[y];
        arr[y] = temp;
    }
    public void sort(){
        boolean swapped = false;
        for(int i = 0; i< length - 1 ;i++){
            for(int j = 0; j < length - 1 - i ; j++){
                if(arr[j]>arr[j+1]){
                    swap(j,j+1);
                    swapped = true;
                }
            }
            if(!swapped){
                return;
            }
            swapped = false;
        }
    }
    public void print(){
        for(int i = 0; i< arr.length; i++){
            System.out.print(arr[i]+",");
        }
    }
    public static void main(String[] args){
        int[] arr = {5,2,4,1,3};
        BubbleSort bsrt = new BubbleSort(arr, arr.length);
        bsrt.sort();
        bsrt.print();
    }
}