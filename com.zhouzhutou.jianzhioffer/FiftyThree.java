/**
 * Created by Administrator on 2017/8/23 0023.
 */
public class FiftyThree {
    public int GetNumberOfK(int [] array , int k) {
        if(array==null || array.length==0)
            return 0;
        int first=getFirstPos(array,k);
        System.out.println(first);
        int last=getLastPos(array,k);
        System.out.println(last);
        if(first>-1 && last>-1) {
            return last - first + 1;
        }
        return 0;
    }

    private int getFirstPos(int[] array, int k)
    {
        int low=0,high=array.length-1;
        while (low<=high){
            int mid=(low+high)>>1;
            if(array[mid]==k)
                if(mid==0 || array[mid-1]!=k)
                    return mid;
                else
                    high=mid-1;
            else if(array[mid]>k)
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
    }

    private int getLastPos(int[] array, int k)
    {
        int low=0,high=array.length-1;
        while (low<=high){
            int mid=(low+high)>>1;
            if(array[mid]==k)
                if(mid==array.length-1 || array[mid+1]!=k)
                    return mid;
                else
                    low=mid+1;
            else if(array[mid]>k)
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] nums=new int[]{3,3,3,3,4,5};
        System.out.println(new FiftyThree().GetNumberOfK(nums,3));
    }
}
