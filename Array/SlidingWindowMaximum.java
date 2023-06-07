import java.util.Stack;
public class SlidingWindowMaximum{

    private int[] nextGreaterElement(int[] arr){
        int[] result = new int[arr.length];
        Stack<Integer> grtElements = new Stack<>();
        for(int i = arr.length-1; i>=0; i--){
            if(!grtElements.isEmpty()){
                while(!grtElements.isEmpty() && arr[grtElements.peek()]<=arr[i]){
                    grtElements.pop();
                }
            }
            if(grtElements.isEmpty()){
                result[i] = arr.length;                
            }else{
                result[i] = grtElements.peek();
            }
            grtElements.push(i);
        }
        return result;
    }


    
    /**
     * Given an array of integers arr, there is  sliding window of size k which
     * is moving from the very left of the array to the very right.
     * You can only see the k numbers in the window. Each time the
     * siding window moves right by one position. 
     * Return the max sliding window.
     * Input: arr = {44,77,33,44,88,11}, k=3
     * Output: arr = {77,77,88,8}
     */

    public int[] slidingMax(int[] arr,int k){
        int[] result = new int[arr.length+1-k];
        int[] nextGreaterElements = nextGreaterElement(arr);
        for(int i = 0;i<=arr.length-k;i++){
            int nextGreaterIndex = i;
            while(nextGreaterElements[nextGreaterIndex] < i+k){
                nextGreaterIndex = nextGreaterElements[nextGreaterIndex];
            }
            result[i] = arr[nextGreaterIndex];
        }
        return result;
    }

    public static void main(String[] args){
        int[] arr = {44,77,33,44,88,11};
        SlidingWindowMaximum swm = new SlidingWindowMaximum();
        for(int e:swm.slidingMax(arr,3)){
            System.out.print(e+", ");
        }  
    }
}