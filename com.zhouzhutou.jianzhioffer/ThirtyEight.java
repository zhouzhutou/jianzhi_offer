import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Administrator on 2017/8/13 0013.
 */
public class ThirtyEight {
   /* public ArrayList<String> Permutation(String str) {
        ArrayList<String> result=new ArrayList<>();
        if(str==null || str.length()==0)
            return result;
        StringBuilder sb=new StringBuilder();
        char[] chars=str.toCharArray();
        boolean visited[]=new boolean[str.length()];
        Arrays.sort(chars);
        trace(result,sb,chars,visited);
        return result;
    }

    private void trace(ArrayList<String> result, StringBuilder sb, char[] chars,boolean[] visited)
    {
        if(sb.length()==chars.length){
            result.add(new String(sb));
        }else{
            for(int i=0;i<chars.length;i++){
               if(visited[i] || (i>0 && chars[i]==chars[i-1] && !visited[i-1])) continue;
               visited[i]=true;
               sb.append(chars[i]);
               trace(result,sb,chars,visited);
               sb.deleteCharAt(sb.length()-1);
               visited[i]=false;
            }
        }
    }*/

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result=new ArrayList<>();
        if(str.length()==0 || str==null)
            return result;
        permutation(result,str.toCharArray(),0);
        Collections.sort(result);
        return result;
    }

    private void permutation(ArrayList<String> result, char[] chars,int begin)
    {
        if(begin==chars.length) {
            result.add(String.valueOf(chars));
        }else{
            for(int i=begin;i<chars.length;i++)
            {
                if(i==begin || chars[i]!=chars[begin]) {
                    swap(chars, i, begin);
                    permutation(result, chars, begin + 1);
                    swap(chars, i, begin);
                }
            }
        }
    }

    private void swap(char[] chars, int i, int j)
    {
        char tmp=chars[i];
        chars[i]=chars[j];
        chars[j]=tmp;
    }


    private ArrayList<String> allSubset(String str)
    {
        ArrayList<String>  result=new ArrayList<>();
        if(str==null || str.length()==0)
            return result;
        StringBuilder sb=new StringBuilder();
        allSubsetTrace(result,str,sb,0);
        return result;
    }

    private void allSubsetTrace(ArrayList<String> result,String str, StringBuilder sb,int begin)
    {
        result.add(sb.toString());
        for(int i=begin;i<str.length();i++){
            sb.append(str.charAt(i));
            allSubsetTrace(result,str,sb,i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args)
    {
        //ArrayList<String> result=new ThirtyEight().Permutation("119");
        ArrayList<String> result=new ThirtyEight().allSubset("abc");
        System.out.println(result);
    }
}
