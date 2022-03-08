package testePrático3.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
  static WebDriver driver;
  
  public static void createDriver() {
    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }
  
  public static WebDriver getDriver() {
    if (driver == null)
      createDriver();
    return driver;
  }
  
  public static void closeDriver() {
    if (driver != null) {
      driver.quit();
      driver = null;
    }
  }
}
