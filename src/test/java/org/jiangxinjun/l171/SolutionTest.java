package org.jiangxinjun.l171;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

@Slf4j
public class SolutionTest {

    @Test
    public void test() throws URISyntaxException, IOException {
        Solution solution = new Solution();
//        int result = solution.titleToNumber("AB");
//        Assert.assertEquals(28, result);
//        int result2 = solution.titleToNumber("ZY");
//        Assert.assertEquals(701, result2);
        int result3 = solution.titleToNumber("FXSHRXW");
        Assert.assertEquals(2147483647, result3);
    }

    @Test
    public void test2() {
        log.info(String.valueOf(Character.getNumericValue('A')));
    }
}
