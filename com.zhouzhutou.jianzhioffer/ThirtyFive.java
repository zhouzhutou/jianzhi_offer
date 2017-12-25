import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/11 0011.
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class ThirtyFive {
/*    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null)
            return null;
        Map<RandomListNode,RandomListNode> map=new HashMap<>();
        RandomListNode newHead=new RandomListNode(pHead.label);
        RandomListNode p=pHead,newp=newHead;
        map.put(p,newp);
        while (p!=null){
            p=p.next;
            if(p!=null) {
                newp.next = new RandomListNode(p.label);
                newp = newp.next;
                map.put(p, newp);
            }
        }
        newp.next=null;
        p=pHead;
        while (p!=null){
            RandomListNode random=p.random;
            RandomListNode newRandom=map.get(random);
            newp=map.get(p);
            newp.random=newRandom;
            p=p.next;
        }
        return newHead;
    }*/

    public RandomListNode Clone(RandomListNode pHead)
    {
       if(pHead==null)
           return null;
       RandomListNode p=pHead;
       while (p!=null){
           RandomListNode newNode=new RandomListNode(p.label);
           newNode.next=p.next;
           p.next=newNode;
           p=p.next.next;
       }

       p=pHead;
       while (p!=null) {
           RandomListNode random=p.random;
           if(random!=null) {
               p.next.random = random.next;
           }
           p=p.next.next;
       }

       p=pHead;
       RandomListNode newHead,newp;
       newHead=newp=p.next;
       p.next=newp.next;
       p=p.next;
       while (p!=null)
       {
           newp.next=p.next;
           newp=newp.next;
           p.next=newp.next;
           p=p.next;
       }
       return newHead;
    }
}
