package in.lnt.day2;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OracleCSS 
{
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		FileInputStream inFile = new FileInputStream("D:\\Book1.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook book = new XSSFWorkbook(inFile);
		XSSFSheet sheet = book.getSheet("Sheet1");
		for (int i = 0; i <= sheet.getLastRowNum(); i++) 
		{

			String data = sheet.getRow(i).getCell(0).toString();
			System.out.print(data);
			String data2 = sheet.getRow(i).getCell(1).toString();
			System.out.println(data2);

			driver.get("http://127.0.0.1:8080/htmldb/f?p=4550:11:16284773533565307088::NO:::");
			driver.findElement(By.cssSelector("input#P11_USERNAME")).clear();
			driver.findElement(By.cssSelector("input[type='password']")).clear();

			driver.findElement(By.cssSelector("input#P11_USERNAME")).sendKeys(data);
			driver.findElement(By.cssSelector("input[type='password']")).sendKeys(data2);
			driver.findElement(By.cssSelector("input[value='Login']")).click();
			if (driver.getTitle().equals("Oracle")) 
			{
				System.out.println("Successfully logged in!!");
				sheet.getRow(i).createCell(2).setCellValue("LoginDone");
				driver.findElement(By.cssSelector("img[title='Logout']")).click();
				driver.findElement(By.cssSelector("a.htmldbInstruct")).click();
			} 
			else 
			{
				System.out.println("Worng password/user name!!");
				sheet.getRow(i).createCell(2).setCellValue("LoginFailed");
			}
			FileOutputStream op = new FileOutputStream("D:\\Book2.xlsx");
			book.write(op);
			// driver.quit();
		}
	}
}