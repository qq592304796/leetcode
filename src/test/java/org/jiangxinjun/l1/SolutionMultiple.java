package org.jiangxinjun.l1;//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
//
// 你可以按任意顺序返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
//
//
// 示例 2：
//
//
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
//
//
// 示例 3：
//
//
//输入：nums = [3,3], target = 6
//输出：[0,1]
//
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 10⁴
// -10⁹ <= nums[i] <= 10⁹
// -10⁹ <= target <= 10⁹
// 只会存在一个有效答案
//
//
//
//
// 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？
//
// Related Topics 数组 哈希表
// 👍 18379 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionMultiple {
    public int[] twoSum(int[] nums, int target) {
        // 1.循环的过程中过滤nums<target的值
        // 2.保存每种组合的位置
        List<List<Integer>> combinations = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> newCombinations = new ArrayList<>();
            for (int i1 = 0; i1 < combinations.size(); i1++) {
                // 计算每一种组合，跟当前值相加，与目标值对比
                // 1.如果相等，返回对应数组下标
                // 2.如果大于，跳过当前数组结果集
                // 3.如果小于，把当前值添加到当前的数组结果集
                List<Integer> combination = combinations.get(i1);
                int sum = combination.stream().mapToInt(idx -> nums[idx]).sum();
                sum = sum + nums[i];
                if (sum > target) {
                    continue;
                }
                // 添加新的组合
                ArrayList<Integer> newCombination = new ArrayList<>(combination);
                newCombinations.add(newCombination);
                newCombination.add(i);
                if (sum == target) {
                    return newCombination.stream().mapToInt(Integer::intValue).toArray();
                }
            }
            combinations.addAll(newCombinations);
            // 如果当前的数值满足目标值，直接返回新建的数组
            ArrayList<Integer> newList = new ArrayList<>();
            newList.add(i);
            combinations.add(newList);
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
