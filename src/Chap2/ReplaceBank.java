package Chap2;

/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceBank {
    /**
     * 调用StringBuffer中方法的解法
     * @param str
     * @return
     */
    public String replace(StringBuffer str) {
        if (str.length() == 0) {
            return null;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                str.replace(i, i + 1, "%20");
            }
        }
        return str.toString();
    }

    /**
     * 原理解法
     * @param stringBuffer
     * @return
     */
    public String replaceSpace(StringBuffer stringBuffer){
        if(stringBuffer == null){
            return null;
        }
        int sapceNum = 0 ;//用于统计空格数量
        for(int i = 0 ;i<stringBuffer.length();i++){
            if (stringBuffer.charAt(i) == ' ') {
                sapceNum++;
            }
        }
        //原字符串的末尾指针
        int oldP = stringBuffer.length()-1;
        stringBuffer.setLength(stringBuffer.length()+sapceNum*2);
        int newP = stringBuffer.length()-1;
        while(oldP>=0&&newP>oldP){
            if(stringBuffer.charAt(oldP)==' '){
                stringBuffer.setCharAt(newP--,'0');
                stringBuffer.setCharAt(newP--,'2');
                stringBuffer.setCharAt(newP--,'%');
            }else {
                stringBuffer.setCharAt(newP--,stringBuffer.charAt(oldP));
            }
            oldP--;
        }
        return stringBuffer.toString();
    }

}
