package Chap4;

import common.TreeNode;

/**
 * @Author Ha
 * @DATE 2019/6/21 17:06
 **/
//二叉搜索树转为双向链表
public class q36 {
    //需要有一个节点存储上一个节点以便于连接
    private TreeNode pre = null;
    private TreeNode head = null;

    public TreeNode Convert(TreeNode treeNode){
        inorder(treeNode);
        return head;
    }

    private void inorder(TreeNode treeNode) {
        if(treeNode == null){
            return;
        }
        inorder(treeNode.left);
        treeNode.left = pre;
        if(pre!=null){
            pre.right = treeNode;
        }
        pre = treeNode ;
        if(head == null){
            head = treeNode;
        }
        inorder(treeNode.right);
    }

}
