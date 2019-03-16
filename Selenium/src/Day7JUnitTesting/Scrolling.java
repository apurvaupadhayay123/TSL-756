package Day7JUnitTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import util.Base;

public class Scrolling extends Base
{
  @Test
  public void f() throws InterruptedException 
  {
//	  TakesScreenshot t=(TakesScreenshot)driver;
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  driver.get("http://seleniumhq.org");
	  Thread.sleep(4000);
	  js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.linkText("Selenium blog")));
	  Thread.sleep(4000);
	  
	  js.executeScript("window.scrollBy(0,-550)");	//
	  Thread.sleep(4000);
	  
	  js.executeScript("window.scrollBy(0,230)");	
	  Thread.sleep(4000);
	  
	  js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");	
	  Thread.sleep(4000);
	  
	  js.executeScript("window.scrollBy(0,document.body.scrollHeight)");	
	  Thread.sleep(4000);
	  
	  js.executeScript("arguments[0].click();",driver.findElement(By.linkText("Selenium blog")));
	  Thread.sleep(4000);
	  
  }
}
