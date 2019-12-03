import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * @author Lydia BARAUKOVA
 */
@RunWith(value = Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, features = "../resources/features", glue = "./step_definitions")
public class RunCucumberTest { // will run all features found on the classpath in the same package as this class
}
