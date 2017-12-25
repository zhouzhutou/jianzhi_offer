/**
 * Created by Administrator on 2017/7/24 0024.
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val=val;
    }
}
public class Seven {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        int preStart=0, inStart=0, preEnd=pre.length-1, inEnd=in.length-1;
        return construct(pre,in,preStart,preEnd,inStart,inEnd);
    }

    private TreeNode construct(int[] pre,int[] in, int preStart, int preEnd, int inStart, int inEnd)
    {
        int rootVal=pre[preStart];
        TreeNode root=new TreeNode(rootVal);
        if(preStart==preEnd){
            if(inStart==inEnd && pre[preStart]==in[inStart])
                return root;
            else
                throw new RuntimeException("construct field");
        }
        int inorderRoot=inStart;
        for(;inorderRoot<=inEnd;inorderRoot++){
            if(in[inorderRoot]==rootVal)
                break;
        }
        if(inorderRoot>inEnd)
            throw new RuntimeException("construct field");

        int leftLength=inorderRoot-inStart;
        int leftPredEnd=preStart+leftLength;
        if(leftLength>0)
        {
            root.left=construct(pre,in,preStart+1,leftPredEnd,inStart,inorderRoot-1);
        }
        if(leftLength<preEnd-preStart){
            root.right=construct(pre,in,leftPredEnd+1,preEnd,inorderRoot+1,inEnd);
        }
        return root;
    }
}
