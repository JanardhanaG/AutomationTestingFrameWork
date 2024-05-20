package base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.j2objc.annotations.Property;

public class Base {
	WebDriver driver;
	Properties prop;
	
	
	public Base() {
		String propPath="C:\\Users\\janardhana gpl\\eclipse-workspace\\MavenFrameworkSelenium\\testData\\config.properties";
		prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream(propPath);
			prop.load(fis);
			System.out.println(prop.getProperty("browserName"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public WebDriver initializeBrowserAndLaunchAppllication() {
		
		String browserName=prop.getProperty("browserName");
		if(browserName.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("invalid Browser");
		}
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
	
	
	
}
}
