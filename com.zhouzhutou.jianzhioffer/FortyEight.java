import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/21 0021.
 */
public class FortyEight {
    public int longestSubstringWithoutDuplication(String s)
    {
        if(s==null || s.length()==0)
            return 0;
        Map<Character,Integer> map=new HashMap<>();//字符与其在字符串中的位置的映射
        int maxLen=0, curLen=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            Integer pos;
            if((pos=map.get(ch))==null || i-pos>curLen){
                curLen++;
            }else{
                if(curLen>maxLen)
                    maxLen=curLen;
                curLen=i-pos;
            }
            map.put(ch,i);
        }
        return Math.max(curLen,maxLen);
    }

    public static void main(String[] args)
    {
        System.out.println(new FortyEight().longestSubstringWithoutDuplication("abcdefa"));
    }
}
