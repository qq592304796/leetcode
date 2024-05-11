package org.jiangxinjun.l2312;


//leetcode submit region begin(Prohibit modification and deletion)
class LongestIncreasingSubsequenceSolution {
    public static int longestIncreasingSubsequence(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLength = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
