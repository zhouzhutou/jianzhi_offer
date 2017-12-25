/**
 * Created by Administrator on 2017/8/31 0031.
 */
public class Sixtysix {
    public int[] multiply(int[] A) {
        int B[]=new int[A.length];
        B[0]=1;
        for(int i=1;i<A.length;i++)
            B[i]=B[i-1]*A[i-1];
        int temp=1;
        for(int i=A.length-2;i>=0;i--){
            temp*=A[i+1];
            B[i]*=temp;
        }
        return B;
    }
}
