package dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class lengthOfLTS {
    /**
     * 定义状态转移方程
     * dp数组 表示以当前元素结尾的最大子序列的长度    以当前元素结尾的最长子序列的长度
     */
    public static int lengthLIS(int[] nums){
        int[] dp=new int[nums.length];

        for(int i=0;i<nums.length;i++){//存储 每一个 元素的 最大子数组的长度 外层循环， 存储结果
            dp[i]=1;
            for(int j=0;j<i;j++){//遍历 当前元素 前面的所有元素；
                if(nums[j]<nums[i]){//确实 比 i 小的话 那么就可以加入
                    dp[i]=Math.max(dp[i],dp[j]+1);//这样可以 把 所有 i前面的 进行比较 的最大值就是 当前的最长序列长度
                }
            }
        }

        int result=0;
        for(int number:dp){
            result=Math.max(result,number);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{7,7,7,7,7,7,7};
        System.out.println(lengthLIS(nums));
    }



}
