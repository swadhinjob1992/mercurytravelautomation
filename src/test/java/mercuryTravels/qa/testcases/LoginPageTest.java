package mercuryTravels.qa.testcases;

import MercuryTravels.qa.pages.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import MercuryTravels.qa.base.TestBase;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(description = "Verify login page tittle")
	public void loginPageTitleTest(){
		Reporter.log("Test Start-> Validate Login page tittle");
		Reporter.log("Browser lunch successfully");
		String title = loginPage.validateLoginPageTitle();
		Reporter.log("Validate the tittle of the login page");
		Assert.assertEquals(title, "Flight Booking - Book Airticket, Flight Ticket Online at Mercury Travels");
		Reporter.log("Test Complete-> The login page tittle has been successfully validate");
	}

	@Test(description= "Home page login")
	public void loginPageTest()  {
		Reporter.log("Test Start->Launch Home page");
		loginPage.LogINPage();
		Reporter.log("The Home page was Launch Successfully");
	}

	@Test(description ="Enter ValidUsername and password, and verify that they are appearing correctly")
	public void validUsernameAndValidPassword() throws InterruptedException {
		Reporter.log("Test Start->Enter ValidUsername and ValidPassword, and verify that they are appearing correctly");
		loginPage.LogINPage();
		Reporter.log("Enter valid username");
		String username = prop.getProperty("username");
		Reporter.log("Enter valid password");
		String password=prop.getProperty("password");
		loginPage.enterValidUsernameAndValidPassword(username,password);
		loginPage.ClickOnLoginButton();
		Assert.assertEquals(loginPage.validateLoginDetails(),"Welcome, Mohit");
		Reporter.log("Test Completed with ValidUsername and ValidPassword");
	}

	@Test(description ="Enter InvalidUsername and validPassword, and verify that they are appearing correctly")
	public void invalidUsername()  {
		Reporter.log("Test Start->Enter InvalidUsername and validPassword, and verify that they are appearing correctly");
		loginPage.LogINPage();
		Reporter.log("Enter Invalid username");
		String username = prop.getProperty("invalidUsername");
		Reporter.log("Enter valid password");
		String password=prop.getProperty("validPassword");
		loginPage.validateEmailErrorMessage(username,password);
		Assert.assertEquals(loginPage.validateEmailErrorMessage() ,"This value should be a valid email.");
		Reporter.log("Test Completed with InvalidUsername and ValidPassword");
	}

	@Test(description ="Enter ValidUsername and InvalidPassword, and verify that they are appearing correctly")
	public void invalidPassword() throws InterruptedException  {
		Reporter.log("Test Start->Enter ValidUsername and InvalidPassword, and verify that they are appearing correctly");
		loginPage.LogINPage();
		Reporter.log("Enter valid username");
		String username = prop.getProperty("validUsername");
		Reporter.log("Enter Invalid password");
		String password=prop.getProperty("invalidPassword");
		loginPage.validatePasswordErrorMessage(username,password);
		Assert.assertTrue(loginPage.validatePasswordErrorMessage());
		Reporter.log("Test Completed with ValidUsername and InValidPassword");
	}

	
	@Test(description ="Check whether the page is possible to login without providing the user with any details")
	public void loginWithoutAnyDetails()  {
		Reporter.log("Test Start->Check whether the page is possible to login without providing the user with any details");
		loginPage.LogINPage();
		Reporter.log("Do not Enter any Username");
		Reporter.log("Do not Enter any Password");
		loginPage.ClickOnLoginButton();		
		Assert.assertEquals(loginPage.getEmptyUserNameError(),"This value is required.");
		Assert.assertEquals(loginPage.getEmptyPasswordError(),"This value is required.");
		Reporter.log("Error messsage displyed as This value is required");
		Reporter.log("Test Completed with EmptyUsername and EmptyPassword");
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
		Reporter.log("Close the browser");
	}
}
