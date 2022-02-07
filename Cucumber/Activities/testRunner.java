package cucumberTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Features",
        glue = {"stepDefinations"},
        tags = "@SmokeTest",
        plugin = {"pretty","html: test-reports","json: test-report\\json-report.json"},
        monochrome = true
)

public class testRunner {
}
