// DOUBLY LINKED LIST
/*
It is also referred to as a two way linked list.
It is charachterized by the presence of both a head and tail pointer.
The list nodes in a doubly linked list have a refrence to both the next and previous node
on the list, as well as a variable to store data. 
This, coupled with the  presence of a tail node makes it possible to traverse
a doubly linked list in both directions. The lenght property also keeps track of items in the list.
*/

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
    // Print elements in the forward direction
    /*
    We set the current pointer to the head node. While it's not equal to null we print out the
    data of the current node and move the current pointer to the next node. Finally we can print null
    */
    public void displayForward(){
        ListNode current = head;
        while(current != null){
            System.out.print(current.data+"-->");
            current = current.next;
        }
        System.out.println("null");
    }
    // Print elements in the backword direction
    /*
    We set the current pointer to the tail node. While it's not equal to null we print out the
    data of the current node and move the current pointer to the previous node. Finally we can print null
    */
    public void displayBackward(){
        ListNode current = tail;
        while(current != null){
            System.out.print(current.data+"-->");
            current = current.previous;
        }
        System.out.println("null");
    }

    // Insert element at the first node in a doubly linked list
    /*
    Because of the presence of a tail pointer, we have to consider if the list is empty. If so we set the tail pointer to 
    the new node. Else if it's not empty, we set the newnode's next to the head node.
    We the set the previous of the head node to the new node. Finally we set the head to the new node.
    */
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
    // Insert element at the Last node in a doubly linked list
    /*
    Because of the presence of a head pointer, we have to consider if the list is empty. If so we set the head pointer to 
    the new node. Else if it's not empty, we set the newnode's previous to the tail node.
    We the set the next of the tail node to the new node. Finally we set the tail to the new node.
    */
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

    // Delete first element of a doubly linked list
    /*
    If the list is empty, we can throw an error and return. 
    We also need a temporary pointer to point to the head node.
    If there is only one element in the list meaning head is equal to tail
    then we can just set tail to null. 
    Else if there is more than one element in the list, then we can set the head nodes' next previous pointer to null.
    Also we move head to it's next node and finally set the current pointer holding a reference to the head node to have 
    it's next point to null, and decrese the length of the doubly linked list. 
    */

    public ListNode deleteFirst(){
        if(head == null){
            return head;
        }
        ListNode temp = head;
        if(head == tail){
            tail = null;
        }else{
            head.next.previous = null;
        }
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }
    
    // Delete last element of a doubly linked list
    /*
    If the list is empty, we can throw an error and return. 
    We also need a temporary pointer to point to the tail node.
    If there is only one element in the list meaning head is equal to tail
    then we can just set head to null. 
    Else if there is more than one element in the list, then we can set the tail node's previous next pointer to null.
    Also we move tail to it's previous node and finally set the current pointer holding a reference to the tail node to have 
    it's previous point to null, and decrease the length of the doubly linked list.
    */

    public ListNode deleteLast(){
        if(head == null){
            return head;
        }
        ListNode temp = tail;
        if(head == tail){
            head = null;
        }else{
            tail.previous.next = null;
        }
        tail = tail.previous;
        temp.previous =null;
        length--;
        return temp;
    }

    public static void main(String[] args){
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertFirst(5);
        dll.insertFirst(4);
        dll.insertFirst(3);
        dll.insertFirst(2);
        dll.insertFirst(1);
        dll.displayForward();
        dll.deleteLast();
        dll.deleteFirst();
        dll.displayForward();
    }

}