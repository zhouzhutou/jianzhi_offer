import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Administrator on 2017/8/12 0012.
 */
public class ThirtySix {

   /* private TreeNode head;
    public TreeNode Convert(TreeNode pRootOfTree) {
        return convertTreeToList(pRootOfTree);
    }

    private TreeNode convertTreeToList(TreeNode pRootOfTree)
    {
        if(pRootOfTree==null)
            return pRootOfTree;
        convertTreeToList(pRootOfTree.right);
        if(head==null){
            head=pRootOfTree;
        }else{
            pRootOfTree.right=head;
            head.left=pRootOfTree;
            head=pRootOfTree;
        }
        convertTreeToList(pRootOfTree.left);
        return head;
    }*/
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null)
            return pRootOfTree;
        LinkedList<TreeNode> stack=new LinkedList<>();
        TreeNode root=pRootOfTree,r;
        TreeNode listHead=null,listTail=null;
        while (stack.size()>0 || root!=null)
        {
            while (root!=null) {
                stack.push(root);
                root = root.left;
            }
            r = stack.pop();
            if (listTail == null) {
                listHead=listTail=r;
            } else {
                r.left = listTail;
                listTail.right = r;
                listTail = r;
            }
            root=r.right;
        }
        return listHead;
    }

    public static void main(String[] args)
    {
        LinkedList<Integer> list=new LinkedList<>();
        list.add(1);list.add(2);list.add(3);
        while (!list.isEmpty()){
            System.out.print(list.remove()+" ");
        }
    }
}
