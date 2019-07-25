package Chap6;

import common.TreeNode;

//求二叉树的深度
//深度优先遍历
public class q55_1 {
    public int TreeDept(TreeNode treeNode){
        return treeNode==null?0:1+Math.max(TreeDept(treeNode.left),TreeDept(treeNode.right));
    }
}
