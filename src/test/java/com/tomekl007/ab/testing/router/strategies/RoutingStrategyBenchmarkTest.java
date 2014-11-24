package com.tomekl007.ab.testing.router.strategies;

import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.tomekl007.ab.testing.router.TestingGroupGenerator;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RoutingStrategyBenchmarkTest extends AbstractBenchmark{

    public static final int LENGTH_OF_CLIENT_ID = 14;

    @BenchmarkOptions(benchmarkRounds = 10000, warmupRounds = 5)
    @Test
    public void randomClientIdShouldFallIntoOnOfSuppliedGroups(){
        //given
        String clientId = RandomStringUtils.random(LENGTH_OF_CLIENT_ID);
        Map<String, Integer> testingGroups = TestingGroupGenerator.generateTestingGroups(100);

        HashRoutingStrategy hashRoutingStrategy = new HashRoutingStrategy(testingGroups);
        //when
        String groupForId = hashRoutingStrategy.getGroupForId(clientId);
        //then
        assertThat(groupForId).isIn(testingGroups.keySet());

    }
}