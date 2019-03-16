package in.lnt.day2;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import util.BrowserConfigration;

public class Downloads 
{
	public static void main(String[] args) 
	{

		WebDriver driver=BrowserConfigration. browserStart("chrome","https://www.seleniumhq.org/");
		String ParentID=driver.getWindowHandle();
		Actions action=new Actions(driver);
		WebElement search=driver.findElement(By.linkText("Download"));
		Action a=action.keyDown(Keys.CONTROL).click(search).build();
		a.perform();

		Set<String> allWin=driver.getWindowHandles();
		Iterator<String> itr=allWin.iterator();
		while(itr.hasNext())
		{
			String ID=itr.next();
			System.out.println(ID);
			if(!(ID.equals((ParentID))))
			{
				driver.switchTo().window(ID);
				System.out.println("You are on"+driver.getTitle());
				driver.close();
			}
			driver.switchTo().window(ParentID);	
		}
	}
}
