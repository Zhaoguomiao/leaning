package dp;

public class Main1 {
    /**
     * 最长递增子序列的长度
     */
    static int maxLength(int[] nums){
        /**
         * 定义dp数组
         * 数组的每一个值 代表 以本元素结尾的递增子序列的长度
         */
        int[] dp=new int[nums.length];//使用下标0
        int maxLength=0;
        for(int i=0;i<nums.length;i++){//外层循环 代表 填入dp数组的下标
            dp[i]=1;
            for(int j=0;j<i;j++){//遍历当前元素前面的所有元素，如果小于当前值 则 可为当前值所用
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            maxLength=Math.max(maxLength,dp[i]);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums={1, 2, 3, 4, 5, 6, 7, 18};
        System.out.println(maxLength(nums));
    }
}
