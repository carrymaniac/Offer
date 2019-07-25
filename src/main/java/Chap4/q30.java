package Chap4;

import java.util.Stack;

/**
 * @Author Ha
 * @DATE 2019/6/15 15:32
 **/
//定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的 min 函数。
    //定义一个辅助栈,每次插入新元素的时候 判断当前的最小元素,即取辅助栈栈顶元素和新插入的元素进行对比判断.
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
