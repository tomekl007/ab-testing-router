package com.tomekl007.ab.testing.router.strategies;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;

public class RoutingStrategyWithCacheTest {

    public static final String GROUP_A = "GROUP A";
    @Mock
    private RoutingStrategy routingStrategy;

    public static final int LENGTH_OF_CLIENT_ID = 14;
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        Mockito.when(routingStrategy.getGroupForId(anyString())).thenReturn(GROUP_A);
    }

    @Test
    public void shouldGetGroupNameFromCache(){
        //given
        String clientId = RandomStringUtils.random(LENGTH_OF_CLIENT_ID);
        //when
        RoutingStrategy hashRoutingStrategy = new RoutingStrategyWithCache(routingStrategy);
        String groupForClientIdFirstRequest = hashRoutingStrategy.getGroupForId(clientId);
        String groupForClientIdSecondRequest = hashRoutingStrategy.getGroupForId(clientId);
        //then
        assertThat(groupForClientIdFirstRequest).isSameAs(groupForClientIdSecondRequest);
        Mockito.verify(routingStrategy,times(1)).getGroupForId(anyString());
    }



}