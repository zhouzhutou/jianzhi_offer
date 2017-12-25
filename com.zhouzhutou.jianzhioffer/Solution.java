import java.util.Date;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * Created by Administrator on 2017/8/4 0004.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0)
            return 0;
        int hash[]=new int[256];
        int count=0 ,max=0;
        for(int i=0;i<s.length();i++)
        {
            int pos=s.charAt(i);
            if(hash[pos]==0)
            {
                hash[pos]=i+1;
                count++;
            }else{
                max=Math.max(count,max);
                i=hash[pos]-1;
                for(int k=0;k<hash.length;k++)
                    hash[k]=0;
                count=0;
            }

        }
        return Math.max(count,max);
    }

    public static void main(String[] args)
    {
        Queue<Integer> queue=new PriorityQueue<Integer>();
        for(int i=0;i<20;i++)
            queue.offer(new Random(new Date().getTime()).nextInt(100));
        while (queue.peek()!=null)
            System.out.print(queue.poll()+" ");
        //System.out.print(new Solution().lengthOfLongestSubstring("dvdf"));
    }
}
