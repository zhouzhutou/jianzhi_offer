import java.util.Arrays;

/**
 * Created by Administrator on 2017/8/23 0023.
 */
public class FiftyOne {

    private static final int CONST=1000000007;

    public int InversePairs(int [] array) {
        if(array==null || array.length==0)
            return 0;
        int[] temp=new int[array.length];
        return inversePairs(array,temp,0,array.length-1);
    }

    private int inversePairs(int[] array, int[] temp, int low, int high)
    {
        if(low>=high) {
            return 0;
        }
        int mid=(low+high)>>1;
        int leftCount = inversePairs(array,temp,low,mid)%CONST;
        int rightCount = inversePairs(array,temp,mid+1,high)%CONST;
        int mergeCount= inverseCount(array,temp,low,mid,high);
        return (leftCount+rightCount+mergeCount)%CONST;
    }

    private int inverseCount(int[] array, int[] temp, int low, int mid, int high)
    {
        int count=0;
        int i=mid,j=high,k=high;
        while (i>=low && j>=mid+1){
            if(array[i]>array[j])
            {
                count+=j-mid;
                temp[k--]=array[i--];
                if(count>CONST)
                    count%=CONST;
            }else{
                temp[k--]=array[j--];
            }
        }
        while (i>=low)
            temp[k--]=array[i--];
        while (j>=mid+1)
            temp[k--]=array[j--];
        for(int c=low;c<=high;c++)
            array[c]=temp[c];
        return count;
    }

    public static void main(String[] args)
    {
        int[] nums={7,5,6,4,3};
        System.out.println(new FiftyOne().InversePairs(nums));
    }
}
