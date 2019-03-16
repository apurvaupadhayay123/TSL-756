package util;

import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class BrowserSetup 
{
	static WebDriver driver=null;

	public static WebDriver browserStart(String name)
	{
		if(name.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		else if(name.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
	public static WebDriver browserStart(String name,String url)
	{
		WebDriver driver=browserStart(name);
		driver.get(url);
		return driver;
	}
	
	public static void getScreenShot(String Name)
	{	
		Date d=new Date();
		System.out.println("Before "+d.toString());
		String date=d.toString().replaceAll(" ", "_").replaceAll(":","_");
		System.out.println("After "+date);
		
		TakesScreenshot screen=(TakesScreenshot)driver;
		File src=screen.getScreenshotAs(OutputType.FILE);
		try 
		{
			FileHandler.copy(src, new File(".\\"+Name+".png"));
		} 
		catch (Exception e) 
		{
//			System.out.println("Error while taking screenshot");
			e.printStackTrace();
		}
	}
	
}
