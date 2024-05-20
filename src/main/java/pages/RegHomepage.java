package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegHomepage {
	WebDriver driver;
	public RegHomepage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void clickOnRegister() {
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
	}

}
