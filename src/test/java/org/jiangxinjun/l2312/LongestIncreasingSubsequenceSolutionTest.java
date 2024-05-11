package org.jiangxinjun.l2312;

import org.junit.Assert;
import org.junit.Test;

public class LongestIncreasingSubsequenceSolutionTest {

    @Test
    public void test() {
        LongestIncreasingSubsequenceSolution solution = new LongestIncreasingSubsequenceSolution();
        long sellingWood = solution.longestIncreasingSubsequence(new int[]{3, 4, 2, 8, 10, 5, 1});
        Assert.assertEquals(4, sellingWood);
    }
}


//leetcode submit region end(Prohibit modification and deletion)
