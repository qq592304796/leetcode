package org.jiangxinjun.l2960;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution solution = new Solution();
        int result = solution.countTestedDevices(new int[]{1,1,2,1,3});
        Assert.assertEquals(3, result);
        int result2 = solution.countTestedDevices(new int[]{0,1,2});
        Assert.assertEquals(2, result2);
    }
}
