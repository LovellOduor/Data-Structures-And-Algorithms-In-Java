import java.util.Queue;
import java.util.LinkedList;
public class QueueGenerateBinaryNumbers{
    public static void main(String[] args){
        Queue<String> q = new LinkedList<String>();
        String[] binaryNums = new String[5];
        q.offer("1");
        String n1 = "";
        String n2 = "";
        for(int i = 0; i< binaryNums.length; i++){
            binaryNums[i] = q.poll();
            n1 = binaryNums[i]+"0";
            n2 = binaryNums[i]+"1";
            q.offer(n1);
            q.offer(n2);
        }
        for(String c:binaryNums){
            System.out.println(c);
        }
    }
}