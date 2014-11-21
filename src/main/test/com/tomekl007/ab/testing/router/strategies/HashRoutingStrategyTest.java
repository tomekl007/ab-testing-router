package com.tomekl007.ab.testing.router.strategies;

import com.google.code.tempusfugit.concurrency.IntermittentTestRunner;
import com.google.code.tempusfugit.concurrency.annotations.Intermittent;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(IntermittentTestRunner.class)
public class HashRoutingStrategyTest {

  public static final int LENGTH_OF_CLIENT_ID = 14;
  public static final int UPPER_BOUND = 10;
  public static final int LOWER_BOUND = 0;

  @Intermittent(repetition = 100)
  @Test
  public void numericValueForClientIdShouldBeWithingRange() {
    //given
    String clientId = RandomStringUtils.random(LENGTH_OF_CLIENT_ID);
    //when
    Integer numericValueForClientId = HashRoutingStrategy.getNumericValueForClientId(clientId);
    //then
    assertThat(numericValueForClientId).isLessThan(UPPER_BOUND).isGreaterThanOrEqualTo(LOWER_BOUND);
  }
}