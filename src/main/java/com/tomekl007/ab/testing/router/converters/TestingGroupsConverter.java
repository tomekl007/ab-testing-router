package com.tomekl007.ab.testing.router.converters;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Tomasz Lelek
 * @since 2014-11-21
 */
public class TestingGroupsConverter {
    public static Map<Integer, String> toInterval(Map<String, Integer> testingGroups) {
        Map<Integer, String> result = new LinkedHashMap<>();
        final AtomicInteger currentMin = new AtomicInteger(0);
        testingGroups.forEach((groupName, weight) -> {
            int i = currentMin.get();
            for (; i < weight + currentMin.get(); i++) {
                result.put(i, groupName);
            }
            currentMin.set(i);

        });
        return result;

    }
}
