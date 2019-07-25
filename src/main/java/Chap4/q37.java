package Chap4;

import common.TreeNode;

/**
 * @Author Ha
 * @DATE 2019/6/21 17:11
 **/
public class q37 {
    private String deserializeStr;

    //序列化
    public String Serialize(TreeNode node){
        if(node == null){
            return "#";
        }
        return node.val+" "+Serialize(node.left)+" "+Serialize(node.right);
    }

    //反序列化
    public TreeNode DeSerialize(String str){
        deserializeStr = str ;
        return DeSerialize();
    }

    private TreeNode DeSerialize(){
        if(deserializeStr.length() == 0 ){
            return null;
        }
        int index = deserializeStr.indexOf(" ");
        String node = index == -1 ?deserializeStr:deserializeStr.substring(0,index);
        deserializeStr = index == -1?"":deserializeStr.substring(index+1);
        if(node.equals("#")){
            return null;
        }
        int val = Integer.valueOf(node);
        TreeNode t = new TreeNode(val);
        t.left = DeSerialize();
        t.right = DeSerialize();
        return t;
    }
}
