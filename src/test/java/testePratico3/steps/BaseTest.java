package testePratico3.steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import testePratico3.driver.Driver;

public class BaseTest {
	static WebDriver driver = Driver.getDriver();

	@After
	public static void encerra() {
		Driver.closeDriver();
	}
}
