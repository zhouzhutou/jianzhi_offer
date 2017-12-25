import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 2017/10/24 0024.
 */
public class Sort {

    private void insertSort(int[] nums)
    {
        if(nums==null || nums.length==0)
            return;
        int j=0;
        for(int i=1;i<nums.length;i++){
            int tmp=nums[i];
            for(j=i;j>0 && tmp<nums[j-1];j--)
                nums[j]=nums[j-1];
            nums[j]=tmp;
        }
    }

    private void mergeSort(int[] nums)
    {
        if(nums==null || nums.length==0)
            return;
        int left=0,right=nums.length-1;
        int array[]=new int[nums.length];
        mergeSort(nums,0,nums.length-1,array);
    }

    private void mergeSort(int[] nums,int left,int right,int[] array)
    {
        if(left<right){
            int mid=(left+right)>>1;
            mergeSort(nums,left,mid,array);
            mergeSort(nums,mid+1,right,array);
            merge(nums,left,mid+1,right,array);
        }
    }

    private void merge(int[] nums,int left,int mid,int right,int[] array)
    {
        int leftStart=left,rigthStart=mid,k=left;
        while (leftStart<=mid-1 && rigthStart<=right){
            if(nums[leftStart]<nums[rigthStart])
                array[k++]=nums[leftStart++];
            else
                array[k++]=nums[rigthStart++];
        }
        while (leftStart<=mid-1)
            array[k++]=nums[leftStart++];
        while (rigthStart<=right)
            array[k++]=nums[rigthStart++];
        for(int i=left;i<=right;i++)
            nums[i]=array[i];
    }

    public void quickSort(int[] nums)
    {
        if(nums==null || nums.length==0)
            return;
        quickSort(nums,0,nums.length-1);
    }

    private void quickSort(int[] nums,int low ,int high)
    {
        if(low<high){
            int p=partition(nums,low,high);
            quickSort(nums,low,p-1);
            quickSort(nums,p+1,high);
        }
    }

    private int partition(int[] nums,int low,int high)
    {
        int temp=nums[low];
        while (low<high){
            while (low<high && nums[high]>=temp) high--;
            nums[low]=nums[high];
            while (low<high && nums[low]<=temp) low++;
            nums[high]=nums[low];
        }
        nums[low]=temp;
        return low;
    }


    private int child(int i){
        return 2*i+1;
    }

    private void heapDown(int[] nums, int i, int len)
    {
        int pos=i;
        int val=nums[pos];
        int ch;
        for(;pos<len/2;pos=ch){
            ch=child(pos);
            if(ch<len-1 && nums[ch+1]>nums[ch])
                ch++;
            if(nums[ch]>val)
                nums[pos]=nums[ch];
            else
                break;
        }
        nums[pos]=val;
    }

    private void swap(int nums[], int left, int right)
    {
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }

    public void heapSort(int[] nums)
    {
        for(int i=nums.length/2-1;i>=0;i--){
            heapDown(nums,i,nums.length);
        }
        for(int i=nums.length-1;i>0;i--){
            swap(nums,0,i);
            heapDown(nums,0,i);
        }
    }


    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<    >();
        ArrayList<Integer> temp=new ArrayList<>();
        if(root==null) return result;
        findPath(root,target,0,result,temp);
        return result;
    }

    private void findPath(TreeNode root, int target,int sum, ArrayList<ArrayList<Integer>> result,
                                                   ArrayList<Integer> temp)
    {
        sum+=root.val;
        temp.add(root.val);
        if(root.left==null && root.right==null && sum==target)
            result.add(new ArrayList<>(temp));
        if(root.left!=null)
            findPath(root.left,target,sum,result,temp);
        if(root.right!=null)
            findPath(root.right,target,sum,result,temp);
        temp.remove(temp.size()-1);
        sum-=root.val;
    }

    public int coins(int[] coins, int target)
    {
        int p[][]=new int[coins.length+1][target+1];
        for(int i=0;i<coins.length;i++)
            p[i][0]=0;
        for(int j=0;j<p[0].length;j++)
            p[0][j]=Integer.MAX_VALUE;
        for(int i=1;i<=target;i++){
            for(int j=1;j<=coins.length;j++){
                if(coins[j-1]>i)
                    p[j][i]=p[j-1][i];
                else
                    p[j][i]=Math.min(p[j-1][i],1+p[j][i-coins[j-1]]);
            }
        }
        return p[coins.length][target];
    }

    public int oneZeroBackpack(int[] w, int v[], int target)
    {
        int p[][]=new int[v.length+1][target+1];
        int itemsLen=v.length;
        for(int i=0;i<=v.length;i++)
            p[i][0]=0;
        for(int j=0;j<=target;j++)
            p[0][j]=0;
        for(int i=1;i<=target;i++){
            for(int j=1;j<=itemsLen;j++){
                if(w[j-1]>i)
                    p[j][i]=p[j-1][i];
                else
                    p[j][i]=Math.max(p[j-1][i],p[j-1][i-w[j-1]]+v[j-1]);
            }
        }
        return p[itemsLen][target];
    }

    private static final int COUNT=1000000007;
    public int InversePairs(int [] array) {
        if(array==null || array.length==0)
            return 0;
        int[] copy=new int[array.length];
        return inversePairs(array,copy,0,array.length-1);
    }

    private int inversePairs(int[] array,int[] copy,int left,int right)
    {
        if(left>=right)
            return 0;
        int mid=(left+right)>>1;
        int leftCount=inversePairs(array,copy,left,mid)%COUNT;
        int rightCount=inversePairs(array,copy,mid+1,right)%COUNT;
        int count=inversePairsCount(array,copy,left,mid,right)%COUNT;
        return (leftCount+rightCount+count)%COUNT;
    }

    private int inversePairsCount(int[] array,int[] copy,int left,int mid,int right)
    {
        int i=mid, j=right;
        int count=0;
        int k=right;
        while (i>=left && j>=mid+1){
            if(array[i]>array[j]){
                count+=(j-mid);
                if(count>=COUNT)
                    count%=COUNT;
                copy[k--]=array[i--];
            }else
                copy[k--]=array[j--];
        }
        while (i>=left)
            copy[k--]=array[i--];
        while (j>=mid+1)
            copy[k--]=array[j--];
        for(int c=left;c<=right;c++)
            array[c]=copy[c];
        return count;
    }

    public int StrToInt(String str) {
        if(str==null || str.length()==0)
            return 0;
        long num=0;
        int k=0;
        boolean positive=true;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch==' ') continue;
            if(ch=='-' || ch=='+') positive= ch!='-';
            else if(ch<'0' || ch>'9') return 0;
            else {
                num=(long)(num*10+ch-'0');
            }
        }
        if(!positive)
            num=-num;
        return (int)num;
    }

    public static void main(String[] args)
    {
        int[] array={1,2,3,4,5,6,7,0};
        System.out.println(new Sort().InversePairs(array));
    }
}
