package Chap4;


import common.TreeNode;

/**
 * @Author Ha
 * @DATE 2019/6/15 15:02
 **/
public class q27 {
    /**
     * 交换节点两边的值
     * @return
     */
    private void swap(TreeNode treeNode){
        TreeNode temp = treeNode.left;
        treeNode.left = treeNode.right;
        treeNode.right = temp;
    }

    public void Mirror(TreeNode root){
        if(root == null){
            return;
        }
        swap(root);
        Mirror(root.left);
        Mirror(root.right);
    }
}
