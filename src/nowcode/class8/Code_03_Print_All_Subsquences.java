package nowcode.class8;

/**
 * 打印所有的子串
 * 不断分支的过程。选择or不选择当前的字符
 *
 *
 */
public class Code_03_Print_All_Subsquences {


    public void process(char[] chars,int i,String res){
        if(i==chars.length){
            return;
        }
        process(chars,i+1,res+chars[i]);
        process(chars,i+1,res);


    }
}
