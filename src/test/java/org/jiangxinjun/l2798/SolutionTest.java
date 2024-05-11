package org.jiangxinjun.l2798;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution solution = new Solution();
        int result = solution.numberOfEmployeesWhoMetTarget(new int[]{0,1,2,3,4}, 2);
        Assert.assertEquals(3, result);
        int result2 = solution.numberOfEmployeesWhoMetTarget(new int[]{0,1,2,3,4}, 2);
        Assert.assertEquals(3, result2);
    }
}
