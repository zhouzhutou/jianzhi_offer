import java.util.*;

/**
 * Created by Administrator on 2017/8/4 0004.
 */
class HaffNode{
    HaffNode left;
    HaffNode right;
    int val = 0;

    HaffNode(int val){
        this.val = val;
    }
}
public class Alibaba {

    static int cut(int[] parts) {
        if (parts.length == 0) return 0;
        if (parts.length == 1) return 0;
        if (parts.length == 2) return parts[0]+parts[1];

        PriorityQueue<Integer> Q = new PriorityQueue<Integer>();

        for (int i=0; i<parts.length; ++i ){
            Q.add(parts[i]);
        }

        int result = 0;

        while (!Q.isEmpty()){
            HaffNode node = new HaffNode(0);

            Integer leftVal = Q.poll();
            Integer rightVal = Q.poll();

            if (rightVal == null){
                // result += leftVal;
                break;
            }
            node.left = new HaffNode(leftVal);
            node.right = new HaffNode(rightVal);

            node.val = node.right.val+ node.left.val;
            result += node.val;
            Q.add(node.val);
        }

        return result;

    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result=new ArrayList<>();
        if(str==null || str.length()==0)
            return result;
        permutation(str.toCharArray(),0,result);
        Collections.sort(result);
        return result;
    }

    private void permutation(char[] str,int begin,ArrayList<String> result)
    {
        if(begin==str.length){
            result.add(String.valueOf(str));
        }
        for(int i=begin;i<str.length;i++){
            if(i==begin || str[i]!=str[begin]){
                swap(str,i,begin);
                permutation(str,begin+1,result);
                swap(str,i,begin);
            }
        }
    }

    private void swap(char[] str, int i, int j)
    {
        char temp=str[i];
        str[i]=str[j];
        str[j]=temp;
    }

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int k=scanner.nextInt();
        int arr[]=new int[3];
        arr[0]=scanner.nextInt();
        arr[1]=scanner.nextInt();
        arr[2]=scanner.nextInt();
        int n=(int)Math.pow(2,k)-1;
        Arrays.sort(arr);
        int left=1,right=n;
        int res=0;
        while (left<right){
            int root=left+(right-left)/2;
            if(arr[0]>root){
                left=root+1;
            }else if(arr[2]<root){
                right=root-1;
            }else {
                res = root;
                break;
            }
        }
        System.out.println(res);
    }

    public void recruive(int left,int right)
    {

    }


}
