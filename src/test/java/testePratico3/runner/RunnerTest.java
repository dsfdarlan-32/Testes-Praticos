package testePratico3.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features",
//        tags = "@Teste1",
        glue = {""},
        publish = true,
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false,
        plugin = {"json:target/cucumber.json", "rerun:target/rerun.txt"})

public class RunnerTest {
}		

