import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import util.BrowserConfigration;

public class MultipleFrames 
{
	public static void main(String[] args) 
	{
		WebDriver driver=BrowserConfigration.browserStart("chrome","file:///D:/frame.html");
		@SuppressWarnings("unused")
		Actions action =new Actions(driver);
		driver.switchTo().frame(1);
		driver.findElement(By.name("userName")).sendKeys("123456");
		driver.switchTo().parentFrame();
		driver.switchTo().frame(0);
		driver.findElement(By.name("q")).sendKeys("LTI");
		driver.switchTo().parentFrame();
		driver.switchTo().frame(2);
		//driver.findElement(By.xpath("/html/body/iframe[3]")));
		driver.findElement(By.name("p_t01")).sendKeys("Sys");
	}
}
