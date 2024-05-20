package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegRegisterPage {
	 public WebDriver driver;
	public RegRegisterPage(WebDriver driver) {
		this.driver=driver;
	}
	/*public void registerDetais() {
		driver.findElement(By.id("input-firstname")).sendKeys("Janardhana");
		driver.findElement(By.id("input-lastname")).sendKeys("gpl");
		driver.findElement(By.id("input-email")).sendKeys("s170776@rguktsklm.ac.in");
		driver.findElement(By.id("input-telephone")).sendKeys("7901045793");
		driver.findElement(By.id("input-password")).sendKeys("Krish@143");
		driver.findElement(By.id("input-confirm")).sendKeys("Krish@143");
		
}
*/
	public void enterFirstName(String firstNamee) {
		driver.findElement(By.id("input-firstname")).sendKeys(firstNamee);
	}
	public void enterLastName(String lastNamee) {
		driver.findElement(By.id("input-lastname")).sendKeys(lastNamee);
	}
	public void enterEmail(String emaill) {
		driver.findElement(By.id("input-email")).sendKeys(emaill);
	}
	public void enterTelephone(String telephonee) {
		driver.findElement(By.id("input-telephone")).sendKeys(telephonee);
	}
	public void enterPassword(String enterpasswordd) {
		driver.findElement(By.id("input-password")).sendKeys(enterpasswordd);
	}
	public void enterConfirmPassword(String confirmPasswordd) {
		driver.findElement(By.id("input-confirm")).sendKeys(confirmPasswordd);
	}
	
	
	public void subscriptionNo() {
		driver.findElement(By.xpath("//input[@value='0']")).click();
	}
	public void subscriptionYes() {
		driver.findElement(By.name("newsletter")).click(); 
	}

	public void checkbox() {
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	}
	public void clickOnSubmit() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	}
	

