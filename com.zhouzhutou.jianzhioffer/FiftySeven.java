import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/26 0026.
 */
public class FiftySeven {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<Integer> temp=new ArrayList<>();
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        int small=1,big=2;
        int curSum=small+big;
        temp.add(small);temp.add(big);
        while (small<=(1+sum)/2){
            if(curSum==sum) {
                result.add(new ArrayList<>(temp));
                big++;
                temp.add(big);
                curSum+=big;
            }
            else if(curSum<sum){
                big++;
                temp.add(big);
                curSum+=big;
            }else{
                small++;
                int smallest=temp.remove(0);
                curSum-=smallest;
            }
        }
        return result;
    }

    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> result=new ArrayList<>();
        if(array==null || array.length==0)
            return result;
        int begin=0, end=array.length-1;
        int curSum=array[begin]+array[end];
        result.add(array[begin]);
        result.add(array[end]);
        while (begin<end){
            if(curSum==sum){
                break;
            }else if(curSum<sum) {
                begin++;
                curSum-=result.remove(0);
                curSum+=array[begin];
                result.add(0,array[begin]);
            }else {
                end--;
                curSum-=result.remove(1);
                curSum+=array[end];
                result.add(array[end]);
            }
        }
        if(begin==end)
            return new ArrayList<Integer>();
        return result;

    }

    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> res=new FiftySeven().FindContinuousSequence(15);
        System.out.println(res);
    }
}
