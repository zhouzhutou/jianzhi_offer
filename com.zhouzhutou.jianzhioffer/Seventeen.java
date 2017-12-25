/**
 * Created by Administrator on 2017/7/31 0031.
 */
public class Seventeen {
    /*常规循环方法*/
    public void printToMaxOfDigits(int n)
    {
        if(n<=0)
            return;
        char[] nums=new char[n+1];
        for(int i=0;i<nums.length;i++)
            nums[i]='0';
        while (increase(nums))
        {
            printNumsArray(nums);
        }
    }

    private void printNumsArray(char[] nums)
    {
        int i=0;
        if(nums[0]=='1')
            return;
        for(;i<nums.length;i++)
            if(nums[i]!='0')
                break;
        for(;i<nums.length;i++)
            System.out.print(nums[i]);
        System.out.println();
    }

    private boolean increase(char[] nums)
    {
        boolean flag=true;
        if(nums[0] =='1')
            return false;
        int jw=1;
        for(int i=nums.length-1;i>=0;i--)
        {
            int temp= flag ? nums[i]-'0'+jw : nums[i]-'0';
            if(temp>=10){
                jw=1;
                temp%=10;
                flag=true;
                nums[i]=(char)(temp+48);
            }else{
                jw=0;
                flag=false;
                nums[i]=(char)(temp+48);
                break;
            }
        }
        return true;
    }

    /*回溯法*/
    public void printToMaxOfDigits1(int n)
    {
        if(n<=0)
            return;
        char numbers[]=new char[n];
        backtrace(numbers,numbers.length,0);
    }

    private void backtrace(char[] numbers,int length,int idx)
    {
        if(idx==length){
            printNumsArray1(numbers);
            return;
        }
        for(int i=0;i<10;i++){
            numbers[idx]=(char)(i+48);
            backtrace(numbers,length,idx+1);
        }
    }

    private void printNumsArray1(char[] numbers)
    {
        if(numbers[0]=='1')
            return;
        int i=0;
        for(;i<numbers.length;i++)
        {
            if(numbers[i]!='0')
                break;
        }
        for(;i<numbers.length;i++)
        {
            System.out.print(numbers[i]);
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        int n=4;
        //new Seventeen().printToMaxOfDigits(5);
        new Seventeen().printToMaxOfDigits1(n);
    }
}
