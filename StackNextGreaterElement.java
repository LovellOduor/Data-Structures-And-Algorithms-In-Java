import java.util.Stack;
public class StackNextGreaterElement{
    // Next greater element
    // Question
    /* Given an array of integers. For each element in the array, find its next 
    greater element in the array. The next greater element is the first element towards right,
    which is greater than the current element.  
    */
    // Solution
    /*
    
    */
    public static int[] nextGreaterElement(int[] nums){
        int[] result = new int[nums.length];
        Stack<Integer> numbers = new Stack<>();
        for(int i=nums.length -1; i >= 0; i--){

            if(!numbers.isEmpty()){
                while(!numbers.isEmpty() && numbers.peek() <= nums[i]){
                    numbers.pop();
                }
            }

            if(numbers.isEmpty() == true){
                result[i] = -1;
            }else{
                result[i] = numbers.peek();
            }

            numbers.push(nums[i]);
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums = {1,7,5,3,2,6,8,1,4,2};
        for(int r : nextGreaterElement(nums)){
            System.out.print(r+",");
        }

    }
}