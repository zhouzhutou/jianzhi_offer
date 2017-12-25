/**
 * Created by Administrator on 2017/8/16 0016.
 */
public class FortyThree {

    public int NumberOf1Between1AndN_Solution(int n) {
        return numberOf1BetweenAndN_Solution(String.valueOf(n));
    }

    private int numberOf1BetweenAndN_Solution(String number)
    {
        if(number==null || number.length()==0)
            return 0;
        int first=number.charAt(0)-'0';
        if(number.length()==1 && first==0)
            return 0;
        if(number.length()==1 && first>0)
            return 1;
        int len=number.length();
        int pNumbers=0,sNumbers,tNumbers;
        if(first>1){
            pNumbers=(int)Math.pow(10,len-1);
        }else if(first==1){
            pNumbers=Integer.valueOf(number.substring(1))+1;
    }
        sNumbers=first*(len-1)*((int)Math.pow(10,len-2));
        tNumbers=numberOf1BetweenAndN_Solution(number.substring(1));
        return pNumbers+sNumbers+tNumbers;
    }

    public static void main(String[] args)
    {
        System.out.print(new FortyThree().NumberOf1Between1AndN_Solution(10000));
    }
}
