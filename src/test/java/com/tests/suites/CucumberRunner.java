package com.tests.suites;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags={"@Tests"},
        plugin = { "pretty", "html:target/cucumber" },
        glue = {"feature.tests"},
        features = "src\\test\\resources\\features",
        dryRun = false, monochrome = true
		)

public class CucumberRunner {

}
