package nowcode.tree;

import common.TreeNode;

/**
 * 判断一棵树是否为平衡树
 * 树型dp：
 * 第一：分析情况：
 * （1）以X为头节点的树，左子树不平衡，则不是平衡树
 * （2）以X为头节点的树，右子树不平衡，则不是平衡树
 * （3）以X为头节点的树，左右平衡，左子树高度为A，右子树高度为B，|(A-B)|>1,则不是平衡树
 * <p>
 * 第二：分析信息：
 * 需要的信息有：
 * （1）树是否平衡
 * （2）树的高度
 * （3）
 * 第三：设计递归函数：
 * （1） base case：当node为null时，高度为1 是平衡
 * （2）
 */
public class isBalance {
    /**
     * 结果结构
     */
    class ReturnType {
        public boolean isBlanced;
        public int height;

        public ReturnType(boolean isBlanced, int height) {
            this.isBlanced = isBlanced;
            this.height = height;
        }
    }

    public ReturnType process(TreeNode node) {
        if (node == null) {
            return new ReturnType(true, 0);
        }
        ReturnType lData = process(node.left);
        ReturnType rData = process(node.right);
        if (!rData.isBlanced || !lData.isBlanced) {
            return new ReturnType(false, -1);
        }
        if (Math.abs(lData.height-rData.height)<2) {
            int height = Math.max(lData.height, rData.height) + 1;
            return new ReturnType(true, height);
        } else {
            return new ReturnType(false, -1);
        }
    }

    public boolean isBalance(TreeNode head) {
        if (head == null) {
            return true;
        }
        return process(head).isBlanced;
    }

}

