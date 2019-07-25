package Chap5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组 {3，32，321}，则打印出这三个数字能排成的最小数字为 321323。
 * <p>
 * <p>
 * 贪心算法：
 */
public class q45 {

    public static class comparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            String str1 = o1 + "" + o2;
            String str2 = o2 + "" + o1;
            if (Integer.getInteger(str1) < Integer.getInteger(str2)) {
                return -1;
            } else if (Integer.getInteger(str1) > Integer.getInteger(str2)) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    class ddd implements Comparator<int[]>{

        @Override
        public int compare(int[] o1, int[] o2) {
            return 0;
        }
    }
    // HIX
    public String PrintMinNumber(int[] numbers) {
        if(numbers==null||numbers.length==0){
            return "";
        }
        if(numbers.length==1){
            return numbers[0]+"";
        }
        Integer[] integers = new Integer[numbers.length];
        for(int i = 0 ;i< numbers.length;i++){
            integers[i]=numbers[i];
        }
        Arrays.sort(integers,new comparator());
        System.out.println(integers);
        StringBuilder stringBuilder = new StringBuilder();
        for(Integer i: integers){
            stringBuilder.append(i);
        }
        return stringBuilder.toString();
    }
    //直接用String的compareTo方法就行
    public String process(int[] numbers){
        if(numbers==null||numbers.length==0){
            return "";
        }
        if(numbers.length==1){
            return numbers[0]+"";
        }
        String[] strs = new String[numbers.length];
        for(int i = 0 ; i<numbers.length;i++){
            strs[i]= String.valueOf(numbers[i]);
        }
        Arrays.sort(strs,(str1,str2)-> (str1+str2).compareTo((str2+str1)));
        String str = "";
        for(String string:strs){
            str+=string;
        }
        return str;
    }
}
