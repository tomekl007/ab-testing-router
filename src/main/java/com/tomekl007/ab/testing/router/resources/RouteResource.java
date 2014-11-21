package com.tomekl007.ab.testing.router.resources;

import com.tomekl007.ab.testing.router.strategies.RoutingStrategy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * @author Tomasz Lelek
 * @since 2014-11-21
 */
@Path("/route")
public class RouteResource {
  private final RoutingStrategy routingStrategy;

  public RouteResource(RoutingStrategy routingStrategy) {
    this.routingStrategy = routingStrategy;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String getRouteForUser(@QueryParam("id") String id){
    return routingStrategy.getGroupForId(id);
  }
}
