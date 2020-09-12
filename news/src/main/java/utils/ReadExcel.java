package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	 //This class can be called by creating object ReadExcel excel = new ReadExcel("Path of Excel");
	//Path = C:\\Users\\namit\\Documents\\Linked in learning\\Eclipse\\news\\userInfo.xlsx
	//print (excel.getData(0,0,0));
	
	static FileInputStream fis;
	static XSSFWorkbook wb;
	XSSFSheet sheet1;
	
	public static void readExcel(String path) throws IOException
	{
		try {
			File src = new File(path);
			
			fis = new FileInputStream(src);
			
			wb = new XSSFWorkbook(fis); 
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getData(int sheet, int row, int column)
	{
		sheet1 = wb.getSheetAt(sheet);
		String data = sheet1.getRow(row).getCell(column).getStringCellValue();
		
		return data;
	}

}
