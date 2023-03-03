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

    public void resize(int capacity){
        Integer[] temp = new Integer[capacity];
        for(int i = 0; i < heap.length; i++){
            temp[i] = heap[i];
        }
        heap = temp;
    }

    public void insert(int x){
        if(length == heap.length-1){
            resize(2*heap.length);
        }
        length++;
        heap[length] = x;
        swim(length);
    }

    public void swim(int i){
        while(i>1 && heap[i/2] < heap[i]){
            int temp = heap[i];
            heap[i] = heap[i/2];
            heap[i/2] = temp;
            i = i/2;
        }
    }

    // Bottom up re-heapify / Sink
    // Deleting max value in a max heap

    public void sink(int i){
        while(i*2 <= length){
            int j = i*2;
            if(j<length && heap[j]<heap[j+1]){
                j++;
            }
            if(heap[i]<heap[j]){
                swap(i,j);                
            }else{
                break;
            }
            i = j;
        }
    }

    public void swap(int x, int y){
        int max = heap[x];
        heap[x] = heap[y];
        heap[y] = max;
    }

    public int deleteMax(){
        if(length == 0){
            throw new NullPointerException("Can't delete empty heap");
        }
        // we store the max to return it
        int max = heap[1];
        // We swap the last element in the heap with the first
        swap(1,length);
        length--;
        sink(1);
        heap[length+1] = null;
        return heap[1];
    }

    public void print(){
        if(isEmpty()){
            System.out.print("heap is empty");
        }
        for(int i = 1; i<=length; i++){
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        MaxPQ maxpq = new MaxPQ(3);
        maxpq.insert(4);
        maxpq.insert(5);
        maxpq.insert(2);
        maxpq.insert(6);
        maxpq.insert(1);
        maxpq.insert(3);
        System.out.println(maxpq.size()+" is empty "+maxpq.isEmpty());
        maxpq.print();
        maxpq.deleteMax();
        maxpq.print();
    }
}