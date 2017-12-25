import java.util.Stack;

/**
 * Created by Administrator on 2017/7/25 0025.
 */
public class Nine {
    Stack<Integer> stack1=new Stack<Integer>();
    Stack<Integer> stack2=new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if(!stack2.isEmpty()){
            return stack2.pop();
        }else{
            throw new RuntimeException("QUEUE IS EMPTY");
        }
    }
}
