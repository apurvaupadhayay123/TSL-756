package util;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Base2 extends BrowserSetup
{
	public WebDriver driver;
	@BeforeTest
	public void beforeTest() throws InterruptedException 
	{
		driver = BrowserSetup.browserStart("chrome");
	}

	@AfterTest
	public void afterTest() 
	{
		driver.quit();
	}
}
