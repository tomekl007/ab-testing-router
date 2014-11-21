package com.tomekl007.ab.testing.router.configuration;

import com.yammer.dropwizard.config.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Map;

/**
 * @author Tomasz Lelek
 * @since 2014-11-21
 */
public class AbTestingConfiguration extends Configuration{
  public Map<String, Integer> getTestingGroups() {
    return testingGroups;
  }

  @NotEmpty
  private Map<String, Integer> testingGroups;
}
