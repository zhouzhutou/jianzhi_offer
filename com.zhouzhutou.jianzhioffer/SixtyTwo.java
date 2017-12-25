import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/30 0030.
 */
public class SixtyTwo {
    public int LastRemaining_Solution(int n, int m) {
        if(n<=0 || m<=0)
            return -1;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(i);
        int count=0,pos=0;
        while (list.size()>1)
        {
            if(count==m-1) {
                list.remove(pos);
                count=0;
            }else{
                count++;
                pos++;
                if(pos>=list.size())
                    pos%=list.size();
            }
        }
        return list.get(0);
    }

    public static void main(String[] args)
    {
        System.out.println(new SixtyTwo().LastRemaining_Solution(5,3));
    }
}
