package in.lnt.day2;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel1 
{
	public static void main(String[] args) throws Exception 
	{
		FileInputStream inFile = new FileInputStream("D:\\Book1.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook book = new XSSFWorkbook(inFile);
		XSSFSheet sheet = book.getSheet("Sheet1");
		sheet.createRow(4).createCell(4).setCellValue("NewLNT");
		//sheet.getRow(2).getCell(1).setCellValue("LNT");
	//	sheet.getRow(0).createCell(3).setCellValue("LNT");
		
		FileOutputStream op = new FileOutputStream("D:\\Book2.xlsx");
		book.write(op);	
	}
}
