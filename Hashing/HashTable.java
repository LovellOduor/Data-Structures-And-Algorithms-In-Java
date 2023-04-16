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

    public void put(Integer key, String value){
    }

    public String get(Integer key){
        return null;
    }

    public String remove(Integer key){
        return null;
    }
}