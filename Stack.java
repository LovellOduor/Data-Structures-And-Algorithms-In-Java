/*
It is a linear data structure in which insertions and deletions are done at one end called as top.
It implements the LiFo data structure. Last In First Out.
*/
public class Stack{

    ListNode top;
    int length = 0;

    public static class ListNode{
        int data;
        ListNode next;
        public ListNode(int d){
            data = d;
        }
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public ListNode pop(){
        if(isEmpty()) throw new EmptyStackException();
   
        ListNode temp = top;
        top = top.next;
        
        length--;
        return temp;
    }

    public int peek(){
        if(isEmpty()) throw new EmptyStackException();
        return top.data;
    }

    public void push(int data){
        ListNode newNode = new ListNode(data);
        newNode.next = top;
        top = newNode;
        length+=1;
    }

    public static void main(String[] args){
        Stack st = new Stack();
        
        st.push(15);
        st.push(20);
        st.pop();
        System.out.println(st.top.data);

    }
}