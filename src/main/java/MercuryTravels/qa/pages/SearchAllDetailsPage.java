package MercuryTravels.qa.pages;

import MercuryTravels.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SearchAllDetailsPage extends TestBase {

    @FindBy(xpath="//input[@class=\"form-control \"]")
    WebElement selectDate;
    @FindBy(xpath = "(//div[@class = 'datepicker-days']/table/thead/tr[1]/th[3])[3]")
    WebElement clickOnNextTab;
    @FindBy(xpath = "//td[@class = 'day  old']")
    WebElement selectDateOfJourney;
    @FindBy(xpath = "(//td[@class = 'day  active'])[4]")
    WebElement selectReturnDate;
    @FindBy(xpath="//input[@name = 'fromCity']")
    WebElement fromCity;
    @FindBy(xpath = "//input[@name = 'toCity']")
    WebElement toCity;
    @FindBy(xpath = "//li[@class=\"ui-menu-item\"][1]")
    WebElement selectFromCity;
    @FindBy(xpath = "//ul[@id='ui-id-8']/li[@class=\"ui-menu-item\"][1]")
    WebElement selectToCity;
    @FindBy(xpath = "//button[@id = 'searchFlightsBtn']")
    WebElement clickOnSearFlight;
    @FindBy(xpath = "//div[@id=\"result\"]/div[1]/div[2]/div[1]/a")
    WebElement flightDetails;
    @FindBy(xpath = "//div[@id='itinerary']/div[1]/div[1]/p")
    WebElement flightName;
    @FindBy(xpath = "//div[@id='itinerary']/div[1]/div[1]/p")
    WebElement flightCode;  
    @FindBy(xpath = "//div[@id='itinerary']/div[1]/div[2]/p[2]/strong")
    WebElement startTime;
    @FindBy(xpath = "//div[@id='itinerary']/div[1]/div[4]/p[2]/strong")
    WebElement endTime;
    @FindBy(xpath = "//div[@id=\"my_jcarousel\"]/ul/li[2]/label/span")
    WebElement selectFlightName;
    @FindBy(xpath = "//div[@id=\"my_jcarousel\"]/ul/li[1]/label/span")
    WebElement validateFlightDetails;
    @FindBy(xpath = "//button[text() = 'Book Now']")
    WebElement validateBookingNow;
    @FindBy(xpath = "//div[text() = 'Sorry, there are no flights available for this search. Please make another search']")
    WebElement checkFlightAvailability;
    @FindBy(xpath = "//select[@id=\"Childs\"]")
    WebElement clickOnChildSeat;
    @FindBy(xpath = "//select[@id=\"Childs\"]/option[2]")
    WebElement selectSeat;
    @FindBy(xpath = "//div[text() = 'Passengers: 1 Adult(s), 1 Child(ren), 0 Infant(s)']")
    WebElement checkSeatDetails;
    @FindBy(xpath = "//input[@data-date-format='dd/mm/yyyy' and @name='departDate']")
    WebElement departDateformat;
    @FindBy(xpath = "//input[@data-date-format='dd/mm/yyyy' and @name='returnDate']")
    WebElement returnDateformat;    
  
  

    public SearchAllDetailsPage(){
        PageFactory.initElements(driver, this);
    }


    public void selectDepartureDate() {
        Reporter.log("Select date, The date format in dd/mm/yyyy");
        selectDate.click();
        clickOnNextTab.click();
        clickOnNextTab.click();
        selectDateOfJourney.click();
        selectReturnDate.click();
    }

    public boolean validateDepartureDateFormat() {
        try {
        	departDateformat.isDisplayed();            	 
                return true;
            } catch (Exception e) {
            	Reporter.log("Return date format is invalid");
                return false;
            }
    }
    
    public boolean validateReturnDateFormat() {
        try {
        	returnDateformat.isDisplayed();            	 
           return true;
       } catch (Exception e) {
       	Reporter.log("Return date format is invalid");
          return false;
       }
}

    public void selectFromToCity() throws InterruptedException {
        fromCity.sendKeys("Delhi");
        Reporter.log("The Boarding city is Delhi");
        selectFromCity.click();
        Thread.sleep(5);
        toCity.sendKeys("GOA");
        Reporter.log("The Destination city is GOA");
        selectToCity.click();
    }

    public void selectCityName() {
        fromCity.sendKeys("DEL");
        Reporter.log("The Boarding city is Delhi");
        selectFromCity.click();
    }
    public void selectFromCityName() {
        toCity.sendKeys("MUM");
        Reporter.log("The Destination city is GOA");
        selectToCity.click();

    }
    public void clickOnSearchButton() throws InterruptedException {
        Thread.sleep(5000);
        clickOnSearFlight.click();
    }
    public void clickOnFlightDetails() {
        flightDetails.click();
    }
    public boolean validateFlightDetails() {
        return flightName.isDisplayed();        
    }
    public boolean validateflightCode() {
        return flightCode.isDisplayed();        
    }   
    
    public boolean validateStartAndEndTime() {
        startTime.isDisplayed();
        endTime.isDisplayed();
        return true;
    }
    public void clickOnNewFlight() {
        selectFlightName.click();
    }
    public boolean validateTheFlightDetails() {
        return validateFlightDetails.isDisplayed();        
    }

    public boolean validateBookingButton() {
        return validateBookingNow.isEnabled();        
    }

    public String validateFlightAvailability() {
        return checkFlightAvailability.getText();
    }

    public void selectChildSeat() {
        clickOnChildSeat.click();
        selectSeat.click();
    }

    public String validateSeatDetails() {
        return checkSeatDetails.getText();
    }
}
