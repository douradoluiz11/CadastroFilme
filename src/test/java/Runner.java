import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


	@RunWith(Cucumber.class)
	@CucumberOptions(
			features = "src/features", 
			glue = { "" }, 
			tags = { "@tag3" }, 
			plugin = {"pretty" },
			monochrome = true)

	public class Runner {

	}

