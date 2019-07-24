package nowcode.class8;

/**
 * 汉诺塔问题
 */
public class Code_02_Hanoi {

    /**
     * 代表这是第几阶的问题
     * @param N
     * @param from
     * @param to
     * @param help
     */
    public void function(int N, String from, String to, String help){
        //base case
        if(N==1){
            System.out.println("move"+1+"from"+from+"to"+to);
        }else {
            function(N-1,from,help,to);
            System.out.println("move"+N+"from"+from+"to"+to);
            function(N-1,help,to,from);
        }

    }
}
