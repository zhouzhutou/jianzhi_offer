/**
 * Created by Administrator on 2017/7/20 0020.
 */

public class Three {

    //找出数组中重复的元素
    public boolean solution(int[] numbers)
    {
        if(numbers.length==0 || numbers==null)
            return false;
        for(int i=0;i<numbers.length;i++)
        {
            if(numbers[i]<0 || numbers[i]>numbers.length-1)
                return false;
        }
        for(int i=0;i<numbers.length;i++)
        {
            while (numbers[i]!=i){
                if(numbers[i]==numbers[numbers[i]]){
                    return true;
                }else{
                    int m=numbers[i];
                    numbers[i]=numbers[m];
                    numbers[m]=m;
                }
            }
        }
        return false;
    }


    public int solution_change(int[] numbers){
        if(numbers==null || numbers.length==0 || numbers.length==1)
            return -1;
        int length=numbers.length;
        int begin=1,end=length-1;
        while (begin<=end){
            int mid=((end-begin)>>1)+begin;
            int count=countRange(numbers,begin,mid);
            if(begin==end){
                if(count>0)
                    return begin;
                else
                    break;
            }
            if(count>mid-begin+1)
                end=mid;
            else
                begin=mid+1;

        }
        return -1;
    }

    private int countRange(int[] nums, int begin, int end){
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=begin && nums[i]<=end)
                ++count;
        }
        return count;
    }

    public static void main(String[] args)
    {
        //int nums[]={2,3,1,0,2,5,3};
        //int nums[]={4,3,1,0,2,5,6};
        int nums[]={2,3,5,4,3,2,6,7};

        System.out.println(new Three().solution_change(nums));
    }
}
