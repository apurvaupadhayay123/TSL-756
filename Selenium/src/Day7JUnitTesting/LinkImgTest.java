package Day7JUnitTesting;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.BrowserSetup;

public class LinkImgTest 
{
	static WebDriver driver=null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		driver=BrowserSetup.browserStart("chrome");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
		driver.quit();
	}

	@Test
	public void test()
	{
		driver.get("http://newtours.demoaut.com");
		List<WebElement>alllinks= driver.findElements(By.xpath("//a"));
		alllinks.addAll(driver.findElements(By.tagName("img")));
		for(WebElement e:alllinks)
		{
			String url=e.getAttribute("href");
			System.out.println(url);
			try 
			{
				Proxy prox= new Proxy(Proxy.Type.HTTP,new InetSocketAddress("192.168.100.1", 8081));
				URL u=new URL(url);
				URLConnection c=u.openConnection(prox);
				HttpURLConnection hc=(HttpURLConnection)c;
				hc.connect();
				int code=hc.getResponseCode();

				if(code==200)
				{
					System.out.println(url+" Working");
				}
				else
				{
					System.out.println(url+" Not Working");
				}
			} 
			catch (MalformedURLException e1) 
			{
				//e1.printStackTrace();
				System.out.println("MalformedURLException catch kiya!");
			} 
			catch (IOException e1)
			{				
		//		e1.printStackTrace();
				System.out.println("IOException catch kiya!");
			}
		}
	}

	public void urlTest(String url) throws Exception
	{
/*		URL u=new URL(url);
		URLConnection c=u.openConnection();
		HttpURLConnection hc=(HttpURLConnection)c;
		hc.connect();

		int code=hc.getResponseCode();
		if(code==200)
		{
			System.out.println(url+" Working");
		}
		else
		{
			System.out.println(url+" Not Working");
		}
 */
	}
}
