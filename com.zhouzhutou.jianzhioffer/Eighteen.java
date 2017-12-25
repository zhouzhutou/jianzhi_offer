import java.util.List;

/**
 * Created by Administrator on 2017/8/1 0001.
 */
public class Eighteen {
    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode vhead=new ListNode(0);
        vhead.next=pHead;
        ListNode prev=vhead, cur=pHead;
        while (cur!=null){
            ListNode nxt=cur.next;
            if(nxt!=null && cur.val==nxt.val) {
                while (nxt != null && cur.val == nxt.val) {
                    cur = nxt;
                    nxt = cur.next;
                }
                prev.next=cur.next;
            }else{
                prev=cur;
            }
            cur=cur.next;
        }
        return vhead.next;
    }
}
