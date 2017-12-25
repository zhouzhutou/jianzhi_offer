/**
 * Created by Administrator on 2017/8/3 0003.
 */
public class TwentyTwo {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null || k<=0)
            return null;
        ListNode p1=head;
        ListNode p2=head;
        for(int i=0;i<k-1;i++){
            if(p1.next!=null)
                p1=p1.next;
            else
                return null;
        }
        while (p1.next!=null){
            p1=p1.next;
            p2=p2.next;
        }
        return p2;
    }
}
