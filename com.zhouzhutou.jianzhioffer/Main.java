import java.util.*;
import java.util.Queue;
import java.util.PriorityQueue;

/**
 * Created by Administrator on 2017/8/16 0016.
 * 测试类（忽略）
 */
public class Main {

    private static final String SC = "&=+$,;?/-_.!~*'()#";

    private static final String SEG_1 = "@";

    private static final String SEG_2 = ".";

    private String mailchange(String str)
    {
        StringBuilder sb=new StringBuilder(str);
        int start=0;
        while (sb.indexOf(SEG_1,start)!=-1) {
            int firstIdx, secondIdx;
            firstIdx = sb.indexOf(SEG_1,start);
            int segOnelen = firstIdx-start;
            secondIdx = sb.indexOf(SEG_2, firstIdx + 1);
            int segTwoLen = secondIdx - firstIdx - 1;
            if (segTwoLen >= 0 && segTwoLen <= 119 && (firstIdx-start) >= 3 && countSpec(str,firstIdx-3,firstIdx) >= 3) {
                sb.setCharAt(firstIdx - 1, '*');
                sb.setCharAt(firstIdx - 2, '*');
                sb.setCharAt(firstIdx - 3, '*');
                start=secondIdx+1;
            }else{
                start=firstIdx+1;
            }

        }
        return sb.toString();
    }

    private int countSpec(String str, int start, int firstIndex)
    {
        int count=0;
        char ch;
        for(int i=start;i<firstIndex;i++){
            ch=str.charAt(i);
            if(SC.indexOf(ch)!=-1 || (ch>='0'&&ch<='9') || (ch>='a'&&ch<='z') || (ch>='A'&&ch<='Z'))
               count++;
        }
        return count;
    }

   /* public static void main(String[] args)
    {
        System.out.println(new Main().mailchange("12@hu.12@we.i.com"));
        System.out.println(new Main().mailchange("21312a1A@hu23-awei.com"));
    }*/

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers==null || numbers.length==0){
            duplication[0]=-1;
            return false;
        }
        for(int i=0;i<numbers.length;i++)
        {
            while (numbers[i]!=i){
                int idx=numbers[i];
                if(numbers[i]==numbers[idx]){
                    duplication[0]=numbers[i];
                    return true;
                }
                int temp=numbers[i];
                numbers[i]=numbers[idx];
                numbers[idx]=temp;
            }
        }
        duplication[0]=-1;
        return false;
    }

    Map<Character,Integer> map=new HashMap<>();
    //Insert one char from stringstream
    private int i;

    public void Insert(char ch)
    {
        Integer pos=map.get(ch);
        if(pos==null){
            map.put(ch,i++);
        }else if(pos>=0){
            map.put(ch,-1);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        Set<Character> keySet=map.keySet();
        Character firstChar=null;
        int minVal=0;
        int count=1;
        for(Character key : keySet)
        {
            int val=map.get(key);
            if(val>=0){
                if(count==1){
                    firstChar=key;
                    minVal=val;
                }else{
                    if(val<minVal){
                        firstChar=key;
                        minVal=val;
                    }
                }
                count++;
            }
        }
        if(firstChar==null)
            return '#';
        return firstChar;
    }


    public int getDuplication(int[] nums,int length)
    {
        if(nums==null || length==0)
            return -1;
        int start=1, end=length-1;
        while (start<=end){
            int mid= (start+end)>>1;
            int count=countNumbers(nums,start,mid);
            if(start==end){
                if(count>1)
                    return start;
                 else
                    break;
            }
            if(count>mid-start+1)
                end=mid;
            else
                start=mid+1;
        }
        return -1;
    }

    private int countNumbers(int nums[], int start, int mid)
    {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=start && nums[i]<=mid)
                count++;
        }
        return count;
    }

    public String replaceSpace(StringBuffer str) {
        if(str==null || str.length()==0)
            return "";
        int spaceCount=0;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)==' ')
                spaceCount++;
        }
        int oldLen=str.length();
        int newLen=oldLen+2*spaceCount;
        str.setLength(newLen);
        int oldStart=oldLen-1, newStart=newLen-1;
        while (oldStart<newStart){
            char ch= str.charAt(oldStart);
            if(ch==' ')
            {
                str.setCharAt(newStart--,'0');
                str.setCharAt(newStart--,'2');
                str.setCharAt(newStart--,'%');
            }else{
                str.setCharAt(newStart--,ch);
            }
            oldStart--;
        }
        return str.toString();
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre==null || in==null)
            return null;
        return reConstructBinaryTree(pre,in,0,pre.length-1,0,in.length-1);
    }

    private TreeNode reConstructBinaryTree(int[] pre,int[] in, int startPre, int endPre, int startIn, int endIn)
    {
        int val=pre[startPre];
        TreeNode root=new TreeNode(val);
        if(startPre==endPre && startIn==endIn){
            if(pre[startPre]==in[startIn])
                return root;
        }

        int roo=0;
        int i;
        for(i=startIn;i<=endIn;i++){
            if(in[i]==val){
                roo=i;
                break;
            }
        }
        if(i>endIn)
            throw new RuntimeException("Input error");
        int len=roo-startIn;
        int preLeftEnd=startPre+len;
        if(len>0){
            root.left=reConstructBinaryTree(pre,in,startPre+1,preLeftEnd,startIn,roo-1);
        }
        if(len<endPre-startPre){
            root.right=reConstructBinaryTree(pre,in,preLeftEnd+1,endPre,roo+1,endIn);
        }
        return root;
    }

    public List<Character> lcs(String str1, String str2)
    {
        int len1=str1.length();
        int len2=str2.length();
        int[][] c=new int[len1+1][len2+1];
        List<Character> res=new ArrayList<>();
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1))
                    c[i][j]=c[i-1][j-1]+1;
                else{
                    c[i][j]=Math.max(c[i-1][j],c[i][j-1]);
                }
            }
        }
        recurive(c,str1,str2,res,len1,len2);
        return res;
    }

    private void recurive(int[][] c,String str1, String str2, List<Character> res,int x,int y)
    {
        if(x==0 || y==0) return;
        if(str1.charAt(x-1)==str2.charAt(y-1)){
            recurive(c,str1,str2,res,x-1,y-1);
            res.add(str1.charAt(x-1));
        }else if(c[x-1][y]>=c[x][y-1]){
            recurive(c,str1,str2,res,x-1,y);
        }else{
            recurive(c,str1,str2,res,x,y-1);
        }
    }

    public Map tryCatchTest(int n)
    {
        Map<String,Integer> map=new HashMap<>();
        try{
            n++;
            map.put("a",n);
            n=n/0;
            return map;//压入引用
        }catch (Exception e){
            map.put("a",++n);
            return map;
        }finally {
            map.put("a",++n);
            System.out.println("finally: "+n);
        }
    }

    public int minNumberInRotateArray(int [] array) {
        if(array==null || array.length==0)
            return 0;
        int left=0, right=array.length-1;
        int mid=left;
        while (array[left]>=array[right]){
            if(left==right-1) {
                mid=right;
                break;
            }
            mid=(left+right)>>1;
            if(array[mid]==array[left] && array[mid]==array[right])
            {
                return findMin(array);
            }
            if(array[mid]>=array[left])
                left=mid;
            else if(array[mid]<=array[right])
                right=mid;
        }
        return array[mid];
    }

    public int findMin(int[] array)
    {
        int min=array[0];
        for(int i=0;i<array.length;i++)
            if(array[i]<min)
                min=array[i];
        return min;
    }


    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix==null || matrix.length==0)
            return false;
        boolean[][] visited=new boolean[rows][cols];
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                int idx=0;
                if(trace(matrix,rows,cols,str,i,j,visited,idx))
                    return true;
            }
        }
        return false;
    }

    private boolean trace(char[] matrix, int rows, int cols, char[] str, int i, int j, boolean[][] visited, int idx)
    {
        if(idx==str.length)
            return true;

        if(i<0 || i>=rows || j<0 || j>=cols || visited[i][j] || str[idx]!=matrix[i*cols+j])
            return false;

        visited[i][j]=true;
        if(trace(matrix,rows,cols,str,i-1,j,visited,idx+1) ||
            trace(matrix,rows,cols,str,i+1,j,visited,idx+1) ||
            trace(matrix,rows,cols,str,i,j-1,visited,idx+1) ||
            trace(matrix,rows,cols,str,i,j+1,visited,idx+1))
        {
            return true;
        }
        visited[i][j]=false;
        return false;
    }

    public int cutMax(int n)
    {
        if(n<2)
            return 0;
        if(n==2)
            return 1;
        if(n==3)
            return 2;
        int array[]=new int[n+1];
        array[0]=0;
        array[1]=1;
        array[2]=2;
        array[3]=3;
        int max=0;
        for(int i=4;i<=n;i++)
        {
            max=0;
            for(int j=1;j<=i/2;j++){
                int temp=array[j]*array[i-j];
                if(temp>max)
                    max=temp;
            }
            array[i]=max;
        }
        return array[n];
    }

    public int NumberOf1(int n) {
        /*int c=0;
        while (n!=0){
            n=(n-1)&n;
            c++;
        }
        return c;*/
        int flag=1;
        int c=0;
        while (flag!=0)
        {
            if((flag&n)==1) {
                c++;
            }
            flag <<= 1;
        }
        return c;
    }


    public double Power(double base, int exponent) {
        boolean flag=false;
        if(exponent<0)
            flag=true;
        double result=power(base,exponent);
        result= flag ? 1/result : result;
        return result;
    }

    private double power(double base, int exponent)
    {
        if(exponent==0)
            return 1;
        if(exponent==1)
            return base;
        double res=power(base,exponent/2);
        res*=res;
        if((exponent&1)==1)
            res*=base;
        return res;
    }

    public List<char[]> printNumber(int n){
        char[] number=new char[n+1];
        for(int i=0;i<number.length;i++)
            number[i]='0';
        List<char[]> list=new ArrayList<>();
        while (true){
            increase(number);
            if(number[0]=='1')
                break;
            list.add(Arrays.copyOf(number,number.length));
        }
        return list;
    }

    private void increase(char[] number)
    {
        boolean flag=true;
        for(int i=number.length-1;i>=0;i--)
        {
            int ch=number[i]-'0';
            int temp=ch+ (flag ? 1 : 0);
            if(temp>=10){
                ch=temp%10;
                flag=true;
            }else{
                ch=temp;
                flag=false;
            }
            number[i]=(char)('0'+ch);
        }
    }

    public List<char[]> printNumberDFS(int n)
    {
        char[] number=new char[n];
        List<char[]> result=new ArrayList<>();
        printNumberDFS(number,0,result);
        return result;
    }

  private void printNumberDFS(char[] number, int idx, List<char[]> list){
        if(idx==number.length){
            list.add(Arrays.copyOf(number,number.length));
            return;
        }
        for(int i=0;i<=9;i++) {
            number[idx] = (char) ('0' + i);
            printNumberDFS(number,idx+1,list);
        }
  }

    private static void printNumber(char[] number)
    {
        int i;
        for(i=0;i<number.length;i++)
            if(number[i]!='0')
                break;
        for(;i<number.length;i++)
        {
            System.out.print(number[i]);
        }
        System.out.println();
    }


    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode pVHead=new ListNode(0);
        pVHead.next=pHead;
        ListNode pre=pVHead,cur=pHead,next;
        while (cur!=null){
            next=cur.next;
            if(next!=null && cur.val!=next.val){
                pre=cur;
            }else if(next!=null) {
                while (next != null && cur.val == next.val) {
                    cur = next;
                    next = next.next;
                }
                pre.next=cur.next;
            }
            cur=next;
        }
        return pVHead.next;
    }


    public boolean match(char[] str, char[] pattern)
    {
        int idx1=0,idx2=0;
        return match(str,idx1,pattern,idx2);
    }

    private boolean match(char[] str, int idx1, char[] pattern, int idx2)
    {
        if(idx1==str.length && idx2==pattern.length)
            return true;
        if(idx1!=str.length && idx2==pattern.length)
            return false;
        if(idx2<pattern.length-1 && pattern[idx2+1]=='*'){
            if((idx1<str.length )&& (pattern[idx2]=='.' || pattern[idx2]==str[idx1]))
            {
                return match(str,idx1,pattern,idx2+2) ||
                        match(str,idx1+1,pattern,idx2) ||
                        match(str,idx1+1,pattern,idx2+2);
            }else{
                return match(str,idx1,pattern,idx2+2);
            }
        }else if((idx1<str.length) && (pattern[idx2]=='.' || pattern[idx2]==str[idx1])){
            return match(str,idx1+1,pattern,idx2+1);
        }
        return false;
    }


    public ListNode FindKthToTail(ListNode head,int k) {
      if(head==null || k<=0)
          return null;
        ListNode p1=head,p2=null;
        int c=0;
        while (k>1)
        {
            if(p1.next!=null){
                p1=p1.next;
            }else{
                return null;
            }
            k--;
        }
        p2=head;
        while (p1.next!=null){
            p1=p1.next;
            p2=p2.next;
        }
        return p2;
    }


    public ListNode ReverseList(ListNode head) {
        /*ListNode pre=null, cur=head, nxt=null;
        if(cur!=null) nxt=cur.next;
        while (cur!=null)
        {
            cur.next=pre;
            pre=cur;
            cur=nxt;
            if(nxt!=null)
                nxt=nxt.next;
        }
        return pre;*/
        if(head==null) return null;
        return recurive(null,head,head.next);
    }

    private ListNode recurive(ListNode pre,ListNode cur,ListNode nxt)
    {
        if(cur==null)
            return cur;
        cur.next=pre;
        if(nxt==null)
            return cur;
        return recurive(cur,nxt,nxt.next);

    }


    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head=null;
        ListNode tail=null;
        while (list1!=null && list2!=null)
        {
            if(list1.val<list2.val){
                if(head==null) {
                    head=new ListNode(list1.val);
                    tail=head;
                }else{
                    tail.next=new ListNode(list1.val);
                    tail=tail.next;
                }
                list1=list1.next;
            }else{
                if(head==null){
                    head=new ListNode(list2.val);
                    tail=head;
                }else{
                    tail.next=new ListNode(list2.val);
                    tail=tail.next;
                }
                list2=list2.next;
            }
        }
        while (list1!=null){
            if(head==null){
                head=new ListNode(list1.val);
                tail=head;
            }else {
                tail.next = new ListNode(list1.val);
                tail = tail.next;
            }
            list1=list1.next;
        }
        while (list2!=null){
            if(head==null){
                head=new ListNode(list2.val);
                tail=head;
            }else {
                tail.next = new ListNode(list2.val);
                tail = tail.next;
            }
            list2 = list2.next;
        }
        return head;
    }


    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result=false;
        if(root1!=null && root2!=null)
        {
            if(equal(root1.val,root2.val))
                result=hasSubTree(root1,root2);
            if(!result)
                result=hasSubTree(root1.left,root2);
            if(!result)
                result=hasSubTree(root1.right,root2);
        }
        return result;
    }

    private boolean hasSubTree(TreeNode root1, TreeNode root2){
        if(root2==null)
            return true;
        if(root1==null)
            return false;
        if(!equal(root1.val,root2.val))
            return false;

        return hasSubTree(root1.left,root2.left) && hasSubTree(root1.right,root2.right);
    }

    private boolean equal(int a, int b)
    {
        return a==b;
    }

    public boolean isSymmetrical(TreeNode pRoot)
    {
        return isSymmetrical(pRoot,pRoot);
    }

    private boolean isSymmetrical(TreeNode p1, TreeNode p2)
    {
        if(p1==null && p2==null)
            return true;
        if(p1==null || p2==null)
            return false;
        if(p1.val!=p2.val)
            return false;
        return isSymmetrical(p1.left,p2.right) && isSymmetrical(p1.right,p2.left);
    }

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int cols=matrix[0].length, rows=matrix.length;
        int start=0;
        ArrayList<Integer> result=new ArrayList<>();
        while (start*2<rows && start*2<cols){
            int endRow=rows-1-start;
            int endCol=cols-1-start;

            for (int i = start; i <= endCol; i++){
                result.add(matrix[start][i]);
            }

            if(start<endRow){
                for(int i=start+1;i<=endRow;i++){
                    result.add(matrix[i][endCol]);
                }
            }

            if(start<endCol && start<endRow){
                for(int i=endCol-1;i>=start;i--){
                    result.add(matrix[endRow][i]);
                }
            }

            if(start<endCol && start<endRow-1){
                for(int i=endRow-1;i>start;i--){
                    result.add(matrix[i][start]);
                }
            }
            start++;
        }
        return result;
    }


    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int popLen=popA.length;
        int pushLen=pushA.length;
        LinkedList<Integer> list=new LinkedList<>();
        int i=0;
        int j=0;
        while (i<popLen)
        {
            while (list.isEmpty() || list.getLast()!=popA[i]) {
                if (j == pushLen)
                    break;
                list.addLast(pushA[j]);
                j++;
            }
            if(list.getLast()!=popA[i])
                break;
            list.removeLast();
            i++;
        }

        if(list.isEmpty() && i==popLen)
            return true;
        return false;
    }

    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        if(pRoot==null) return list;
        int toBePrint=1;
        int nextLevel=0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(pRoot);
        ArrayList<Integer> temp=new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode root=queue.poll();
            temp.add(root.val);
            if(root.left!=null) {
                queue.offer(root.left);
                nextLevel++;
            }
            if(root.right!=null) {
                queue.offer(root.right);
                nextLevel++;
            }
            --toBePrint;
            if(toBePrint==0){
                toBePrint=nextLevel;
                nextLevel=0;
                list.add(temp);
                temp=new ArrayList<>();
            }
        }
        return list;
    }


    /*public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        if(pRoot==null)
            return list;
        int current=0, next=1;
        Stack<TreeNode> stack[]=new Stack[2];
        for(int i=0;i<stack.length;i++)
            stack[i]=new Stack<>();
        stack[current].push(pRoot);
        ArrayList<Integer> temp=new ArrayList<>();
        while (!stack[0].isEmpty() || !stack[1].isEmpty())
        {
            TreeNode root=stack[current].pop();
            temp.add(root.val);
            if(current==0)
            {
                if(root.left!=null)
                    stack[next].push(root.left);
                if(root.right!=null)
                    stack[next].push(root.right);
            }else{
                if(root.right!=null)
                    stack[next].push(root.right);
                if(root.left!=null)
                    stack[next].push(root.left);
            }
            if(stack[current].isEmpty())
            {
                current=1-current;
                next=1-next;
                list.add(temp);
                temp=new ArrayList<>();
            }
        }
        return list;
    }*/

    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null || sequence.length==0)
            return false;
        return verifySquenceOfBST(sequence,0,sequence.length-1);
    }


    private boolean verifySquenceOfBST(int[] sequence, int start, int end)
    {
        int root=sequence[end];
        int i;
        for(i=start;i<end;i++)
            if(sequence[i]>root)
                break;
        int j=i;
        for(;j<end;j++)
            if(sequence[j]<root)
                return false;
        boolean left=true;
        if(i>start)
            left=verifySquenceOfBST(sequence,start,i-1);
        boolean right=true;
        if(i<end)
            right=verifySquenceOfBST(sequence,i,end-1);
        return left && right;
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        if(root==null)
            return list;
        ArrayList<Integer> temp=new ArrayList<>();
        findPath(root,target,list,temp);
        return list;
    }

    private void findPath(TreeNode root, int target, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> temp)
    {
        temp.add(root.val);
        if(root.left==null && root.right==null){
            int sum=0;
            for(int val : temp)
                sum+=val;
            if(sum==target)
                list.add(new ArrayList<>(temp));
        }
        if(root.left!=null)
            findPath(root.left,target,list,temp);
        if(root.right!=null)
            findPath(root.right,target,list,temp);
        temp.remove(temp.size()-1);
    }


    private static  int getNumberSum(int n)
    {
        int sum=0;
        while (n!=0){
            int r=n%10;
            sum+=r*r;
            n/=10;
        }
        return sum;
    }

    private static boolean isHappyNumber(int n)
    {
        if(n<=0) return false;
        while (n!=1){
            n=getNumberSum(n);
            if(n==4)
                return false;
        }
        return true;
    }


    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int maximumRating(int nhorror, int nscifi, int amount, int[][] horrorList,
                      int[][] scifiList)
    {
       return 0;
    }
    // FUNCTION SIGNATURE ENDS

    int minNumberOfLines(int num, int timX, int timY, int[][] coordinates)
    {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<coordinates.length;i++){
            int x=coordinates[i][0];
            int y=coordinates[i][1];
            int k=(y-timY)/(x-timX);
            if(!set.contains(k)){
                set.add(k);
            }
        }
        return set.size();
    }


    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null)
            return null;
        createNextNode(pHead);
        createrandomNode(pHead);
        return getCopyList(pHead);
    }

    private void createNextNode(RandomListNode pHead)
    {
        RandomListNode p=pHead;
        while (p!=null){
            RandomListNode newNode=new RandomListNode(p.label);
            newNode.next=p.next;
            p.next=newNode;
            p=newNode.next;
        }
    }

    private void createrandomNode(RandomListNode pHead)
    {
        RandomListNode p=pHead;
        while (p!=null) {
            RandomListNode rand = p.random;
            if (rand != null) {
                p.next.random=rand.next;
            }
            p=p.next.next;
        }

    }

    private RandomListNode getCopyList(RandomListNode pHead)
    {
        RandomListNode p=pHead;
        RandomListNode newHead=p.next,newp=p.next;
        p.next=newp.next;
        p=p.next;
        while (p!=null){
            newp.next=p.next;
            newp=newp.next;
            p.next=newp.next;
            p=p.next;
        }
        return newHead;
    }

    private TreeNode head;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null)
            return pRootOfTree;
        Convert(pRootOfTree.right);
        if(head==null)
            head=pRootOfTree;
        else{
            pRootOfTree.right=head;
            head.left=pRootOfTree;
            head=pRootOfTree;
        }
          Convert(pRootOfTree.left);
        return head;
    }

    private String str;

    String Serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        if(root==null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val+',');
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        Queue<String> queue=new LinkedList<>();
        String[] strs=str.split(",");
        for(int i=0;i<strs.length;i++)
            queue.offer(strs[i]);
        return deserialize(queue);
    }



    private TreeNode deserialize(Queue<String> queue)
    {
        String val=queue.poll();
        if(val.equals("#"))
            return null;
        TreeNode root=new TreeNode(Integer.valueOf(val));
        root.left=deserialize(queue);
        root.right=deserialize(queue);
        return root;
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list=new ArrayList<>();
        if(str==null || str.length()==0)
            return list;
        permutation(str.toCharArray(),0,list);
        Collections.sort(list);
        return list;
    }

    private void permutation(char[] str,int start,ArrayList<String> list)
    {
        if(start==str.length){
            list.add(new String(str));
        }else{
            for(int i=start;i<str.length;i++){
                if(i==start || str[i]!=str[start]){
                    swap(str,start,i);
                    permutation(str,start+1,list);
                    swap(str,start,i);
                }
            }
        }
    }

    private void swap(char[] str, int left, int right)
    {
        char temp=str[left];
        str[left]=str[right];
        str[right]=temp;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> tempList=new ArrayList<>();
        if(nums==null || nums.length==0)
            return result;
        dfsSubsets(nums,result,tempList,0);
        return result;
    }

    private void dfsSubsets(int[] nums,List<List<Integer>> result, List<Integer> tempList,int start)
    {
        result.add(new ArrayList<>(tempList));
        for(int i=start;i<nums.length;i++){
            tempList.add(nums[i]);
            dfsSubsets(nums,result,tempList,i+1);
            tempList.remove(tempList.size()-1);
        }
    }


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> tempList=new ArrayList<>();
        if(nums==null || nums.length==0)
            return result;
        Arrays.sort(nums);
        dfsSubsetsWithDup(nums,result,tempList,0);
        return result;
    }

    private void dfsSubsetsWithDup(int[] nums, List<List<Integer>> result, List<Integer> tempList, int start)
    {
        result.add(new ArrayList<>(tempList));
        for(int i=start;i<nums.length;i++)
        {
            if(i==start || i>start && nums[i]!=nums[i-1]){
                tempList.add(nums[i]);
                dfsSubsetsWithDup(nums,result,tempList,i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> tempList=new ArrayList<>();
        if(nums==null || nums.length==0)
            return result;
        dfsPermute(nums,result,tempList);
        return result;
    }

    private void dfsPermute(int[] nums, List<List<Integer>> result, List<Integer> tempList)
    {
        if(tempList.size()==nums.length)
            result.add(new ArrayList<>(tempList));
        else{
            for(int i=0;i<nums.length;i++){
                if(tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                dfsPermute(nums,result,tempList);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> tempList=new ArrayList<>();
        boolean visited[]=new boolean[nums.length];
        Arrays.sort(nums);
        dfsPermuteUnique(nums,result,tempList,visited);
        return result;
    }

    private void dfsPermuteUnique(int[] nums,List<List<Integer>> result,List<Integer> tempList,boolean[] visited)
    {
        if(tempList.size()==nums.length)
            result.add(new ArrayList<>(tempList));
        else{
            for(int i=0;i<nums.length;i++){
                if(visited[i] || (i>0 && nums[i]==nums[i-1] && !visited[i-1])) continue;
                visited[i]=true;
                tempList.add(nums[i]);
                dfsPermuteUnique(nums,result,tempList,visited);
                tempList.remove(tempList.size()-1);
                visited[i]=false;
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> tempList=new ArrayList<>();
        if(candidates==null || candidates.length==0)
            return result;
        Arrays.sort(candidates);
        dfsCombination(candidates,result,tempList,target,0);
        return result;
    }

    private void dfsCombination(int[] candidates,List<List<Integer>> result,List<Integer> tempList,int target,int index){
        if(target<=0) {
            if (target == 0)
                result.add(new ArrayList<>(tempList));
        }else{
            for(int i=index;i<candidates.length;i++) {
                tempList.add(candidates[i]);
                dfsCombination(candidates,result,tempList,target-candidates[i],i);
                tempList.remove(tempList.size()-1);
            }
        }
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> tempList=new ArrayList<>();
        if(candidates==null || candidates.length==0)
            return result;
        Arrays.sort(candidates);
        dfsCombinationSum2(candidates,result,tempList,target,0);
        return result;
    }

    private void dfsCombinationSum2(int[] candidates,List<List<Integer>> result,List<Integer> tempList,int target,int index)
    {
        if(target<=0)
            if(target==0)
                result.add(new ArrayList<>(tempList));
        else{
            for(int i=index;i<candidates.length;i++){
                if(i>index && candidates[i]==candidates[i-1]) continue;
                tempList.add(candidates[i]);
                dfsCombinationSum2(candidates,result,tempList,target-candidates[i],i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result=new ArrayList<>();
        List<String> tempList=new ArrayList<>();
        if(s==null || s.length()==0)
            return result;
        dfsPartition(s,result,tempList,0);
        return result;
    }

    private void dfsPartition(String s, List<List<String>> result, List<String> tempList, int index)
    {
        if(index==s.length())
            result.add(new ArrayList<>(tempList));
        else{
            for(int i=index;i<s.length();i++){
                if(isPalindrome(s,index,i)){
                    tempList.add(s.substring(index,i+1));
                    dfsPartition(s,result,tempList,i+1);
                    tempList.remove(tempList.size()-1);
                }
            }
        }
    }
    private boolean isPalindrome(String s,int low,int high)
    {
        while (low<high){
            if(s.charAt(low++)!=s.charAt(high--)) return false;
        }
        return true;
    }

    

    public int MoreThanHalfNum_Solution(int [] array){
        int left=0,right=array.length-1;
        int mid=(array.length-1)>>1;
        int p=partition(array,left,right);
        while (p!=mid){
            if(p>mid)
                p=partition(array,left,p-1);
            else
                p=partition(array,p+1,right);
        }
        int target=array[p];
        int count=0;
        for(int i=0;i<array.length;i++)
            if(array[i]==target)
                count++;
        if(count>array.length/2)
            return target;
        else
            return 0;
    }


    private int partition(int[] array, int low, int high)
    {
        int temp=array[low];
        while (low<high){
            while (low<high && array[high]>=temp) high--;
            array[low]=array[high];
            while (low<high && array[low]<=temp) low++;
            array[high]=array[low];
        }
        array[low]=temp;
        return low;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result=new ArrayList<>();
        if(k>input.length || k<=0)
            return result;
        if(k==input.length) {
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<input.length;i++)
                list.add(input[i]);
            result.addAll(list);
            return result;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>(k,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for(int i=0;i<k;i++)
            pq.add(input[i]);
        for(int i=k;i<input.length;i++){
            if(input[i]<pq.peek()){
                pq.poll();
                pq.offer(input[i]);
            }
        }
        result.addAll(pq);
        return result;
    }

    private PriorityQueue<Integer> minPq=new PriorityQueue<>(100, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    });

    private PriorityQueue<Integer> maxPq=new PriorityQueue<>(100, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    private int k;

    public void Insert(Integer num) {
        int temp=num;
        if((k&1)!=0){
            if(maxPq.size()>0 && num<maxPq.peek()){
                temp=maxPq.poll();
                maxPq.offer(num);
            }
            minPq.offer(temp);
        }else{
            if(minPq.size()>0 && num>minPq.peek()){
                temp=minPq.poll();
                minPq.offer(num);
            }
            maxPq.offer(temp);
        }
        k++;
    }

    public Double GetMedian() {
        int minPqSize=minPq.size(),maxPqSize=maxPq.size();
        int sum=minPqSize+maxPqSize;
        if((sum&1)!=0){
            if(minPqSize>maxPqSize)
                return (double)minPq.peek();
            else
                return (double)maxPq.peek();
        }else{
            double d=minPq.peek()+maxPq.peek();
            return d/2;
        }
    }

    public int FindGreatestSumOfSubArray(int[] array) {
        int curSum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++){
            if(curSum<=0)
                curSum=array[i];
            else
                curSum+=array[i];
            if(curSum>maxSum)
                maxSum=curSum;
        }
        return maxSum;
    }

    public int NumberOf1Between1AndN_Solution(int n)
    {
        String str=String.valueOf(n);
        return countNumberOf1Between1AndN(str);
    }

    private int countNumberOf1Between1AndN(String str)
    {
        if(str==null || str.length()==0)
            return 0;
        int len=str.length();
        int first;
        if(len==1) {
            first=str.charAt(0)-'0';
            if (first == 0)
                return 0;
            if (first > 0)
                return 1;
        }
        first=str.charAt(0)-'0';
        int firstNumber=0;
        if(first>1)
            firstNumber=(int)Math.pow(10,str.length()-1);
        else if(first==1)
            firstNumber=Integer.valueOf(str.substring(1))+1;
        int secondNumber=first*(len-1)*(int)Math.pow(10,str.length()-2);
        int thirdNumber=countNumberOf1Between1AndN(str.substring(1));
        return firstNumber+secondNumber+thirdNumber;
    }

    class Com implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            String str1=""+o1+o2;
            String str2=""+o2+o1;
            return str1.compareTo(str2);
        }
    }

    public String PrintMinNumber(int [] numbers)
    {
        if(numbers==null || numbers.length==0)
            return "";
        Integer[] arr=new Integer[numbers.length];
        for(int i=0;i<numbers.length;i++)
            arr[i]=numbers[i];
        Arrays.sort(arr,new Com());
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    private int minOfThree(int a,int b,int c)
    {
        int min=a<b ? a:b;
        return min<c ? min:c;
    }

    public int GetUglyNumber_Solution(int index) {
        if(index==0)
            return 0;
        int[] array=new int[index];
        array[0]=1;
        int first=0,second=0,third=0;
        for(int i=1;i<index;i++){
            int val=minOfThree(2*array[first],3*array[second],5*array[third]);
            array[i]=val;
            while (2*array[first]<=val)
                first++;
            while (3*array[second]<=val)
                second++;
            while (5*array[third]<=val)
                third++;
        }
        return array[index-1];
    }


    public int translateWays(String str){
        int result[]=new int[str.length()];
        int count;
        for(int i=str.length()-1;i>=0;i--){
            count=0;
            if(i<str.length()-1)
                count=result[i+1];
            else
                count=1;
            if(i<str.length()-1){
                int firstNum=str.charAt(i)-'0';
                int secondNum=str.charAt(i+1)-'0';
                int number=firstNum*10+secondNum;
                if(number>=0 && number<=25){
                    if(i<str.length()-2)
                        count+=result[i+2];
                    else
                        count+=1;
                }
            }
            result[i]=count;
        }
        return result[0];
    }


    private int getMaxValue_solution(int[][] values)
    {
        int row=values.length, col=values[0].length;
        //int maxValue[][]=new int[row][col];
        int maxVal[]=new int[col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int upVal=0,leftVal=0;
                if(i>0)
                    upVal=maxVal[j];
                if(j>0)
                    leftVal=maxVal[j-1];
                maxVal[j]=values[i][j]+Math.max(upVal,leftVal);
            }
        }
        return maxVal[col-1];
    }

    //零钱找零
    public int minCoins(int[] coins,int money)
    {
        int[][] p=new int[coins.length+1][money+1];
        for(int i=0;i<p.length;i++)
            p[i][0]=0;
        for(int i=0;i<p[0].length;i++)
            p[0][i]=Integer.MAX_VALUE;
        for(int i=1;i<=money;i++){
            for(int j=1;j<=coins.length;j++){
                if(i<coins[j-1]) {
                    p[j][i] = p[j-1][i];
                }else{
                    p[j][i]=Math.min(p[j-1][i],p[j][i-coins[j-1]]+1);
                }
            }
        }
        return p[coins.length][money];
    }

    //0-1背包
    public int zero_one_backpack(int[] v, int[] w, int value)
    {
        int n=v.length;
        int p[][]=new int[n+1][value+1];
        for(int i=0;i<n+1;i++)
            p[i][0]=0;
        for(int i=0;i<value+1;i++)
            p[0][i]=0;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<value+1;j++){
                if(w[i-1]>j){
                    p[i][j]=p[i-1][j];
                }else{
                    p[i][j]=Math.max(p[i-1][j],p[i-1][j-w[i-1]]+v[i-1]);
                }
            }
        }
        return p[n][value];
    }

    private int longestSubstringWithDuplication(String str)
    {
        if(str==null)
            return 0;
        Map<Character,Integer> map=new HashMap<>();
        int maxLen=0, curLen=0;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            Integer preIndex=map.get(ch);
            if(preIndex==null || i-preIndex>curLen)
                curLen++;
            else{
                if(curLen>maxLen)
                    maxLen=curLen;
                curLen=i-preIndex;
            }
            map.put(ch,i);
        }
        if(curLen>maxLen)
            maxLen=curLen;
        return maxLen;
    }

    public int FirstNotRepeatingChar(String str) {
        if(str==null || str=="")
            return -1;
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            Integer pos;
            if((pos=map.get(ch))==null){
                map.put(ch,i);
            }else{
                if(pos>=0){
                    map.put(ch,-1);
                }
            }
        }
        Set<Character> keySet=map.keySet();
        int minPos=Integer.MAX_VALUE;
        char result=0;
        for(Character ch : keySet){
            Integer p=map.get(ch);
            if(p!=-1){
                if(p<minPos)
                {
                    minPos=p;
                    result=ch;
                }
            }
        }
        return minPos;
    }

    public int longestSubstringWithoutDuplication(String str)
    {
        Map<Character,Integer> map=new HashMap<>();
        int curLen=0,maxLen=0;
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            Integer pos=null;
            if((pos=map.get(ch))==null || i-pos>curLen)
                curLen++;
            else {
                if(curLen>maxLen)
                    maxLen=curLen;
                curLen=i-pos;
            }
            map.put(ch,i);
        }
        if(curLen>maxLen)
            maxLen=curLen;
        return maxLen;
    }

    public char firstNotRepeatigChar(String str)
    {
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(map.get(ch)==1)
                return ch;
        }
        return '\0';
    }

    /*private Map<Character,Integer> map=new HashMap<>();

    private int count;
    //Insert one char from stringstream
    public void insert(char ch)
    {
        Integer val;
        if((val=map.get(ch))==null)
            map.put(ch,count);
        else if(val>=0)
            map.put(ch,-2);
        count++;
    }
    //return the first appearence once char in current stringstream
    public char firstAppearingOnce()
    {
        int max=Integer.MAX_VALUE;
        char result='#';
        for(Map.Entry<Character,Integer> entry : map.entrySet())
        {
            if(entry.getValue()>=0){
                int val=entry.getValue();
                if(val<max){
                    max=val;
                    result=entry.getKey();
                }
            }
        }
        return result;
    }
*/
    private static final int COUNT=1000000007;
    public int inversePairs(int[] array)
    {
        if(array==null || array.length==0)
            return 0;
        int[] copy=new int[array.length];
        return inversePair(array,copy,0,array.length-1);
    }

    private int inversePair(int[] data,int[] copy,int left,int right)
    {
        if(left>=right)
            return 0;
        int mid=(right+left)>>1;
        int leftCount=inversePair(data,copy,left,mid)%COUNT;
        int rightCount=inversePair(data,copy,mid+1,right)%COUNT;
        int count=inverseCount(data,copy,left,mid,right)%COUNT;
        return (leftCount+rightCount+count)%COUNT;
    }

    private int inverseCount(int[] data,int[] copy,int left,int mid,int right)
    {
        int i=mid,j=right,k=right;
        int c=0;
        while (i>=left && j>=mid+1)
        {
            if(data[i]>data[j]) {
                c+=j-mid;
                copy[k--]=data[i--];
                if(c>COUNT)
                    c%=COUNT;
            }else{
                copy[k--]=data[j--];
            }
        }
        while (i>=left)
            copy[k--]=data[i--];
        while (j>=mid+1)
            copy[k--]=data[j--];
        for(int n=left;n<=right;n++)
            data[n]=copy[n];
        return c;
    }

    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null || pHead2==null)
            return null;
        ListNode p1=pHead1,p2=pHead2;
        int len1=getListLength(pHead1);
        int len2=getListLength(pHead2);
        int len= len1>len2 ? len1-len2 : len2-len1;
        if(len1>len2){
            while (len>0){
                p1=p1.next;
                len--;
            }
        }else{
            while (len>0){
                p2=p2.next;
                len--;
            }
        }
        while (p1!=null && p2!=null)
        {
            if(p1==p2)
                return p1;
            p1=p1.next;
            p2=p2.next;
        }
        return null;
    }

    private int getListLength(ListNode head)
    {
        int len=0;
        while (head!=null){
            head=head.next;
            len++;
        }
        return len;
    }

    public int GetNumberOfK(int [] array , int k) {
        if(array==null || array.length==0)
            return 0;
        int first=getFirstK(array,k);
        int last=getLastK(array,k);
        if(first==-1)
            return 0;
        return last-first+1;
    }

    public int getFirstK(int[] array,int k)
    {
        int left=0, right=array.length-1;
        while (left<=right){
            int mid=(left+right)>>1;
            if(k<array[mid] || mid>0&&k==array[mid]&&array[mid-1]==k)
                right=mid-1;
            else if(k>array[mid])
                left=mid+1;
            else
                return mid;
        }
        return -1;
    }

    public int getLastK(int[] array,int k)
    {
        int left=0, right=array.length-1;
        while (left<=right){
            int mid=(left+right)>>1;
            if(k<array[mid])
                right=mid-1;
            else if(k>array[mid] || mid<array.length-1&&k==array[mid]&&array[mid+1]==k)
                left=mid+1;
            else
                return mid;
        }
        return -1;
    }

    public int getMissingNumber(int[] nums)
    {
        if(nums==null || nums.length==0)
            return -1;
        int len=nums.length;
        int low=0,high=len-1;
        while (low<=high){
            int mid=(low+high)>>1;
            if(nums[mid]==mid)
                low=mid+1;
            else{
                if(mid>0 && nums[mid-1]!=mid-1)
                    high=mid-1;
                else
                    return mid;
            }
        }
        if(low==len)
            return low;
        return -1;
    }

    public int getNumberSameAsIndex(int[] nums)
    {
        if(nums==null || nums.length==0)
            return -1;
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid=(left+right)>>1;
            if(nums[mid]<mid)
                left=mid+1;
            else if(nums[mid]>mid)
                right=mid-1;
            else
                return mid;
        }
        return -1;
    }

    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot==null)
            return null;
        List<TreeNode> list=new LinkedList<>();
        TreeNode p=pRoot,r;
        while (p!=null || list.size()>0){
            while (p!=null){
                TreeNode node=new TreeNode(p.val);
                node.left=p.left;
                node.right=p.right;
                list.add(node);
                p=p.left;
            }
            r=list.remove(list.size()-1);
            if(--k==0)
                return r;
            p=r.right;
        }
        return null;
    }

    public int TreeDepth(TreeNode root) {
        if(root==null)
            return 0;
        return heightTree(root);
    }

    private int heightTree(TreeNode root)
    {
        if(root==null)
            return 0;
        return 1+Math.max(heightTree(root.left),heightTree(root.right));
    }

    class Depth{
        int d;
        Depth(int d){
            this.d=d;
        }
    }

    public boolean IsBalanced_Solution(TreeNode root)
    {
        if(root==null)
            return true;
        return isBalanced_solution(root,new Depth(0));
    }

    private boolean isBalanced_solution(TreeNode root,Depth depth)
    {
        if(root==null){
            depth.d=0;
            return true;
        }

        Depth leftDepth=new Depth(0), rightDepth=new Depth(0);
        if(isBalanced_solution(root.left,leftDepth)&&isBalanced_solution(root.right,rightDepth))
        {
            int diff=leftDepth.d-rightDepth.d;
            if(diff>=-1 && diff<=1){
                depth.d=1+Math.max(leftDepth.d, rightDepth.d);
                return true;
            }
        }
        return false;
    }

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null || array.length==0 || array.length<2)
            return;
        int num=0;
        for(int i=0;i<array.length;i++){
            num^=array[i];
        }
        int k=getOneBitPos(num);
        int n1=0,n2=0;
        for(int i=0;i<array.length;i++)
            if(bitPos(array[i],k))
                n1^=array[i];
            else
                n2^=array[i];
        num1[0]=n1;
        num2[0]=n2;
    }

    private boolean bitPos(int num,int k)
    {
        return ((num>>k)&1)==1;
    }
    private int getOneBitPos(int num)
    {
        int c=0;
        while ((num&1)==0 && c<=31){
            num>>=1;
            c++;
        }
        return c;
    }

    public int findNumberAppearingOnce(int[] numbers)
    {
        if(numbers==null || numbers.length==0)
            return -1;
        int record[]=new int[32];
        for(int i=0;i<numbers.length;i++){
            int flag=1;
            for(int j=31;j>=0;j--){
                int bit=numbers[i]&flag;
                if(bit!=0)
                    record[j]+=1;
                flag<<=1;
            }
        }
        int result=0;
        for(int i=0;i<=31;i++)
        {
            result<<=1;
            result+=record[i]%3;
        }
        return result;
    }

    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list=new ArrayList<>();
        if(array==null || array.length==0 || array.length<2)
            return list;
        int start=0, end=array.length-1;
        while (start<end){
            if(array[start]+array[end]<sum)
                start++;
            else if(array[start]+array[end]>sum)
                end--;
            else {
                list.add(array[start]);
                list.add(array[end]);
                break;
            }
        }
        return list;
    }


    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        int small=1,big=2;
        int curSum=small+big;
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        ArrayList<Integer> temp=new ArrayList<>();
        temp.add(small);
        temp.add(big);
        while (small<(sum+1)/2){
            if(curSum<sum){
                big++;
                curSum+=big;
                temp.add(big);
            }else if(curSum>=sum){
                if(curSum==sum)
                    list.add(new ArrayList<>(temp));
                curSum-=temp.remove(0);
                small++;
            }
        }
        return list;
    }

    public String LeftRotateString(String str,int n) {
        char[] arr=str.toCharArray();
        reverse(arr,0,n-1);
        reverse(arr,n,arr.length-1);
        reverse(arr,0,arr.length-1);
        return new String(arr);
    }

    private void reverse(char[] array,int left,int right)
    {
        while (left<right)
        {
            char temp=array[left];
            array[left]=array[right];
            array[right]=temp;
            left++;
            right--;
        }
    }

    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result=new ArrayList<>();
        if(num==null || num.length==0 || num.length<size || size==0)
            return result;
        Deque<Integer> deque=new LinkedList<>();
        for(int i=0;i<size;i++){
            while (!deque.isEmpty() && num[i]>num[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offer(i);
        }

        for(int i=size;i<num.length;i++){
            result.add(num[deque.peek()]);
            while (!deque.isEmpty() && num[i]>num[deque.peekLast()]){
                deque.pollLast();
            }
            if(!deque.isEmpty() && deque.peek()+size<=i){
                deque.poll();
            }
            deque.offer(i);
        }
        result.add(num[deque.peek()]);
        return result;
    }

    public boolean isContinuous(int [] numbers) {
        if(numbers==null || numbers.length==0)
            return false;
        Arrays.sort(numbers);
        int zeroNumber=0;
        for(int i=0;i<numbers.length;i++)
            if(numbers[i]==0)
                zeroNumber++;
        int start=zeroNumber,end=start+1;
        int count=0;
        while (end<numbers.length){
            int diff=numbers[end]-numbers[start];
            if(diff==0)
                return false;
            if(diff!=1){
                count+=diff-1;
            }
            start=end;
            end++;
        }
        return count>zeroNumber ? false : true;
    }

    private static final int MAX_VALUE=6;

    public float[] PrintProbability(int number)
    {
        int[][] numbers=new int[2][MAX_VALUE*number+1];
        int flag=0;
        for(int i=1;i<=MAX_VALUE;i++){
            numbers[flag][i]=1;
        }
        for(int k=2;k<=number;k++){
            for(int i=0;i<k;i++)
                numbers[1-flag][i]=0;
            for(int i=k;i<=k*MAX_VALUE;i++){
                numbers[1-flag][i]=0;
                for(int j=1;j<=i&&j<=MAX_VALUE;j++){
                    numbers[1-flag][i]+=numbers[flag][i-j];
                }
            }
            flag=1-flag;
        }
        float[] result=new float[number*MAX_VALUE+1];
        double total=Math.pow(MAX_VALUE,number);
        for(int i=1;i<=number*MAX_VALUE;i++)
        {
            result[i]=(float)(numbers[flag][i]/total);
        }
        return result;
    }

    public int lastRemaining(int n, int m)
    {
        if(n<1 || m<1)
            return -1;
        int last=0;
        for(int i=2;i<=n;i++)
            last=(last+m)%i;
        return last;
    }

    public int Add(int num1,int num2) {
        if(num1==0)
            return num2;
        if(num2==0)
            return num1;
        do{
            int sum=num1^num2;
            int val=(num1&num2)<<1;
            num1=sum;
            num2=val;
        }while (num2!=0);
        return num1;
    }

    public static void main(String[] args)
    {
        System.out.println(new Main().lastRemaining(3,1));
    }
    private static int strToIntDate(String s)
    {
        String[] date=s.split("/");
        int d=Integer.valueOf(date[2])*365+Integer.valueOf(date[1])+Integer.valueOf(date[0])*30;
        return d;
    }
    private static int strToIntTime(String s)
    {
        String[] time=s.split(":");
        int t=Integer.valueOf(time[2])+Integer.valueOf(time[1])*60+Integer.valueOf(time[0])*3600;
        return t;
    }
}

