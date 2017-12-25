/**
 * Created by Administrator on 2017/8/22 0022.
 */
public class FortyNine {
    public int GetUglyNumber_Solution(int index) {
        if(index==0)
            return 0;
        int[] array=new int[index];
        array[0]=1;
        int next=1;
        int twoPointer=0,threePointer=0,fivePointer=0;
        for(int i=0;i<index-1;i++)
        {
            int min=min(2*array[twoPointer],3*array[threePointer],5*array[fivePointer]);
            array[next++]=min;
            while (2*array[twoPointer]<=min)
                twoPointer++;
            while (3*array[threePointer]<=min)
                threePointer++;
            while (5*array[fivePointer]<=min)
                fivePointer++;
        }
        return array[index-1];
    }

    private int min(int v1, int v2, int v3)
    {
        int min= v1 < v2 ? v1 : v2;
        min= min < v3 ? min : v3;
        return min;
    }

    public static void main(String[] args)
    {
        System.out.println(new FortyNine().GetUglyNumber_Solution(5));
    }
}
