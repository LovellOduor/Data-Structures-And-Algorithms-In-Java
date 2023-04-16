// Circular Singly Linked List
/*
It's similar to a Singly Linked List. The only difference is that the last node points to the
first node. 
However, rather than tracking the head node, we keep track of the last/tail node.
*/

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
    /* 
    Similar to a SinglyLinked List but the last node's next value should point to the
    first node.
    */
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
    /*
    To access the first node of the list, create a variable that points to the next of the last node.
    Then in a loop check whether the first node is not equal to the last and print the current node's data.
    Finally when the loop exits, print the last node that should be stored in the variable referencing the current node.
    */
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
    /*
    We consider two scenarios. The first is if the list is empty. 
    If so then we set the last node to point to the new node.
    If noe then we set the next node of the new node to point to the next node of the last node.
    Finally, we can set the last node's next to point to the new node.
    */
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
    
    //Insert node at the end of a circular singly linked list
    /*
    We consider if the list is empty.
    If so we set the last node to point to the new node,
    and then the next of the last node to the new node.
    Otherwise if the list is not empty, we set the next of the new node to the next of the last node.
    we set the next of the last node to the new node. Then finally we set the last node to the new node.
    */
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
    /*
    We consider if the list has only one node. If so then we simply set the last node to null.
    If there is more than one item, then we set the next of the last node to the next of the first node.
    Finally we set the next of the temporary node holding the removed first node to null and return it
    
    */
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
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList(); 
        csll.createCircularSinglyLinkedList();
        csll.display();
        csll.insertLast(7);
        csll.insertLast(8);
        csll.removeFirst();
        csll.display();
    }
}