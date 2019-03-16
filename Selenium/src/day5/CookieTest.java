package day5;

import org.testng.annotations.Test;

import util.Base;

import java.util.Set;

import org.openqa.selenium.Cookie;

public class CookieTest extends Base
{
	@Test
	public void Google()
	{
		driver.get("http://127.0.0.1:8080/htmldb");
		
		Set<Cookie> allCookie = driver.manage().getCookies();
		for (Cookie C : allCookie)
		{
			System.out.println("Name of cookie " + C.getName());
			System.out.println("Value of cookie " + C.getValue());
			System.out.println("Path of cookie " + C.getPath());
			System.out.println("Expiry of cookie "+C.getExpiry());
			System.out.println("Domain of cookie "+C.getDomain());
		}
	}

}
