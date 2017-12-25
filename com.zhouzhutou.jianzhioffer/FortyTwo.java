/**
 * Created by Administrator on 2017/8/16 0016.
 */
public class FortyTwo {

    public int FindGreatestSumOfSubArray(int[] array) {
        int result=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++)
        {
            if(result<0)
                result=array[i];
            else{
                result+=array[i];
            }
            if(result>max){
                max=result;
            }
        }
        return max;
    }

    public int findGreatestSumOfSubArray(int[] data)
    {
        if(data==null || data.length==0)
            return 0;
         int sum=0,curSum=0;
         for(int i=0;i<data.length;i++){
             if(curSum<0)
                 curSum=data[i];
             else
                 curSum+=data[i];
             if(curSum>sum)
                 sum=curSum;
         }
         return sum;
    }
    public static void main(String[] args)
    {
        int nums[]={1,-2,3,10,-4,7,2,-5};
        System.out.println(new FortyTwo().findGreatestSumOfSubArray(nums));
    }
}
