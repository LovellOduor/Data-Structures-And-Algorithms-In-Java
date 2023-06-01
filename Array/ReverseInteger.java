public class ReverseInteger{
    public static long reverseInteger(int value){
        boolean isNegative = false;
        if(value<0){
            value*=-1;
            isNegative = true;
        }
        long reversed = 0;
        int remainder = 0;
        while(value>0){
            remainder = value%10;
            reversed = reversed * 10 + remainder;
            value = value/10;
        }

        return isNegative?reversed*-1:reversed;
    }
    public static void main(String[] args){
        System.out.println(reverseInteger(789));
    }
}