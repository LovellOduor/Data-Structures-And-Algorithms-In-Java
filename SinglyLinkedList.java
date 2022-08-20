public class SinglyLinkedList{
    // The SinglyLinkedList is declared with 
    private ListNode head;
    // Each ListNode contains data as well as a reference to the next item on the list
    private static class ListNode{
        private int data;
        private ListNode next;
        public ListNode(int data){
            this.data = data;
            this.next = null;  
        }
    }
    // Print out the elements of the LinkedList
    public void displayList(){
        ListNode current = head;
        while(current!=null){
            System.out.print(current.data+" --> ");
            current = current.next;
        }
        System.out.print("null");
    }
    // Get the length of the Singly Linked List
    public int length(){
        int count = 0;
        ListNode current = head;
        while(current != null){
            current = current.next;
            count++;
        }
        return count;
    }
    // Insert a new node at the begining of the Singly Linked List
    public void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head=newNode;
    }
    // Insert a new node at the end of a Singly Linked List
    public void insertLast(int value){
        ListNode newNode = new ListNode(value);
        if(head == null){
            head = newNode;
            return;
        }
        ListNode current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next=newNode;
    }
    // Insert value at any position in the list
    public void insert(int position,int value){
        ListNode newNode = new ListNode(value);
        if(position == 1){
            newNode.next = head;
            head = newNode;
            return;
        }
        ListNode previous = head;
        int count = 1;
        while(count < position - 1){
            previous = previous.next;
            count++;
        }
        newNode.next = previous.next;
        previous.next = newNode;
    }
    public ListNode deleteFirst(){
        if(head==null){
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }
    // Delete the last element in the list
    public ListNode deleteLast(){
        if(head == null || head.next == null ){
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        int count = 1;
        while(current.next != null){
            previous = current;
            current = current.next;
            count+=1;
        }
        previous.next = null;
        return current;
    }
    // Delete a node at any position on the List
    public ListNode delete(int position){
        ListNode previous = head;
        if(position == 1){
            head = head.next;
        }else{
        int count = 1;
        while(count < position -1){
            previous = previous.next;
            count += 1;
        }
        }
        ListNode current = previous.next;
        previous.next = current.next;
        return current;
    }
    // search for an item in the list
    public boolean search(int value){
        ListNode current = head;
        boolean present = false;
        while(current!= null){
            if(current.data == value){
                return true;
            }
            current = current.next;
        }
        return false;
    }
    // Reverse a Linked List
    public void reverse(){
        if(head == null){
            return;
        }
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        while(current!=null){  
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    public static void main(String[] args){
        // Create the Singly Linked List and initialize the head
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new ListNode(10);
        // Initialize other ListNodes
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);
        // Link the nodes with each other and also to the head of the SinglyLinkedList
        sll.head.next = second;
        second.next = third;
        third.next = fourth;
        // sll.insertFirst(9);
        // sll.insertLast(7);
        // sll.insert(5,2);
        // sll.deleteFirst();
        // sll.displayList();
        // sll.delete(2);
        sll.reverse();
        sll.displayList();
        sll.reverse();
        sll.displayList();
       // System.out.println(sll.search(5));
        //System.out.println(" The length is "+sll.length());
    }
}