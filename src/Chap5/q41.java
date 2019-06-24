package Chap5;

import java.util.PriorityQueue;

/**
 * @Author Ha
 * @DATE 2019/6/24 19:30
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 **/
public class q41 {
    //大顶堆,用于存放左半边数据
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1,o2)->(o2-o1));
    //小顶堆
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    //当前已经读入的数据量
    public Integer N;
    public void Insert(Integer val){
        if(N%2==0){
            /**
             * N为偶数的话要插在右半边小根堆
             * 注意不是直接进入小根堆，而是经大根堆筛选后取大根堆中最大元素进入小根堆）
             */
            left.add(val);
            right.add(left.poll());
        }else {
            /**
             * 注意不是直接进入大根堆，而是经小根堆筛选后取小根堆中最大元素进入大根堆
             */
            right.add(val);
            left.add(right.poll());
        }
        N++;
    }
    public Double GetMedian() {
        if (N % 2 == 0)
            return (left.peek() + right.peek()) / 2.0;
        else
            return (double) right.peek();
    }

}
