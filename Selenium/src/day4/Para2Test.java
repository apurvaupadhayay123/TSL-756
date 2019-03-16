package day4;

import util.BrowserSetup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Para2Test 
{
	WebDriver driver;
	Connection connRef;

	@Test(dataProvider = "dp")
	public void Login( String userName, String password)  
	{
		driver.get("http://127.0.0.1:8080/htmldb");

		driver.findElement(By.xpath("//*[@type='text']")).sendKeys(userName);
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@value='Login']")).click();
		try 
		{
			if(driver.getTitle().equals("Oracle"))
			{
				System.out.println("Loop 1");
				PreparedStatement pst = 	connRef.prepareStatement("update usertable set status='Success' where userid='"+userName+"'");

				int row = pst.executeUpdate();
				System.out.println("row updated "+row);
				//connRef.createStatement().executeQuery("update usertable set status='Fail' where userid='"+userName+"'");
			}			
			else
			{
				System.out.println("Loop 2");
				PreparedStatement pst = connRef.prepareStatement("update usertable set status='Fail' where userid='"+userName+"'");

				int row = pst.executeUpdate();
				System.out.println("row updated "+row);
				//				connRef.createStatement().executeQuery("update usertable set status='Fail' where userid='"+userName+"'");
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.linkText("Logout")).click();
		driver.findElement(By.partialLinkText("Log")).click();
	}

	@DataProvider
	public Object[][] dp() throws Exception
	{
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		connRef = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Newuser123");
		ResultSet rs1 = connRef.createStatement().executeQuery("select count(*) from usertable");
		rs1.next();
		System.out.println("rs1: "+rs1.getInt(1));

		Object data[][] = new Object[rs1.getInt(1)][2];
		int i = 0;
		System.out.println("Check a");
		ResultSet rs2 = connRef.createStatement().executeQuery("select * from usertable");

		while (rs2.next()) 
		{
			data[i][0] = rs2.getString(1);
			data[i][1] = rs2.getString(2);
			i++;
		}
		return data;
	}

	@BeforeMethod
	public void beforeMethod() 
	{
	}

	@AfterMethod
	public void afterMethod(ITestResult result) 
	{
		/*	String status = null;
		System.out.println(ITestResult.FAILURE);
		System.out.println(ITestResult.SUCCESS);
		System.out.println(ITestResult.SKIP);
		 */
		if (result.getStatus() == ITestResult.SUCCESS) 
		{
			//			status="Success";
			System.out.println("Success:    "+result);
		}

		else if (result.getStatus() == ITestResult.SKIP) 
		{
			//			status="Skip";
			System.out.println("Skipped: "+result);
		}

		else if (result.getStatus() == ITestResult.FAILURE) 
		{
			//			status="Failure";
			System.out.println("Taking Screenshot  "+result);

			BrowserSetup.getScreenShot(result.getName());
		}

		/*	try 
		{
			PreparedStatement pst = connRef.prepareStatement("update usertable set status='?' where userid='?'");
			pst.setString(1,status);
			pst.setString(2,);

			int row = pst.executeUpdate();
			System.out.println("row updated "+row);

		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	@BeforeTest
	public void beforeTest() 
	{
		driver = BrowserSetup.browserStart("chrome");
	}

	@AfterTest
	public void afterTest() 
	{
		driver.quit();
	}
	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeSuite
	public void beforeSuite() {
	}

	@AfterSuite
	public void afterSuite() {
	}

}
