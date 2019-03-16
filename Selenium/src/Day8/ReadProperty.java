package Day8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import util.Base2;
import util.BrowserSetup;

public class ReadProperty extends Base2{
  @Test
  public void Read() throws Exception {
	  Properties prop=new Properties();
	  prop.load(new FileInputStream(".//constant.property"));
	  
	  //WebDriver driver=BrowserSetup.browserStart("chrome");
	  driver.get(prop.getProperty("URL"));
	  
	 // driver.findElement(By.linkText(prop.getProperty("e_download"))).click();;
	  driver.findElement(element(prop.getProperty("e_download"))).click();;
	  
  }
  public By element(String Value)
  {
	  By b=null;
	  if(Value.endsWith("_linktext"))
		  b=By.linkText(Value.split("_")[0]);
	  else if(Value.endsWith("_xpath"))
		  b=By.linkText(Value.split("_")[0]);
	  return b; 
  }
  
}
