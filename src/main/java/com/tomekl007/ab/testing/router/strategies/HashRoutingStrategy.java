package com.tomekl007.ab.testing.router.strategies;

import java.util.Collections;
import java.util.Map;

/**
 * @author Tomasz Lelek
 * @since 2014-11-21
 */
public class HashRoutingStrategy implements RoutingStrategy {
    private final Map<Integer, String> testingGroups;
    private final int sumOfTestingGroups;

    public HashRoutingStrategy(Map<Integer, String> testingGroups) {
        this.testingGroups = Collections.unmodifiableMap(testingGroups);
        sumOfTestingGroups = testingGroups.keySet().stream().mapToInt(e -> e).sum();
    }


    @Override
    public String getGroupForId(String clientId) {
        int numberValueForClient = getNumericValueForClientId(clientId, sumOfTestingGroups);
        return testingGroups.get(numberValueForClient);
    }

    static Integer getNumericValueForClientId(String clientId, int sumOfTestingGroups) {
        return Math.floorMod(clientId.hashCode(), sumOfTestingGroups - 1);
    }
}
