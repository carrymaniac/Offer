package Chap4;

import common.TreeNode;

import java.util.ArrayList;

/**
 * @Author Ha
 * @DATE 2019/6/15 16:22
 **/
//二叉树中和为某一值的路径
public class q34 {
    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
    private ArrayList backtracking(TreeNode treeNode,int target){
        backtracking(treeNode,target,new ArrayList<>());
        return ret;
    }

    private void backtracking(TreeNode treeNode,int target, ArrayList<Integer> path){
        //鲁棒性判断,若为空说明已经到了末尾or本身数据有问题
        if(treeNode == null){
            return;
        }
        //先将节点加入到路径中
        path.add(treeNode.val);
        //将target减去节点的值
        target=-treeNode.val;
        if(target==0&&treeNode.left==null&&treeNode.right==null){
            //完成一条路径,将路径加入到ret中
            ret.add(new ArrayList<>(path));
        }else {
            //继续走下面的路
            backtracking(treeNode.left,target,path);
            //继续走
            backtracking(treeNode.right,target,path);
        }
        //在返回到父节点之前,将自身从路径中删除;因为path是全局公用的
        path.remove(path.size()-1);
        //路径可以使用栈来代替存储,因为都是压栈和出栈的过程.只不过这里使用数组来模拟.
    }
}
