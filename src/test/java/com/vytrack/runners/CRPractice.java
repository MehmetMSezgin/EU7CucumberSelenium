package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/Navigation.feature",
        glue = "com/vytrack/step_definitions",
        dryRun = false,
        tags = "@Navigation"

)

public class CRPractice {
}
