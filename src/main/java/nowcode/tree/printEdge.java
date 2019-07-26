package nowcode.tree;

import common.TreeNode;

/**
 * 打印二叉树的边界节点
 * <p>
 * 分为三步：1。从上往下打印所有左子树的最左节点。
 * 2。打印不是最左最右的叶子节点
 * 3。从下往上打印右子树的最右节点
 */
public class printEdge {
    public void printEdge(TreeNode head) {
        if (head == null) {
            return;
        }
        int height = getHeight(head, 0);
        TreeNode[][] edgeMap = new TreeNode[height][2];
        setEdgeMap(head, 0, edgeMap);
        for (int i = 0; i != edgeMap.length; i++) {
            System.out.println(edgeMap[i][1] + " ");
        }

    }


    public int getHeight(TreeNode h, int l) {
        if (h == null) {
            return 1;
        }
        return Math.max(getHeight(h.left, l + 1), getHeight(h.right, l + 1));
    }

    public void setEdgeMap(TreeNode node, int l, TreeNode[][] edgemap) {
        if (node == null) {
            return;
        }
        edgemap[l][0] = edgemap[l][0] == null ? node : edgemap[l][0];
        edgemap[l][1] = node;
        //将所有的最左节点填充进去
        setEdgeMap(node.left, l + 1, edgemap);
        //将所有的最右节点
        setEdgeMap(node.right, l + 1, edgemap);
    }

    public void printLeafNotInMap(TreeNode head,int l ,TreeNode[][] map){
        if(head==null){
            return;
        }
        if (head.right == null && head.left == null && head != map[l][0] && head != map[l][1]) {
            System.out.println(head+" ");
        }
        printLeafNotInMap(head.left,l+1,map);
        printLeafNotInMap(head.right,l+1,map);
    }
}
