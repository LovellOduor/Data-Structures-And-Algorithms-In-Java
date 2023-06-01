import java.util.Map;
import java.util.HashMap;

public class FirstNonRepeatingCharacter{
    
    public static int fnrc(String value){
        int c = -1;
        Map<Character,Integer> chars = new HashMap<>();
        char[] values = value.toCharArray();
        for(int i=0; i<values.length; i++){
            chars.put(values[i],chars.getOrDefault(values[i],0)+1);
        }
        for(int x = 0; x < values.length; x++){
            if(chars.get(values[x]) == 1){
                c = x;
                return c;
            }
        }
        return c;
    }

    public static void main(String[] args){
        String word = "closetooclose";
        System.out.println("First non repeating character in the words "+word+" is "+word.charAt(fnrc(word)));
    }
}