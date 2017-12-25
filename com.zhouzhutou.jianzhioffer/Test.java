

import java.util.*;
import java.util.function.Function;

/**
 * Created by Administrator on 2017/8/10 0010.
 */
interface CalculateInterface{
    default int mul(int a, int b){
        return a+b;
    }
}
class Calculate implements CalculateInterface{

}
public class Test {
    public static void main(String[] args)
    {
        /*Calculate calculate=new Calculate();
        int r=calculate.mul(3,5);
        System.out.print(r);*/
        /*Function<String,Integer> toInteger=Integer::valueOf;
        Function<String,String> backToString=toInteger.andThen(String::valueOf);
        System.out.print(backToString.apply("123"));
        String aa="123";
        aa=aa.toUpperCase();*/
        List<Integer> list=new ArrayList<>();
        Random rand=new Random(37);
        for(int i=0;i<20;i++)
            list.add(rand.nextInt(100));
        System.out.println(list);
        list.stream().filter((val)-> val>10).map(val->val+100).sorted((v1, v2)-> v2.compareTo(v1)).reduce((v1, v2)->v1+v2)
                .ifPresent(System.out::println);
        Map<Integer,String> map=new HashMap<>();
        for(int i=0;i<10;i++)
            map.putIfAbsent(i,"val"+i);
        map.computeIfAbsent(3,key->key+"zz");
        System.out.println(map.get(3));
        map.merge(3,"new",String::concat);
        System.out.println(map.get(3));
    }
}
