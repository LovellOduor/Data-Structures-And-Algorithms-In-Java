public class HashTable{
    private HashNode[] buckets;
    int size;// No of key value pairs or no. of HashNodes
    int capacity;// Number of buckets

    private class HashNode{
        private Integer key;
        private String value;
        private HashNode next;

        public HashNode(Integer key,String value){
            this.key = key;
            this.value = value;
        }
    }

    public HashTable(int capacity){
        this.capacity = capacity;
        buckets = new HashNode[capacity];
        this.size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /* 
    We apply the modular hash function to get the index of the bucket where we are going to 
    to place the hashnode in the bucket array.
    */
    public int getBucketIndex(Integer key){
        int index = key%capacity;
        return index;
    }

    public void put(Integer key, String value){
        int index = getBucketIndex(key);
        HashNode head = buckets[index];
        while(head!=null){
            if(head.key == key){
                head.value = value;
                return;
            }
            head = head.next;
        }
        head = buckets[index];
        HashNode newNode = new HashNode(key,value);
        newNode.next = head;
        buckets[index] = newNode;
    }

    public void printHashTable(){
        System.out.println("Hash Table");
        int bucketIndex = 0;
        for(HashNode node:buckets){
            System.out.print("bucket:"+bucketIndex +"->");
            if(node != null){
                HashNode head = node;
                while(head!=null){
                    System.out.print("HashNode[key:"+head.key+",value:"+head.value+"]->");
                    head=head.next;
                }
            }
            System.out.print("null");
            System.out.println("");
            bucketIndex += 1;
        }
    }

    public String get(Integer key){
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        while(head != null){
            if(head.key == key){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public String remove(Integer key){
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        HashNode previous = null;       

        while(head!=null){
            if(head.key == key){
                break;
            }
            previous=head;
            head = head.next;
        }

        if(head == null){
            return null;
        }
        size--;
        if(previous == null){
            buckets[bucketIndex] = head.next;       
        }else{
            previous.next = head.next;
        }

        return head.value;
    }

    public static void main(String[] args){
        HashTable hashTable = new HashTable(10);
        hashTable.put(11,"Lovell");
        hashTable.put(21,"Mark");
        hashTable.put(10,"Jane");
        hashTable.printHashTable();
        hashTable.remove(10);
        hashTable.remove(11);
        hashTable.printHashTable();
        System.out.println(hashTable.get(21));
    }
}