/**
 * Created by Administrator on 2017/7/25 0025.
 */
public class Ten {
    long fibonacci(long n)
    {
        if(n==0 || n==1)
            return n;
        int first=0;
        int second=1;
        int r=0;
        for(int i=2;i<=n;i++){
            r=first+second;
            first=second;
            second=r;
        }
        return r;
    }

    public int JumpFloor(int target) {
        if(target<=2)
            return target;
        int first=1, second=2;
        int temp=0;
        for(int i=3;i<=target;i++){
            temp=first+second;
            first=second;
            second=temp;
        }
        return temp;
    }

    public int JumpFloorII(int target) {
        if(target==1)
            return 1;
        int res=1;
        while (target-->1){
            res*=2;
        }
        return res;
    }

    public int RectCover(int target) {
        if(target<=2)
            return target;
        int first=1, second=2;
        int temp=0;
        for(int i=3;i<=target;i++){
            temp=first+second;
            first=second;
            second=temp;
        }
        return temp;
    }

    public static void main(String[] args)
    {
        System.out.println(new Ten().fibonacci(24  ));
    }
}
