package testePratico3.steps;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Before;
import testePratico3.driver.Driver;

public class BaseTest {
	WebDriver driver;

	@Before
	public void init() {
		driver = Driver.getDriver();
	}

	@AfterClass
	public void encerra() {
		driver.close();
		driver.quit();
	}
}
