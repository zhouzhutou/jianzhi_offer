/**
 * Created by Administrator on 2017/7/24 0024.
 */
public class Four {
    public boolean Find(int target, int [][] array) {
        if(array==null || array.length==0 || array[0].length==0)
            return false;
        int rows=array.length;
        int cols=array[0].length;
        int r=0,c=cols-1;
        while (r<rows && c>=0)
        {
            if(array[r][c]==target)
                return true;
            else if(target<array[r][c])
                c--;
            else if(target>array[r][c])
                r++;
        }
        return false;
    }

    public static void main(String[] args)
    {
        int[][] array={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(new Four().Find(16,array));
    }

}
