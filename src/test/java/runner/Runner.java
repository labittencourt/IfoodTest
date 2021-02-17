package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"hook", "steps"},
        tags = {"@all"},
        plugin = {"json:target/cucumber-report/cucumber.json"},
        snippets = SnippetType.CAMELCASE,
        dryRun = false,
        strict = false)

public class Runner extends AbstractTestNGCucumberTests {

}
