package Day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SQL_Command 
{
	private WebDriver driver;
	SQL_Command(WebDriver driver)
	{
		this.driver=driver;
	}
	private By e_Logout=By.linkText("Logout");
	private By e_SQL=By.linkText("SQL");
	private By e_SQL_Command=By.linkText("SQL Commands");
	private By e_Query=By.id("P1003_SQL_COMMAND1");
	private By e_display=By.xpath("//select[@id='P1003_ROWS']");
	private  By e_run=By.xpath("//*[@value='Run']");
	
	public void logoutProcess()
	{
		driver.findElement(e_Logout).click();
	}
	public void SQLCommand(String query)
	{
		driver.findElement(e_SQL).click();
		//System.out.println("Clicked ");
		driver.findElement(e_SQL_Command).click();
		new Select(driver.findElement(e_display)).selectByVisibleText("20");
		driver.findElement(e_Query).sendKeys(query);
		driver.findElement(e_run).click();
		//driver.findElement(e_Query).sendKeys("create table Group(name varchar2(10);");
		
	}
}
