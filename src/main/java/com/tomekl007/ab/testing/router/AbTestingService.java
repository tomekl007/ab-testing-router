package com.tomekl007.ab.testing.router;

import com.tomekl007.ab.testing.router.configuration.AbTestingConfiguration;
import com.tomekl007.ab.testing.router.resources.RouteResource;
import com.tomekl007.ab.testing.router.strategies.RoutingStrategy;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * @author Tomasz Lelek
 * @since 2014-11-21
 */
public class AbTestingService extends Application<AbTestingConfiguration> {
  public static void main(String[] args) throws Exception {
    new AbTestingService().run(args);
  }

  @Override
  public void initialize(Bootstrap<AbTestingConfiguration> bootstrap) {

  }

  @Override
  public void run(AbTestingConfiguration configuration, Environment environment) throws Exception {
    RoutingStrategy routingStrategy = new RoutingStrategy(configuration.getTestingGroups());
    environment.jersey().register(new RouteResource(routingStrategy));
  }
}
