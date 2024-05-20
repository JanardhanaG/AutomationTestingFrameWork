package utilites;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class UtilitiesEx1 {
	public static void main(String[] args) {
		
	
		
	
		//how to read data from excel file?
		//step1 path
		//C:\Users\janardhana gpl\Desktop\A M T Notes\Material\ExcelFiles
		
		//step2 open WorkBook
		//in workBook there are two workBooks are there 1.XSS WorkBook 2.HSS WorkBook
		//xtendsd spread sheet //Horrible Spread Sheet  we are usually using XSS workBook
		
		//step3 openSheet
		//ste4 read ROWS
		//Step5 read columns
		//step6 read cell
		//step7 print cell data
		String path="C:\\Users\\janardhana gpl\\Desktop\\A M T Notes\\Material\\ExcelFiles\\Book2.xlsx";
		 XSSFWorkbook wbook=null;
		try {
			FileInputStream fis=new FileInputStream(path);
			   wbook =new XSSFWorkbook(fis);
			  
			
		}catch(IOException e) {
			
			e.printStackTrace();
		}
		XSSFSheet sheet=wbook.getSheetAt(0);
		int rowCount=sheet.getLastRowNum();
		int colCount=sheet.getRow(0).getLastCellNum();
		for(int i=0;i<rowCount;i++) {
			XSSFRow row=sheet.getRow(i+1);
			for(int j=0;j<colCount;j++) {
				XSSFCell cell=row.getCell(j);
				
			switch(cell.getCellType()) {
			case STRING: System.out.print(cell.getStringCellValue());
			break;
			case NUMERIC:System.out.print(cell.getNumericCellValue());
			break;
			
			}
			System.out.print("  |  ");
			}
			System.out.println();
			
		}
		
		
		
			}
		
		
	}


