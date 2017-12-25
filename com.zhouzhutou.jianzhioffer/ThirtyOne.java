import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Administrator on 2017/8/9 0009.
 */
public class ThirtyOne {

    private Stack<Integer> stack=new Stack<>();
  /*  public boolean IsPopOrder(int [] pushA,int [] popA) {
        int i=0,j=0;
        boolean result=false;
        while (i<=pushA.length){
            if(stack.size()>0 && stack.peek()==popA[j]){
                stack.pop();
                j++;
                if(j==popA.length && stack.size()==0)
                {
                    result=true;
                    break;
                }
            }else{
                if(i==pushA.length && stack.peek()!=popA[j])
                {
                    result=false;
                    break;
                }
                stack.push(pushA[i]);
                i++;
            }
        }
        return result;
    }*/

    public boolean IsPopOrder(int [] pushA,int [] popA) {
       Stack<Integer> stack=new Stack<>();
       int i=0,j=0;
       while (stack.isEmpty() || stack.peek()!=popA[j])
       {
           stack.push(pushA[i]);
           i++;
           while (!stack.isEmpty() && stack.peek()==popA[j]){
               stack.pop();
               j++;
           }
           if(i==pushA.length)
               break;
       }
       if(i==pushA.length && !stack.isEmpty()){
           return false;
       }
       return true;

    }

    public static void main(String[] args)
    {
        int a[]={1,2,3,4,5};
        int b[]=new int[]{4,5,3,2,1};
        System.out.println(new ThirtyOne().IsPopOrder(a,b));
    }
}
