public class RearrangeSortedArray{

    public void sort(int[] arr){
    
        int minIdx = 0;
        int maxIdx = arr.length -1;
        int max = arr[maxIdx] + 1;

        for(int i = 0; i < arr.length; i++){
            if(i%2 == 0){
                arr[i] = arr[maxIdx] + (arr[maxIdx] % max) * max;
                maxIdx--;
            }else{      
                arr[i] = arr[minIdx] + (arr[minIdx] % max) * max;
            }
        }

        for(int i= 0; i < arr.length; i++){
            arr[i] = arr[i]/max;
        }
    }

    public void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i+", ");
        }
    }

    public static void main(String[] args){
        RearrangeSortedArray rsrta = new RearrangeSortedArray();
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        rsrta.sort(arr);
        rsrta.printArray(arr);
    }
}