public class LinearSearch{
    public boolean search(int[] arr,int arrLength,int value){
        for(int i=0;i<arrLength;i++){
            if(arr[i] == value){
                return true;
            }
        }
        return false;
    } 
    
    public static void main(String[] args){
        LinearSearch ls = new LinearSearch();
        int[] arr = {1,2,3};
        System.out.println(ls.search(arr,3,4));
    }
}