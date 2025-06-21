package AAAAA;

import java.util.ArrayList;
import java.util.List;

public class target {
    static int target=7;
    static int[] nums={2,3,6,7};
    static List<List<Integer>> result=new ArrayList<>();
    public static void backTrack(int[] nums,int target,List<Integer> path,int start){
        if(target==0){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=start;i<nums.length;i++){
            /**
             * 剪枝
             * 不知道怎么写，就模拟最简单的情况
             * 最顶层两层循环 1 和 2
             * 那么在执行 1 的循环的时候，会执行完毕  下面的 1 2  因为可以重复利用 ，所以无限递归，必须加入剪纸函数，提前结束不可能的递归
             */
            if(target-nums[i]<0){
                continue;
            }
            path.add(nums[i]);
            backTrack(nums,target-nums[i],path,i);
            path.remove(path.size()-1);
        }
    }
    public static void main(String[] args) {
        backTrack(nums,target,new ArrayList<>(),0);
        System.out.println(result);
    }
}
