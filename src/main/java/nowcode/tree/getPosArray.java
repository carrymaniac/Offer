package nowcode.tree;

import java.util.HashMap;

/**
 * 通过先序和中序数组生成后序数组
 */
public class getPosArray {
    public int[] getPostArray(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        int length = pre.length;
        int[] pos = new int[length];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < length; i++) {
            map.put(in[i], i);
        }
        setPost(pre,0,length-1,in,0,length-1,pos,length-1,map);
        return pos;
    }

    /**
     *  填写数组
     * @param p 前序数组
     * @param pi
     * @param pj
     * @param n 中序数组
     * @param ni
     * @param nj
     * @param s 后序数组
     * @param si
     * @param map 检索map
     * @return
     */
    public int setPost(int[] p, int pi, int pj,
                       int[] n, int ni, int nj,
                       int[] s, int si,
                HashMap<Integer, Integer> map) {
        if (pi > pj) {
            return si;
        }
        //后序遍历数组的末尾为前序的第一位根
        s[si--] = p[pi];
        //根结点在中序遍历中的下标
        int i = map.get(p[pi]);
        int l = nj-i-1;
        si = setPost(p,pj-l,pj,n,i+1,nj,s,si,map);
        return setPost(p,pi+1,pi+i-ni,n,ni,i-1,s,si,map);
    }
}
