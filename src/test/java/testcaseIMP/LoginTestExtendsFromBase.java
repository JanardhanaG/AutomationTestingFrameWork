package testcaseIMP;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

//just sample for local git repo to main Git repo

public class LoginTestExtendsFromBase extends BaseClass{
	WebDriver driver;
	
	
	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndLaunchApllication();
		HomePage homepage =new HomePage(driver);
		homepage.clickOnMyAccount();
		homepage.selectLogin();
		
	}
	

	@AfterMethod
	public void quitBrowser() throws Exception{
		Thread.sleep(2000);
		driver.quit();
		
	}
	//testCase1
	@Test
	public void loginWithValidUserNameAndPassword()throws InterruptedException {
		
		LoginPage loginPage=new LoginPage(driver);
	    loginPage.enterUserName(prop.getProperty("userName"));
		loginPage.enterPassword(prop.getProperty("password"));
		loginPage.clickOnClick();
		
		AccountPage accountPage=new AccountPage(driver);
		accountPage.verifySuccessfullyLoginMessage();
		
	}
	//testcase2
	@Test
	public void loginWithValidUserNameAndInvalidPAssword() throws InterruptedException{
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUserName(prop.getProperty("userName"));
		loginPage.enterPassword(prop.getProperty("incorrectPassword"));
		loginPage.clickOnClick();
		
		LoginPage loginPage1=new LoginPage(driver);
		loginPage1.assertionAss();
	}
			
		
		
	//testcase3	
	@Test
	public void loginWithInvalidUserNameAndValidPassword()throws InterruptedException {
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUserName(prop.getProperty("incorrectUserName"));
		loginPage.enterPassword(prop.getProperty("password"));
		loginPage.clickOnClick();
		
		LoginPage loginPage1=new LoginPage(driver);
		loginPage1.assertionAss();
		
		
		
	}
	//testcase4
	@Test
	public void loginWithoutUserNameAndPAssword()throws InterruptedException {
		LoginPage loginPage=new LoginPage(driver);
		loginPage.clickOnClick();
	
		LoginPage loginPage1=new LoginPage(driver);
		loginPage1.assertionAss();
		
		
	}
	

}
