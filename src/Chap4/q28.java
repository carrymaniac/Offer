package Chap4;

import common.TreeNode;

/**
 * @Author Ha
 * @DATE 2019/6/15 15:16
 **/
public class q28 {

    boolean isSymmetrical(TreeNode rootNode){
        if(rootNode==null){
            return true;
        }
        return isSymmetrical(rootNode.left,rootNode.right);
    }
    boolean isSymmetrical(TreeNode t1,TreeNode t2){
        if(t1 == null && t2 == null){
            return true;
        }
        if(t1 == null || t2 == null){
            return false;
        }
        if(t1.val != t2.val){
            return false;
        }
        return isSymmetrical(t1.left,t2.right)&&isSymmetrical(t1.right,t2.left);
    }
}
