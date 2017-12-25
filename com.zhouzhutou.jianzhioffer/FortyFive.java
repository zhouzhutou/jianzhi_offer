import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2017/8/17 0017.
 */
public class FortyFive {

    class Com implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            String s1=String.valueOf(o1), s2=String.valueOf(o2);
            String ss1=s1.concat(s2), ss2=s2.concat(s1);
            return ss1.compareTo(ss2);
        }
    }
    public String PrintMinNumber(int [] numbers) {
        if(numbers==null || numbers.length==0)
            return "";
        Integer[] nums=new Integer[numbers.length];
        for(int i=0;i<numbers.length;i++)
            nums[i]=numbers[i];
        Arrays.sort(nums,new Com());
        StringBuilder sb=new StringBuilder();
        for(Integer val : nums)
            sb.append(val);
        return sb.toString();
    }

    public static void main(String[] args)
    {
        int[] nums={3,32,321};
        System.out.println(new FortyFive().PrintMinNumber(nums));
    }
}
