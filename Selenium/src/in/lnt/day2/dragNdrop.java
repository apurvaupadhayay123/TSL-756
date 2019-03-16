package in.lnt.day2;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import util.*;

public class dragNdrop 
{
	public static void main(String[] args) 
	{
		WebDriver driver=BrowserConfigration.browserStart("chrome","https://jqueryui.com/droppable/");
		Actions action =new Actions(driver);
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement srcElement=driver.findElement(By.id("draggable"));
		WebElement desElement=driver.findElement(By.id("droppable"));
		action.dragAndDrop(srcElement, desElement).perform();
		/*TakesScreenshot screen=(TakesScreenshot)driver;
		File src=screen.getScreenshotAs(OutputType.FILE);
		try
		{
			
			FileHandler.copy(src,new File(".\\dragNdrop.png"));
			
		}
		catch(IOException e)
		{
			System.out.println("Error while taking screenshot");
		}

	}*/
		
		BrowserSetup.browserStart("abc");
	}
}
