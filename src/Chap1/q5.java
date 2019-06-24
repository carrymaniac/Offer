package Chap1;

/**
 * @Author Ha
 * @DATE 2019/6/22 11:03
 **/
public class q5 {
    public String replaceSpace(StringBuffer stringBuffer){
        int P1 = stringBuffer.length() - 1;
        for(int i = 0 ;i<=P1;i++){
            if(stringBuffer.charAt(i) == ' '){
                stringBuffer.append("   ");
            }
        }
        int P2 = stringBuffer.length() - 1;
        while (P1>=0 && P2>P1){
            char c = stringBuffer.charAt(P1--);
            if(c==' '){
                stringBuffer.setCharAt(P2--,'0');
                stringBuffer.setCharAt(P2--,'2');
                stringBuffer.setCharAt(P2--,'%');
            }else {
                stringBuffer.setCharAt(P2--,c);
            }
        }
        return stringBuffer.toString();
    }
}
