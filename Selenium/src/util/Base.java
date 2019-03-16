package util;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Base extends BrowserSetup
{
	public WebDriver driver;
	@BeforeTest(alwaysRun=true)
	@Parameters("browser")
	public void beforeTest(String browser) throws InterruptedException 
	{
		if(browser.equalsIgnoreCase("firefox"))
					driver = BrowserSetup.browserStart("firefox");
		else if(browser.equalsIgnoreCase("chrome"))
		{
			//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Thread.sleep(5000);
			driver = BrowserSetup.browserStart("chrome");

		}
	}

	@AfterTest
	public void afterTest() 
	{
		driver.quit();
	}
}
