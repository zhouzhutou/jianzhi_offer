/**
 * Created by Administrator on 2017/8/28 0028.
 */
public class FiftyEight {
    public String ReverseSentence(String str) {
        if(str==null || str.length()==0)
            return str;
        char[] arr=str.toCharArray();
        reverse(arr,0,arr.length-1);
        reverseWord(arr);
        return new String(arr);
    }

    private void reverse(char[] str, int begin, int end)
    {
        while (begin<end){
            swap(str,begin++,end--);
        }
    }

    private void reverseWord(char[] str)
    {
        int begin=0,end=0;
        while (begin<str.length){
            if(end==str.length || str[end]==' '){
                reverse(str,begin,end-1);
                begin=end+1;
            }
            end++;
        }
    }

    private void swap(char[] str, int left, int right)
    {
        char temp=str[left];
        str[left]=str[right];
        str[right]=temp;
    }

    public String LeftRotateString(String str,int n) {
        if(str!=null){
            int length=str.length();
            if(length>0 && n>0 && n<length){
                char arr[]=str.toCharArray();
                reverse(arr,0,n-1);
                reverse(arr,n,length-1);
                reverse(arr,0,length-1);
                str=new String(arr);
            }
        }
        return str;
    }

    public static void main(String[] args)
    {
        //System.out.println(new FiftyEight().ReverseSentence("student. a am I"));
        System.out.println(new FiftyEight().LeftRotateString("123456",2));
    }
}
