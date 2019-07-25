package Chap4;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Ha
 * @DATE 2019/6/15 16:04
 **/
//从上往下打印出二叉树的每个节点，同层节点从左至右打印。
    //用一个队列来承接遍历的节点,当队列不为空时,取出队列的节点,将其输出到数组中,并将其左右节点放回队列中
public class q32_1 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            //循环树的一层
            int cnt = queue.size();
            while (cnt-->0){
                TreeNode treeNode = queue.poll();
                ret.add(treeNode.val);
                queue.add(treeNode.left);
                queue.add(treeNode.right);
            }
        }
        return ret;
    }
}
