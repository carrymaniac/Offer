package nowcode.tree;

import common.TreeNode;

/**
 * 找到符合二叉搜索树的最大拓扑结构
 */
public class bstTopoSize {
    /**
     * 思路1：如何判断一个以X为头节点的树是二叉搜索树
     * 先考察X的孩子节点，根据孩子节点的值进行对X按照二叉搜索的方式移动，如果能移动到同一个孩子节点，说明
     * 该孩子节点可以加入到拓扑结构中，并继续考察其孩子节点。
     */


    public int bstTopoSize(TreeNode head) {
        if (head == null) {
            return 0;
        }
        int max = maxTop(head, head);
        max = Math.max(max, bstTopoSize(head.left));
        max = Math.max(max, bstTopoSize(head.right));
        return max;

    }

    /**
     * 计算最大的拓扑结构
     *
     * @param h
     * @param n
     * @return
     */
    public int maxTop(TreeNode h, TreeNode n) {
        if (h != null && n != null & isBSTNode(h, n, n.val)) {
            return maxTop(h, n.left) + maxTop(h, n.right) + 1;
        }
        return 0;
    }

    /**
     * 找到子节点
     *
     * @param h     当前遍历到的节点
     * @param n     想要查找的节点(即预计的节点
     * @param value 想要查找的节点的值
     * @return
     */
    public boolean isBSTNode(TreeNode h, TreeNode n, int value) {
        if (h == null) {
            return false;
        }
        if (h == n) {
            return true;
        }
        return isBSTNode(h.val > value ? h.left : h.right, n, value);
    }
}
