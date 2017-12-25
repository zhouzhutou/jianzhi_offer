/**
 * Created by Administrator on 2017/8/24 0024.
 */
public class FiftySix {

    class Depth{
        int depth;
        Depth(int depth){
            this.depth=depth;
        }
    }
    public boolean IsBalanced_Solution(TreeNode root) {
        Depth depth=new Depth(0);
        return isBalancedTree(root,depth);
    }

    public boolean isBalancedTree(TreeNode root,Depth d)
    {
        if(root==null) {
            d.depth = 0;
            return true;
        }
        Depth leftDepth=new Depth(0),rightDepth=new Depth(0);
        if(isBalancedTree(root.left,leftDepth) && isBalancedTree(root.right,rightDepth))
        {
            int diff=leftDepth.depth-rightDepth.depth;
            if(diff>=-1  && diff<=1) {
                d.depth = (leftDepth.depth>rightDepth.depth ? leftDepth.depth : rightDepth.depth)+1;
                return true;
            }
        }
        return false;
    }

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int result=array[0];
        for(int i=1;i<array.length;i++)
            result^=array[i];

        int k=0;
        while ((result&1)!=1 && k<=31)
        {
            k++;
            result>>=1;
        }
        int standard=1<<k;
        int d1=0,d2=0;
        for(int i=0;i<array.length;i++)
        {
            if((array[i]&standard)!=0)
                if(d1==0)
                    d1=array[i];
                else
                    d1^=array[i];
            else
                if(d2==0)
                    d2=array[i];
                else
                    d2^=array[i];
        }
        num1[0]=d1;
        num2[0]=d2;
    }

    public static void main(String[] args)
    {
        int[] num1=new int[1];
        int[] num2=new int[1];
        int[] array=new int[]{2,4,3,6,3,2,5,5};
        new FiftySix().FindNumsAppearOnce(array,num1,num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
