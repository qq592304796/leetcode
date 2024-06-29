package org.jiangxinjun.l848;

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
//        String result = solution.shiftingLetters("abc", new int[]{3, 5, 9});
//        Assert.assertEquals("rpl", result);
        String result2 = solution.shiftingLetters("mkgfzkkuxownxvfvxasy", new int[]{505870226,437526072,266740649,224336793,532917782,311122363,567754492,595798950,81520022,684110326,137742843,275267355,856903962,148291585,919054234,467541837,622939912,116899933,983296461,536563513});
        Assert.assertEquals("wqqwlcjnkphhsyvrkdod", result2);
    }

    @Test
    public void test2() {
        log.info(String.valueOf(Character.getNumericValue('a')));
    }
}
