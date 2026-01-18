package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/CustomerLogin.feature",
        glue = {"Steps","Pages","Factory", "DomainObject","Constants"},
        snippets = CAMELCASE,
        plugin = "pretty",
        monochrome = true

)
public class TestRunner {

}
