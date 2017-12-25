/**
 * Created by Administrator on 2017/8/14 0014.
 */
public class ThirtyNine {
    public void quickSort(int[] nums)
    {
        quickSort(nums,0,nums.length-1);
    }

    private void quickSort(int[] nums,int low,int high)
    {

        if(low<high){
            //median(nums,low,high);
            int p=partition(nums,low,high);
            quickSort(nums,low,p-1);
            quickSort(nums,p+1,high);
        }
    }

    private void swap(int[] nums, int left, int right)
    {
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }

    private void median(int nums[],int left,int right)
    {
        int mid=left+(right-left)>>2;
        if(nums[left]<nums[right]){
            if(nums[right]<nums[mid])
                swap(nums,left,right);
            else
                if(nums[left]<nums[mid])
                    swap(nums,left,mid);
        }else {
            if(nums[right]>nums[mid])
                swap(nums,left,right);
            else
                if(nums[left]>nums[mid])
                    swap(nums,left,mid);
        }
    }

    private int partition(int nums[],int low, int high)
    {
        int temp=nums[low];
        while (low<high){
            while (low<high && nums[high]>=temp) {
                high--;
            }
            nums[low]=nums[high];
            while (low<high && nums[low]<=temp){
                low++;
            }
            nums[high]=nums[low];
        }
        nums[low]=temp;
        return low;
    }

    public int MoreThanHalfNum_Solution(int [] array) {
        if(array==null || array.length==0)
            return 0;
        int p=partition(array,0,array.length-1);
        int m=(array.length-1)>>2;
        while (p!=m)
        {
            if(p>m){
                p=partition(array,0,p-1);
            }else{
                p=partition(array,p+1,array.length-1);
            }
        }
        int result=array[p];
        if(moreThanHalf(array,result))
            return result;
        else
            return 0;
    }

    private boolean moreThanHalf(int[] array, int result)
    {
        boolean mth=false;
        int count=0;
        for(int val : array)
            if(val==result)
                count++;
        if(count>array.length/2)
            mth=true;
        return mth;
    }

    public int MoreThanHalfNum_Solution2(int [] array) {
        if(array==null || array.length==0)
            return 0;
        int count=1;
        int result=array[0];
        for(int i=1;i<array.length;i++)
        {
            if(count==0){
                result=array[i];
                count=1;
            }else if(array[i]==result){
                count++;
            }else{
                count--;
            }
        }
        if(moreThanHalf(array,result)){
            return result;
        }else{
            return 0;
        }
    }

    public static void main(String[] args)
    {
        int[] nums={33,54,67,324,645,34,23,65,34,5,3,56,3,3,5,467,8};
        new ThirtyNine().quickSort(nums);
        for(int v : nums)
            System.out.print(v+" ");
    }
}
