package org.jiangxinjun.l2079;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution solution = new Solution();
        int result = solution.wateringPlants(new int[]{2,2,3,3}, 5);
        Assert.assertEquals(14, result);
        int result2 = solution.wateringPlants(new int[]{1,1,1,4,2,3}, 4);
        Assert.assertEquals(30, result2);
    }
}
