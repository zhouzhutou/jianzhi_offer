import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/22 0022.
 */
public class Fifty {
    public int FirstNotRepeatingChar(String str) {
        if(str==null || str.length()==0)
            return -1;
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            Integer val=map.get(ch);
            if(val==null)
                map.put(ch,1);
            else
                map.put(ch,val+1);
        }
        int pos=0;
        for(int i=0;i<str.length();i++)
        {
            if(map.get(str.charAt(i))==1) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    public static void main(String[] args)
    {
        System.out.println(new Fifty().FirstNotRepeatingChar("abaccdeff"));
    }
}
