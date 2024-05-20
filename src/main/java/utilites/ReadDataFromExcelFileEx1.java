package utilites;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadDataFromExcelFileEx1 {

	@Test
	public void readdata()
	{
		XSSFWorkbook wb=null;
		try {
			FileInputStream fis= new FileInputStream("C:\\Users\\janardhana gpl\\Desktop\\A M T Notes\\Material\\Book1.xlsx.xlsx");
			wb=new XSSFWorkbook(fis);
		}catch(IOException e) {
			e.printStackTrace();
	}
		XSSFSheet sheet = wb.getSheetAt(0);
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