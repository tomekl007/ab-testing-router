package com.tomekl007.ab.testing.router.configuration;

import com.tomekl007.ab.testing.router.AbTestingService;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.ClassRule;
import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AbTestingConfigurationTest {

    @ClassRule
    public static final DropwizardAppRule<AbTestingConfiguration> RULE =
            new DropwizardAppRule<>(AbTestingService.class, "configuration.yml");

    @Test
    public void shouldHaveConfigurationOfTestingGroups() {
        //when
        Map<String, Integer> testingGroups = RULE.getConfiguration().getTestingGroups();
        //then
        assertThat(testingGroups).hasSize(3);
    }

}