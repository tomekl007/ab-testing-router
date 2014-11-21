package com.tomekl007.ab.testing.router.strategies;

/**
 * @author Tomasz Lelek
 * @since 2014-11-21
 */
public interface RoutingStrategy {
    String getGroupForId(String clientId);
}
