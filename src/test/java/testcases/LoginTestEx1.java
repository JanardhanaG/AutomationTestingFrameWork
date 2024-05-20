package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class LoginTestEx1 {
	//login Scenario
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
			
			
			
			
		}
	}
	