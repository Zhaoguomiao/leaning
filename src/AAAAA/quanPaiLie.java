package AAAAA;

import java.util.ArrayList;
import java.util.List;

public class quanPaiLie {
    static int[] nums={1,5,4,3,2};
    static void backTrack(int[] nums,List<Integer> path,List<List<Integer>> resultList){
        /**
         * 每次传入进来的 值 先判断是否满足退出条件。如果满足，保存结果，返回结果到上一层backTrack的函数调用处
         */
        if(path.size()==nums.length){
            resultList.add(new ArrayList<>(path));//Java中的所有都是引用，需要使用当前引用新建一个列表来保存当前数据的快照
            return;                 //并不返回值，仅仅代表这一层调用结束
        }
        /**
         * 整个递归也就是最顶层的backTrack执行了一遍这五层循环，然后每一层都继续执行
         */
        for(int i=0;i<nums.length;i++){
            if(path.contains(nums[i])){
                continue;
            }
            path.add(nums[i]);      //将更改后的临时变量传入下一层递归
            backTrack(nums,path,resultList);
            /**
             * 执行下面这条删除语句，有两种可能
             * 满足最下层的return直接执行
             * 当前循环已经结束了（1，2，3，4），自然而然的返回了上层调用，那么返回了上层，本条语句就要马上再执行一次，进入上一层
             * 循环的下一个 i 的选择
             * 本质上高层的递归i变一个数字，低层的i要全部遍历结束
             */
            path.remove(path.size()-1);
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> resultList=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        /**
         * 递归函数 仅仅传入 所求问题的数组，临时结果保存变量，结果变量
         */
        backTrack(nums,path,resultList);
        System.out.println(resultList);
    }
}
