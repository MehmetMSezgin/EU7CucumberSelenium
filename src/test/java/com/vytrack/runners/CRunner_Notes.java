/*package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json"}, //For reporting I use. It creates json file into Target folder
        features = "src/test/resources/features",
        glue = "com/vytrack/step_definitions",
        dryRun = true, //it checks just corresponding definitions are there ot not
        //if you want to run codes, you need to turn it false

        //ABOUT TAGS
        //1)"@smoke" //to run specific scenario
        //it goes and runs all scenarios who has "smoke" label

        tags = "@Driver and @Vyt-123" //2)this runs only scenarios who has both label
        //"and" logic

        //3) "@Driver or @Store_manager" it runs which has @Driver or @Store_manager

        //4) Excluding wip : "@login and not @wip"
        //run all the login tags but not wip

        //5) @Allscenarios and not @This and not @This2
)
public class CukesRunner {
}
*/
