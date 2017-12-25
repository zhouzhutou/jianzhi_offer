/**
 * Created by Administrator on 2017/8/24 0024.
 */
public class FiftyFive {
    public int TreeDepth(TreeNode root) {
        if(root==null)
            return 0;
        int leftDepth=TreeDepth(root.left);
        int rightDepth=TreeDepth(root.right);
        return (leftDepth>rightDepth ? leftDepth : rightDepth) +1;
    }
}
