package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAssertionEx1 {
	@Test
	public void LoginWithValidUserNameAndValidPassword() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("s170776@rguktsklm.ac.in");
		driver.findElement(By.id("input-password")).sendKeys("Krish@143");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		/*when we launch the code output will be successful or not we identified with the some text after login successful.
		 * but client wants when test the code, when login the page output will be successful.
		 * this is the actually we want.
		 * for that we are using script but in the automation selenium we are using 
		 * 
		 * ASSERTION
		 * 1.Hard Assert and 2.Soft Assert
		 */
		String actualTest=driver.findElement(By.linkText("Edit your account information")).getText();
		String expectedTest="Edit your account information";
		Assert.assertEquals(actualTest, expectedTest);
		
		
		
	}

}
