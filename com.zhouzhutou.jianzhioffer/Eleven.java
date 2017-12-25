/**
 * Created by Administrator on 2017/7/25 0025.
 */
public class Eleven {
    public int minNumberInRotateArray(int [] array) {
        if(array==null || array.length==0)
            return 0;
        int left=0, right=array.length-1;
        int mid=left;
        while (array[left]>=array[right])
        {
            if(right-left==1) {
                mid=right;
                break;
            }
            else{
                mid=(left+right)/2;
                if(array[left]==array[mid] && array[mid]==array[right])
                    return getMin(array,left,right);
                if(array[mid]>=array[left])
                    left=mid;
                else if(array[mid]<=array[right])
                    right=mid;
            }
        }
        return array[mid];
    }

    private int getMin(int [] array,int left, int right){
        int r=array[left];
        for(int i=left+1;i<=right;i++)
            if(array[i]<r)
                r=array[i];
        return r;
    }

    public static void main(String[] args)
    {
        //int nums[]={3,4,5,1,2};
        int nums[]={1,0,1,1,1};
        System.out.println(new Eleven().minNumberInRotateArray(nums));
    }
}
