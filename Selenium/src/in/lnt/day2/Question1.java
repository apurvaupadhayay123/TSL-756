package in.lnt.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.interactions.Actions;

import util.BrowserSetup;

public class Question1 
{
	public static void main(String[] args) 
	{
		WebDriver driver=BrowserSetup. browserStart("chrome","https://google.com/");
		//	Actions action=new Actions(driver);
		driver.get("https://www.nseindia.com/");
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.id("keyword")).sendKeys("Reliance Industries Limited");
		//action.sendKeys(driver.findElement(By.id("keyword")));
		driver.findElement(By.xpath("//*[text()='Reliance Industries Limited']")).click();
		//action.moveToElement(rel).click(rel).perform();
		BrowserSetup.getScreenShot("pqr");
		String faceV=driver.findElement(By.xpath("//span[@id='faceValue']")).getText();
		String high52=driver.findElement(By.xpath("//span[@id='high52']")).getText();
		String low52=driver.findElement(By.xpath("//span[@id='low52']")).getText();

		System.out.println("faceV is"+faceV);
		System.out.println("high52 is"+high52);
		System.out.println("low52 is"+low52);

	}
}
