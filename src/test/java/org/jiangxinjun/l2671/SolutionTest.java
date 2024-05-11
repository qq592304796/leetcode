package org.jiangxinjun.l2671;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class SolutionTest {

    @Test
    public void test() {
        FrequencyTracker frequencyTracker = new FrequencyTracker();
        frequencyTracker.add(3);
        frequencyTracker.add(3);
        boolean hasFrequency = frequencyTracker.hasFrequency(2);
        Assert.assertTrue(hasFrequency);
    }

    @Test
    public void test2() {
        FrequencyTracker frequencyTracker = new FrequencyTracker();
        frequencyTracker.add(1);
        frequencyTracker.deleteOne(1);
        boolean hasFrequency = frequencyTracker.hasFrequency(1);
        Assert.assertFalse(hasFrequency);
    }

    @Test
    public void test3() throws InvocationTargetException, IllegalAccessException {
        String[] callTracks = {"FrequencyTracker","deleteOne","deleteOne","deleteOne","deleteOne","hasFrequency","add","deleteOne","hasFrequency","deleteOne","deleteOne","deleteOne","hasFrequency","add","hasFrequency","deleteOne","hasFrequency","hasFrequency","add","hasFrequency","add","deleteOne","hasFrequency","add","hasFrequency","hasFrequency","add"};
        String paramsJsonStr = "[[],[9],[8],[1],[4],[1],[10],[5],[1],[10],[9],[10],[1],[4],[1],[4],[1],[1],[10],[1],[2],[1],[2],[7],[1],[1],[6]]";
        Object[] expecteds = {null,null,null,null,null,false,null,null,true,null,null,null,false,null,true,null,false,false,null,true,null,null,false,null,true,true,null};
        frequencyTrackerTest(callTracks, paramsJsonStr, expecteds);
    }

    @Ignore
    @Test
    public void test4() throws InvocationTargetException, IllegalAccessException, URISyntaxException, IOException {
        String[] callTracks = JSON.parseArray(FileUtils.readFileToString(new File(this.getClass().getResource(
                "./test4CallTracks.json").toURI()))).toArray(new String[]{});
        String paramsJsonStr = FileUtils.readFileToString(new File(this.getClass().getResource("./test4Params.json").toURI()));
        Object[] expecteds = new Object[callTracks.length];
        frequencyTrackerTest(callTracks, paramsJsonStr, expecteds);
    }

    @Test
    public void test5() throws InvocationTargetException, IllegalAccessException {
        String[] callTracks = {"FrequencyTracker","hasFrequency","add","hasFrequency","hasFrequency","add","add","add","deleteOne","deleteOne","hasFrequency","add","hasFrequency","hasFrequency"};
        String paramsJsonStr = "[[],[1],[3],[1],[1],[6],[2],[6],[6],[6],[2],[2],[2],[1]]";
        Object[] expecteds = {null,false,null,true,true,null,null,null,null,null,false,null,true,true};
        frequencyTrackerTest(callTracks, paramsJsonStr, expecteds);
    }


    private static void frequencyTrackerTest(String[] callTracks, String paramsJsonStr, Object[] expecteds) throws IllegalAccessException, InvocationTargetException {
        Map<String, Method> methodMap = Arrays.stream(FrequencyTracker.class.getDeclaredMethods())
                .filter(method -> Modifier.isPublic(method.getModifiers())).collect(Collectors.toMap(Method::getName, Function.identity()));
        Object[] actuals = new Object[expecteds.length];
        JSONArray paramsJsonArray = JSON.parseArray(paramsJsonStr);
        FrequencyTracker frequencyTracker = new FrequencyTracker();
        for (int i = 0; i < callTracks.length; i++) {
            String callTrack = callTracks[i];
            Method method = methodMap.get(callTrack);
            if (method != null) {
                int param = ((JSONArray) paramsJsonArray.get(i)).getIntValue(0);
                actuals[i] = method.invoke(frequencyTracker, param);
//                if (!Objects.equals(expecteds[i], actuals[i])) {
//                    log.info("index:{}, expected:{}, actuals:{}", i, expecteds[i], actuals[i]);
//                    log.info("expecteds:{}", JSON.toJSONString(expecteds));
//                    log.info("actuals  :{}", JSON.toJSONString(actuals));
//                }
            }
        }
        Assert.assertArrayEquals(expecteds, actuals);
    }

}


//leetcode submit region end(Prohibit modification and deletion)
