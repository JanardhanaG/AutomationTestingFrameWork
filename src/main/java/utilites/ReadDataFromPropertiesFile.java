package utilites;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadDataFromPropertiesFile {
	@Test
	public void readDatafromPropertiesFiles() throws IOException {
		String propPath="C:\\Users\\janardhana gpl\\Desktop\\A M T Notes\\Material\\ExcelFiles\\config.properties.txt";
		FileInputStream fis=new FileInputStream(propPath);
		Properties prop=new Properties();
		prop.load(fis);
		System.out.println(prop.getProperty("browserName"));
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
		
	}

}
