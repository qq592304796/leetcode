package org.jiangxinjun.l2789;//给你一个下标从 0 开始、由正整数组成的数组 nums 。
//
// 你可以在数组上执行下述操作 任意 次：
//
//
// 选中一个同时满足 0 <= i < nums.length - 1 和 nums[i] <= nums[i + 1] 的整数 i 。将元素 nums[i
//+ 1] 替换为 nums[i] + nums[i + 1] ，并从数组中删除元素 nums[i] 。
//
//
// 返回你可以从最终数组中获得的 最大 元素的值。
//
//
//
// 示例 1：
//
// 输入：nums = [2,3,7,9,3]
//输出：21
//解释：我们可以在数组上执行下述操作：
//- 选中 i = 0 ，得到数组 nums = [5,7,9,3] 。
//- 选中 i = 1 ，得到数组 nums = [5,16,3] 。
//- 选中 i = 0 ，得到数组 nums = [21,3] 。
//最终数组中的最大元素是 21 。可以证明我们无法获得更大的元素。
//
//
// 示例 2：
//
// 输入：nums = [5,3,3]
//输出：11
//解释：我们可以在数组上执行下述操作：
//- 选中 i = 1 ，得到数组 nums = [5,6] 。
//- 选中 i = 0 ，得到数组 nums = [11] 。
//最终数组中只有一个元素，即 11 。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// 1 <= nums[i] <= 10⁶
//
//
// Related Topics 贪心 数组
// 👍 44 👎 0


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public long maxArrayValue(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        List<Long> numsList = Arrays.stream(nums).asLongStream().boxed().collect(Collectors.toList());
        // 每次循环开始时，打印数组
//        System.out.println(numsList);
        // 如果数组中没有符合条件的数据时，直接返回
        boolean isRtn = true;
        // 循环的时候从末位开始遍历，保证合并的数值是最大的
        for (int i = numsList.size() - 1; i >= 0; i--) {
            // 每次循环开始时，打印数组
            //System.out.println(numsList);
            if (numsList.get(i - 1) <= numsList.get(i)) {
                numsList.set(i, numsList.get(i - 1) + numsList.get(i));
                numsList.remove(i - 1);
                i = numsList.size();
                isRtn = false;
            }
            // 每次循环结束时，打印数组
//            System.out.println(numsList);
            // 如果循环到最后一个位置，判断
            if (i <= 1) {
                if (isRtn || numsList.size() == 1) {
                    // idx为0的就是最大的数
                    return numsList.get(0);
                }
                i = numsList.size();
                isRtn = true;
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
