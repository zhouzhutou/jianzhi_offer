/**
 * Created by Administrator on 2017/7/31 0031.
 */
public class Sixteen {
    public double Power(double base, int exponent) {
        if(base==0)
            if(exponent<0)
                return 0;
        if(base!=0 && exponent==0)
            return 1;
        int exponent2=0;
        if(exponent<0)
            exponent2=-exponent;
        else
            exponent2=exponent;
        double res=calculate(base,exponent2);
        if(exponent<0)
            res=(double)1/res;
        return res;
    }

    private double calculate(double base, int exponent)
    {
        if(exponent == 0)
            return 1;
        if(exponent == 1)
            return base;
        double result=calculate(base,exponent>>1);
        result*=result;
        if((exponent & 1)==1)
        {
            result*=base;
        }
        return result;
    }

    public static void main(String[] args)
    {
        System.out.println(new Sixteen().Power(5,5));

    }
}

