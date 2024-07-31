package org.jiangxinjun.l3096;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class SolutionTest {

    @Test
    public void test() throws URISyntaxException, IOException {
        Solution solution = new Solution();
        int result = solution.minimumLevels(new int[]{1,0,1,0});
        Assert.assertEquals(1, result);
        int result2 = solution.minimumLevels(new int[]{1,1,1,1,1});
        Assert.assertEquals(3, result2);
        int result3 = solution.minimumLevels(new int[]{0,0});
        Assert.assertEquals(-1, result3);
        int result4 = solution.minimumLevels(new int[]{1,1});
        Assert.assertEquals(-1, result4);
    }
}
