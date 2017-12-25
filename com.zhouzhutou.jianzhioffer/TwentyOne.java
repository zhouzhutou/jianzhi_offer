import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Administrator on 2017/8/3 0003.
 */
public class TwentyOne {
    public void reOrderArray(int [] array) {
        /*int left=0,right=array.length-1;
        while (left<=right){
            while (left<=right && (array[left]&0x1)==1)
            {
                left++;
            }
            while (left<=right && (array[right]&0x1)!=1)
            {
                right--;
            }
            if(left<=right){
                int temp=array[left];
                array[left]=array[right];
                array[right]=temp;
            }
        }*/
        Deque<Integer> dequeOdd=new LinkedList<>();
        Deque<Integer> dequeEven=new LinkedList<>();
        for(int i=0;i<array.length;i++){
            if((array[i]&0x1)==1)
                dequeOdd.add(array[i]);
            else
                dequeEven.add(array[i]);
        }
        dequeOdd.addAll(dequeEven);
        for(int i=0;i<array.length;i++)
            array[i]=dequeOdd.removeFirst();
    }

    public static void main(String[] args)
    {
        int nums[]=new int[]{1,2,3,4,5,6,7,8,9,10};
        new TwentyOne().reOrderArray(nums);
        for(int num : nums)
            System.out.print(num+" ");
    }
}
