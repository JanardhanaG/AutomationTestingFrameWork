package utilites;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadDataFromPropertiesFileAndExcelFileEx1 {
	
	@Test
	public void readDataFromPropertiesFile()throws IOException {
		String propPath="C:\\\\Users\\\\janardhana gpl\\\\Desktop\\\\A M T Notes\\\\Material\\\\ExcelFiles\\\\config.properties.txt";
		FileInputStream fis =new FileInputStream(propPath);
		Properties prop =new Properties();
		prop.load(fis);	
		System.out.println(prop.getProperty("browserName"));
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("Username"));
		System.out.println(prop.getProperty("password"));
	}
	@Test
	public void readDataFromExcelFile() {
		XSSFWorkbook wb=null;
		try {
			FileInputStream fis =new FileInputStream("C:\\\\Users\\\\janardhana gpl\\\\Desktop\\\\A M T Notes\\\\Material\\\\Book1.xlsx.xlsx");
			wb=new XSSFWorkbook(fis);
		}
		catch(IOException e) {
			e.printStackTrace();
			
		}
		XSSFSheet sheet=wb.getSheetAt(0);
		int rowCount=sheet.getLastRowNum();
		int colCount=sheet.getRow(0).getLastCellNum();
		for(int i=0;i<rowCount;i++) {
			XSSFRow row=sheet.getRow(i++);
			for(int j=0;j<colCount;j++) {
				XSSFCell cell=row.getCell(j);
				switch(cell.getCellType()) {
				case STRING:System.out.print(cell.getStringCellValue());
				break;
				case NUMERIC:System.out.println(cell.getNumericCellValue());
				break;
				}
				System.out.print("  |  ");
			}
			System.out.println();
		}
		
		
	}

}
