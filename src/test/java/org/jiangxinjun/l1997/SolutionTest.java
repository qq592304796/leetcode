package org.jiangxinjun.l1997;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution3 solution = new Solution3();
        int result = solution.firstDayBeenInAllRooms(new int[]{0, 0});
        Assert.assertEquals(2, result);
        int result2 = solution.firstDayBeenInAllRooms(new int[]{0,0,2});
        Assert.assertEquals(6, result2);
        int result3 = solution.firstDayBeenInAllRooms(new int[]{0,1,2,0});
        Assert.assertEquals(6, result3);
        int result4 = solution.firstDayBeenInAllRooms(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        Assert.assertEquals(320260018, result4);
    }
}
