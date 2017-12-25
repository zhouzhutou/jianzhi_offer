/**
 * Created by Administrator on 2017/7/24 0024.
 */
public class Five {
    public String replaceSpace(StringBuffer str) {
        if(str==null || str.length()==0)
            return "";
        int spaceSum=0;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)==' ')
                spaceSum++;
        }
        int oldLength=str.length();
        int newLength=oldLength+2*spaceSum;
        str.setLength(newLength);
        int oldIndex=oldLength-1,newIndex=newLength-1;
        while (oldIndex>=0 && oldIndex<newIndex){
            if(str.charAt(oldIndex)!=' ')
            {
                str.setCharAt(newIndex--,str.charAt(oldIndex));
            }else{
                str.setCharAt(newIndex--,'0');
                str.setCharAt(newIndex--,'2');
                str.setCharAt(newIndex--,'%');
            }
            oldIndex--;
        }
        return str.toString();
    }

    public static void main(String[] args)
    {
        StringBuffer sb=new StringBuffer(10);
        sb.append("a b c");
        System.out.println(new Five().replaceSpace(sb));
    }
}
