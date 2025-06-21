package Algorithm;

public class MaximumSubarray {
    public static int maxSubArray(int[] nums){

        if(nums==null||nums.length==0){
            return -1;
        } else {
            int recentSum=nums[0];
            int maxSum=nums[0];
            for(int i=1;i<nums.length;i++){
                recentSum=Math.max(nums[i],recentSum+nums[i]);
                maxSum=Math.max(recentSum,maxSum);
            }
            return maxSum;
        }

    }
    public static void main(String[] args) {
        int[] nums1= {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.printf("nums1数组最大子段和为："+maxSubArray(nums1));
    }
}
