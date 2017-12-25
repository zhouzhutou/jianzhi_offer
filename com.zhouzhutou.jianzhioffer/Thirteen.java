/**
 * Created by Administrator on 2017/7/26 0026.
 */
public class Thirteen {
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[][] visited=new boolean[rows][cols];
        if(rows<0 || cols<0 || threshold<0)
            return 0;
        return backtrace(threshold,rows,cols,0,0,visited);
    }

    private int backtrace(int threshold, int rows, int cols, int row, int col, boolean[][] visited)
    {
        if(row<0 || row>=rows || col<0 || col>=cols || visited[row][col] || psum(row,col)>threshold)
            return 0;
        visited[row][col]=true;
        return 1+backtrace(threshold,rows,cols,row+1,col,visited)+backtrace(threshold,rows,cols,row-1,col,visited)
                +backtrace(threshold,rows,cols,row,col+1,visited)+backtrace(threshold,rows,cols,row,col-1,visited);

    }

    private int psum(int row,int col){
        int sum=0,r;
        while (row!=0){
            r=row%10;
            row/=10;
            sum+=r;
        }
        while (col!=0){
            r=col%10;
            col/=10;
            sum+=r;
        }
        return sum;
    }
}
