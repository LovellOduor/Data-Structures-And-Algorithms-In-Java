public class SquaresSortedArray{
    public int[] sort(int[] arr){
        int[] result = new int[arr.length];
        int resultIdx = arr.length - 1;
        int startIdx = 0; 
        int endIdx = arr.length-1;
        for(int i = arr.length-1; i>=0; i--){
            if(Math.abs(arr[startIdx]) > Math.abs(arr[endIdx])){
                result[i] = arr[startIdx] * arr[startIdx];
                startIdx++;
             }else{
                result[i] = arr[endIdx] * arr[endIdx];
                endIdx--;
            }
        }
    return result;
    }

    public void printArray(int[] arr){
        for(int i:arr){
            System.out.print(i+", ");
        }
    }

    public static void main(String[] args){
        int[] arr = {-5,-4,-3,-2,-1,0,1,2,7,8,10};
        SquaresSortedArray ssrta = new SquaresSortedArray();
        int[] result = ssrta.sort(arr);
        ssrta.printArray(result);
    }
}