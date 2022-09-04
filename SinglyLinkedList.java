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
    // find the middle node in the linked list

    public ListNode getMiddleNode(){
        if (head==null){
            return head;
        }
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while(fastPtr != null || fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
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
        while(current != null){
            current = current.next;
        }
        current=newNode;
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
    // Delete the first node 
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
        ListNode previous = head;
        while(current.next!=null){
            previous = current;
            current = current.next;
        }
        previous.next = null;
      return new ListNode(3);
    }
    // Delete a node at any position on the List
    public ListNode delete(int position){
        ListNode previous = head;
        ListNode current = previous.next;
        if(position == 1){
            head = head.next;
        }else{
        int count = 1;
        while(count < position -1){
            previous = current;
            current = current.next;
        }
        previous.next = current.next;
        }
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
        
        ListNode previous = null;
        ListNode current = head;
        
        while(current != null){
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }
    // Find the nth node from the end of a singly linked list
 public ListNode getNthNodeFromTheEnd(int n){
    if(head == null){
        return head;
    }
    if(n == 0){
        throw new IllegalArgumentException("Invalid value: n = "+n);
    }

    ListNode mainPtr = head;
    ListNode refPtr = head;
    int count = 0;
    while(count < n ){
        if(refPtr == null){
            throw new IllegalArgumentException(n + " Is greater than the number of nodes in the list"); 
        }
        refPtr = refPtr.next;
        count++;
    }
    while(refPtr!=null){
        refPtr = refPtr.next;
        mainPtr= mainPtr.next;
    }
    return mainPtr;
 }
 // Remove duplicates from a sorted linked list
    public void removeDuplicates(){
        if(head == null){
            return;
        }
    ListNode current = head;
    while(current != null && current.next != null){
        if(current.data == current.next.data){
            current.next = current.next.next;
        }else{
        current = current.next;
        }
    }
    }
    // Insert a node in a sorted singly linked list
    public ListNode insertNew(int d){
    ListNode newNode = new ListNode(d);
    if(head==null){
        return newNode;
    }
     ListNode current = head;
     ListNode previous = null;
     while(current!=null && current.data < newNode.data){
        previous = current;
        current = current.next;
     }
     previous.next = newNode;
     newNode.next = current;
     return head;
    }
    // how to remove a given key from a singly linked list
     public ListNode removeKey(int key){
        ListNode current = head;
        ListNode previous = null;
        if(current!=null && current.data == key){
            head = current.next;
            return head;
        }
        while(current != null && current.data != key){
            previous = current;
            current = current.next;
        }
        if(current == null) return current;
        previous.next = current.next;
        return current;
     }
     // Detecting a loop in a singly linked list
     public boolean containsLoop(){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(slowPtr == fastPtr){
                return true; 
            }
        }
        return false;
     }

    public void createLoopInLinkedList(){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);
        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = third;
    }
    // Floyd's Cycle detection algorithm, finding the start node of a looped linked list
    public ListNode startListNodeInALoop(){
           ListNode fastPtr = head;
           ListNode slowPtr = head;
           while(fastPtr!= null && fastPtr.next !=null){
              slowPtr = slowPtr.next;
              fastPtr = fastPtr.next.next;
              // when the fastptr meets the slowptr we have a loop in the list, at that point, we need to 
              // implement floyd cycle detection which compares values from the start node to the slowptr
              // from where it met with the fastptr until they are equal
              if(slowPtr == fastPtr){
                ListNode start = head;
                while(start != slowPtr){
                    start = start.next;
                    slowPtr = slowPtr.next;
                }
                return slowPtr;
              }
           }
           return null;
    }

    public static void main(String[] args){
        // Create the Singly Linked List and initialize the head
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new ListNode(1);
        // Initialize other ListNodes
        ListNode second = new ListNode(3);
        ListNode third = new ListNode(5);
        ListNode fourth = new ListNode(7);
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
        //sll.reverse();
        //sll.displayList();
       // sll.reverse();
        //sll.displayList();
       // sll.reverse();
       // sll.displayList();
       // System.out.println(sll.search(5));
        //System.out.println(" The length is "+sll.length());
       /* sll.displayList();
        ListNode n = sll.getNthNodeFromTheEnd(2);
        System.out.println(n.data);
        */
        /*
        sll.displayList(); 
        sll.insertNew(10); 
        sll.displayList(); 
        */ 
        /*
        sll.displayList(); 
        sll.removeKey(1); 
        sll.displayList(); 
        */
        
        sll.createLoopInLinkedList();
        System.out.println(sll.containsLoop());
        ListNode loopStart = sll.startListNodeInALoop();
        System.out.println(loopStart.data);

        
        
    }
}