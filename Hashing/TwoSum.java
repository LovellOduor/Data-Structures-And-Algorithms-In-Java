import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

/**
 Given an array of integers, return indices of the two numbers such that they add up
 to a specific target.
 Example
 {2,11,5,10,7,8} target = 9
*/

public class TwoSum{
    // Two Sum Hash Map implementation  
    /*
    Best applied when you want to return the indices of the elements
    that sum up to a given value
    */
    /*
    It applies the simple principle that
    x + y = target
    x = target - y or y = target - x
    We however utilize a hashmap to store the results
    if y is already stored in the hash map we can check 
    if the difference between x and the target results to y 
    if it does then we have found the two elements that sum up
    to ourdesired target. If not found we just store the current 
    element and index in the HashMap
    */


    public int[] twoSum(int[] arr,int target){
         int[] result = new int[2];
         Map<Integer,Integer> map = new HashMap();

        for(int i = 0; i < arr.length; i++){
            if(!(map.containsKey(target - arr[i]))){
                map.put(arr[i],i);
            }else{
                result[0] = map.get(target - arr[i]);
                result[1] = i;
                return result;
            }
        }       
    return result; 
    }

    // Two sum sorted Array implemenation
    /*
    Best applied when you want to return the elements that sum up to the target value
    */
    public int[] twoSumII(int[] arr,int target){
        int[] result = new int[2];
        Arrays.sort(arr);
        
        int left = 0;
        int right = arr.length-1;

        while(left<right){
            int sum = arr[left]+arr[right];
            if(sum == target){
                result[0] = arr[right];
                result[1] = arr[left];
                return result; 
            }else if(sum <  target){
                left++;
            }else{
                right--;
            }
        }
        return result;
    }


    // Two Sum  
    public static void main(String[] args){
        // Two sum implementation 1 demo
        TwoSum ts = new TwoSum();
        // int[] arr = {1,2,3,4,5,6,7};
        // int[] result = ts.twoSum(arr,9);
        // System.out.println("indices "+result[0]+","+result[1]);
         int[] arr = {7,1,4,5,6,2,3};
         int[] result = ts.twoSumII(arr,9);
         System.out.println("elements "+result[0]+","+result[1]);
        
    }
}