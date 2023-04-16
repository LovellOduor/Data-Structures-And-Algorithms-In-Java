import java.util.Stack;
public class StackValidParentheses{
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            /* We add only the openning brackets to the stack
            as we iterate through the stack we only remove them from the stack if we
            find a matching closing parenthesis.
            If ever the stack is empty before we finish iterating, then we have failed
            to find an opening parenthesis to add to the stack.
            If then stack is empty after iteration it means all opening brackets
            found a match and therefore all brackets were in a valid order. { } 
            */
            if(c == '{' || c == '[' || c == '('){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    char x = stack.peek();
                    if((x == '{' && c =='}') || (x =='(' && c ==')') || (x =='[' && c ==']')){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args){
        System.out.print(isValid("{[]}"));
    }
}