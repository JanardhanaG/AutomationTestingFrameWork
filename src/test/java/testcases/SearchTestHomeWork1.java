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

public class SearchTestHomeWork1 {
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
	}
	@AfterMethod
	public void quit() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
		
		
	//testcase1
   @Test(priority=1)
	public void availableProduct() {
		
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("HP");
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		String successResult=driver.findElement(By.linkText("HP LP3065")).getText();
		Assert.assertTrue(successResult.contains("HP LP3065"));
		
	}
   //testcase2
   @Test(priority=2)
  	public void productNotAvailable() {
  		
  		
  		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("cricketbat");
  		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
  		String successResult=driver.findElement(By.xpath("//label[text()='Search Criteria']")).getText();
  		Assert.assertTrue(successResult.contains("Search Criteria"));
   
}
   //testcase3
   @Test(priority=3)
   public void donotSearchAnyThing() {
	   
 		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
 		String successResult=driver.findElement(By.xpath("//label[text()='Search Criteria']")).getText();
  		Assert.assertTrue(successResult.contains("Search Criteria"));
   }
   }
