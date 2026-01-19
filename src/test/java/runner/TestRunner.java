package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"Steps","Pages","Factory", "DomainObject","Constants","CustomType","Hooks"},
        snippets = CAMELCASE,
        plugin = {
        "pretty",
        "html:target/cucumber-report.html",
        "json:target/cucumber.json"
        },
        monochrome = true

)
public class TestRunner {

}
