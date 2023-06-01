import java.util.Set;

public class StringUtil{
    public String removeVowels(String words){
        Set<Character> chars = Set.of('a','e','i','o','u');
        StringBuilder sb = new StringBuilder();
        char[] charArray = words.toCharArray();
        for(char c:charArray){
            if(!chars.contains(c)){
                sb.append(c);
            }
        }
    return sb.toString();
    }

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
        StringUtil sutil = new StringUtil();
        // System.out.println(sutil.isPalindrome("noon"));
        System.out.println(sutil.removeVowels("hello how are you"));

    }
}
