// Kadane's  Algorithm or Maximum sum Sub-Array
/*
Given an array we find the maximum sum that can be obtained from adding values
in a given subarray/range.
*/
public class MaximumSumSubarray{
    public int maximumSum(int[] arr){
        // We start with the first element in the array as the max sum and 
        // current maximum value
        int currentMax = arr[0];
        int maxSum = arr[0];
        // We loop starting from the second element in the array with index 1
        for(int i = 1; i < arr.length; i++){
            // We check whether the sum of the currentMax and the element at the current
            // index is greater than the element at the current index and set it to be our
            // current max
            currentMax = Math.max((currentMax + arr[i]),arr[i]); 
            // if the current max is greater than our stored maximum sum then we
            // set our maximum sum to be equal to the current max
            if(currentMax > maxSum ){
                maxSum = currentMax;
            }

        }
        return maxSum;

    }
    public static void main(String[] args){
        int[] arr = {4,3,-2,6,-12,7,-1,6};
        MaximumSumSubarray maxSumSub = new MaximumSumSubarray();
        System.out.print("Max Sum Sub-Array "+ maxSumSub.maximumSum(arr));
    }
}