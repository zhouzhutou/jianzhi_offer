/**
 * Created by Administrator on 2017/8/23 0023.
 */
public class FiftyTwo {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        long len1=getListLength(pHead1);
        long len2=getListLength(pHead2);
        long shortLen,longLen;
        ListNode shortNode,longNode;
        if(len1>len2){
            shortLen=len2;
            longLen=len1;
            shortNode=pHead2;
            longNode=pHead1;
        }else{
            shortLen=len1;
            longLen=len2;
            shortNode=pHead1;
            longNode=pHead2;
        }
        long diff=longLen-shortLen;
        while (diff>0){
            longNode=longNode.next;
            diff--;
        }
        while (longNode!=null && shortNode!=null && longNode!=shortNode)
        {
            longNode=longNode.next;
            shortNode=shortNode.next;
        }
        return longNode;
    }

    private long getListLength(ListNode pHead)
    {
        long len=0;
        ListNode p=pHead;
        while (p!=null){
            p=p.next;
            len++;
        }
        return len;
    }
}
