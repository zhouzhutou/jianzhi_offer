import javax.transaction.TransactionRequiredException;

/**
 * Created by Administrator on 2017/7/26 0026.
 */
class TreeLinkNode{
    int val;
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode next;

    TreeLinkNode(int val){
        this.val=val;
    }
}
public class Eight {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode==null)
            return pNode;
        if(pNode.right!=null)
        {
            TreeLinkNode right=pNode.right;
            while (right.left!=null)
                right=right.left;
            return right;
        }else{
            TreeLinkNode cur=pNode;
            TreeLinkNode parent=pNode.next;
            while (parent!=null && cur==parent.right){
                cur=parent;
                parent=parent.next;
            }
            return parent;
        }
    }
}
