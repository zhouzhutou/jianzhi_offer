/**
 * Created by Administrator on 2017/8/10 0010.
 */
public class ThirtyThree {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null || sequence.length==0)
            return false;
        return verifySquenceOfBSTRecursion(sequence,0,sequence.length-1);
    }

    private boolean verifySquenceOfBSTRecursion(int[] sequence,int left,int right){
        int root=sequence[right];
        int i;
        for(i=left;i<right;i++){
            if(sequence[i]>root)
                break;
        }
        int j=i;
        while (j<right){
            if(sequence[j]<root)
                return false;
            j++;
        }

        boolean lb=true;
        if(i>left)
            lb=verifySquenceOfBSTRecursion(sequence,left,i-1);
        boolean rb=true;
        if(i<right-left)
            rb=verifySquenceOfBSTRecursion(sequence,i,right-1);
        return lb && rb;
    }
}
