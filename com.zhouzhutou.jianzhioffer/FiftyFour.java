import java.util.Stack;

/**
 * Created by Administrator on 2017/8/24 0024.
 */
public class FiftyFour {
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot==null || k==0)
            return null;
        return kthNode(pRoot,k);
    }

    TreeNode kthNode(TreeNode pRoot, int k)
    {
        TreeNode p=pRoot;
        Stack<TreeNode> stack=new Stack<>();
        while (!stack.isEmpty() || p!=null)
        {
            while (p!=null){
                stack.push(p);
                p=p.left;
            }
            if(!stack.isEmpty()){
                TreeNode tmp=stack.pop();
                if(--k==0)
                    return tmp;
                p=tmp.right;
            }
        }
        return null;
    }
}
