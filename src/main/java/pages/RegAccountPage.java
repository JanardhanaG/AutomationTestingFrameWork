package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class  RegAccountPage{
	  public WebDriver driver;
	
	
	public  RegAccountPage(WebDriver driver) {
		this.driver=driver;
	}
	public void accountRegistered() {
		String actualTest= driver.findElement(By.xpath("//div[text()='Warning: E-Mail Address is already registered!']")).getText();
		String expectedTest="Warning: E-Mail Address is already registered!";
		Assert.assertEquals(actualTest, expectedTest);
		
	}
	public void warningMessage() {
		String warningScene= driver.findElement(By.xpath("//h1[text()='Register Account']")).getText();
	    Assert.assertTrue(warningScene.contains("Register Account"));
	}
	public void accountSuccess() {
		String registerSuccess=driver.findElement(By.linkText("login page")).getText();
		Assert.assertTrue(registerSuccess.contains("login page"));
	}

}
