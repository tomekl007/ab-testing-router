package com.tomekl007.ab.testing.router.resources;

import com.sun.jersey.api.client.ClientResponse;
import com.tomekl007.ab.testing.router.strategies.RoutingStrategy;
import com.yammer.dropwizard.testing.ResourceTest;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class RouteResourceTest extends ResourceTest {

  @Mock
  private RoutingStrategy routingStrategy;

  private static final String expectedGroup = "group 1";

  @Override
  protected void setUpResources() throws Exception {
    MockitoAnnotations.initMocks(this);
    addResource(new RouteResource(routingStrategy));
    when(routingStrategy.getGroupForId(anyString())).thenReturn(expectedGroup);
  }

  @Test
  public void shouldRespodWithGroupNameForId() {
    //when
    ClientResponse clientResponse = client()
      .resource("/route")
      .queryParam("id", "clientId")
      .get(ClientResponse.class);
    //then
    assertThat(clientResponse.getEntity(String.class)).isEqualTo(expectedGroup);

  }

}