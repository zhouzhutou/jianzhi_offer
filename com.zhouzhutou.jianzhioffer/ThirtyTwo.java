import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2017/8/9 0009.
 */

public class ThirtyTwo {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        ArrayList<Integer> result=new ArrayList<>();
        if(root==null)
            return result;
        queue.offer(root);
        while (queue.size()>0){
            TreeNode node=queue.poll();
            result.add(node.val);
            if(node.left!=null)
                queue.add(node.left);
            if(node.right!=null)
                queue.add(node.right);
        }
        return result;
    }
}
