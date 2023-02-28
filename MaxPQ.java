public class MaxPQ{
    Integer[] heap;
    int length;

    public MaxPQ(int capacity){
        heap = new Integer[capacity+1];
        length = 0;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public int size(){
        return length;
    }

    public static void main(String[] args){
        MaxPQ maxpq = new MaxPQ(3);
        System.out.println(maxpq.size()+" is empty "+maxpq.isEmpty());

    }
}