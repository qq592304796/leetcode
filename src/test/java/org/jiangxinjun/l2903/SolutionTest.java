package org.jiangxinjun.l2903;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class SolutionTest {

    @Test
    public void test() throws URISyntaxException, IOException {
        Solution solution = new Solution();
        int[] result = solution.findIndices(new int[]{2, 1}, 0, 0);
        Assert.assertArrayEquals(new int[]{0, 0}, result);
        int[] result2 = solution.findIndices(new int[]{5, 1, 4, 1}, 2, 4);
        Assert.assertArrayEquals(new int[]{0, 3}, result2);
        int[] result3 = solution.findIndices(new int[]{1, 2, 3}, 2, 4);
        Assert.assertArrayEquals(new int[]{-1, -1}, result3);
        int[] result4 = solution.findIndices(new int[]{11,3,36,17,13,0,26}, 2, 33);
        Assert.assertArrayEquals(new int[]{2, 5}, result4);
    }
}
