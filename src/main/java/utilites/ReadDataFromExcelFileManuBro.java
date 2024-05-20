package utilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcelFileManuBro {
	
		
		public static void main(String[] args) throws Throwable {
			XSSFWorkbook wb=null;
			
			//String path = "C:\\Users\\Dell\\OneDrive\\Desktop\\AutomationSelenium\\New folder\\Selenium.xlsx";
		
			
			try {
				FileInputStream fis = new FileInputStream("C:\\Users\\janardhana gpl\\Desktop\\A M T Notes\\Material\\ExcelFiles\\Book1.xlsx.xlsx");
				wb = new XSSFWorkbook(fis);
			} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			XSSFSheet  sheet = wb.getSheetAt(0);
			
			int rowcount = sheet.getLastRowNum();
			int colcount = sheet.getRow(0).getLastCellNum();
			
			for(int i=0;i<rowcount;i++) {
				XSSFRow row = sheet.getRow(i+1);
				
				for(int j=0;j<colcount;j++) {
					XSSFCell cell= row.getCell(j);
					
					switch(cell.getCellType()) {
					case STRING:System.out.print(cell.getStringCellValue());
					
					 break;
					 
					case NUMERIC:System.out.print(cell.getNumericCellValue());
					break;
					}
					
					System.out.print("  |   ");
				}
				System.out.println("");
			}
			
			
		}

	}


