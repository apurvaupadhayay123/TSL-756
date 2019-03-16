package util;

public class Execute 
{
	public static void main(String[] args) 
	{
		Excel excel = new Excel("D:\\Book1.xlsx");
		
		System.out.println(excel.rowCount("Sheet1"));
		System.out.println(excel.cellCount("Sheet1", 2));
		System.out.println(excel.Read("Sheet1", 1, 1));
		System.out.println(excel.Read("Sheet1", 1, 0));
	}
}
