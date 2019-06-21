package common;

import lombok.Data;

/**
 * @Author Ha
 * @DATE 2019/6/21 16:38
 **/
@Data
public class RandomListNode {
    public int label;
    public RandomListNode next = null;
    public RandomListNode random = null ;

    public RandomListNode(int label) {
        this.label = label;
    }
}
