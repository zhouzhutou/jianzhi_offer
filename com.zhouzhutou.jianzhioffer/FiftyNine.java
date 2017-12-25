import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Administrator on 2017/8/29 0029.
 */
public class FiftyNine {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result=new ArrayList<>();
        if(num.length>=size && size>=1) {
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                while (deque.size() > 0 && num[deque.peekLast()] < num[i])
                    deque.pollLast();
                deque.offer(i);
            }
            for (int i=size;i<num.length;i++)
            {
                result.add(num[deque.peek()]);
                while (deque.size()>0 && num[deque.peekLast()]<num[i])
                    deque.pollLast();//删除队尾
                if(deque.size()>0 && (i-deque.peek())>=size)
                    deque.poll();//删除对头
                deque.offer(i);
            }
            result.add(num[deque.peek()]);
        }
        return result;
    }

    public static void main(String[] args)
    {
        int[] nums={2,3,4,2,6,2,5,1};
        System.out.println(new FiftyNine().maxInWindows(nums,3));
    }

}
