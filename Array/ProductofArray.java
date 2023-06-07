public class ProductofArray{
/**
 *  Product of an array except self (the product excludes the element at the current index of the array)
 *  Given an array of integers arr[] return an array result[]
 *  such that result[i] is equal to the product of all elements of
 *  arr except arr[i]. The product fits in 32-bit integer. The algorithm
 *  should run in O(n) time and without using the division operator.    
 
    input:arr = {1,2,3,4}
    output:result = {24,12,8,6}
*/

/**
 * The solution comprises of two arrays, the first, we iterate from the 
 * left to right, storing the product of all the elements left to the 
 * current index in a result array.
 * We then iterate from right to left, find the product of the elements to
 * the right of the current index, and the previously stored value
 * in the result array, and storing the product at the current index in the result array;
 */
    public static int[] arrayProduct(int[] arr){
        int prod=1;
        int[] result = new int[arr.length];
        for(int i = 0; i< arr.length;i++){
            result[i] = prod;
            prod = prod * arr[i];            
        }
        prod = 1;
        for(int i=arr.length-1; i>-1; i--){
            result[i] = result[i] * prod;
            prod  = prod * arr[i];
        }
        return result;
    }

    public static void main(String[] args){
        int[]arr = {1,2,3,4};
        int[] res = arrayProduct(arr);
        for(int r:res){
            System.out.print(r+", ");
        }
    }
    
}