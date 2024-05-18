package org.jiangxinjun.l2908;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution solution = new Solution();
        int result = solution.minimumSum(new int[]{8,6,1,5,3});
        Assert.assertEquals(9, result);
        int result2 = solution.minimumSum(new int[]{5,4,8,7,10,2});
        Assert.assertEquals(13, result2);
        int result3 = solution.minimumSum(new int[]{6,5,4,3,4,5});
        Assert.assertEquals(-1, result3);
    }
}
