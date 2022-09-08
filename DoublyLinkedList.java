class DoublyLinkedList{
    public class ListNode{
    int data;
    ListNode previous;
    ListNode next;
    public ListNode(int data){
           this.data = data;
           this.next = null;
           this.previous = null;
    }
    }
    private ListNode head;
    private ListNode tail;
    private int length;
    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }
    public boolean isEmpty(){
        return this.length == 0;
    }

    public int length(){
        return length;
    }

    public void displayForward(){
        ListNode current = head;
        while(current != null){
            System.out.print(current.data+"-->");
            current = current.next;
        }
        System.out.println("null");
    }

    public void displayBackward(){
        ListNode current = tail;
        while(current != null){
            System.out.print(current.data+"-->");
            current = current.previous;
        }
        System.out.println("null");
    }

    public void insertFirst(int data){
        ListNode newNode = new ListNode(data);
        if(isEmpty()){
            tail = newNode;
        }else{
            head.previous = newNode;
            newNode.next = head;
        }
        head = newNode;
        length += 1;
    }

    public void insertLast(int data){
        ListNode newNode = new ListNode(data);
        if(isEmpty()){
            head = newNode;
        }else{
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        length++;
    }

    public static void main(String[] args){
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertFirst(5);
        dll.insertFirst(4);
        dll.insertFirst(3);
        dll.insertFirst(2);
        dll.insertFirst(1);
        dll.displayBackward();
    }
}