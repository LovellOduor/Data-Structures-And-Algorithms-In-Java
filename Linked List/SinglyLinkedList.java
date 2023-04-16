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
    /* 
    First set the current pointer to the head node 
    and through a while loop check whether the current pointer is null. 
    if not print the current value and set the current pointer to the next node in the list 
    */

    public void displayList(){
        ListNode current = head;
        while(current!=null){
            System.out.print(current.data+" --> ");
            current = current.next;
        }
        System.out.print("null");
    }
    // find the middle node in the linked list
    /*
    This requires we define two pointers, a fast pointer that will traverse the list twice as fast as
    a slow pointer, both of which are initialized to the head pointer. 
    In a while loop we check whether the fast pointer is null or it's next pointer is null, if not,
    then we traverse the slow pointer to the next node and the fast pointer to the next next node of it's next node
    if the fast pointer or it's next node evaluates to null, then we return the slow pointer as the middle node
    */
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
      /* 
    First check whether the head node is null if so return 0 otherwise
    create a count variable and set it to zero
    set the current pointer to the head node 
    and through a while loop check whether the current pointer is null. 
    if not increment count by one and set the current pointer to the next node in the list
    finally return the count
    */
    public int length(){
         if(head==null){
            return 0;
        }
        int count = 0;
        ListNode current = head;
        while(current != null){
            current = current.next;
            count++;
        }
        return count;
    }
    // Insert a new node at the begining of the Singly Linked List
    /*
    Create a new node and set the next pointer of the new node to point to the head node
    of the singly linked list. Then set the head node of the singly linked list to point
    to the new node
    */
    public void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head=newNode;
    }
    // Insert a new node at the end of a Singly Linked List
    /*
    Check if the head node is null if so, we set head node to be equal to the new node
    otherwise we set a pointer too the current node 
    through a while loop we check whether the current.next node is null if not we move the current pointer
    to the next node finally when current.next is null meaning we are at the last node, we set the 
    current.next to our new node
    */

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
        current.next = newNode;
    }
    
    // Insert value at any position in the list
    /*
    First we have to consider whether we are inserting a value at the first node if so
    we Create a new node and set the next pointer of the new node to point to the head node
    of the singly linked list. Then set the head node of the singly linked list to point
    to the new node 
    if not inserting at the first position, then we loop until the previous position relative to
    the position we want to insert our new node i.e ( position - 1 ). we set a pointer to the previous node and increment the counter
    we then exit the loop and set the next pointer of the new node to the next pointer of the previous node
    and finally set the next pointer of the previous node to point to the newnode.
    */
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
    /*
    We first check whether the head node is null if so we exit
    we then create a temporary node to store the head and set head to point to head.next
    finally we set the temp.next to be null to break linkage and clear the memory
    */
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
    /*
    Check whether head is null or head.next is null if so we return head
    then we create a current node and set it to the head and a previous node to null
    we then loop checking whether the next node relative to the current node is null
    if not we set the previous node to the current and the current node to the next node
    finally we set the next pointer of the previous node to nul to delete the node and 
    return the deleted node which is stored in the current pointer
    */
    public ListNode deleteLast(){
        if(head == null || head.next == null ){
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        while(current.next!=null){
            previous = current;
            current = current.next;
        }
        previous.next = null;
      return current;
    }
    
    // Delete a node at any position on the List
    /*
    First we check whether the we are inserting in the first node. 
    If so we simply set head to point to its next node else
    we create a count and through a while loop check whether we have arrived at the previous position
    before the current position that we want to delete. If we arrive at that position, then we set the
    next pointer of the previous position, to point to the next pointer of the current position
    */
    public void delete(int position){
        ListNode previous = head;
        if(position == 1){
            head = head.next;
        }else{
        int count = 1;
        while(count < position -1){
            previous = previous.next;
            count++;
        }
        previous.next = previous.next.next;
        }
    }

    // Search for an item in the list
    /*
    This involves looping through the items of the linked list 
    and checking whether the current pointer data is equal to the search key
    if it is we return true otherwise we traverse the current to be equal to the next pointer of 
    the current node
    */
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
    /*
    This entails changing the direction of the next pointers and setting the last node to be
    head. Set pointers for the current to point to head, previous to null and next node set to null.
    In a while loop, we check whether the current pointer is null. If not then we set the
    next pointer to the next node in the list, we set the next pointer of the current node to the 
    previous node we then move to the next node by setting current to next and previous to current 
    if current is null and we are at the end then we 
    */

    public void reverse(){
        if(head == null){
            return;
        }
        ListNode previous = null;
        ListNode current = head;
        ListNode next = null;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    // Find the nth node from the end of a singly linked list
    /*
    This requires us to kind of offset the end of the list to bring it to the nth node. To do this
    we need to first traverse an offset pointer n positions. Then we traverse both our main pointer and the offset
    pointer until the offset pointer is null. if so then the main pointer has arrived at the nth position 
    and we can return it.
    */
    
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
 /*
 This entails traversing the list while comparing the current list node's data with the next
 list node's data and if they are the same, then we set the current pointer's next node to point to
 the next node of the next pointer else we just set the current pointer to the next pointer to traverse the 
 list
 */

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
    /*
    First we create a new node (newNode) containing the data we want to insert to the sorted linked list. 
    we ensure that the list is not null by checking whether the head is null is so we return the new node.
    We then create variables for the current and previous list nodes that we'll be keeping track of.
    As we loop through the list, we check whether current is null and the current list node data is less than the new
    node data. If so we update the previous pointer to the current node and the current pointer to the next node in the list.
    If the conditions are false then we have arrived at the desirable state where the current node data is 
    greater than the new node data so we set the previous node's next pointer to the new node and the new node's
    next pointer to the current node's next node.
    */


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
    /*
    First we create variables to keep track of the current and previous list node. 
    We can then check whether the key we are deleting is the head. If so we assign the head to it's next ListNode
    and return it. If the node to be deleted is not the head, then we loop through the list cheking whether the
    the current node id null or the current data is not equal to the key. If so then we set the previous pointer to point to the current
    node and the current node to point to it's next node. If the current is null, at the end of the loop. It means that
    no mat was found for the key we desire to remove so we can return the current node. Otherwise we set the 
    next node of he previous pointer, to point to the next node of the current pointer, and return the current node. 
    */
    
     public ListNode removeKey(int key){
        ListNode current = head;
        ListNode previous = null;
        if(head!=null && head.data == key){
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
     /*
     We need a first and slow pointer both initiated to the head node. The fast pointer will traverse the list at twice the speed of the
     slow pointer, by setting it to it's next, next node on every iteration, while the slow pointer  will be set to it's next node on each iteratation.
     This will continue as long as the fast pointer is not equal to null and the fast pointer's next node is not equal to null. 
     When the fast and slow pointer meet, then it means our linked list has a loop and we can return true. Otherwise false.
     */

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
    /*
        First we implement the algorithm for detecting a loop in a singly linked list. Once the loop is 
        detected, we create another new pointer at the head node and progrsivelly move it to the next node, and 
        also progrsively move the slowpointer to it's next node until both meet. Then they'll meet at 
        the starting point of the loop.
    */

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

 // remove a loop from a singly linked list 
 /*
 To remove a loop from a singly linked list, we need to implement floyd cycles detection algorithm,
 the only difference is instead of checking that the start node value is equal to the slow pointer to find 
 the starting point of the loop, we loop while the next pointer of the start node is not equal to the next of the slow pointer.
 When they are equal we exit the loop and set the next pointer of the slow pointer to be equal to null
 */
     public void removeLoop(){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while(slowPtr.next != null && fastPtr.next.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if(slowPtr == fastPtr){
                ListNode loopStart = head;
                while(loopStart.next != slowPtr.next){
                    loopStart = loopStart.next;
                    slowPtr = slowPtr.next;
                }
                slowPtr.next = null;
            }
        }
     }

     // Merging two sorted linked lists
     /*
     First we create a dummy list node to provide a concrete object in the heap, to avoid null pointer exceptions.
     we add a tail pointer to traverse the list. Through a while loop that checks whether we are at the end of either lists
     by checking whether they are null, we see if the data of node a is less than the data of node b. If so we add a to the next
     of the tail pointer and we also move a to it's next node. however if node b's data is greater than a then
     we add b to tail's next pointer and we move b to it's next pointer. Finally we also move tail to it's next pointer.
     We then check whether we are at the end of either list if we are at the end of a, meaning it's current pointer
     is null, then we set tail's next pointer to b. Otherwise we set tail's next pointer to a to add the remain values to the
     new merged list. Finally we return the next pointer of the dummy node, to get the merged sorted list.

     */
    public static ListNode merge(ListNode a, ListNode b){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(a!=null && b!=null){
            if(a.data <= b.data){
                tail.next = a;
                a = a.next;
            }else{
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        if(a == null){
            tail.next = b;
        }else{
            tail.next = a;
        }
        return dummy.next;
    }
    // Adding two SinglyLinkedList - Make sure the lists are first reversed
    /*
    We need to create a dummy list node and a tail pointer to traverse the dummy list.
    we also need to create integer variables for sum, carry, x to store the first value and y the second list's value.
    in a while loop, we check whether a or b is not equal to null. We assign a.data to x if a is not null otherwise we assign 0,
    we assign b.data to y of b is not null otherwise we assign 0. We then assign to sum the sum of x, y and carry. 
    We then calculate carry by dividing sum by 10. We also add to the remainder to the next node of the tail and move the tail pointer to its next node.
    finally we check whether a is null if not we move a to it's node in the list and also do the same for b. Upon exiting the while loop
    We check if carry is greater than 0 if so we set the next of the tail node to carry, and then we return the next of the dummy node.
    */
    public static ListNode add(ListNode a,ListNode b){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        int sum = 0;
        int x = 0;
        int y = 0;
        while(a!= null || b!=null){
           x = (a!=null)? a.data:0;
           y = (b!=null)? b.data:0;
          
           sum =  x + y + carry;
           // Carry is an integer therefore it won't keep any decimal values
           carry = sum/10;
           tail.next = new ListNode(sum%10);
           tail = tail.next;
           if(a!=null) a = a.next;
           if(b!=null) b = b.next; 
        }
        
        if(carry > 0){
            tail.next = new ListNode(carry);
        }
        return dummy.next;
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
        sll.deleteLast();
        sll.displayList();
        // sll.delete(3);
        // sll.displayList();
        // sll.reverse();
        // sll.displayList();
        // sll.reverse();
        // sll.displayList();
        // sll.reverse();
        // sll.displayList();
        // System.out.println(sll.search(5));
        // System.out.println(" The length is "+sll.length());
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
        /*
        sll.createLoopInLinkedList();
       // System.out.println(sll.containsLoop());
       // ListNode loopStart = sll.startListNodeInALoop();
        sll.removeLoop();
        sll.displayList();
        */
        /*
        SinglyLinkedList sll1 = new SinglyLinkedList();
        sll1.insertLast(1);
        sll1.insertLast(4);
        sll1.insertLast(8);
        SinglyLinkedList sll2 = new SinglyLinkedList();
        sll2.insertLast(3);
        sll2.insertLast(5);
        sll2.insertLast(8);
        sll2.insertLast(9);
        sll2.insertLast(14);
        sll2.insertLast(18);
        sll1.displayList();
        sll2.displayList();

        SinglyLinkedList result = new SinglyLinkedList();
        result.head = merge(sll1.head,sll2.head);
        result.displayList();
        */
        // ADDING TWO SINGLY LINKED LISTS
       /* 
        SinglyLinkedList sll1 = new SinglyLinkedList();
        sll1.insertLast(0);
        sll1.insertLast(0);
        sll1.insertLast(2);
        SinglyLinkedList sll2 = new SinglyLinkedList();
        sll2.insertLast(0);
        sll2.insertLast(1);
        SinglyLinkedList result = new SinglyLinkedList();
        result.head = add(sll1.head,sll2.head);
        result.displayList();
        */



    }
}