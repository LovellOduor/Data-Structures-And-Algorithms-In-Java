public class FibonacciSequence{
    // Bottom up approach or Tabulation Method
    /*
    We try to solve smaller sub-problems use their solution to build on and arrive at solutions to bigger 
    sub-problems.
    This is also caled tabulation method because the previous solutions to the sub-problem are stored in a table.
    And they help us arrive at a solution to the main problem.
    */
    public int[] fibonacci(int n){
        int[] table = new int[n+1];
        table[0] = 0;
        table[1] = 1;
        for(int i = 2; i <= n; i+=1){
            table[i] = table[i-1] + table[i-2];
        }
        for(int c : table){
            System.out.print(c+",");
        }
        return table;
    }

    // Top down approach or Memorization
    /*
    We break the large problem int multiple sub-problems.
    Each of the sub-problems are solved and solutions are remebered.
    If the sub-problem is slved already, reuse the answer.
    Else solve the sub-problem and store the result.
    */ 

   public int fibonacci(int[] memory, int n){
    /* We check if the value of the current number in the series is zero if so it means that we haven't 
    assigned or calculated aby value for the nth number in the series. */
    if(memory[n] == 0){
        // if n is either 0 or one then we simply store the respective values as they match the fibonacci value
        if(n < 2){
            memory[n] = n;
        }else{
            int left = fibonacci(memory,n-1);
            int right = fibonacci(memory,n-2);
            memory[n] = left + right;
        }
    }
    // if the nth fibonacci number is not zero then we return the nth value in memory for it means it has been 
    // calculated and stored in the array

    return memory[n];
   }

   public void printArray(int[] mem){
    for(int c: mem){
        System.out.print(c+", ");
    }
   }
    public static void main(String[] args){
        FibonacciSequence fib = new FibonacciSequence();
        //fib.fibonacci(5);
        int[] memry = new int[6];
        fib.fibonacci(memry,memry.length - 1);
        fib.printArray(memry);
    }
}