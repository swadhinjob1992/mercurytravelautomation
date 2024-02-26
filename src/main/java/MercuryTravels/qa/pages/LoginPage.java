package MercuryTravels.qa.pages;

import com.relevantcodes.extentreports.ExtentReports;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MercuryTravels.qa.base.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage extends TestBase{

	Logger logger =  LoggerFactory.getLogger(LoginPage.class);

	@FindBy(xpath="//input[@id=\"sign_user_email\"]")
	WebElement username;	
	@FindBy(xpath="//input[@id=\"sign_user_password\"]")
	WebElement password;
	@FindBy(xpath = "(//a[text() = 'Welcome, Mohit '])[2]")
	WebElement validateCustomerLoginDetails;
	@FindBy(xpath="//ul[@class = 'nav navbar-nav navbar-right margin-right-logo']/li/a/i")
	WebElement customerLogin;
	@FindBy(xpath = "//ul[@class = 'nav navbar-nav navbar-right margin-right-logo']/li/ul/li[1]/a")
	WebElement userLogin;
	@FindBy(xpath = "//*[@id=\"modalLogin\"]/div/div/div[2]/form/button")
	WebElement clickOnLogIn;
	@FindBy(xpath = "//li[text() = 'This value should be a valid email.']")
	WebElement validateErrorEmail;
	@FindBy(xpath = "//div[text()='Incorrect email address and password combination. Please try again.']")
	WebElement validateErrorMessage;
	@FindBy(xpath = "//input[@id='sign_user_email']/../ul[1]/li")
	WebElement validateEmptyUserName;	
	@FindBy(xpath = "//input[@id='sign_user_password']/../ul[1]/li")
	WebElement validateEmptyPassword;

	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle(){
		return driver.getTitle();
	}

	public void LogINPage() {
		Actions actions = new Actions(driver);
		actions.moveToElement(customerLogin);
		actions.perform();
		userLogin.click();
	}
	public void ClickOnLoginButton() {
		clickOnLogIn.click();
		Reporter.log("Click on loginButton");
	}

	public void enterValidUsernameAndValidPassword(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		Reporter.log("Using valid username and valid password, Validate Successfully");
	}

	public String validateLoginDetails() throws InterruptedException {
		Thread.sleep(5000);
		return validateCustomerLoginDetails.getText();
	}

	public void validateEmailErrorMessage(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		ClickOnLoginButton();
		Reporter.log("Successfully Validate the  email error message");
	}
	public String validateEmailErrorMessage() {
		return validateErrorEmail.getText();
	}

	public void validatePasswordErrorMessage(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		ClickOnLoginButton();
		validateErrorMessage.isDisplayed();
		Reporter.log("Successfully Validate the  password error message");
	}
	public boolean validatePasswordErrorMessage() throws InterruptedException {
		Thread.sleep(5000);
		return validateErrorMessage.isDisplayed();

	}
	
	public String getEmptyUserNameError() {
		return validateEmptyUserName.getText();
	}
	
	public String getEmptyPasswordError() {
		return validateEmptyPassword.getText();
	}
}
