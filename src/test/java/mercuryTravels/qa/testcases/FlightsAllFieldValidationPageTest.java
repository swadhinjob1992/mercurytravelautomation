package mercuryTravels.qa.testcases;

import MercuryTravels.qa.base.TestBase;
import MercuryTravels.qa.pages.FlightsAllFieldValidationPage;
import MercuryTravels.qa.pages.SearchAllDetailsPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FlightsAllFieldValidationPageTest extends TestBase {

    FlightsAllFieldValidationPage flightsAllFieldValidationPage;
    SearchAllDetailsPage searchAllDetailsPage;

    public FlightsAllFieldValidationPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        flightsAllFieldValidationPage = new FlightsAllFieldValidationPage();
        searchAllDetailsPage = new SearchAllDetailsPage();
    }

    @Test(description = "Validate Boarding Place and Destination PLace")
    public void validateFlightField() {
        Reporter.log("Test Start->Select Boarding place and Destination place");;
        Assert.assertTrue(flightsAllFieldValidationPage.validateBoardingPlace());
        Reporter.log("Boarding place is validate successfully");
        Assert.assertTrue(flightsAllFieldValidationPage.validateDestination());
        Reporter.log("Destination place is validate successfully");
        Reporter.log("Test complete-> Successfully validate the Boarding place details and Destination place details");
    }

    @Test(description = "Validate seat price details")
    public void validateDifferentTypeOfSeat() throws InterruptedException {
        Reporter.log("Test Start->Validate seat price details");
        searchAllDetailsPage.selectFromToCity();
        searchAllDetailsPage.selectDepartureDate();
        Reporter.log("The date format is dd/mm/yyyy successfully validate");
        Reporter.log("Click On Search Button");
        searchAllDetailsPage.clickOnSearchButton();
        Reporter.log("Validate actual price details");
        Assert.assertTrue(flightsAllFieldValidationPage.validatePriceDetails());
        Reporter.log("Test complete->Validate the price details successfully");
    }

    @AfterMethod public void tearDown(){driver.quit();}
}
