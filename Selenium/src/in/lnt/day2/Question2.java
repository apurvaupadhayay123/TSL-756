package in.lnt.day2;

import java.io.FileInputStream;


import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import util.BrowserSetup;

/*
import util.BrowserConfigration;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
 */

public class Question2 
{
	public static void main(String[] args) throws Exception 
	{
//		WebDriver driver = BrowserSetup.browserStart("chrome", "https://google.com/");
//		Actions action = new Actions(driver);
//		driver.get("https://www.nseindia.com/");
//		FileInputStream inFile = new FileInputStream("D:\\Question2.xls");
//		HSSFWorkbook book = new HSSFWorkbook(inFile);
//		HSSFSheet sheet = book.getSheet("Sheet1");
//		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
//			String data = sheet.getRow(i).getCell(0).toString();
//			driver.findElement(By.id("keyword")).sendKeys(data);
//			WebElement E = driver.findElement(By.xpath("//b[(text(),'"+data+"')]"));
//			action.moveToElement(E).click(E).perform();
//			// BrowserSetup.getScreenShot("pqr");
//			String faceV = driver.findElement(By.xpath("//span[@id='faceValue']")).getText();
//			System.out.println("faceV is" + faceV);

			
		FileInputStream inFile=new FileInputStream("D:\\Question2.xls");
		@SuppressWarnings("resource")
		HSSFWorkbook book=new HSSFWorkbook(inFile);
		HSSFSheet sheet=book.getSheet("Sheet1");
		WebDriver driver=BrowserSetup.browserStart("chrome","https://www.nseindia.com/");
		Actions action=new Actions(driver);
		driver.manage().window().maximize();
		for(int i=0;i<=sheet.getLastRowNum();i++)
		{
		String Keyword=sheet.getRow(i).getCell(0).toString();
		driver.findElement(By.id("keyword")).sendKeys(Keyword);
		System.out.println("Xpath is >>> "+"//*[text()='"+Keyword+"']");
		WebElement E=driver.findElement(By.xpath("//*[contains(text(),'"+Keyword+"')]"));
		action.moveToElement(E).click(E).perform();
		String faceV=driver.findElement(By.xpath("//span[@id='faceValue']")).getText();
		System.out.println("Face value is "+faceV);
		BrowserSetup.getScreenShot(Keyword);	
}
		}
	}
