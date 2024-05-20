package base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseClass {
	 public WebDriver driver;
	 public Properties prop;

	
	public BaseClass() {
		//String propPath="C:\\\\Users\\\\janardhana gpl\\\\eclipse-workspace\\\\MavenFrameworkSelenium\\\\testData\\\\config.properties.txt";
		//String proppath= "C:\\Users\\janardhana gpl\\eclipse-workspace\\MavenFrameworkSelenium\\testData\\config.properties.txt";
		String propPath="C:\\Users\\janardhana gpl\\Desktop\\A M T Notes\\Material\\ExcelFiles\\config.properties.txt";
		prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream(propPath);
			prop.load(fis);
			System.out.println(prop.getProperty("browserName"));
			}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public WebDriver initializeBrowserAndLaunchApllication() {
		String browser="chrome";
		
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equals("edge")) {
			driver= new EdgeDriver();
		}
		else{
			System.out.println("invalid browser ----> thank you ");
			
		}
		
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//driver.findElement(By.xpath("//span[text()='My Account']")).click();
		//driver.findElement(By.linkText("Register")).click();
		return driver;
	}
	}


