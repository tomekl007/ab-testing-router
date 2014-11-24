package com.tomekl007.ab.testing.router.strategies;

import com.tomekl007.ab.testing.router.converters.TestingGroupsConverter;

import java.util.Map;
import java.util.function.ToIntFunction;

/**
 * @author Tomasz Lelek
 * @since 2014-11-21
 */
public class HashRoutingStrategy implements RoutingStrategy {
    private final Map<Integer, String> testingGroups;
    private final int sumOfTestingGroups;

    public HashRoutingStrategy(Map<String, Integer> testingGroups) {
        this.testingGroups = TestingGroupsConverter.toInterval(testingGroups);
        this.sumOfTestingGroups = sumTestGroups(testingGroups);
     }

    private int sumTestGroups(Map<String, Integer> testingGroups) {
        return testingGroups.values().stream()
                .mapToInt(identity)
                .sum();
    }

    private final ToIntFunction<Integer> identity = value -> value;


    @Override
    public String getGroupForId(String clientId) {
        int numberValueForClient = getNumericValueForClientId(clientId, sumOfTestingGroups);
        return testingGroups.get(numberValueForClient);
    }

    static Integer getNumericValueForClientId(String clientId, int sumOfTestingGroups) {
        return Math.floorMod(clientId.hashCode(), sumOfTestingGroups - 1);
    }
}
