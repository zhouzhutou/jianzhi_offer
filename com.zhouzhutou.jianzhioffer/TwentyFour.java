/**
 * Created by Administrator on 2017/8/4 0004.
 */
public class TwentyFour {
    public ListNode ReverseList(ListNode head) {
        if(head==null)
            return null;
        if(head.next==null)
            return head;
        ListNode cur=head;
        ListNode pre=null,nxt=null,reverseHead=null;
        while (cur!=null)
        {
            nxt=cur.next;
            if(nxt==null)
                reverseHead=cur;
            cur.next=pre;
            pre=cur;
            cur=nxt;

        }
        return reverseHead;
    }
}
