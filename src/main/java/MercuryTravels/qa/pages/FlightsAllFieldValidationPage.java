package MercuryTravels.qa.pages;

import MercuryTravels.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class FlightsAllFieldValidationPage extends TestBase {

    @FindBy(xpath="//input[@name = 'fromCity']")
    WebElement fromCity;
    @FindBy(xpath = "//input[@name = 'toCity']")
    WebElement toCity;
    @FindBy(xpath = "//li[@class=\"ui-menu-item\"][1]")
    WebElement selectFromCity;
    @FindBy(xpath = "//ul[@id='ui-id-8']/li[@class=\"ui-menu-item\"][1]")
    WebElement selectToCity;
    @FindBy(xpath = "//div[@id=\"result\"]/div[1]/div[1]/div/div[3]/span")
    WebElement priceDetails;


    public FlightsAllFieldValidationPage(){
        PageFactory.initElements(driver, this);
    }

    public boolean validateBoardingPlace() {
        fromCity.sendKeys("Delhi");
        Reporter.log("Select Boarding place");
        selectFromCity.isDisplayed();
        Reporter.log("The Boarding place has been selected");
        return true;
    }
    public boolean validateDestination() {
        toCity.sendKeys("GOA");
        Reporter.log("Select destination place");
        selectToCity.isDisplayed();
        Reporter.log("The Destination place has been selected");
        return true;        
    }

    public boolean validatePriceDetails() {
       return priceDetails.isDisplayed();
    }
}
