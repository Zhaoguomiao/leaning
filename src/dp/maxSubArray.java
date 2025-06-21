package dp;

import java.util.Arrays;

public class maxSubArray {
    public static int Function(int[] nums){
        /**
         * 连续的子数组  只需要给出最大的和 不需要具体都有谁
         * 考虑 dp数组的定义以及 递推关系
         * 4 5 6
         * 以 第三个元素结尾的子数组的最大和 受到 以第二个元素结尾的最大和 和 本身的影响
         * 定义dp[8] 表示 以第8个元素为结尾的子数组的最大和；
         * dp[9]=dp[8]+A[9];假设本身是正确的
         * 所以 当本身大于等于0的时候 就可以把自己算进去
         */
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            /**
             * 对于当前的这一个 结尾，要么要我，要么不要我，要我比我大 那就行，否则还不如自己
             */
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
        }
        Arrays.sort(dp);
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        int[] nums=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(Function(nums));
    }
}
