package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/html-reports/report.html"},
        features ="src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@[bot]",
        dryRun=false


)
public class Runner {
}
