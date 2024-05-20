package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;


public class LoginTestExtendsFromBase extends BaseClass{
	WebDriver driver;
	LoginTestExtendsFromBase(){
		super();
	}
	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndLaunchApllication();
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
	}
	
	@AfterMethod
	public void quitBrowser() throws Exception{
		Thread.sleep(2000);
		driver.quit();
		
	}
	//testCase1
	@Test
	public void loginWithValidUserNameAndPassword() {
		driver.findElement(By.id("input-email")).sendKeys("s170776@rguktsklm.ac.in");
		driver.findElement(By.id("input-password")).sendKeys("Krish@143");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		//Assertion
		String actualTest =driver.findElement(By.xpath("//h2[text()='My Account']")).getText();
		Assert.assertTrue(actualTest.contains("My Account"));
		
	}
	//testcase2
	@Test
	public void loginWithValidUserNameAndInvalidPAssword() {
		driver.findElement(By.id("input-email")).sendKeys("s170776@rguktsklm.ac.in");
		driver.findElement(By.id("input-password")).sendKeys("Krish143");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String actualTest=driver.findElement(By.xpath("//div[text()='Warning: No match for E-Mail Address and/or Password.']")).getText();
		Assert.assertTrue(actualTest.contains("and/or Password."));
	}
	//testcase3
	@Test
	public void loginWithInvalidUserNameAndValidPassword() {
		driver.findElement(By.id("input-email")).sendKeys("s170776rguktsklm.ac.in");
		driver.findElement(By.id("input-password")).sendKeys("Krish@143");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String outputscene=driver.findElement(By.xpath("//div[text()='Warning: No match for E-Mail Address and/or Password.']")).getText();
	    Assert.assertTrue(outputscene.contains("and/or Password."));
		
	}
	//testcase4
	@Test
	public void loginWithoutUserNameAndPAssword() {
driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String actualTest=driver.findElement(By.xpath("//div[text()='Warning: No match for E-Mail Address and/or Password.']")).getText();
		Assert.assertTrue(actualTest.contains("and/or Password."));
	}
	

}
