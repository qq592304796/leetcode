package org.jiangxinjun.l2312;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution2 solution = new Solution2();
        long sellingWood = solution.sellingWood(3, 5, new int[][]{new int[]{1, 4, 2}, new int[]{2, 2, 7}, new int[]{2
                , 1, 3}});
        Assert.assertEquals(19L, sellingWood);
        long sellingWood2 = solution.sellingWood(4, 6, new int[][]{new int[]{3, 2, 10}, new int[]{1, 4, 2},
                new int[]{4, 1, 3}});
        Assert.assertEquals(32L, sellingWood2);
    }

    @Test
    public void test3() {
        // 自动取整
        Assert.assertEquals(3, 10 / 3);
        Assert.assertEquals(1, 3 / 2);
    }
}


//leetcode submit region end(Prohibit modification and deletion)
