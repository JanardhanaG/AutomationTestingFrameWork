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

public class DependsOnMethodsEx1 {
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		String browser="chrome";
		if(browser.equals("chrome")){
			driver=new ChromeDriver();
			}
		else if(browser.equals("edge")) {
			driver=new EdgeDriver();
		}
		else {
			System.out.println("Invalid Browser----->  Thank you");
		}
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	@AfterMethod
	public void quit()throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
	//testcase1
	@Test
	public void searchWithValidProduct() {
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("hp");
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		
		String validresult=driver.findElement(By.xpath("//a[text()='HP LP3065']")).getText();
		Assert.assertTrue(validresult.contains("HP LP3065"));
	}
	//testcase2
	@Test
	public void searchWithInvalidProduct() {
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("foot ball");
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		
		String validresult=driver.findElement(By.xpath("//label[text()='Search Criteria']")).getText();
		Assert.assertTrue(validresult.contains(" gpl"));

	}
	//testcase3
	@Test(dependsOnMethods="searchWithInvalidProduct")
	public void donotsearchNothing() {
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		
		String validresult=driver.findElement(By.xpath("//label[text()='Search Criteria']")).getText();
		Assert.assertTrue(validresult.contains("Search Criteria"));
	}
	
	
	
}
