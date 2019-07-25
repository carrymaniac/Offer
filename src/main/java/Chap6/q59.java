package Chap6;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 滑动窗口的最大值
 *
 * 借助一个大顶堆(优先队列)来实现
 */
public class q59 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        //鲁棒
        if(num==null||num.length==0){
            return null;
        }
        //大顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>((i1,i2)->i2-i1);
        //构建一个数组
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0;i<size;i++){
            heap.add(num[i]);
        }
        arrayList.add(heap.peek());
        for(int i = 0,j=i+size;j<num.length;i++){
            heap.remove();
            heap.add(num[j]);
            arrayList.add(heap.peek());
        }
        return arrayList;
    }

}
