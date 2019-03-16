package Day9;

import java.util.List;
import util.Base2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Execute extends Base2 {
	
	@Test
	  public void f2()
	{
		driver.get("http://127.0.0.1:8080/htmldb");
		LoginFactory Lf=new LoginFactory(driver);
		
		Lf.LoginProcess("sys","Newuser123");
	
	}
	

  @Test
   public void f1() {
	  //List<WebElement> all=driver.findElements(By.xpath("//a"));
	
	  driver.get("http://newtours.demoaut.com/");
        
		CheckLinks links=new CheckLinks(driver);
		links.f();


}
}
