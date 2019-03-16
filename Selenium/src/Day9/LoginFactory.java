package Day9;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginFactory {
	WebDriver driver;
	
	public LoginFactory(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="p_t01") WebElement e_username;
	@FindBy(name="p_t02") WebElement e_password;
	@FindBy(how=How.XPATH,using="//*[@value='Login']") WebElement e_login;
	
	public void LoginProcess(String UN,String PSD)
	{
		e_username.sendKeys(UN);
		 e_password.sendKeys(PSD);
		 e_login.click();
	}
	
	
	
	
	

}
