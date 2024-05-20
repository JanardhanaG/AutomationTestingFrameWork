package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTestCasesEx1 {
	WebDriver driver;
	
	
	
	@BeforeMethod
	public void setup() {
		
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
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
	}
	@AfterMethod
	public void quit() throws Exception{
		Thread.sleep(3000);
		driver.quit();
		
	}
	//testcase1
	@Test
	public void validInformationAndRegister() {
		driver.findElement(By.id("input-firstname")).sendKeys("Janardhana");
		driver.findElement(By.id("input-lastname")).sendKeys("gpl");
		driver.findElement(By.id("input-email")).sendKeys("s170776@rguktsklm.ac.in");
		driver.findElement(By.id("input-telephone")).sendKeys("7901045793");
		driver.findElement(By.id("input-password")).sendKeys("Krish@143");
		driver.findElement(By.id("input-confirm")).sendKeys("Krish@143");
		driver.findElement(By.xpath("//input[@value='0']")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String actualTest= driver.findElement(By.xpath("//div[text()='Warning: E-Mail Address is already registered!']")).getText();
		String expectedTest="Warning: E-Mail Address is already registered!";
		Assert.assertEquals(actualTest, expectedTest);
	}
	//testcase2
	@Test
	public void registerWithWithoutAnyInformation() {
		driver.findElement(By.xpath("//input[@value='0']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String warningScene= driver.findElement(By.xpath("//h1[text()='Register Account']")).getText();
		Assert.assertTrue(warningScene.contains("Register Account"));
	}
	//testcase3
	@Test
	public void registerWithSubscriptionYes() {
		driver.findElement(By.id("input-firstname")).sendKeys("Janardhana");
		driver.findElement(By.id("input-lastname")).sendKeys("gpl");
		driver.findElement(By.id("input-email")).sendKeys("s170776@rguktsklm.ac.in");
		driver.findElement(By.id("input-telephone")).sendKeys("7901045793");
		driver.findElement(By.id("input-password")).sendKeys("Krish@143");
		driver.findElement(By.id("input-confirm")).sendKeys("Krish@143");
		driver.findElement(By.name("newsletter")).click(); 
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String registerSuccess=driver.findElement(By.linkText("login page")).getText();
		Assert.assertTrue(registerSuccess.contains("login page"));
	}
	

}
