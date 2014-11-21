package com.tomekl007.ab.testing.router.configuration;

import io.dropwizard.Configuration;
import lombok.Getter;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Map;

/**
 * @author Tomasz Lelek
 * @since 2014-11-21
 */
@Getter
public class AbTestingConfiguration extends Configuration{
  @NotEmpty
  private Map<String, Integer> testingGroups;
}
