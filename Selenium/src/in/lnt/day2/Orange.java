package in.lnt.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Orange 
{
	public static void main(String[] args) 
	{				
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		Actions action=new Actions(driver);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login"); 
		
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		
		driver.findElement(By.id("btnLogin")).click();
		
		action.moveToElement(driver.findElement(By.id("menu_admin_viewAdminModule"))).perform();
		action.moveToElement(driver.findElement(By.id("menu_admin_Organization"))).perform();
		
		driver.findElement(By.id("menu_admin_viewOrganizationGeneralInformation")).click();
	}
}
