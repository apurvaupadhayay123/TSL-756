package Day9;

import org.testng.annotations.Test;

import util.Base2;
import util.Excel;

import org.testng.annotations.DataProvider;

public class Hybrid extends Base2
{
  @Test(dataProvider = "dp")
  public void f(String k, String locator, String data)
  {
	  KeyWords key = new KeyWords(driver);
	  
	  switch(k)
	  {
	  case "url":
		  key.url(data);
		  break;
	  
	  case "type":
		  key.type(locator,data);
		  break;
		  
	  case "click":
		  key.click(locator);
		  break;
		  
	  case "getScreenShot":
		  key.getScreenShot(data);
		  break;
		  
		  default:System.out.println("Invalid selection");
	  
	  }
  
  }

  @DataProvider
  public Object[][] dp()
  {
  Excel excel = new Excel("D:\\excel keyword\\Book1.xls");
 // System.out.println(excel.rowCount("Sheet1")+1);
  Object data[][] = new Object[excel.rowCount("Sheet1")][3];
  for (int i=0;i<excel.rowCount("Sheet1"); i++)
  {
	  data [i][0]= excel.Read("Sheet1", i+1, 0);
	  data [i][1]= excel.Read("Sheet1", i+1, 1);
	  data [i][2]= excel.Read("Sheet1", i+1, 2);
  }
	  return data;
     
   
  }
}

