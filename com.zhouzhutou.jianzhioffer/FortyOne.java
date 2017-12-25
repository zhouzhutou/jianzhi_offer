import java.util.PriorityQueue;

/**
 * Created by Administrator on 2017/8/15 0015.
 */
public class FortyOne {
    public int getMedian(int[] nums)
    {
        PriorityQueue<Integer> min=new PriorityQueue<>((t1,t2)->t1.compareTo(t2));
        PriorityQueue<Integer> max=new PriorityQueue<>((t1,t2)->t2.compareTo(t1));
        for(int i=0;i<nums.length;i++){
            put(nums[i],min,max);
        }
        if((min.size()==max.size()))
            return (max.peek() + min.peek()) >> 1;
        else if(max.size()>min.size())
            return max.peek();
        else
            return min.peek();
    }

    private void put(int num,PriorityQueue<Integer> min,PriorityQueue<Integer> max)
    {
        if(((min.size()+max.size())&1)==1)
        {
            int tmp=num;
            if(min.size()>0 && tmp>min.peek()){
                min.offer(tmp);
                tmp=min.poll();
            }
            max.offer(tmp);
        }else{
            int tmp=num;
            if(max.size()>0 && tmp<max.peek()){
                max.offer(tmp);
                tmp=max.poll();
            }
            min.offer(tmp);
        }
    }

    public static void main(String[] args)
    {
        int[] nums={2,3,5,6,3,2,7,8,9,2,1};
        System.out.println(new FortyOne().getMedian(nums));
    }
}
