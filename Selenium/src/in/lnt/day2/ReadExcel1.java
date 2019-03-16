package in.lnt.day2;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel1 
{
	private static XSSFWorkbook book;

	public static void main(String[] args) throws Exception 
	{
		FileInputStream inFile = new FileInputStream("D:\\Book1.xlsx");
		book = new XSSFWorkbook(inFile);
		XSSFSheet sheet = book.getSheet("Sheet1");
		for(int i=0;i<=sheet.getLastRowNum();i++) 
		{
			String data = sheet.getRow(i).getCell(0).toString();
			System.out.print(data);
			String data2 = sheet.getRow(i).getCell(1).toString();
			System.out.println(data2);
		}
	}
}
