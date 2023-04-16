// Graph problem leetcode #200
/*
Given an m x n 2D binary grid, which represents a map of '1's (land) and '0's (water), return
the number of islands. An island is surrounded by water and is formed by connecting
adjascent islands horizontally or vertically. You may assume all four edges of the grid
are all surrounded by water. 
            {1, 1, 0, 0},
            {1, 0, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
*/
public class NumberofIslands{
    public static void depthFirstSearch(int[][] graph,int row,int column,boolean[][] visited){
        if(row < 0 || column < 0 || row >= graph[0].length || column >= graph.length || graph[row][column] == 0 || visited[row][column]){
            return;
        }
        visited[row][column] = true;
        depthFirstSearch(graph,row - 1,column,visited); // left
        depthFirstSearch(graph,row + 1,column,visited); // right
        depthFirstSearch(graph,row,column - 1,visited); // top
        depthFirstSearch(graph,row,column + 1,visited); // bottom
    }

    public static int countIslands(int[][] graph){
        int rowCount = graph[0].length;
        int columnCount = graph.length;
        int islandCount = 0;
        boolean[][] visited = new boolean[rowCount][columnCount];
        for(int c = 0; c < columnCount; c++){
            for(int r = 0; r < rowCount; r++){
                if(!visited[r][c] && graph[r][c] == 1){
                    depthFirstSearch(graph,r,c,visited);
                    islandCount++;    
                }
            }
        }
        return islandCount;
    }

    public static void main(String[] args){
        int[][] graph = {
            {1,1,0,0},
            {1,0,0,0},
            {0,0,1,0},
            {0,0,0,1}
        };
        System.out.println("Number of islands "+ NumberofIslands.countIslands(graph));
    }
}