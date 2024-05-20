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

public class RegisterTestCases {
	public class RegisterTest {

		WebDriver driver;//global variable declaration
			
			@BeforeMethod
			public void setup() {
				
				String browserName = "chrome";
				
				if(browserName.equals("chrome")) {
					driver = new ChromeDriver();
				}
				else if(browserName.equals("firefox")) {
					driver = new FirefoxDriver();
				}
				else if(browserName.equals("edge")) {
					driver = new EdgeDriver();
				}
				else {
					System.out.println("Invalid browser Thank you..!!");
				}
				
				driver.get("https://tutorialsninja.com/demo/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.findElement(By.xpath("//span[text()='My Account']")).click();
				driver.findElement(By.linkText("Register")).click();
			}
			
			@AfterMethod
			public void quitBrowser() throws InterruptedException {
				Thread.sleep(3000);
				driver.quit();
			}
			
			//TC-1
			@Test(priority=1)
			public void registerWithAllMandatoryDetail() {
				
				driver.findElement(By.id("input-firstname")).sendKeys("janardhnaa");
				driver.findElement(By.id("input-lastname")).sendKeys("gpl");
				driver.findElement(By.id("input-email")).sendKeys("jan@gmail.com");
				driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
				driver.findElement(By.id("input-password")).sendKeys("Password@123");
				driver.findElement(By.id("input-confirm")).sendKeys("Password@123");
				driver.findElement(By.xpath("//input[@type='checkbox']")).click(); //privacy policy
				
				driver.findElement(By.xpath("//input[@value='Continue']")).click();
				
				String registerSuccessText = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
				Assert.assertTrue(registerSuccessText.contains("dismissible"));	
			}
			
			//TC-2
			@Test(priority=2)
			public void registerWithoutProvidingAnyDetail() {
				driver.findElement(By.xpath("//input[@value='Continue']")).click();//clicks on continue botton
				
				String registerWarningText = driver.findElement(By.xpath("//div[text()='Warning: You must agree to the Privacy Policy!']")).getText();
				Assert.assertTrue(registerWarningText.contains("Warning"));
			}
			
			//TC-3
			@Test(priority=3)
			public void registerWithAllDetailAndSubscriptionYes() {
				driver.findElement(By.id("input-firstname")).sendKeys("janardhana");
				driver.findElement(By.id("input-lastname")).sendKeys("gpl");
				driver.findElement(By.id("input-email")).sendKeys("jan@gmail.com");
				driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
				driver.findElement(By.id("input-password")).sendKeys("Password@123");
				driver.findElement(By.id("input-confirm")).sendKeys("Password@123");
				
				//select newsletter subscription
				driver.findElement(By.name("newsletter")).click();
				driver.findElement(By.xpath("//input[@type='checkbox']")).click(); //privacy policy
				driver.findElement(By.xpath("//input[@value='Continue']")).click();//clicks on continue botton
				
				String registerSuccessText = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
				Assert.assertTrue(registerSuccessText.contains("dismissible"));	
			}
			
			
			
		}

}
