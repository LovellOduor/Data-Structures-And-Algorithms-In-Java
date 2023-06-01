public class SortedMatrix{
    public Boolean search(int[][] matrix, int key){
        int i = 0;
        int j = matrix[0].length - 1;
        while(i<matrix.length && j>=0){
            if(matrix[i][j] == key){
                System.out.println("Found "+key+" at position "+i +", "+j);
            }
            if(key<matrix[i][j]){
                j--;
            }else{
                i++;
            }
        }
        System.out.println("Not found");
        return false;
    }

    public void spiralPrint(int[][] matrix){
        int rows = matrix.length;
        int columns = matrix.length;
        int i,r = 0; int c = 0;
        while(r < rows && c < columns){
            for(i=c; i < columns; i++){
                System.out.print(matrix[r][i]+" ");
            }
            r++;
            for(i=r;i <rows;i++){
                System.out.print(matrix[i][columns-1]+" ");
            }
            columns--;
            if(r<rows){
                for(i=columns-1;i>= c; i--){
                    System.out.print(matrix[rows-1][i]+" ");
                }
                rows--;
            }
            if(c<columns){
                for(i=rows-1;i>=r;i--){
                    System.out.print(matrix[i][c]+" ");
                }
                c++;
            }
        }
    }
    public static void main(String[] args){
       int[][] mymatrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
       new SortedMatrix().spiralPrint(mymatrix);
    }
}