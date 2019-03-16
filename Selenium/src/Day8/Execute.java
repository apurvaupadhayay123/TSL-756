package Day8;

import org.testng.annotations.Test;

import util.Base2;

public class Execute extends Base2
{
	@Test
	public void f() throws InterruptedException 
	{
		Login ln=new Login(driver);
		SQL_Command command=new SQL_Command(driver);
		driver.get("http://127.0.0.1:8080/htmldb");
		ln.loginProcess("sys", "Newuser123");
		command.SQLCommand("select * from tab");
		Thread.sleep(5000);
		command.logoutProcess();
	}
}
