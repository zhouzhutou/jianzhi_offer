/**
 * Created by Administrator on 2017/8/21 0021.
 */
public class FortySeven {

    public int getMaxValue_solution(int[][] values)
    {
        int maxValue=0;
        int temp[]=new int[values[0].length];
        for(int i=0;i<values.length;i++)
        {
            for(int j=0;j<values[0].length;j++){
                int up=0,left=0;
                if(i>0)
                   up=temp[j];
                if(j>0)
                    left=temp[j-1];
                temp[j]=Math.max(up,left)+values[i][j];
            }
        }
        return temp[values[0].length-1];
    }

    public static void main(String[] args)
    {
        int[][] values=new int[][]{{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
        System.out.println(new FortySeven().getMaxValue_solution(values));
    }
}
