package com.tomekl007.ab.testing.router.converters;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class TestingGroupsConverterTest {
    @Test
    public void shouldConvertTestingGroupsToIntervals() {
        //given
        Map<String, Integer> testingGroups = new LinkedHashMap<>();
        String firstGroup = "grupa A";
        testingGroups.put(firstGroup, 2);
        String secondGroup = "grupa B";
        testingGroups.put(secondGroup, 3);
        String thirdGroup = "grupa C";
        testingGroups.put(thirdGroup, 5);
        //when
        Map<Integer, String> testingGroupsIntervals = TestingGroupsConverter.toInterval(testingGroups);
        //then
        assertThat(testingGroupsIntervals.get(0)).isEqualTo(firstGroup);
        assertThat(testingGroupsIntervals.get(1)).isEqualTo(firstGroup);
        assertThat(testingGroupsIntervals.get(2)).isEqualTo(secondGroup);
        assertThat(testingGroupsIntervals.get(3)).isEqualTo(secondGroup);
        assertThat(testingGroupsIntervals.get(4)).isEqualTo(secondGroup);
        assertThat(testingGroupsIntervals.get(5)).isEqualTo(thirdGroup);
        assertThat(testingGroupsIntervals.get(6)).isEqualTo(thirdGroup);
        assertThat(testingGroupsIntervals.get(7)).isEqualTo(thirdGroup);
        assertThat(testingGroupsIntervals.get(8)).isEqualTo(thirdGroup);
        assertThat(testingGroupsIntervals.get(9)).isEqualTo(thirdGroup);
    }

}