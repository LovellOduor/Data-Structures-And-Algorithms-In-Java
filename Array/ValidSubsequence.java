// Valid Subsequence
/*
Subsequence - A subsequence of a string is a new string formed from the
original string by deleting some or no characters without changing 
the order of the remaining characters.

Example-
"ace" is a subsequence of "abcde"
"aec" is not a subsequence of "abcde"
*/


public class ValidSubsequence{
    public boolean isSubsequence(String str, String seq){
         int i = 0;
         int j = 0;

         while(i<str.length() && j < seq.length()){
            if(str.charAt(i)==seq.charAt(j)){
                j++;
            }
            i++;
         }
         return j == seq.length(); 
    }
    public static void main(String[] args){
        ValidSubsequence vsq = new ValidSubsequence();
        System.out.println("String is valid: "+vsq.isSubsequence("abcdefg","aec"));
    }
}