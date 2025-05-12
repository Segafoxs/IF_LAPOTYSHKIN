import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.core.options.Constants.*;


@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("src/main/java/ru/iFellow/steps")
@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "src/test/resources/AutoTestJira")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
public class CucumberRunnerTest  {

}