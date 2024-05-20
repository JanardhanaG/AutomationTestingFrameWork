package testcaseIMP;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.RegAccountPage;
import pages.RegHomepage;
import pages.RegRegisterPage;

public class RegisterPageExtendsEX1 extends BaseClass{
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver=initializeBrowserAndLaunchApllication();
		RegHomepage regHomepage=new RegHomepage(driver);
		regHomepage.clickOnRegister();
		
	}
	@AfterMethod
	public void quit() throws Exception{
		Thread.sleep(3000);
		driver.quit();
		
	}
	//testcase1
	@Test
	public void validInformationAndRegister() {
		RegRegisterPage regRegisterPage=new RegRegisterPage(driver);
		
	
		
		regRegisterPage.enterFirstName(prop.getProperty("firstName"));
		regRegisterPage.enterLastName(prop.getProperty("lastName"));
		regRegisterPage.enterEmail(prop.getProperty("email"));
		regRegisterPage.enterTelephone(prop.getProperty("telephone"));
		regRegisterPage.enterPassword(prop.getProperty("enterpassword"));
		regRegisterPage.enterConfirmPassword(prop.getProperty("confirmPassword"));
		
		
		
		regRegisterPage.subscriptionNo();
		regRegisterPage.checkbox();
		regRegisterPage.clickOnSubmit();
		
		RegAccountPage regAccountPage=new RegAccountPage(driver);
		regAccountPage.accountRegistered();
		
		
	}
	//testcase2
	@Test
	public void registerWithWithoutAnyInformation() {
		RegRegisterPage regRegisterPage=new RegRegisterPage(driver);
		regRegisterPage.subscriptionNo();
		regRegisterPage.clickOnSubmit();
		
		RegAccountPage regAccountPage =new RegAccountPage(driver);
		regAccountPage.warningMessage();
		
		
		
	}
	//testcase3
	@Test
	public void registerWithSubscriptionYes() {
		RegRegisterPage regRegisterPage=new RegRegisterPage(driver);
		

		
		regRegisterPage.enterFirstName(prop.getProperty("firstName"));
		regRegisterPage.enterLastName(prop.getProperty("lastName"));
		regRegisterPage.enterEmail(prop.getProperty("email"));
		regRegisterPage.enterTelephone(prop.getProperty("telephone"));
		regRegisterPage.enterPassword(prop.getProperty("enterpassword"));
		regRegisterPage.enterConfirmPassword(prop.getProperty("confirmPassword"));
		
		regRegisterPage.subscriptionYes();
		regRegisterPage.checkbox();
		regRegisterPage.clickOnSubmit();

		RegAccountPage regAccountPage=new RegAccountPage(driver);
		regAccountPage.accountRegistered();
		
	}
	
}

