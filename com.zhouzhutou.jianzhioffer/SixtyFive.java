/**
 * Created by Administrator on 2017/8/31 0031.
 */
public class SixtyFive {
    public int Add(int num1,int num2) {
        do{
            int sum=num1 ^ num2;
            int carry=(num1 & num2)<<1;
            num1=sum;
            num2=carry;
        }while (num2!=0);
        return num1;
    }
}
