package Day9;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import util.Base2;

public class CheckLinks extends Base2 {
	WebDriver driver;
	
	
	
	CheckLinks(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(tagName="a")List <WebElement> ls;
  public void f() {
	 
	  //List<WebElement> all=driver.findElements(By.xpath("//a"));
	  
	  
	  driver.get("http://newtours.demoaut.com/");
	  for(int i=0;i<ls.size();i++)
	  {
		  //all= driver.findElements(By.xpath("//a"));
		 ls.get(i).click();
		  try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  driver.navigate().back();
	  }
		  
  }
}
