/**
 * Created by Administrator on 2017/8/3 0003.
 */
public class Nineteen {
    public boolean solution(char[] str, char[] pattern)
    {
        return isMatch(str,pattern,0,0);
    }

    public boolean isMatch(char[] str, char[] pattern, int i, int j)
    {
        if(i==str.length && j==pattern.length)
            return true;
        if((i<str.length && j==pattern.length) || (i==str.length && j<pattern.length))
            return false;

        if(j<pattern.length-1 && pattern[j+1]=='*'){
            if((str[i]==pattern[j]) || (i<str.length&&pattern[j]=='.')){
                return isMatch(str,pattern,i+1,j) //回到原来状态
                        || isMatch(str,pattern,i+1,j+2)//*只匹配一个字符
                        || isMatch(str,pattern,i,j+2);//*不匹配字符
            }else {
                return isMatch(str,pattern,i,j+2);//*不匹配字符
            }
        }
        if((str[i]==pattern[j]) || (i<str.length&&pattern[j]=='.'))
            return isMatch(str,pattern,i+1,j+1);
        return false;
    }
    public static void main(String[] args)
    {
        char[] str=new char[]{'a','a','b','a'};
        char[] pattern=new char[]{'a','b','*','a','c','*','.','a'};
        System.out.println(new Nineteen().solution(str,pattern));
    }
}
