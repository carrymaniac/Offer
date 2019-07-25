package Chap5;

import java.util.Arrays;

/**
 * 输入一个字符串（只包含 a~z 的字符），求其最长不含重复字符的子字符串的长度。
 * 例如对于 arabcacfr，最长不含重复字符的子字符串为 acfr，长度为 4。
 *
 * 动态规划题目
 * 若F(N)的新一个字符在之前没有出现过，则加入，即F(N)=F(N-1)+1
 *
 * 若出现过，则要分情况。
 */
public class q48 {
    public int longestSubStringWithoutDuplication(String str) {
        int curLen = 0 ;
        int maxLen  = 0 ;
        //用于存储该字母在字符串中出现的位置，-1代表没有出现
        int[] preIndexs = new int[26];
        Arrays.fill(preIndexs,-1);
        for(int curI=0;curI<str.length();curI++){
            //  将字符转为数字
            int c = str.charAt(curI) - 'a';
            int preI = preIndexs[c];
            //若该字符未出现过或者是
            if(preI==-1||curI-preI>curLen){
                curLen++;
            }else {
                //存储最长长度
                maxLen = Math.max(maxLen,curLen);
                curLen = curI-preI;
            }
            //更新位置
            preIndexs[c]=curI;
        }
        maxLen=Math.max(maxLen,curLen);
        return maxLen;

    }
}
