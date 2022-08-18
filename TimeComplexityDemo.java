public class TimeComplexityDemo{
public static void main(String[] args){
    /* Testing the time it takes to find the sum of n natural numbers */
    double now = System.currentTimeMillis();
    TimeComplexityDemo demo = new TimeComplexityDemo();
    System.out.println(demo.findSumFormula(999999));
    System.out.println("Time taken "+ (System.currentTimeMillis()-now) + " milliseconds");
}
// using a for loop
public int findSumLoop(int n){
    int sum = 0;
    for(int i=1;i<=n;i++){
     sum += i;
    }
return sum;
}
// using the formula
public int findSumFormula(int n){
  return n*(n+1)/2;
}
}