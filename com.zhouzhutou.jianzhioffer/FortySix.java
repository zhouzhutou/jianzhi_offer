/**
 * Created by Administrator on 2017/8/17 0017.
 */
public class FortySix {
    public int translateWays(int n){
        String str=String.valueOf(n);
        int[] counts=new int[str.length()];
        for(int i=str.length()-1;i>=0;i--)
        {
            int count=0;
            if(i<str.length()-1)
                count=counts[i+1];
            else
                count=1;
            if(i<str.length()-1) {
                int first = str.charAt(i) - '0';
                int second = str.charAt(i + 1) - '0';
                int sum;
                if ((sum = 10 * first + second) >= 0 && sum <= 25) {
                    if (i < str.length() - 2)
                        count+=counts[i + 2];
                    else
                        count+=1;
                }
            }
            counts[i] = count;
        }
        return counts[0];
    }

    public static void main(String[] args)
    {
        System.out.print(new FortySix().translateWays(12258));
    }
}
