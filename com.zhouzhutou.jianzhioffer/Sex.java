import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/24 0024.
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
    }
}
public class Sex {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Deque<Integer> deque=new LinkedList<>();
        while (listNode!=null){
            deque.push(listNode.val);
            listNode=listNode.next;
        }
        ArrayList<Integer> res=new ArrayList<>(deque);
        return res;
    }
}
