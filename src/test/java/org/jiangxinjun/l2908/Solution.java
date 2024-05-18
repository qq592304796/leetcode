package org.jiangxinjun.l2908;
//给你一个下标从 0 开始的整数数组 nums 。
//
// 如果下标三元组 (i, j, k) 满足下述全部条件，则认为它是一个 山形三元组 ：
//
//
// i < j < k
// nums[i] < nums[j] 且 nums[k] < nums[j]
//
//
// 请你找出 nums 中 元素和最小 的山形三元组，并返回其 元素和 。如果不存在满足条件的三元组，返回 -1 。
//
//
//
// 示例 1：
//
//
//输入：nums = [8,6,1,5,3]
//输出：9
//解释：三元组 (2, 3, 4) 是一个元素和等于 9 的山形三元组，因为：
//- 2 < 3 < 4
//- nums[2] < nums[3] 且 nums[4] < nums[3]
//这个三元组的元素和等于 nums[2] + nums[3] + nums[4] = 9 。可以证明不存在元素和小于 9 的山形三元组。
//
//
// 示例 2：
//
//
//输入：nums = [5,4,8,7,10,2]
//输出：13
//解释：三元组 (1, 3, 5) 是一个元素和等于 13 的山形三元组，因为：
//- 1 < 3 < 5
//- nums[1] < nums[3] 且 nums[5] < nums[3]
//这个三元组的元素和等于 nums[1] + nums[3] + nums[5] = 13 。可以证明不存在元素和小于 13 的山形三元组。
//
//
// 示例 3：
//
//
//输入：nums = [6,5,4,3,4,5]
//输出：-1
//解释：可以证明 nums 中不存在山形三元组。
//
//
//
//
// 提示：
//
//
// 3 <= nums.length <= 50
// 1 <= nums[i] <= 50
//
//
// Related Topics 数组
// 👍 24 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumSum(int[] nums) {
        // 按照逆序获取最小的
        int[] reverseOrderMinNums = new int[nums.length-1];
        reverseOrderMinNums[nums.length - 2] = nums[nums.length - 1];
        for (int i = nums.length - 2; i > 0; i--) {
            reverseOrderMinNums[i-1] = Math.min(reverseOrderMinNums[i],nums[i] );
        }
        int minimumSum = - 1;
        int positiveSequenceMinimumNumber = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (positiveSequenceMinimumNumber < nums[i] && reverseOrderMinNums[i-1] < nums[i]) {
                minimumSum = minimumSum == -1
                        ? (positiveSequenceMinimumNumber + nums[i] + reverseOrderMinNums[i-1])
                        : Math.min(minimumSum, (positiveSequenceMinimumNumber + nums[i] + reverseOrderMinNums[i-1]));
            }
            positiveSequenceMinimumNumber = Math.min(positiveSequenceMinimumNumber, nums[i]);
        }
        return minimumSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

