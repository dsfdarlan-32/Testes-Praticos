package testePrático3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testePrático3.driver.Driver;

public class BasePage {
	WebDriver driver = Driver.getDriver();

	public void click(By by) {
		driver.findElement(by).click();
	}

	public void sendKeys(By by, String text) {
		driver.findElement(by).sendKeys(text);
	}

	public Boolean isDisplayed(By by) {
		return driver.findElement(by).isDisplayed();
	}

	public void waitElement(By by, Integer n) {
		WebDriverWait wait = new WebDriverWait(driver, n);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void clear(By by) {
		driver.findElement(by).clear();
	}

	public void moveToFrame(By by) {
		driver.switchTo().frame(driver.findElement(by));
	}

	public String getValue(By by) {
		return driver.findElement(by).getText();
	}

	public void moveToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	public void moveToElement(By by) {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(by)).build().perform();
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public void forceWait(int n) {
		try {
			Thread.sleep(n);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void scrollDown(int n) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + n + ")", "");
	}
	
	public String getAttribute(By by, String attribute) {
		return driver.findElement(by).getAttribute(attribute);
	}
}
