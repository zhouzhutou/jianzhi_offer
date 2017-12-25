import java.util.*;

/**
 * Created by Administrator on 2017/8/14 0014.
 */
public class Forty {
/*
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        if(input==null || input.length==0 || k==0 || input.length<k)
            return arrayList;
        Queue<Integer> priorityQueue=new PriorityQueue<Integer>(8,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for(int i=0;i<k;i++)
            priorityQueue.add(input[i]);
        for(int i=k;i<input.length;i++){
            if(input[i]<priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.offer(input[i]);
            }
        }
        arrayList.addAll(priorityQueue);
        return arrayList;
    }
*/

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        if(input==null || input.length==0 || k==0 || input.length<k)
            return arrayList;
        int p=partition(input,0,input.length-1);
        while (p!=k-1){
            if(p<k-1)
                p=partition(input,p+1,input.length-1);
            else
                p=partition(input,0,p-1);
        }
        for(int i=0;i<=k-1;i++)
            arrayList.add(input[i]);
        return arrayList;
    }

    private int partition(int[] nums,int low,int high)
    {
        int temp=nums[low];
        while (low<high){
            while (low<high && nums[high]>=temp) high--;
                nums[low]=nums[high];
            while (low<high && nums[low]<=temp) low++;
                nums[high]=nums[low];
        }
        nums[low]=temp;
        return low;
    }


    public static void main(String[] args)
    {
        int[] input={4,5,1,6,2,7,3,8};
        System.out.print(new Forty().GetLeastNumbers_Solution(input,8));
    }
}
