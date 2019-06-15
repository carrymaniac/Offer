package Chap4;

import java.util.Stack;

/**
 * @Author Ha
 * @DATE 2019/6/15 15:32
 **/
//定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的 min 函数。
public class q30 {
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(Integer node){
        dataStack.push(node);
        minStack.push(minStack.isEmpty()?node : Math.min(minStack.peek(),node));
    }

    public void pop(){
        dataStack.pop();
        minStack.pop();
    }
    public int top() {
        return dataStack.peek();
    }
    public Integer min(){
        return minStack.peek();
    }
}
