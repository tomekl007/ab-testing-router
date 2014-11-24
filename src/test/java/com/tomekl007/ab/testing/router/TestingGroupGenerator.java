package com.tomekl007.ab.testing.router;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Tomasz Lelek
 * @since 2014-11-24
 */
public class TestingGroupGenerator {

    public static Map<String, Integer> generateTestingGroups(int numberOfTestingGroups) {
        Map<String, Integer> result = new LinkedHashMap<>();
        for (int i = 0; i < numberOfTestingGroups; i++) {
            result.put("group "+ i, i);
        }
        return result;
    }
}
