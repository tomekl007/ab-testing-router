package com.tomekl007.ab.testing.router.strategies;

import java.util.Collections;
import java.util.Map;

/**
 * @author Tomasz Lelek
 * @since 2014-11-21
 */
public class RoutingStrategy {
  private final Map<String, Integer> testingGroups;

  public RoutingStrategy(Map<String, Integer> testingGroups) {
    this.testingGroups = Collections.unmodifiableMap(testingGroups);
  }

  public String getGroupForId(String id) {
    return "";
  }
}
