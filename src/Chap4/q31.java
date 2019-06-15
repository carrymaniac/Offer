package Chap4;


/**
 * @Author Ha
 * @DATE 2019/6/15 15:37
 **/
//输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
public class q31 {

    public boolean IsPopOrder(int[] pushSequence, int[] popSequence) {
        int n = popSequence.length;
        Stack<Integer> dataStack = new Stack<>();
        for(int pushIndex = 0,popIndex = 0;pushIndex<n;pushIndex++){
            dataStack.push(pushSequence[pushIndex]);
            if(dataStack.peek()==popSequence[popIndex]){
                dataStack.pop();
                popIndex++;
            }
        }
        return dataStack.isEmpty();
    }
}
