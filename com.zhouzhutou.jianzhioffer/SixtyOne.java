import java.util.Arrays;

/**
 * Created by Administrator on 2017/8/30 0030.
 */
public class SixtyOne {

    public boolean isContinuous(int [] numbers) {
        if(numbers==null || numbers.length==0)
            return false;
        if(numbers.length==5) {
            Arrays.sort(numbers);
            int numberOfZeros = 0;
            for (int i = 0; i < numbers.length; i++)
                if(numbers[i]==0)
                    numberOfZeros++;
                else
                    break;
            int s=numberOfZeros;
            int b=s+1;
            int count=0;
            while (b<numbers.length){
                if(numbers[b]-numbers[s]>1)
                    count+=numbers[b]-numbers[s]-1;
                else if(numbers[b]==numbers[s])
                    return false;
                s=b;
                b++;
            }
            return count<=numberOfZeros ? true : false;
        }else{
            return false;
        }
    }

    public static void main(String[] args)
    {
        int nums[]={2,0,4,5,6};
        System.out.println(new SixtyOne().isContinuous(nums));
    }
}
