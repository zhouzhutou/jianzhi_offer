/**
 * Created by Administrator on 2017/8/17 0017.
 */
public class FortyFour {
    public int digitIndex(int index){
        int digit=1;
        int remain=index;
        while (true){
            int digits=getDigits(digit);
            if(remain<digits*digit){
                return getIndexNumber(remain,digit);
            }
            remain-=digits*digit;
            digit++;
        }
    }

    private int getIndexNumber(int remain,int digit)
    {
        int number=getBegin(digit)+remain/digit;
        int c=remain%digit;
        int res=0;
        for(int i=digit;i>c;i--)
        {
            res=number%10;
            number/=10;
        }
        return res;
    }

    private int getBegin(int digit)
    {
        if(digit==1)
            return 0;
        else
            return (int)Math.pow(10,digit-1);
    }
    private int getDigits(int i)
    {
        if(i==1)
            return 10;
        else
            return (int)(9*Math.pow(10,i-1));
    }

    public static void main(String[] args)
    {
        System.out.print(new FortyFour().digitIndex(1001));
    }
}
