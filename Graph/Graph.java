public class Graph{
    
    private int[][] adjMatrix;
    private int vertices;
    private int edges;

    public Graph(int nodes){
      adjMatrix = new int[nodes][nodes];
      vertices = nodes;
      edges = 0; 
    }

    public void addEdge(int u, int v){
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
        edges++;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(vertices +" vertices " +edges+" edges "+"\n");
        for(int v=0; v < vertices; v++){
            sb.append(v+": ");
            for(int w:adjMatrix[v]){
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Graph graph = new Graph(4);
        graph.addEdge(0,1);
          graph.addEdge(1,2); 
           graph.addEdge(2,3);
             graph.addEdge(3,0);
        System.out.print(graph);
    }
}