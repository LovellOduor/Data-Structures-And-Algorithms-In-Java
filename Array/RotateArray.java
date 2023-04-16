public class RotateArray{
    public void rotate(int[] arr,int count){
        // Reverse the entire array
        reverse(arr,0,arr.length-1);
        // Reverse the elements from the start to the given count
        reverse(arr,0,count-1);
        // Reverse the remaining elements after the previously reversed batch so they are back in
        // the correct order
        reverse(arr,count,arr.length-1);
    }

    public void reverse(int[] arr,int start,int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public void printArray(int[] arr){
        for(int i:arr){
            System.out.print(i+", ");
        }
    }
    
    public static void main(String[] args){
        // input 1,2,3,4,5,6 rotate 2
        // output 5,6,1,2,3,4
        RotateArray rta = new RotateArray();
        int[] arr = {1,2,3,4,5,6};
        rta.rotate(arr,3);
        rta.printArray(arr);   
    }
}