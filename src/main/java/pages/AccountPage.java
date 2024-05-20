package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountPage {
	WebDriver driver;
	public AccountPage(	WebDriver driver) {
		this.driver=driver;
	}
	public void verifySuccessfullyLoginMessage() {
		String actualTest =driver.findElement(By.xpath("//h2[text()='My Account']")).getText();
		Assert.assertTrue(actualTest.contains("My Account"));
	}

}
