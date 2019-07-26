package nowcode.tree;

import common.TreeNode;

/**
 * 获取二叉树的最大距离
 * 树型DP：（1）分析情况：
 * 1。最大距离来自左子树的最大距离
 * 2。最大距离来自右子树的最大距离
 * 3。最大距离来自左子树和右子的高度之和加一
 * （2）分析所需条件
 * 子树高度
 * 子树的最大距离
 * （3）BASECASE：最大距离为0 高度为0
 */
public class getMAXDistance {
    class ReturnType {
        public int MAXDistance;
        public int height;

        public ReturnType(int MAXDistance, int height) {
            this.MAXDistance = MAXDistance;
            this.height = height;
        }
    }

    public ReturnType process(TreeNode node) {
        if (node == null) {
            return new ReturnType(0, 0);
        }
        ReturnType leftType = process(node.left);
        ReturnType rightType = process(node.right);
        int height = Math.max(leftType.height, rightType.height) + 1;
        int maxDistance = Math.max(leftType.MAXDistance, rightType.MAXDistance);
        maxDistance = Math.max(maxDistance, leftType.height + 1 + rightType.height);
        return new ReturnType(height,maxDistance);
    }

    public int getMaxDistance(TreeNode node){
        if (node == null) {
            return 0;
        }
        return process(node).MAXDistance;
    }
}
