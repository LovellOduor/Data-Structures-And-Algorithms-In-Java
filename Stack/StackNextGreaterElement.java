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
    So we start looping the array from the end because 
    the last item has no greater element to it's right.
    if the stack is not empty
    We then begin by checking if numbers in the stack are less or equal
    to the current element if so then we remove them.
    if the stack is not empty after this then 
    the top element of the stack is greater than the element 
    in the current index of the array.
    if its empty then we assign -1 to the curren element in the result array
    on every iterration we push the current element in the numbers array 
    to the stack.
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

            if(numbers.isEmpty()){
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