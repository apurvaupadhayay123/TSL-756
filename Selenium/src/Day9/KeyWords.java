package Day9;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.javascript.host.Element;

public class KeyWords {
	private WebDriver driver;
	
	public KeyWords(WebDriver driver)
	{
		this.driver=driver;
	}

	public void url(String url)
	{
		driver.get(url);
	}
	
	public void type(String locator,String text)
	{
		
		driver.findElement(element(locator)).sendKeys(text);
		
	}
	public void click(String locator)
	{
		
		driver.findElement(element(locator)).click();
		
	}
	
	public void dropDown(String locator,String visibleText)
	{	
		
		new Select(driver.findElement(element(locator))).selectByVisibleText(visibleText);		
		
	}
	
	public void getScreenShot(String Name)
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
			e.printStackTrace();
		}
	}
	

	public By element(String value)
	{
		  By b=null;
		  if(value.endsWith("_:linktext"))
			  b=By.linkText(value.split("_:")[0]);
		  
		  else if(value.endsWith("_:xpath"))
			  b=By.xpath(value.split("_:")[0]);
		  
		  else if(value.endsWith("_:css"))
			  b=By.cssSelector(value.split("_:")[0]);
		  
		  else if(value.endsWith("_:name"))
			  b=By.name(value.split("_:")[0]);
		  
		  else if(value.endsWith("_:id"))
			  b=By.id(value.split("_:")[0]);
		  
		  else
			  System.out.println("invalid selector");
		  
		  
		  return b; 
	}
	
	
}
