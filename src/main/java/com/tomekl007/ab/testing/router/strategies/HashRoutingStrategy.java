package com.tomekl007.ab.testing.router.strategies;

import java.util.Collections;
import java.util.Map;

/**
 * @author Tomasz Lelek
 * @since 2014-11-21
 */
public class HashRoutingStrategy implements RoutingStrategy {
  private final Map<String, Integer> testingGroups;

  public HashRoutingStrategy(Map<String, Integer> testingGroups) {
    this.testingGroups = Collections.unmodifiableMap(testingGroups);
  }

  @Override
  public String getGroupForId(String clientId) {
    return "";
  }

  static Integer getNumericValueForClientId(String clientId){
    return Math.floorMod(clientId.hashCode(), 9) ;
  }
}
