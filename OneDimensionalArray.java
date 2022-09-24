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

        // Reverse an array in Java
        public int[] reversArray(int[] numbers,int start, int end){
            int temp;
            while(start < end){
                temp = numbers[start];
                numbers[start] = numbers[end];
                numbers[end] = temp;
                start++;
                end--;
            }
            return numbers;
        }

        // find minimum value in an array
        public int findMin(int arr[]){
            int minVal = arr[0];
            for(int i=0;i<arr.length;i++){
                if(arr[i]<minVal){
                    minVal = arr[i];
                }
            }
            return minVal;
        }

        // find maximum value in an array
        public int findMax(int[] arr){
            int maxVal = arr[0];
            for(int i=0;i<arr.length;i++){
                if(arr[i]>maxVal){
                    maxVal = arr[i];
                }
            }
            return maxVal;
        }

       // Find the second maximum value in an array
       public int findSecondMax(int arr[]){
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > max){
                secondMax = max;
                max = arr[i];
            }else if(arr[i]>secondMax && arr[i] != max){
                secondMax = arr[i];
            }
        }
        return secondMax;
       }

       // Move zeros to the end of an array
       public int[] moveZerosToEnd(int[] arr){
            int j = 0;
            for(int i=0; i<arr.length; i++){
                if(arr[i]!=0 && arr[j] == 0){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                if(arr[j]!=0){
                    j++;
                }
            }
            return arr;
       }
       // Resize an array
       public int[] resize(int[] arr,int length){
        int newArray[] = new int[length];
        for(int i=0;i<length;i++){
            newArray[i] = arr[i];
        }
        return newArray;
       }

       public void arrayDemo(){
            int[] myArray = new int[5];
            printArray(myArray);
       }

       public int findMissingNumber(int arr[]){
        int n = arr.length+1;
        int sum = n * (n+1) / 2;
        for(int num:arr){
            sum = sum - num;
        }
        return sum;
       }

    public static void main(String[] args){
        OneDimensionalArray arrutil = new OneDimensionalArray();
        //arrutil.arrayDemo();
        int[] nums = {1,2,3,4,6};
        //arrutil.printArray(arrutil.removeEven(nums));
        //arrutil.printArray(arrutil.reversArray(nums,0,nums.length-1));
        int[] zeros = {1,2,0,3,4,5,0,6,7,0};
        //System.out.println(arrutil.findSecondMax(nums));
        //arrutil.printArray(arrutil.moveZerosToEnd(zeros));
        // arrutil.printArray(arrutil.resize(zeros,5));
        System.out.println(arrutil.findMissingNumber(nums));
    }

}