package myhltest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ={"src/test/java/resources"},
        glue="myhltest",
        plugin={"pretty",
                "json:TargetReport/cucumber.json"},
       tags = {"@iLogin,@LoadingBarTest,@JSalertTest"}
       )

public class runnerClassTest {
}