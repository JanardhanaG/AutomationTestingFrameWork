package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		
	}
	public void enterUserName(String userName) {
		driver.findElement(By.id("input-email")).sendKeys(userName);
	}
	public void enterPassword(String password) {
		driver.findElement(By.id("input-password")).sendKeys(password);
	}
	public void clickOnClick() {
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
	public void assertionAss() {
		String actualTest=driver.findElement(By.xpath("//div[text()='Warning: No match for E-Mail Address and/or Password.']")).getText();
		Assert.assertTrue(actualTest.contains("and/or Password."));
	}

}
