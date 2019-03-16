package Day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login
{
	private WebDriver driver;
	Login(WebDriver driver)
	{
		this.driver=driver;
	}
	private By e_userName=By.name("p_t01");
	private By e_password=By.name("p_t02");
	private By e_login=By.xpath("//*[@value='Login']");
	private By e_getting=By.xpath("//*[@value='Getting Started']");
	
	public void loginProcess(String un,String pwd)
	{
		driver.findElement(e_userName).sendKeys(un);
		driver.findElement(e_password).sendKeys(pwd);
		driver.findElement(e_login).click();
		
	}
}
