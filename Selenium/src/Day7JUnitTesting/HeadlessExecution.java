package Day7JUnitTesting;



import org.openqa.selenium.firefox.*;

import static org.testng.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/*
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import util.*;
 */

public class HeadlessExecution
{
	static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		//  No. of ways to do Handless:---
		//	1.  driver=BrowserSetup.browserStart("chrome");
		//	2.  driver= new HtmlUnitDriver(true);
		//  3.	 GhostDriver (PhantomJS)
		
		System.setProperty("webdriver.gecko.driver",".\\Drivers\\geckodriver.exe");
		FirefoxOptions op=new FirefoxOptions();
		op.addArguments("--headless");
		op.addArguments("--start-maximized");
		driver=new FirefoxDriver(op);
		driver.manage().window().maximize();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
		driver.quit();
	}

	@Test
	public void test() 
	{
		driver.get("http://seleniumhq.org/");
		driver.findElement(By.linkText("Download")).click();
		assertEquals("Downloads", driver.getTitle());
		assertTrue(driver.findElement(By.linkText("Maven users")).isDisplayed());
	}
}
