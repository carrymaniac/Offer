package nowcode.tree;

import common.TreeNode;

/**
 * 找到二叉树中的最大的二叉搜索树
 *
 * 涉及到树形DP
 *
 * 树形DP第一步：以某个节点X为头节点的子树中，分析答案有哪些可能性，并且是以左右子树以及X整棵树来考虑的
 *  例如此题：
 *  （1）X的最大搜索子树就是x的左子树的最大搜索子树，也就是说答案可能来自左子树
 *  （2）
 *  （3）X左子树上的最大搜索二叉子树是x左子树的全体，X右子树的最大搜索二叉树是X右子树的全体，且X的值大于左子树
 *  的最大值，小于右子树的最小值。那么X为头节点的子树，最大的搜索二叉树就是以X为头节点的全体
 *
 *  树形DP第二步：罗列需要的信息：
 *      第1、2种可能性需要：左右子树的最大搜素二叉树的头部以及其大小
 */
public class getMAXBST {
    public TreeNode getMAXBST(TreeNode node){
        return process(node).maxBSTHead;
    }
    public ReturnType process(TreeNode X){
        //base case:如果子树为空
        if(X==null){
            return new ReturnType(null, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        //获得两边的信息
        ReturnType lData = process(X.left);
        ReturnType rData = process(X.right);
        //信息整合
        int min = Math.min(X.val, Math.min(lData.min, rData.min));
        int max = Math.max(X.val, Math.min(lData.max, rData.max));

        //第1 2 种情况
        int maxBSTSize = Math.max(lData.maxBSTSize,rData.maxBSTSize);
        TreeNode maxBSTHead = lData.maxBSTSize>rData.maxBSTSize?lData.maxBSTHead:rData.maxBSTHead;

        //判断第三种可能性
        if (lData.maxBSTHead == X.left && rData.maxBSTHead == X.right
                && X.val > lData.max && X.val < rData.min
        ) {
            maxBSTSize = rData.maxBSTSize + lData.maxBSTSize;
            maxBSTHead = X;
        }
        return new ReturnType(maxBSTHead, maxBSTSize, min, max);
    }

}

class ReturnType{
    //最大搜索二叉树的头
    public TreeNode maxBSTHead;
    //最大搜索二叉树的大小
    public int maxBSTSize;
    //最小值和最大值
    public int min;
    public int max;

    public ReturnType(TreeNode maxBSTHead, int maxBSTSize, int min, int max) {
        this.maxBSTHead = maxBSTHead;
        this.maxBSTSize = maxBSTSize;
        this.min = min;
        this.max = max;
    }
}