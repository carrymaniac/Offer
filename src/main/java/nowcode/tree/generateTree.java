package nowcode.tree;

import common.TreeNode;

/**
 * 通过有序数组生成平衡二叉树
 *
 * 获取中间值作为头节点
 * 然后两边递归铺开
 *
 */
public class generateTree {
    public TreeNode generateTree(int[] arr){
        if (arr == null || arr.length == 0) {
            return null;
        }
        TreeNode process = process(arr, 0, arr.length - 1);
        return process;
    }

    /**
     * 考虑basecase
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public TreeNode process(int[] arr, int start, int end) {
        if(start==end){
            return null;
        }
        // 求中间的值
        int mid = start+(end-start)>>1;
        //生成根节点放进去
        TreeNode head = new TreeNode(arr[mid]);
        //递归两边
        head.left = process(arr,start,mid);
        head.right = process(arr,mid+1,end);
        return head;
    }
}
