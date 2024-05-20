package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Login4TestCasesEX1 {
	WebDriver driver;
	
	@BeforeMethod
public  void setup() {
	String browserName="Chrome";
	if(browserName.equals("Chrome")){
		driver=new ChromeDriver();
	}
		else if(browserName.equals("firefox")){
			driver=new FirefoxDriver();
		
	}
		else if(browserName.equals("edge")) {
			driver=new EdgeDriver();
		}
		else {
			System.out.println("invalid browser ----thank you");
		}
	driver.get("https://tutorialsninja.com/demo/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.findElement(By.xpath(("//span[text()='My Account']"))).click();
     driver.findElement(By.linkText("Login")).click();
	
}
	@AfterMethod
	public void aftermethod() throws Exception {
		Thread.sleep(4000);
		
		driver.quit();
}
	
	//TestCase1
	@Test(priority=1)
	public void loginWithValidUserNameAndValidPassword() {
			
			driver.findElement(By.id("input-email")).sendKeys("s170776@rguktsklm.ac.in");
			driver.findElement(By.id("input-password")).sendKeys("Krish@143");
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			//Assertion
			String actualTest =driver.findElement(By.xpath("//h2[text()='My Account']")).getText();
			Assert.assertTrue(actualTest.contains("My Account"));
			 
			}
	//TestCase2
	@Test(priority=2)
	public void loginWithInvalidUserNameAndValidPassword() {
		
		driver.findElement(By.id("input-email")).sendKeys("s170776rguktsklm.ac.in");
		driver.findElement(By.id("input-password")).sendKeys("Krish@143");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String outputscene=driver.findElement(By.xpath("//div[text()='Warning: No match for E-Mail Address and/or Password.']")).getText();
	    Assert.assertTrue(outputscene.contains("and/or Password."));
				}
	//TestCase3
	@Test(priority=3)
	public void loginWithValidUserNameAndInvalidPassword()throws Exception {
		
		
		driver.findElement(By.id("input-email")).sendKeys("s170776@rguktsklm.ac.in");
		driver.findElement(By.id("input-password")).sendKeys("Krish143");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String actualTest=driver.findElement(By.xpath("//div[text()='Warning: No match for E-Mail Address and/or Password.']")).getText();
		Assert.assertTrue(actualTest.contains("and/or Password."));
	}
	//TestCase4
	@Test(priority=4)
	public void loginWithWithOutUserNameANdPassword() {
		
		//driver.findElement(By.id("input-email")).sendKeys("s170776@rguktsklm.ac.in");
		//driver.findElement(By.id("input-password")).sendKeys("Krish143");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String actualTest=driver.findElement(By.xpath("//div[text()='Warning: No match for E-Mail Address and/or Password.']")).getText();
		Assert.assertTrue(actualTest.contains("and/or Password."));
	}
	}
	


