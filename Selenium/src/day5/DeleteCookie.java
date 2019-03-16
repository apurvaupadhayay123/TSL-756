package day5;

import org.testng.annotations.Test;
import util.Base;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DeleteCookie extends Base
{
	@Test
	public void Google()
	{
		driver.get("http://127.0.0.1:8080/htmldb");
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("sys");
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Newuser123");
		driver.findElement(By.xpath("//*[@value='Login']")).click();
		if(driver.getTitle().equals("Oracle"))
		{
			//			Set<Cookie> allCookie = driver.manage().getCookies();
			//			for (Cookie C : allCookie)
			//			{
			//				System.out.println("Name of cookie " + C.getName());
			//				System.out.println("Value of cookie " + C.getValue());
			//				System.out.println("Path of cookie " + C.getPath());
			//				System.out.println("Expiry of cookie "+C.getExpiry());
			//				System.out.println("Domain of cookie "+C.getDomain());
			//			}
			driver.manage().deleteAllCookies();
			driver.findElement(By.linkText("SQL")).click();

			Assert.assertEquals(driver.getTitle(),"HTML DB Login");
		}
		driver.findElement(By.linkText("Logout")).click();
		driver.findElement(By.partialLinkText("Log")).click();
	}
}
