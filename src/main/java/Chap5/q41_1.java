package Chap5;

/**
 * @Author Ha
 * @DATE 2019/6/24 19:47
 * 字符流中第一个不重复的字符
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"。
 * 当从该字符流中读出前六个字符“google" 时，第一个只出现一次的字符是 "l"。
 **/

import java.util.LinkedList;
import java.util.Queue;

/**
 * 这种情况,根据其特性可以考虑使用队列(先进先出)来存储之前遍历到的第一个出现的字符。
 */
public class q41_1 {
    private int[] cnts = new int[256];
    private Queue<Character> queue = new LinkedList<>();

    public void Insert(char ch){
        cnts[ch]++;
        queue.add(ch);
        //检测一下当前队列的头部是否是唯一的,如果唯一则不进行操作,如果不唯一则进行出队
        while (!queue.isEmpty() && cnts[queue.peek()]>1){
            queue.poll();
        }
    }

    public char FirstAppearingOnce(){
        return queue.isEmpty() ? '#':queue.peek();
    }

    public static void main(String[] args) {
        q41_1 q41_1 = new q41_1();
        q41_1.Insert('g');
        q41_1.Insert('o');
        q41_1.Insert('o');
        q41_1.Insert('g');
        q41_1.Insert('l');
        q41_1.Insert('e');

    }
}
