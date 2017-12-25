/**
 * Created by Administrator on 2017/7/27 0027.
 */
public class Fifteen {
 /*   public int NumberOf1(int n) {
        int flag=1,count=0;
        while (flag!=0){
            if((n&flag)!=0) {
                count++;
            }
            flag <<= 1;
        }
        return count;
    }*/

    public int NumberOf1(int n) {
        int count=0;
        while (n!=0)
        {
            count++;
            n=(n-1)&n;
        }
        return count;
    }
    public static void main(String[] args)
    {
        System.out.println(new Fifteen().NumberOf1(10));
    }
}
