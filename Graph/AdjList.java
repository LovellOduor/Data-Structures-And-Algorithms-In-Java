import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class AdjList{
    private LinkedList<Integer>[] adj; 
    private int vertices;
    public AdjList(int nodes){
        adj = new LinkedList[nodes];
        vertices = nodes;
        for(int i=0;i<nodes;i++){
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int u, int v){
        adj[u].add(v);
        adj[v].add(u);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int v = 0; v < vertices; v++){
            sb.append(v+": ");
            for(int n:adj[v]){
                sb.append(n+"->");
            }        
            sb.append("null \n");
        }
        return sb.toString();
    }
    /* Breadth First Search
       Visiting occures initialy and while nodes are being added to to the queue
       this is because in Breadth First Search a level order search technique
       Steps
       1. Visit the first node and add it to the queue as it is in level 1.
       2. In a while loop check if the queue is empty if not add adjacent nodes of the last 
          item inserted in the queue to the queue.
       3. Before adding a node check if it has already been visited.
    */
    public void breadthFirstSearch(int x){
        boolean[] visited = new boolean[vertices];
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visited[x] = true;
        while(!q.isEmpty()){
            int y = q.poll();
            System.out.print(y+" ");
            for(int c : adj[y]){
                if(visited[c]==false){
                    visited[c] = true;
                    q.offer(c);
                }
            }
        }
    }

    /* Depth First Search
       It is implemented using a stack as opposed to a queue for breadth first search because
       the nodes added last to the stack are given priority so that the graph is traversed depthwise
       at first.
       Steps
       1. Create a stack and add the first node.
       2. In a while loop, check whether the stack is empty, if not then we pop the
          last node added to the stack if it hasn't been visted, then we visit it. 
       3. Then we loop through the adjacent nodes of the last node in the stack and add them to
          the stack if they were not visited. 
    */
   

   public void iterativeDepthFirstSearch(int x){
    boolean[] visited = new boolean[vertices];
    Stack<Integer> stk = new Stack<>();
    stk.push(x);
    while(!stk.isEmpty()){
        int y = stk.pop();
        if(!visited[y]){
            visited[y] = true;
            System.out.print(y+" ");
            for(int i:adj[y]){
                if(!visited[i]){
                    stk.push(i);
                }
            }
        }
    }
   }

   // recursiveDepthFirstSearch
   
   public void recursiveDepthFirstSearch(){
    boolean[] visited = new boolean[vertices];
    for(int vertex = 0; vertex < vertices; vertex++){
        if(!visited[vertex]){
            recursiveDepthFirstSearch(vertex,visited);
        }
    }
   }

   public void recursiveDepthFirstSearch(int v,boolean[] visited){
        visited[v] = true;
        System.out.print(v+" ");
        for(int a: adj[v]){
            if(!visited[a]){
                recursiveDepthFirstSearch(a,visited);
            }
        }
   }
   // Reccursive Depth First Search With component counting
   /* Connected components are a group of nodes that are connected
   Below we count connected components and also store the component id's
   as an extention to the recursive depth first search algorithm
    */
   
   public void recursiveDepthFirstSearchCC(){
    boolean[] visited = new boolean[vertices];
    int[] componentIds = new int[vertices];
    int componentId = 0; 
    // This for loop will iterate through all vertices incase some of them are not connected 
    // to other nodes in the graph, therefore ensure all nodes are visited even those that are
    // disconnected
    for(int vertex = 0; vertex < vertices; vertex++){
        if(!visited[vertex]){
            componentId++;
            recursiveDepthFirstSearchCC(vertex,visited,componentIds,componentId);
        }
    }
    System.out.print("Number of components "+ componentId);
   }

   public void recursiveDepthFirstSearchCC(int v,boolean[] visited,int[] componentIds,int componentId){
        visited[v] = true;
        componentIds[v] = componentId;
        System.out.print(v+" ");
        for(int a: adj[v]){
            if(!visited[a]){
                recursiveDepthFirstSearchCC(a,visited,componentIds,componentId);
            }
        }
   }


    public static void main(String[] args){
        AdjList adjList = new AdjList(6);
        adjList.addEdge(0,1);
        adjList.addEdge(1,2);
        adjList.addEdge(2,3);
        adjList.addEdge(3,0);
        adjList.addEdge(2,4);
        adjList.addEdge(5,5);
        System.out.print(adjList);
        // adjList.breadthFirstSearch(0);
        // adjList.iterativeDepthFirstSearch(0);
        adjList.recursiveDepthFirstSearchCC();
    }
}