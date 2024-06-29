package org.jiangxinjun.l2710;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class SolutionTest {

    @Test
    public void test() throws URISyntaxException, IOException {
        Solution solution = new Solution();
        String result = solution.removeTrailingZeros("51230100");
        Assert.assertEquals("512301", result);
    }
}
