package com.tomekl007.ab.testing.router.strategies;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * @author Tomasz Lelek
 * @since 2014-11-24
 */
public class RoutingStrategyWithCache implements RoutingStrategy {

    private RoutingStrategy routingStrategy;

    public static final int ONE_MILLION = 1000000;


    private final Cache<String, String> cache = CacheBuilder.newBuilder()
            .maximumSize(ONE_MILLION)
            .build();


    public RoutingStrategyWithCache(RoutingStrategy routingStrategy) {

        this.routingStrategy = routingStrategy;
    }

    @Override
    public String getGroupForId(String clientId) {
        return getFromCache(clientId);
    }


    private String getFromCache(String clientId) {
        try {
            return cache.get(clientId, getValueLoader(clientId));
        } catch (ExecutionException e) {
            System.out.println("operation supplying value to cache.get thrown exception " + e);
            throw new RuntimeException(e);
        }
    }

    private Callable<String> getValueLoader(String clientId) {
        return () -> routingStrategy.getGroupForId(clientId);
    }
}
