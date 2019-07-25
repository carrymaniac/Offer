package Chap2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 从尾到头反过来打印出每个结点的值。
 */

public class printListFromTailToHead {
    //使用递归
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        List<Integer> integers = new ArrayList<Integer>();
        if(listNode.next!=null){
            integers.addAll(printListFromTailToHead(listNode.next));
            integers.add(listNode.val);
        }

        return null;
    }

    //使用头插法
    public ArrayList<Integer> printListFromTailToHead_01(ListNode listNode){
        ListNode head = new ListNode(-1);
        while (listNode!=null){
            ListNode memo = listNode.next;
            listNode.next = head.next;
            head.next =listNode;
            listNode = memo;
        }
        ArrayList<Integer> integers = new ArrayList<>();
        head=head.next;
        while (head!=null){
            integers.add(head.val);
            head = head.next;
        }
        return integers;
    }
    public ArrayList<Integer> printListFromTailToHead_02(ListNode listNode){
        ArrayList<Integer> integers = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode!=null){
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()){
            integers.add(stack.pop());
        }
        return integers;
    }

}
 class ListNode {
int val;
ListNode next = null;
     ListNode(int val) {
 this.val = val;
       }
    }