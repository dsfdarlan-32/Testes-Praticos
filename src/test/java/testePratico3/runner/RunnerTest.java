package testePratico3.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features", 
		glue = {""}, 
		tags = "@Teste2", 
		plugin = { "json:target/cucumber.json" , "rerun:target/rerun.txt" }, 
		monochrome = false, 
		dryRun = false, 
		snippets = CucumberOptions.SnippetType.CAMELCASE)

public class RunnerTest {
	
}
