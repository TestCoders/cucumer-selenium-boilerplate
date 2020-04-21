package stepdefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports"},
        features={"classpath:features/"}
)

public class RunCucumberTest {
}

//to run tests with a tag:
//mvn clean test -Dcucumber.filter.tags="@exampleFeature"
