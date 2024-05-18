package org.jiangxinjun.l2008;

import com.alibaba.fastjson2.JSON;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Objects;

public class SolutionTest {

    @SneakyThrows
    @Test
    public void test() {
        Solution solution = new Solution();
        long result = solution.maxTaxiEarnings(5, new int[][]{new int[]{2, 5, 4}, new int[]{1, 5, 1}});
        Assert.assertEquals(7L, result);
        long result2 = solution.maxTaxiEarnings(20, new int[][]{new int[]{1, 6, 1}, new int[]{3, 10, 2},
                new int[]{10, 12, 3}, new int[]{11, 12, 2}, new int[]{12, 15, 2}, new int[]{13, 18, 1}});
        Assert.assertEquals(20L, result2);
        int[][] array3 = JSON.parseObject("[[9,10,2],[4,5,6],[6,8,1],[1,5,5],[4,9,5],[1,6,5],[4,8,3],[4,7,10],[1,9,8],[2,3,5]]", int[][].class);
        long result3 = solution.maxTaxiEarnings(10, array3);
        Assert.assertEquals(22L, result3);
        int[][] array4 = JSON.parseObject(FileUtils.readFileToString(new File(Objects.requireNonNull(this.getClass().getResource(
                "./test4.json")).toURI())), int[][].class);
        long result4 = solution.maxTaxiEarnings(90000, array4);
        Assert.assertEquals(2331223312L, result4);

    }
}
