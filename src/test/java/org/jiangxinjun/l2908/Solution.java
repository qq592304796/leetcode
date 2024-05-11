package org.jiangxinjun.l2908;


import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
@Slf4j
public class Solution {
    public int minimumSum(int[] nums) {
        // 动态规划
        int[] minimumSumAry = new int[nums.length];
        int[] minimumNumAry = new int[nums.length];
        minimumSumAry[0] = nums[0];
        minimumNumAry[0] = 1;
        int minimumSum = -1;
        for (int i = 1; i < nums.length; i++) {
            for (int i1 = 0; i1 < i; i1++) {
                if (nums[i] > nums[i1]) {
                    if (minimumSumAry[i] == 0) {
                        minimumSumAry[i] = minimumSumAry[i1] + nums[i];
                        minimumNumAry[i] = minimumNumAry[i1]++;
                        continue;
                    }
                    minimumSumAry[i] = Math.min(minimumSumAry[i1] + nums[i], minimumSumAry[i]);
                }
            }
        }
        return minimumSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
