package nowcode.class7;

import java.util.Arrays;
import java.util.Comparator;

/*
    一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目的宣讲。
    给你每一个项目开始的时间和结束的时间(给你一个数组，里面是一个个具体的项目)
    ，你来安排宣讲的日程，要求会 议室进行 的宣讲的场次最多。返回这个最多的宣讲场次。

    最优解是最早结束的会议最先安排，使用一个比较器，排列所有的会议组合，早结束的放在前
 */
public class Code_06_BestArrange {

    public static class program{
        public int start;
        public int end;

        public program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class programCompar implements Comparator<program>{

        @Override
        public int compare(program o1, program o2) {
            return o1.end-o1.end;
        }
    }

    public static int bestArrange(program[] programs,int start){
        Arrays.sort(programs);
        int result = 0;
        for(int i = 0;i<programs.length;i++){
            if(start<programs[i].start){
                result++;
                start = programs[i].end;
            }
        }
        return result;
    }
}


