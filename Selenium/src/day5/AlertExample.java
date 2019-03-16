package day5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import util.Base;

public class AlertExample extends Base
{
	@Test
	public void Google() throws InterruptedException 
	{
		driver.get("http://www.magneticautomation.in/2019/01/alert-example.html");
		
		driver.findElement(By.xpath("//Button[@onclick='myFunction1()']")).click();
		Alert a=driver.switchTo().alert();
		String txt=a.getText();
		System.out.println(txt);
		Thread.sleep(2000);
		a.accept();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//Button[@onclick='myFunction2()']")).click();
		Alert b=driver.switchTo().alert();
		String txt1=b.getText();
		System.out.println(txt1);
		Thread.sleep(2000);
		b.accept();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//Button[@onclick='myFunction()']")).click();
		Alert c=driver.switchTo().alert();
		String txt2=c.getText();
		System.out.println(txt2);
		Thread.sleep(2000);
		a.accept();
		Thread.sleep(2000);
	}
}
