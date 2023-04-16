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
        /*
        Since an array has a fixed number of elements, we need to 
        first iterate through all the elements in the array and count those that are
        odd, then initialize a new array with the length of the odd array and
        finally add the odd numbers to the newly initialized odd array
        */

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
        /*
        You need to keep track of both the first and the last indices and items
        in the array. Also a temporary value is needed to keep track of the start
        index so that we still have a reference for it when it is reassigned to
        the item in the last index. We then loop through the array checking if the 
        start index is less than the last index, ass we increment the start index and decrement 
        the last
        */

        public void reverseArray(int[] numbers,int start, int end){
            int temp;
            while(start < end){
                temp = numbers[start];
                numbers[start] = numbers[end];
                numbers[end] = temp;
                start++;
                end--;
            }
        }

        // find minimum value in an array
        /*
        It involves comparing the current value of an array with the
        next value in the array. Initially, we set the first element in the array as the
        minimum value.  If the next element is less than the current element, then we set the new
        minimum value to be equal to the next element, otherwise we continue looping through the elements
        of the array and make the same comparison till the end, and return the minimum value. 

        */
        public int findMin(int arr[]){
            int minVal = arr[0];
            for(int i=1;i<arr.length;i++){
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
       /*
       First the max and second max variables are assigned to the most minimum value.
       we then iterate through the array and if a value is larger than our max value,
       we assign that value to become our max value, we also assign our second max
       value to be equal to our previous max. We also check if a value is greater than
       second max and not equal to max (i.e not a duplicate) and we assign that to the
       second max value
       */
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
       /*
       Here we need two pointers, one keeps track of non-zero elements in the array, while
       the other zero elements in the array. The non-zero pointer traverses the array during 
       each iteration, while the zero pointer only traverses the array if the current value is 
       non-zero. In the event that the zero pointer is on a zero element and the non-zero pointer
       is on a non-zero element, we create a temporary variable to store the non-zero pointer value then
       we assign zero pointer value to the non-zero pointer value, and finally assign the temporary
       variable to the zero pointer value
       */ 

       public int[] moveZerosToEnd(int[] arr){
            int zeroPointer = 0;
            for(int i=0; i<arr.length; i++){
                if(arr[i]!=0 && arr[zeroPointer] == 0){
                    int temp = arr[i];
                    arr[i] = arr[zeroPointer];
                    arr[zeroPointer] = temp;
                }
                if(arr[zeroPointer]!=0){
                    zeroPointer++;
                }
            }
            return arr;
       }

       public void moveZerosToEnd2(int[] arr){
            int zeroPointer = arr.length-1;
            int i = 0;
            while(i < zeroPointer){
                if(arr[i] == 0){
                    int temp = arr[zeroPointer];
                    arr[zeroPointer] = arr[i];
                    arr[i] = temp; 
                    zeroPointer--;
                }else{
                    i++;
                }
            }
       }

       public void moveZerosToStart2(int[] arr){
            int zeroPointer = 0;
            int i = 0;
            while(i < arr.length){
                if(arr[i] == 0){
                    int temp = arr[zeroPointer];
                    arr[zeroPointer] = arr[i];
                    arr[i] = temp; 
                    zeroPointer++;
                }
                i++;
            }
       }

        //[0,1,0,2,4,0,0] 

        public int[] moveZerosToStart(int[] arr){
            int zeroPointer = arr.length-1;
            for(int i=arr.length-1; i!= -1; i--){
                 if(arr[i]!=0 && arr[zeroPointer] == 0){
                    int temp = arr[i];
                    arr[i] = arr[zeroPointer];
                    arr[zeroPointer] = temp;
                }
                if(arr[zeroPointer]!=0){
                    zeroPointer--;
                }
            }
            return arr;
       }

       // Resize an array
       /*
       We create a new array and give it the length we want to assign it
       we loop through our existing array and assign the corresponding values in at the 
       current index to the indices in our new array
       */
       
       public int[] resize(int[] arr,int length){
        int newArray[] = new int[length];
        for(int i=0;i<arr.length;i++){
            newArray[i] = arr[i];
        }
        return newArray;
       }

       public void arrayDemo(){
            int[] myArray = new int[5];
            printArray(myArray);
       }
       
       // Find the missing number in a range of natural numbers starting from 1
       /*
       We take a mathematical approach of finding the sum of the first n natural numbers
       and we'll subtract this natural number sum from the sum of our exisiting array of
       numbers to find the missing number.
       */

       public int findMissingNumber(int arr[]){
        int n = arr.length+1;
        int sum = n * (n+1) / 2;
        for(int num:arr){
            sum = sum - num;
        }
        return sum;
       }

       // Check if a given string is a palindrome
       /*
       A palindrome is a word that has the same meaning when it is reversed e.g madam, noon
       To check if a string is a palindrome, we conver the string into a charachter array,
       then set the start pointer to zero and the end pointer to the index of the last item in
       the array. We then check whether the start index is less than the end index. if 
       so, we compare the charachter in the index of the start pointer with that of the end pointer
       if they are not equal, we return false, meaning the string is not a palindrome. Otherwise, 
       we increment the start index by one and decrement the end index by one. 
       */

       public boolean isPalindrome(String word){
        char[] charArray = word.toCharArray();
        int start = 0;
        int end = word.length()-1;
        while(start<end){
            if(charArray[start]!=charArray[end])
                return false;
            start++;
            end--;
        }
        return true;
       }

    public static void main(String[] args){
        OneDimensionalArray arrutil = new OneDimensionalArray();
        //arrutil.arrayDemo();
        //int[] nums = {1,2,3,4,6};
        //arrutil.printArray(nums);
        //arrutil.reverseArray(nums,0,nums.length-1);
        //arrutil.printArray(nums);
        
        //arrutil.printArray(arrutil.removeEven(nums));
        //arrutil.printArray(arrutil.reversArray(nums,0,nums.length-1));
        int[] zeros = {1,2,0,3,4,5,0,6,7,0};
        arrutil.moveZerosToStart2(zeros);
        //System.out.println(arrutil.findSecondMax(nums));
        arrutil.printArray(zeros);
        //arrutil.printArray(arrutil.resize(zeros,5));
        //System.out.println(arrutil.findMissingNumber(nums));
        //System.out.println(arrutil.isPalindrome("noon"));
    }
}