public class OneDimensionalArray{
        // Printing the elements of an array
        public void printArray(int arr[]){
            int n = arr.length;
            for(int i=0;i<n;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
        // Remove even integers from an array
        int[] removeEven(int arr[]){
            int n = arr.length;
            int oddArrayLength = 0;
            for(int i=0;i<n;i++){
                if(arr[i]%2 != 0){
                    oddArrayLength++;
                }            
            }
            int oddArray[] = new int[oddArrayLength];
            int idx = 0;
            for(int i=0;i<n;i++){
                  if(arr[i]%2 != 0){
                    oddArray[idx]=arr[i];
                    idx++;
                } 
            }
            return oddArray;
        }

        public void arrayDemo(){
            int[] myArray = new int[5];
            printArray(myArray);
        }
    

    public static void main(String[] args){
        OneDimensionalArray arrutil = new OneDimensionalArray();
        arrutil.arrayDemo();
        int[] nums = {1,2,3,4,5,6,7,8,9};
        arrutil.printArray(arrutil.removeEven(nums));
    }

}