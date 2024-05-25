package org.jiangxinjun.l1542;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

public class SolutionTest {

    @Test
    public void test() throws URISyntaxException, IOException {
        Solution solution = new Solution();
        int result = solution.longestAwesome("3242415");
        Assert.assertEquals(5, result);
//        int result2 = solution.longestAwesome("12345678");
//        Assert.assertEquals(1, result2);
//        int result3 = solution.longestAwesome("213123");
//        Assert.assertEquals(6, result3);
//        int result4 = solution.longestAwesome("00");
//        Assert.assertEquals(2, result4);
//        int result5 = solution.longestAwesome("9498331");
//        // 93439
//        Assert.assertEquals(3, result5);
//        int result6 = solution.longestAwesome("805571");
//        Assert.assertEquals(3, result6);
//        String test7 = FileUtils.readFileToString(new File(Objects.requireNonNull(this.getClass().getResource(
//                "./test7.txt")).toURI()));
//        // 删除最后一个换行符
//        test7 = StringUtils.removeEnd(test7, "\n");
//        int result7 = solution.longestAwesome(test7);
//        Assert.assertEquals(29995, result7);
    }
}
