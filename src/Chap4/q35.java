package Chap4;

import common.RandomListNode;

/**
 * @Author Ha
 * @DATE 2019/6/21 16:37
 **/
public class q35 {
    public RandomListNode clone(RandomListNode pHead){
        //1.copy每个节点
        if(pHead == null){
            return pHead;
        }
        RandomListNode cur = pHead;
        while (cur != null){
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }
        //2.拷贝每个节点的random
        cur = pHead;
        while (cur !=null){
            RandomListNode clone = cur.next;
            if(cur.random !=null) {
                clone.random = cur.random.next;
            }
            cur = clone.next;
        }
        //3.断开连接,将原有的进行恢复
        cur = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (cur.next!=null){
            RandomListNode node = cur.next;
            cur.next = node.next;
            cur = node;
        }
        return pCloneHead;
    }
}
