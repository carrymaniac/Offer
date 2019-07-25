package nowcode.tree;

import common.TreeNode;

/**
 * 判断是否为搜素二叉树的后序遍历
 * <p>
 * 搜索二叉树的后序遍历 可分为：
 * 【左子树部分/右子树部分/根结点】
 * 其中左子树部分小于根节点部分
 * 而右子树部分小于根节点部分
 * (有点像快排中的partition
 * <p>
 * 因此 递归判断：
 * （1）basecase：当为空 return true；
 * (2)
 */
public class isPostArray {


    public boolean process(int[] arr, int start, int end) {

        if (arr == null || arr.length == 0) {
            return true;
        }
        if (start == end) {
            return true;
        }
        int less = -1;
        int more = end;
        for (int i = start; i < end; i++) {
            if (arr[end] > arr[i]) {
                //持续记录下小于根结点的下标
                less = i;
            } else {
                //more只需要定位一次即可
                more = more == end ? i : more;
            }
        }
        //一者没有动过。
        if (less == -1 || more == end) {
            return process(arr, start, end - 1);
        }
        //若less和more并未相临，说明并非搜索二叉树
        if (less != more - 1) {
            return false;
        }

        //检测前后两个子树
        return process(arr, start, less) && process(arr, more, end - 1);
    }
}
