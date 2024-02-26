package mercuryTravels.qa.testcases;

import MercuryTravels.qa.base.TestBase;
import MercuryTravels.qa.pages.SearchAllDetailsPage;
import MercuryTravels.qa.util.PageScrolling;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SearchAllDetailsPageTest extends TestBase {

    SearchAllDetailsPage searchAllDetailsPage;
    Logger logger =  LoggerFactory.getLogger(SearchAllDetailsPageTest.class);

    public SearchAllDetailsPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        logger.info("Browser launch");
        searchAllDetailsPage = new SearchAllDetailsPage();
    }

    @Test(description = "Enter the names, and verify that they are appearing correctly and Validate Return and departure date format")
    public void flightSearch() throws InterruptedException {
        Reporter.log("Test Start->Enter all details, and verify that they are appearing correctly and Validate Return and departure date format");
        searchAllDetailsPage.selectFromToCity();
        searchAllDetailsPage.selectDepartureDate();        
        Assert.assertTrue(searchAllDetailsPage.validateDepartureDateFormat());
        Reporter.log("Departure date format is Valid");
        Assert.assertTrue(searchAllDetailsPage.validateReturnDateFormat());
        Reporter.log("Return date format is Valid");
        Reporter.log("Click On Search Button");
        searchAllDetailsPage.clickOnSearchButton();        
        PageScrolling.scrollPage();
        Thread.sleep(5000);
        Reporter.log("Click on flight details");
        searchAllDetailsPage.clickOnFlightDetails();
        Thread.sleep(10000);
        Assert.assertTrue(searchAllDetailsPage.validateFlightDetails());
        Reporter.log("Flight details validation Successfully");
        Assert.assertTrue(searchAllDetailsPage.validateflightCode());
        Reporter.log("Flight code validation Successfully");        
        Assert.assertTrue(searchAllDetailsPage.validateStartAndEndTime());
        Reporter.log("Start and End time validation Successfully");
        Reporter.log("Test Completed successfully validate  city name, date, flight name, start time and end time ");
    }

    @Test(description = "Clicks on New Flight name, and Validate the new Flight Details")
    public void validateFlightName() throws InterruptedException {
        Reporter.log("Test Start->Clicks on New Flight name, and Validate the new Flight Details");
        searchAllDetailsPage.selectFromToCity();
        searchAllDetailsPage.selectDepartureDate();
        Reporter.log("Click On Search Button");
        searchAllDetailsPage.clickOnSearchButton();
        Reporter.log("Click on new flight");
        searchAllDetailsPage.clickOnNewFlight();
        Assert.assertTrue(searchAllDetailsPage.validateTheFlightDetails());
        Reporter.log("Flight details validate successfully");
        Reporter.log("Test Completed with Adding new flight details and validation");
    }

    @Test(description = "Check Booking Now Option is Enabled or Disabled")
    public void validateBookingButton() throws InterruptedException {
        Reporter.log("Test Start->Check Booking Now Option is Enabled or Disabled");
        searchAllDetailsPage.selectFromToCity();
        searchAllDetailsPage.selectDepartureDate();
        Reporter.log("Click On Search Button");
        searchAllDetailsPage.clickOnSearchButton();
        Assert.assertTrue(searchAllDetailsPage.validateBookingButton(),"Booking Button is Disabled");
        Reporter.log("Confirm that the booking button is successfully enabled");
        Reporter.log("Test Complete Successfully to check  if the Booking button is  enabled or disabled");
    }

    @Test(description = "Enter the city, and verify that they are appearing correctly and Check application wheteher is shwoing the availablity of the flight with date and timings of the departure")
    public void validateCityName() throws InterruptedException {
        Reporter.log("Test Start->Enter the city, and verify that they are appearing correctly");
        searchAllDetailsPage.selectCityName();
        searchAllDetailsPage.selectFromCityName();
        searchAllDetailsPage.selectDepartureDate();
        Reporter.log("Click On Search Button");
        searchAllDetailsPage.clickOnSearchButton();
        Assert.assertEquals(searchAllDetailsPage.validateFlightAvailability(),"Sorry, there are no flights available for this search. Please make another search");
        Reporter.log("Successfully verified Flight availability");
        Reporter.log("Test Complete successfully Selecting city by city code");

        }

    @Test(description = "Select one more seat")
    public void selectDifferentTypeOfSeat() throws InterruptedException {
        Reporter.log("Test Start->Select one more seat");
        searchAllDetailsPage.selectFromToCity();
        searchAllDetailsPage.selectDepartureDate();
        Reporter.log("Select child seat");
        searchAllDetailsPage.selectChildSeat();
        Reporter.log("Click On Search Button");
        searchAllDetailsPage.clickOnSearchButton();
        Assert.assertEquals(searchAllDetailsPage.validateSeatDetails(),"Passengers: 1 Adult(s), 1 Child(ren), 0 Infant(s)");
        Reporter.log("Successfully verified seat details");
        Reporter.log("Test complete Successfully to Select one or more seats and validate");
    }

    @AfterMethod public void tearDown(){driver.quit();}
}

