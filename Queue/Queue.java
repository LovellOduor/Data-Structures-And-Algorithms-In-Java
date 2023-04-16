
public class Queue{
    private ListNode front;
    private ListNode rear;
    public int length;

    public Queue(){
        front = null;
        rear = null;
    }

    public class ListNode{
        private int data;
        private ListNode next;
        public ListNode(int data){
            this.data = data;
        }
    }

    public void enqueue(int data){
        ListNode newNode = new ListNode(data);
        if(isEmpty()){
            front = newNode;
        }else{
            rear.next = newNode;
        }
        rear = newNode;
        length++;
    }

    public int dequeue(){
        if(isEmpty()){
             System.out.println("Queue is already empty");
             return -1;
        }
        int result = front.data;
        front = front.next;
        if(front==null){
            rear=null;
        }
        length--;
        return result;
    }

    public void print(){
        if(isEmpty()){
            return;
        }
        ListNode current = front;
        while(current!=null){
            System.out.print(current.data+"-->");
            current = current.next;
        }
        System.out.println("null");
    }

    public int length(){
        return length;
    }
    public boolean isEmpty(){
        return length == 0;
    }
    public static void main(String[] args){
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.print();
        q.dequeue();
        q.print();
    }
}