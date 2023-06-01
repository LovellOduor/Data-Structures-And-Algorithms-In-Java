public class ThreeSum{
    
    public void threeSum(int[] arr,int target){
       
        for(int i = 0; i < arr.length - 2; i++){
            int k = i + 1;
            int j = arr.length - 1;
            while(k < j){
                int sum = arr[i] + arr[j] + arr[k];
                if(sum==target){
                    System.out.println(arr[i]+" "+arr[j]+" "+arr[k]);
                    j--;
                    k++;
                }else if(sum<target){
                    k++;
                }else{
                    j--;
                }
            }
        }        
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9};
        new ThreeSum().threeSum(arr,6);
    }

}