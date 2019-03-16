package Day9;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;

public class GridExample  {
  @Test
  public void f() throws Exception
  {
	 DesiredCapabilities dc = DesiredCapabilities.firefox();
	 dc.setPlatform(Platform.WINDOWS);
	 dc.setBrowserName("firefox");
	 
	 WebDriver driver = new RemoteWebDriver(new URL ("http://192.168.100.170:5482/wd/hub"),dc);
	 driver.get("https://www.seleniumhq.org");
	
	 
	 //driver.get("https://www.seleniumhq.org");
	 Assert.assertEquals(driver.getTitle(),"Selenium - Web Browser Automation");
	 driver.quit();
	 //http://192.168.100.134:4444/wd/hub
  }
}
