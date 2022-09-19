public class CircularSinglyLinkedList{
    private ListNode last;
    private int length; 
    public class ListNode{
        public ListNode next;
        public int data;
        public ListNode(int data){
            this.data = data;
        }
    }

    public CircularSinglyLinkedList(){
        this.length = 0;
        this.last = null;
    }
    
    public int length(){
        return length;
    }
    public boolean isEmpty(){
        return length==0;
    } 

    // Create a Circular Singly Linked List
    public void createCircularSinglyLinkedList(){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = first;
        last = fifth;
    }
    // Traverse and display elements of a circular singly linked list
    public void display(){
        if(last == null){
            return;
        }
        ListNode first = last.next;
        while(first != last){
            System.out.print(first.data+" --> ");
            first= first.next;
        }
        System.out.println(first.data);
    }

    // Insert a node at the start of a Circular Singly Linked List
    public void insertFirst(int data){
        ListNode newNode = new ListNode(data);
        if(last == null){
            last = newNode;
        }else{
        newNode.next = last.next;
        }
       last.next = newNode;
       length++;
    }
    
    //Insert node at the end of a singly linked list
    public void insertLast(int data){
        ListNode newNode = new ListNode(data);
        if(last == null){
            last = newNode;
            last.next = newNode;
        }else{
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
        length++; 
    }
    // Remove first node from a Circular Singly Linked List
    public ListNode removeFirst(){
        ListNode first = last.next;
        if(first == last){
            last = null;
        }else{
        last.next = first.next;
        }
        first.next = null;
        return first;
    }
    
    public static void main(String[] args){
        CircularSinglyLinkedList 
        csll = new CircularSinglyLinkedList(); 
        csll.createCircularSinglyLinkedList();
        csll.display();
        csll.insertLast(7);
        csll.insertLast(8);
        csll.removeFirst();
        csll.display();
    }
}