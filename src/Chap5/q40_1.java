package Chap5;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @Author Ha
 * @DATE 2019/6/24 16:13
 * 另一种解法(若不允许在原数组进行修改)
 * 通过使用大顶堆来维护最小K的容器,每次从中取出最大值,并和当前数字进行比较,若当前数字大于最大值,则不可能为最小k值之一
 * 若小于最大值,则将最大值移除,并加入当前数字
 *
 * or
 *
 * 每次都将数字压入大顶堆,若大顶堆的数量大于K,则将堆顶元素去除.
 *
 **/
//难点在于创建大顶堆
public class q40_1 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] nums, int k) {
        if(k<=0||nums.length==0){
            return null;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) ->o2-o1);
        for(int num:nums){
            priorityQueue.add(num);
            if(priorityQueue.size()>k){
                priorityQueue.poll();
            }
        }
        return new ArrayList<>(priorityQueue);
    }
}
