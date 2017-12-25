/**
 * Created by Administrator on 2017/8/4 0004.
 */
public class TwentyThree {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead==null || pHead.next==null)
            return null;
        int cycleNodeNum=findCycleNodeNum(pHead);
        if(cycleNodeNum==0) return null;
        return findCycleEntrance(pHead,cycleNodeNum);
    }
    private ListNode findCycleEntrance(ListNode head, int cycleNodeNum)
    {
        ListNode p1=head, p2=head;
        for(int i=0;i<cycleNodeNum;i++)
        {
            p1=p1.next;
        }
        while (p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }
    private int findCycleNodeNum(ListNode head)
    {
        ListNode p1=head,p2=head;
        while (p1!=null){
            p1=p1.next.next;
            p2=p2.next;
            if(p1==p2)
                break;
        }
        if(p1==null)
            return 0;
        int count=1;
        p1=p1.next;
        while (p1!=p2){
            count++;
            p1=p1.next;
        }
        return count;
    }
}
