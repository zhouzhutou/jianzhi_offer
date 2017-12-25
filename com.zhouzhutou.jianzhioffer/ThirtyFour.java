import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/11 0011.
 */
public class ThirtyFour {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        if(root==null)
            return result;
        Integer sum=0;
        findPath(root,result,temp,sum,target);
        return result;
    }

    public void findPath(TreeNode root, ArrayList<ArrayList<Integer>> result, List<Integer> temp, Integer sum, int target)
    {
        temp.add(root.val);
        sum+=root.val;
        if(root.left==null && root.right==null) {
            if (sum.equals(target)) {
                result.add(new ArrayList<>(temp));
            }
        }
        if (root.left != null) {
            findPath(root.left, result, temp, sum, target);
        }
        if (root.right != null) {
            findPath(root.right, result, temp, sum, target);
        }
        sum-=temp.remove(temp.size()-1);
    }
}


