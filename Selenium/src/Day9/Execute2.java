package Day9;

import org.testng.annotations.Test;

import util.Base2;

public class Execute2 extends Base2{
  @Test
  public void f() 
  {
	  KeyWords key=new KeyWords(driver);
	  key.url("https://opensource-demo.orangehrmlive.com/");
	  key.type("txtUsername_:name", "Admin");
	  key.type("txtPassword_:id", "admin123");
	  key.click("btnLogin_:id");	  
	  key.click("Welcome Admin_:linktext");
	  key.getScreenShot("Orange");
	  
	  key.click("//a[contains(text(),'Logout')]_:xpath");
	  
	  
  }
}
