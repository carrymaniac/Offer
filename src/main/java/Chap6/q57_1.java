package Chap6;

import java.util.ArrayList;
import java.util.Arrays;


//求和为S的两个叔
public class q57_1 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        if(array==null||array.length==0){
            return null;
        }
        int i = 0;
        int j = array.length-1;

        while(i<j){
            if(array[i]+array[j]<sum){
                i++;
            }else if(array[i]+array[j]>sum){
                j--;
            }else {
                return new ArrayList<>(Arrays.asList(array[i],array[j]));
            }
        }
        return null;
    }
}
