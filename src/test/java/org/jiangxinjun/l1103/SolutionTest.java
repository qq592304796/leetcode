package org.jiangxinjun.l1103;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class SolutionTest {

    @Test
    public void test() throws URISyntaxException, IOException {
        Solution solution = new Solution();
        int[] result = solution.distributeCandies(7, 4);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 1}, result);
        int[] result2 = solution.distributeCandies(10, 3);
        Assert.assertArrayEquals(new int[]{5, 2, 3}, result2);
    }
}
