package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Excel {
     Workbook book;
     
	 public Excel(String fileName) {
		 try {
		FileInputStream fin=new FileInputStream(fileName);
		
		if(fileName.endsWith(".xls"))
		{
			book=new  HSSFWorkbook(fin);
		}
		else if(fileName.endsWith(".xlsx"))
			{
			book=new XSSFWorkbook(fin);
		}
		 }
		 catch(Exception e)
		 {
			 System.out.println("error with file reading");
		 }
	}
	 public String Read(String SheetName,int R,int C)
	 {
		 
		 Sheet sh=book.getSheet(SheetName);
		String data=null;
		 try {
			data=sh.getRow(R).getCell(C).toString();
			 if(data.endsWith(".0")) 
				 data=data.split("\\.")[0];
				
		} catch (Exception e) {
			data=null;
		}
		 return data;
	 }
	 public int rowCount(String SheetName)
	 {
		 return book.getSheet(SheetName).getLastRowNum();
	 }
	 
	 public int cellCount(String SheetName,int R)
	 {
		Sheet sh=book.getSheet(SheetName);
		 int c=sh.getRow(R).getLastCellNum();
		 return c;
}
}
