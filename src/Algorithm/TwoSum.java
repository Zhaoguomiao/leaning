package Algorithm;

import java.util.HashMap;

public class TwoSum {
    public static int[] getTowIndex(int[] nums,int target){
        HashMap<Integer,Integer> map=new HashMap<>();//用于存储数组某一元素的值和下标，初始为空，满足则查不满足则存
        for(int i=0;i<nums.length;i++){
            int distance=target-nums[i];//获取差值，看是否有满足的差值在数组中，一直遍历到数组最后
            if(map.containsKey(distance)) {
                int[] array = {map.get(distance), i};
                return array;
            }else {
                map.put(nums[i],i);//没找到就把这个键值对放入map，供后面的数组值进行匹配。
            }
        }
        int[] arrayNull={0,0};
        return arrayNull;
    }
    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};//存入（2，0），第二次匹配
        int target1 = 9;
        int[] result1 = getTowIndex(nums1, target1);
        System.out.println("结果: [" + result1[0] + ", " + result1[1] + "]"); // 输出: [0, 1]

        int[] nums2 = {3, 2, 4};//第三次匹配存入（3，0）（2，1）
        int target2 = 6;
        int[] result2 = getTowIndex(nums2, target2);
        System.out.println("结果: [" + result2[0] + ", " + result2[1] + "]"); // 输出: [1, 2]

        int[] nums3 = {3, 3};//第二次匹配成功
        int target3 = 6;
        int[] result3 = getTowIndex(nums3, target3);
        System.out.println("结果: [" + result3[0] + ", " + result3[1] + "]");
    }
}
