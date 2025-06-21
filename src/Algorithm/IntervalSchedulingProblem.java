package Algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class IntervalSchedulingProblem {
    public int eraseOverlapIntervals(int[][] intervals){
        if(intervals==null||intervals.length==0){
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {//传进来的是子数组，默认升序
                return a[1]-b[1];//取每一个子区间的结束时间进行比较，结果为正则放后面，结果为负不用动，放前面
            }
        });
        int count=0;
        int preEnd=Integer.MIN_VALUE;
        for(int[] interval:intervals){
            if(interval[0]>=preEnd){
                count++;
                preEnd=interval[1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] intervals={{1, 2},{1, 3},{2, 4},{3, 5}};
        IntervalSchedulingProblem solution=new IntervalSchedulingProblem();
        int result=solution.eraseOverlapIntervals(intervals);
        System.out.printf("最大不重叠的子区间数为：%d",result);
    }
}
