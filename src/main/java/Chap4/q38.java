package Chap4;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author Ha
 * @DATE 2019/6/24 15:35
 * 递归,采用大问题分解为小问题的思路
 **/
public class q38 {
    private ArrayList<String> ret = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        if(str.length()==0){
            return ret;
        }
        char[] chars = str.toCharArray();
        //按照字典序
        Arrays.sort(chars);
        backtracking(chars, new boolean[chars.length], new StringBuilder());
        return ret;
    }
    private void backtracking(char[] chars, boolean[] hasUsed, StringBuilder s) {
        if(s.length()==chars.length){
            //已经构建完成
            ret.add(s.toString());
            return;
        }
        for(int i = 0 ;i<chars.length;i++){
            if(hasUsed[i]){
                continue;
            }
            //考虑字母重复的问题
            if(i!=0&&chars[i]==chars[i-1]&&!hasUsed[i-1]){
                continue;
            }
            hasUsed[i]=true;
            s.append(chars[i]);
            backtracking(chars,hasUsed,s);
            s.deleteCharAt(s.length()-1);
            hasUsed[i]=false;
        }
    }
}
